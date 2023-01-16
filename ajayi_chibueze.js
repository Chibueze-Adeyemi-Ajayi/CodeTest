// this is the shift task
// Developer: AJAYI CHIBUEZE ADEYEMI
// Language: JavaScript

function rotLeft(a, d){
   var array = [], i = -1, start = 0;
    // annotaion steps
    for (let i = 0; i < d; i++) { start ++; var arr = [];
        // looping through the input array
        for (let j = start; j < a.length; j++) arr.push(a[j]);
        // lopping from the beginning considerating start
        for (let x = 0; x < start; x++) arr.push(a[x]);
        array.push(arr);
    }
   return array;
}
// printing out the annotaion
console.log(rotLeft([1,2,3,4,5], 2));