class FreqStack {
  constructor() {
    this.f = {};
    this.n = [];
  }

  push(x) {
    this.f[x] = (this.f[x] || 0) + 1;
    this.n.push(x);
  }

  pop() {
    let toPop = null;
    for (let i = 0; i <= this.n.length - 1; i++) {
      const x = this.n[i];
      const toPopValue = this.n[toPop] || 0;
      const toPopFreq = toPop ? this.f[toPopValue] : 0;
      const xFreq = this.f[x] || 0;
      if (xFreq >= toPopFreq) {
        toPop = i;
      }
    }
    const toPopValue = this.n[toPop];
    this.f[toPopValue]--;
    console.log("popping", toPopValue);
    this.n.splice(toPop, 1);
  }
}
