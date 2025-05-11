$(document).ready(function(){
	$("#registrationForm").on("submit",function(e){
		e.preventDefault();
		register();
	})
})

function register() {
  
  var name=$("#name").val();
  var email=$("#email").val();
  var address =$("#address").val();
  var phone = $("#phone").val();
  var role=$("#role").val();
  var salary=$("#salary").val();
  
  console.log(name);
  
  var saveEmployee={
	"url":"/api/save",
	"method":"post",
	"headers":{
		"Content-Type":"application/json"
	},
	"data":JSON.stringify({
		"name":name,
		"email":email,
		"address":address,
		"phone":phone,
		"role":[role],
		"salary":salary
	})
  };
  
  $.ajax(saveEmployee).done(function(response){
	if(response!=null){
		$("#messagebox").html(`<span style="color:green;">Register Successfully</span>`)
		setTimeout(()=>{
			window.location.href="/emplogin"
		},1000)
	}else{
		$("#messagebox").html(`<span style="color:red;">Email Already exist</span>`)
	}
  }).fail(function(xh,status,error){
	$("#messagebox").html(`<span style="color:red;">Email Already exist</span>`)
  })
}