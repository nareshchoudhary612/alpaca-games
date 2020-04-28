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

var addedToCartP = function(obj){
	obj.style.backgroundColor='green';
	obj.innerHTML = 'Added';
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

var onLoadCartSum = function(){
	var gameListData = document.getElementById('gameListData').value;
	var games = JSON.parse(gameListData);
	var sum = 0;
	for(var i = 0; i < games.length; i++){
		sum+=games[i].discount;
	}
	var finalSum= sum + 6.94;
	document.getElementById('totalCartValue').innerHTML='$'+sum.toFixed(2);
	document.getElementById('finalCartValue').innerHTML='$'+finalSum.toFixed(2);
}

var removeFromCart = function(gameId, obj){
	var rowDel = obj.parentNode.parentElement;
	rowDel.parentNode.deleteRow(rowDel.rowIndex-1);
		
	//update sum
	var valueRemove = rowDel.children[2].firstChild.firstChild.innerText;
	var sum= document.getElementById('totalCartValue').innerHTML.substring(1);
	var finalSum= document.getElementById('finalCartValue').innerHTML.substring(1);
	document.getElementById('totalCartValue').innerHTML='$'+(sum-valueRemove).toFixed(2);
	document.getElementById('finalCartValue').innerHTML='$'+(finalSum-valueRemove).toFixed(2);
	
	//remove from cache
	deleteFromCart(gameId);
	openCartPage(document.getElementById('cartForm'));
}

var initiatePayment = function(){
	//login true continue else error
	if(document.getElementById("loggedInUser")){
		var orderId = document.getElementById('orderIdGenerated').value
		var amount = document.getElementById('finalCartValue').innerHTML.substring(1);
		if(orderId==0){
			alert("Update your cart first!");
		}
		location.href="/payment?orderId="+orderId+"&"+"amount="+amount;
	}else{
		alert("Please login before checking out!");
	}
}


var setAmountDuringPayment=function(){
	var orderId=location.href.substring(location.href.indexOf('orderId=')+8,location.href.indexOf('&amount'));
	var amount=location.href.substring(location.href.indexOf('&amount=')+8);
	document.getElementById('finalAmnt').innerHTML = amount;
}


var payment = function(){
	if(document.getElementById('cardNumber').value.length==16 ||
	document.getElementById('cardNumber').value.length!=0 ||
	document.getElementById('cardNumber').value.length!=0 ||
	document.getElementById('cardNumber').value.length!=0){
		//
	}else{
		alert("Incorrect Payment Details!");
	}
}