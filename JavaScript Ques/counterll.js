// Write a function createCounter. It should accept an initial integer init. It should return an object with three functions.

// The three functions are:

// increment() increases the current value by 1 and then returns it.
// decrement() reduces the current value by 1 and then returns it.
// reset() sets the current value to init and then returns it.
 

// Example 1:

// Input: init = 5, calls = ["increment","reset","decrement"]
// Output: [6,5,4]
// Explanation:
// const counter = createCounter(5);
// counter.increment(); // 6
// counter.reset(); // 5
// counter.decrement(); // 4
// Example 2:

// Input: init = 0, calls = ["increment","increment","decrement","reset","reset"]
// Output: [1,2,1,0,0]
// Explanation:
// const counter = createCounter(0);
// counter.increment(); // 1
// counter.increment(); // 2
// counter.decrement(); // 1
// counter.reset(); // 0
// counter.reset(); // 0

/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let presentCount = init;
   
        function increment(){
            return ++presentCount;
        }
        function reset() {
            return (presentCount = init);
        }
        function decrement(){
            return --presentCount;
        }
    return {increment , reset , decrement};
    };
   //using arrow function -- meth 2 
// var createCounter = function(init) {
//     let presentCount = init
//     return {
//         increment:()=> ++presentCount,
//         decrement:()=> --presentCount,
//         reset:()=> presentCount = init,
//     }
// };

//method 3 :Class Object methd
// class Counter {
//   constructor(init) {
//     this.init = init;
//     this.presentCount = init;
//   }

//   increment() {
//     this.presentCount += 1;
//     return this.presentCount;
//   }

//   decrement() {
//     this.presentCount -= 1;
//     return this.presentCount;
//   }

//   reset() {
//     this.presentCount = this.init;
//     return this.presentCount;
//   }
// }

// var createCounter = function(init) {
//   return new Counter(init);
// };


/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */