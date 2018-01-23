
const nItteration = 1000;

// A
const util = a => a+1;
const A = (x) => {
  return util(x);
}

let start = performance.now();
for (let i = 0; i < nItteration; i++) {
  A(i);
}
let stop = performance.now();
console.log(`A: ${stop - start}`)


// B
const B = (x) => {
  const inner = x => x+1;
  return inner();
}

start = performance.now();
for (let i = 0; i < nItteration; i++) {
  B(i);
}
stop = performance.now();
console.log(`B: ${stop - start}`)
