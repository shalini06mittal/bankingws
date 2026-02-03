function greet(name="Guest"){
    console.log(arguments[0]);
    return "welcome "+name
    
}
// console.log(greet());
// console.log(greet("shalini"));
// console.log(greet("shalini","chirag"));
/*
named functions
func expressions
arrow functions
IIFE
nested functions
*/
let add = function(a,b){
    return a+b;
};

// console.log(add);
// console.log(add(2,3));
function calculate(no , fn){
    console.log(fn(no[0],no[1]));   
}
// calculate([1,2], add);
// calculate([1,2], (a,b)=>{ return a-b});

// let greet1 = () => console.log("hello");
// console.log(greet1);

// let greet1 = () =>  "hello";
// console.log(greet1);

// let greet1 = name =>  "hello "+name;
// console.log(greet1);

let greet1 = (name , city)=>  "hello "+name;
// console.log(greet1);

// create a function that takes 2 parameters : an array of numbers and a function
// 1. print all odd numbers in the array
// 2. print all even numbers in the array

function calc  ( arr , func){
    // print all odd values from the array, logic will be in func
    for(let n of arr){
        if(func(n))
            console.log(n);
            
    }
}
// calc([2,3,5,7,55,34,2,23], (no) => no%2!==0);
// calc([2,3,5,7,55,34,2,23], (no) => no%2===0);

function counter(){
    let c = 0;
    function increment(){
        return ++c;
    }
    function decrement(){
        return --c;
    }
    return {increment, decr: decrement};
}
let c = counter();
// incr, decr
console.log(c['increment']());
console.log(c.decr());

// console.log(counter()());
let user = {id:1, username:'shalini'};
// let id = user.id;
// let name = user.name;
let {id, username} = user;
console.log(id, username);

let n1 = [1,2,3];
let n2= [4,5,6]
n1.push(...n2);// spread operator
console.log(n1.length);
console.log(n1);


