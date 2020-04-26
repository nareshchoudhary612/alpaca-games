var myCart = [];
var addToCart= function(item){
	
	if(localStorage['cart']==undefined){
		//
	}else{
		myCart = JSON.parse(localStorage['cart']);
	}
	
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


var generateCart= function(){
	var table = document.getELementById("cart_Table");
}

var openCartPage = function(f){
	console.log("dd");
	if(localStorage['cart']==undefined){
		//
	}else{
		f.mycart.value = JSON.parse(localStorage.cart);
	}	
	f.action="/checkout";
    f.submit();
}