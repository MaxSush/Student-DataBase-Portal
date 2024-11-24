<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Student Dashboard</title>

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

<link rel="stylesheet"
	href="assets/plugins/simple-calendar/simple-calendar.css">

<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/college.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css"
	rel="stylesheet">

<style>
/* Internal CSS */
.page-wrapper {
	position: relative;
}

.page-wrapper:before {
	content: "";
	background-image: url('assets/mmec.webp');
	/* Add the path to your image */
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 100%;
	height: 100%;
	opacity: 0.3; /* Adjust the opacity as needed */
	z-index: -1;
}

.heading {
	position: relative;
	text-align: center;
	background-image: radial-gradient(circle, #553c9a, #ee4b2b);
	font-family: Times New Roman;
	color: transparent;
	background-clip: text;
	-webkit-background-clip: text;
	font-size: 40px;
	font-weight: 600; /* Adjust font size as needed */
	margin-top: 15%; /* Adjust vertical positioning */
}

@media ( max-width : 768px) {
	.heading {
		font-size: 18px; /* Adjust font size for smaller screens */
		margin-top: 10%;
	}
	.page-wrapper:before {
		background-attachment: scroll;
	}
}

.footer {
	content: "";
	background-image: url('assets/logo.webp');
	/* Add the path to your image */
	background-size: 500px;
	background-position: center;
	background-repeat: no-repeat;
	position: absolute;
	top: 120;
	left: 0;
	width: 100%;
	height: auto%;
	/* Adjust the opacity as needed */
	z-index: -1;
	border: none;
}

.footer a {
	color: #fff; /* Link color */
	text-decoration: none; /* Remove underline from links */
	margin: 0 10px; /* Margin between links */
	font-family: Times New Roman;
	font-weight: 200;
}

@media ( max-width : 768px) {
	.footer {
		top: 800px;
		/* Adjust the top position for smaller screens */
		background-size: contain;
		/* Adjust background size for smaller screens */
	}
}
</style>
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}"
					class="logo"
					>
					<img src="assets/mmec1.jpg" alt="Logo" >
				</a> <a
					href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}"
					class="logo logo-small"> <img src="assets/symbol.png"
					alt="Logo" width="30" height="30">
				</a>
			</div>

			<div class="menu-toggle">
				<a href="javascript:void(0);" id="toggle_btn"> <i
					class="fas fa-bars"></i>
				</a>
			</div>




			<a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i>
			</a>


			<ul class="nav user-menu">







				<li class="nav-item dropdown has-arrow new-user-menus"><a
					href="#" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
						<span class="user-img">
						 <c:choose>
								<c:when test="${image!=null }">
									<img class="rounded-circle"
										src="data:image/jpeg;base64,${image}" width="31"
										alt="${name }">
								</c:when>
								<c:otherwise>
									<img class="rounded-circle"
										src="assets/img/profiles/avatar-01.jpg" width="31"
										alt="${name }">
								</c:otherwise>
							</c:choose>
							<div class="user-text">
								<h6>${name}</h6>
								<p class="text-muted mb-0">Student</p>
							</div>
					</span>
				</a>
					<div class="dropdown-menu">
						<div class="user-header">
							<div class="avatar avatar-sm">
								<c:choose>
								<c:when test="${image!=null }">
									<img class="rounded-circle"
										src="data:image/jpeg;base64,${image}" width="31"
										alt="${name }">
								</c:when>
								<c:otherwise>
									<img class="rounded-circle"
										src="assets/img/profiles/avatar-01.jpg" width="31"
										alt="${name }">
								</c:otherwise>
							</c:choose>
							</div>
							<div class="user-text">
								<h6>${name}</h6>
								<p class="text-muted mb-0">Student</p>
							</div>
						</div>
						<a class="dropdown-item"
							href="Student-Profile?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">My
							Profile</a> <a class="dropdown-item" href="log-out">Logout</a>
					</div></li>

			</ul>

		</div>


		<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div id="sidebar-menu" class="sidebar-menu">
					<ul>
						<li class="menu-title"><span>Main Menu</span></li>
						<li class="submenu active"><a href="#"><i
								class="feather-grid"></i> <span> Dashboard</span> <span
								class="menu-arrow"></span></a>
							<ul>

								<li><a
									href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}"
									class="active">Student Dashboard</a></li>
							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-graduation-cap"></i> <span> Students</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-student-info?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">View
										Info</a></li>

								

							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-building"></i> <span> Departments</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="department?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Department List</a></li>

							</ul></li>

						<li class="submenu"><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-student-subjects?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Subject
										List</a></li>

							</ul></li>

						<li><a href="fees"><i class="fas fa-comment-dollar"></i>
								<span>Fees</span></a></li>
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Exam</span> <span class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-exams-for-student?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Exam
										List</a></li>

								<li><a
									href="view-result-for-student?usn=${usn}&name=${name}&sem1=${sem}&regid=${regid}&id=${id}">
										Exam Results</a></li>
							</ul></li>

						<li class="submenu"><a href="#"><i
								class="fas fa-shield-alt"></i> <span> Authentication </span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="/">Login</a></li>
								<li><a href="registration-student">Register</a></li>
								<li><a href="forgot-password">Forgot Password</a></li>
							</ul></li>

					</ul>
				</div>
			</div>
		</div>


		<div class="page-wrapper">
			<div class="content container-fluid">
				<div class="page-header">
					<div class="row">
						<div class="col-sm-12">
							<div class="page-sub-header">
								<h3 class="page-title">Welcome ${name }</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Home</a></li>
									<li class="breadcrumb-item active">Student</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<h2 class="heading">MARATHA MANDAL ENGINEERING COLLEGE BELAGAVI</h2>

			<footer class="footer">
				<!-- Add your logo image -->
				<div>
					<a href="https://www.mmec.edu.in/index.php/about-us/"
						target="_blank">About Us</a> <a href="https://www.mmec.edu.in/"
						target="_blank">More</a>
				</div>
			</footer>
		</div>


	</div>




	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="assets/plugins/apexchart/chart-data.js"></script>

	<script src="assets/plugins/simple-calendar/jquery.simple-calendar.js"></script>
	<script src="assets/js/calander.js"></script>

	<script src="assets/js/circle-progress.min.js"></script>

	<script src="assets/js/script.js"></script>

</body>
</html>