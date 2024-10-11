const keys = [17, 94, 86, 22, 98, 79, 54, 38];

// $m = 11,\quad h(k) = k \mod 11$ with double hashing $f(i) = i \cdot h'(k),\quad h'(k) = 2 - (k \mod 2)$.
const m = 11;
const h = (k) => k % m;
const h_prime = (k) => 2 - (k % 2);
let hashResults = [];

for (const key of keys) {
  const hash = h(key);
  hashResults.push(hash);
}

console.log(hashResults);

// double hashing
let slots = Array(11).fill(undefined);
hashResults.forEach((hash, index) => {
  const key = keys[index];
  let insertAt = hash;
  let insertAtChecked = [insertAt];
  while (slots[insertAt] !== undefined) {
    insertAt = (insertAt + h_prime(key)) % m;
    insertAtChecked.push(insertAt);
  }
  process.stdout.write(`(${insertAtChecked.join(", ")}) `);
  slots[insertAt] = key;
});
