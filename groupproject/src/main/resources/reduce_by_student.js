/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function(key, values) {
    var result = {count: 0, amt: 0, candNm:""};
    values.forEach(function(value) {
      result.count += value.count;
      result.amt += value.amt;
      result.candNm = value.candNm;
    });
    return result;
}

function (key, values) {
    var sum = 0;
    for (var i = 0; i < values.length; i++)
        sum += values[i];
    return sum;
}