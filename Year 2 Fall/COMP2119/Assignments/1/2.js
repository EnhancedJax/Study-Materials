class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  constructor(data) {
    if (data) {
      this.head = new Node(data);
    }
    this.head = null;
  }

  push(data) {
    const newNode = new Node(data);
    const head = this.head;
    if (head) {
      let current = head;
      while (current.next !== null) {
        current = current.next;
      }
      current.next = newNode;
    } else {
      this.head = newNode;
    }
  }

  print() {
    let current = this.head;
    while (current !== null) {
      console.log(current.data);
      current = current.next;
    }
  }
}

// Question 2a
function mergeAndSort(l1, l2) {
  const merged = new LinkedList();
  let current1 = l1.head;
  let current2 = l2.head;
  while (current1 !== null || current2 !== null) {
    if (current1 === null) {
      merged.push(current2.data);
      current2 = current2.next;
    } else if (current2 === null) {
      merged.push(current1.data);
      current1 = current1.next;
    } else if (current1.data < current2.data) {
      merged.push(current1.data);
      current1 = current1.next;
    } else {
      merged.push(current2.data);
      current2 = current2.next;
    }
  }
  return merged;
}

// Question 2b
function getCycledNode(l) {
  let current = l.head;
  let traversed = [];
  while (current !== null) {
    const next = current.next;
    if (next === null) break;
    if (traversed.includes(next)) return current;
    traversed.push(current);
    current = next;
  }
  return null;
}
