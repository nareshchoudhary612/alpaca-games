var myCart = [];
var addToCart= function(item){
	var mycart = JSON.parse(localStorage['cart']);
	const index = myCart.indexOf(item);
	if(index==-1){
		myCart.push(item);
	}
	localStorage.setItem('cart',JSON.stringify(myCart));
}


var deleteFromCart = function(item){
	var mycart = JSON.parse(localStorage['cart']);
	const index = myCart.indexOf(item);
	if (index > -1) {
		myCart.splice(index, 1);
	}
	localStorage.setItem('cart',JSON.stringify(myCart));
}

var getCart = function(){
	return JSON.parse(localStorage['cart']);
}

var addedToCart = function(obj){
	obj.innerHTML = '<span class="glyphicon glyphicon-ok"></span> Added';
}