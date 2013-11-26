/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function() {
    emit( this.candNm, {count: 1, candNm: this.candNm, amt: this.contbReceiptAmt} );
}

function () {
    for (var i = 0; i < this.x.length; i++) {
        emit(this.x[i], 1);
    }
}