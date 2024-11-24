<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Register</title>

<link rel="shortcut icon" href="assets/symbol.png">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="assets/plugins/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="assets/plugins/feather/feather.css">

<link rel="stylesheet"
	href="assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/custom2.css">

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
							<h1>Sign Up</h1>
							<span style="color: blue;">${msg4}</span>
							<p class="account-subtitle">Enter details to create your
								account</p>

							<form action="student-registration-controller" method="post">
								<div class="form-group">
									<label>USN <span class="login-danger">*</span></label> <input
										class="form-control" type="text" name=usn required="required" >
									<span class="profile-views"><i
										class="fas fa-user-circle"></i></span><span
										style="color: red; font-size: 11px">${msg3 }</span>
								</div>
								<div class="form-group">
									<label>Fisrt Name <span class="login-danger">*</span></label> <input
										class="form-control" type="text" name=firstName
										required="required"> <span class="profile-views"><i
										class="fas fa-user-circle"></i></span><span
										style="color: red; font-size: 11px"></span>
								</div>
								<div class="form-group">
									<label>Last Name <span class="login-danger">*</span></label> <input
										class="form-control" type="text" name=lastName
										required="required"> <span class="profile-views"><i
										class="fas fa-user-circle"></i></span><span
										style="color: red; font-size: 11px"></span>
								</div>
								<div class="form-group">
									<label>Email <span class="login-danger">*</span></label> <input
										class="form-control" type="text" name=email
										required="required"> <span class="profile-views"><i
										class="fas fa-envelope"></i></span><span
										style="color: red; font-size: 11px">${msg2 }</span>
								</div>
								<div class="form-group">
									<label>Mobile <span class="login-danger">*</span></label> <input
										class="form-control pass-input" type="text" name=mobile
										required="required"> <span
										class="profile-views feather-eye toggle-password"></span><span
										style="color: red; font-size: 11px">${msg1 }</span>
								</div>
								
								<div class="form-group local-forms">
									<label>Department <span class="login-danger">*</span></label> <select
										class="form-control select" required="required"
										name="department">
										
										<option>Computer Science</option>
										<option>Electronics and Communication</option>
										<option>Robotics and AI</option>
										<option>Mechanical</option>
										<option>Office Faculty</option>
									</select>
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
								<div class=" dont-have">
									Already Registered? <a href="/">Login</a>
								</div>
								<div class="form-group mb-0">
									<button class="btn btn-primary btn-block" type="submit">Register</button>

								</div>

							</form>

						</div>
					</div>
				</div>
			</div>
		</div>


	</div>


	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>