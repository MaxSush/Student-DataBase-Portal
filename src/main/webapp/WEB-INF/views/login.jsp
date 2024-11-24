<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Login</title>
<link rel="shortcut icon" href="assets/symbol.png">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="assets/plugins/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="assets/plugins/feather/feather.css">

<link rel="stylesheet" href="assets/plugins/icons/flags/flags.css">

<link rel="stylesheet"
	href="assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

	<div class="main-wrapper login-body">
		<div class="login-wrapper">
			<div class="container">
				<div class="loginbox">
					<div class="login-left">
						<img class="img-fluid" src="assets/img/login.png" alt="Logo">
					</div>
					<div class="login-right">
						<div class="login-right-wrap">
							<h1>Welcome to MMEC</h1><span style="color:red;font-size:15px;">${error.message}</span>
							<p class="account-subtitle">
								Need an account? <a href="registration-student">Sign Up</a>
							</p>
							<h2>Sign in</h2>

							<form action="login-controller" method="post">
								<div class="form-group">
									<label>USN <span class="login-danger">*</span></label> <input
										class="form-control" type="text" name="usn"
										required="required"> <span class="profile-views"><i
										class="fas fa-user-circle"></i></span><span
										style="color: red; font-size: 11px">${usermessage}</span>
								</div>
								<div class="form-group">
									<label>Password <span class="login-danger">*</span></label> <input
										class="form-control pass-input" type="text" name="password"
										required="required"> <span
										class="profile-views feather-eye toggle-password"></span>
								</div>
								<div class="form-group local-forms">
									<label>User <span class="login-danger">*</span></label> <select
										class="form-control select" required="required"
										name="user">
										
										<option>Student</option>
										<option>Staff</option>
										<option>HOD</option>
										<option>Accountant</option>
										
									</select>
								</div>
								<div class="forgotpass">

									<a href="forgot-password">Forgot Password?</a>
								</div>
								<div class="form-group">
									<button class="btn btn-primary btn-block" type="submit">Login</button>
								</div>
							</form>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		window.onload = function() {
			<c:set var="status" value="${popup}"/>
			<c:choose>
			<c:when test="${status==true}">
			var message = "<c:out value='You Have Registered Successefully With MMEC. Please Refer Your Email For Password' />";
			alert(message);
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
			</c:choose>
			
			
			<c:set var="passwordRecovery" value="${passwordRecovery}"/>
				<c:choose>
				<c:when test="${passwordRecovery==true}">
				var message = "<c:out value='Your password has been recovered successefully. Kindly refer your email for password' />";
				alert(message);
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
				</c:choose>
			
			
				<c:set var="passwordChanged" value="${passwordChanged}"/>
					<c:choose>
					<c:when test="${passwordChanged==true}">
					var message = "<c:out value='Your Password is changed successefully..' />";
					alert(message);
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
					</c:choose>
					
					<c:set var="sessionMsg" value="${sessionMsg}"/>
						<c:choose>
						<c:when test="${sessionMsg==true}">
						var message = "<c:out value='Session Expired , please login again...' />";
						alert(message);
						</c:when>
						<c:otherwise>
					
						</c:otherwise>
						</c:choose>
		};
		
	</script>
	
	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>

</html>