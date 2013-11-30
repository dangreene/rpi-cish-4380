/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function() { 
    var sum = 0;
    for (var i = 0; i < this.courses.length; i++) {
        sum += this.courses[i].credits;
    }  
    emit(this._id, sum);
}

