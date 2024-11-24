<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC-Admin Dashboard</title>
<link rel="shortcut icon" href="assets/img/favicon.png">
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
<link rel="stylesheet" href="assets/css/custom1.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<style>
/* CSS styles */
.dashboard {
	display: flex;
	justify-content: space-around;
	padding: 20px;
}

.chart-container {
	width: 100%; /* Adjusted width to occupy more space */
}

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
	opacity: 0.7; /* Adjust the opacity as needed */
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

 .page-title {
            color: blue;
            font-size: 24px;
            font-weight: bold;
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
								<h1 class="page-title">
							Welcome To 	${department } Department
									</h1>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Home</a></li>
									<li class="breadcrumb-item active">Student</li>
								</ul>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-xl-3 col-sm-6 col-12 d-flex">
						<div class="card bg-comman w-100">
							<div class="card-body">
								<div
									class="db-widgets d-flex justify-content-between align-items-center">
									<div class="db-info">
										<h6>Students</h6>
										<h3>${numberOfStudents}+</h3>
									</div>
									<div class="db-icon">
										<img src="assets/img/icons/dash-icon-01.svg"
											alt="Dashboard Icon">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12 d-flex">
						<div class="card bg-comman w-100">
							<div class="card-body">
								<div
									class="db-widgets d-flex justify-content-between align-items-center">
									<div class="db-info">
										<h6>Number of Boys</h6>
										<h3>${numberOfBoys }</h3>
									</div>
									<div class="db-icon">
										<img src="assets/boy.png" alt="Dashboard Icon">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12 d-flex">
						<div class="card bg-comman w-100">
							<div class="card-body">
								<div
									class="db-widgets d-flex justify-content-between align-items-center">
									<div class="db-info">
										<h6>Number of Girls</h6>
										<h3>${numberOfGirls }</h3>
									</div>
									<div class="db-icon">
										<img src="assets/favicon-32x32.png" alt="Dashboard Icon">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12 d-flex">
						<div class="card bg-comman w-100">
							<div class="card-body">
								<div
									class="db-widgets d-flex justify-content-between align-items-center">
									<div class="db-info">
										<h6>Department</h6>
										<h3>3+</h3>
									</div>
									<div class="db-icon">
										<img src="assets/img/icons/dash-icon-03.svg"
											alt="Dashboard Icon">
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-12 col-lg-6">

						<div class="card card-chart">
							<div class="card-header">
								<div class="row align-items-center">
									<div class="col-6">
										<h5 class="card-title">Number Of Students</h5>
									</div>

								</div>
							</div>
							<div class="dashboard">
								<div class="chart-container" style="opacity: 1;">
									<canvas id="student-chart"></canvas>
								</div>
							</div>
						</div>

					</div>
					
				</div>
				
				 <div class="row">
						<div class="col-md-12">
							<div class="profile-header">
								<div class="row align-items-center">
									<div class="col-auto profile-image">
										<a href="#"> <c:choose>
												<c:when test="${adminImage!=null }">
													<img class="rounded-circle"
														src="data:image/jpeg;base64,${adminImage}" width="31"
														alt="${admin.firstName }">
												</c:when>
												<c:otherwise>
													<img class="rounded-circle"
														src="assets/img/profiles/avatar-01.jpg" width="31"
														alt="${admin.firstName }">
												</c:otherwise>
											</c:choose>
										</a>
									</div>
									<div class="col ms-md-n2 profile-user-info">
										<h4 class="user-name mb-0">
											<span>Prof. ${admin.firstName} ${admin.lastName} H.O.D</span>
										</h4>
										<h6 class="text-muted">
											<span>${admin.department }</span>
										</h6>


									</div>

								</div>
							</div>
							
							<div class="tab-content profile-tab-cont">

								<div class="tab-pane fade show active" id="per_details_tab">

									<div class="row">
										<div class="col-lg-9">
											<div class="card">
												<div class="card-body">
													<h5 class="card-title d-flex justify-content-between">
														<span>Personal Details</span>
													</h5>
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Name</p>
														<p class="col-sm-9">
															<span>Prof. ${admin.firstName} ${admin.lastName} </span>
														</p>
													</div>
													
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Email
															ID</p>
														<p class="col-sm-9">
															<a class="__cf_email__"
																data-cfemail="a1cbcec9cfc5cec4e1c4d9c0ccd1cdc48fc2cecc">${admin.email }</a>
														</p>
													</div>
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Mobile</p>
														<p class="col-sm-9">${admin.mobile }</p>
													</div>
													
												</div>
											</div>
										</div>
										<div class="col-lg-3"></div>
									</div>

								</div>


								

							</div>
						</div>
					</div> 
					<c:forEach items="${staffs }" var="staff">
					<div class="row">
						<div class="col-md-12">
							
							
							<div class="tab-content profile-tab-cont">

								<div class="tab-pane fade show active" id="per_details_tab">

									<div class="row">
										<div class="col-lg-9">
											<div class="card">
												<div class="card-body">
													<h5 class="card-title d-flex justify-content-between">
														<span>Staff Details</span>
													</h5>
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Name</p>
														<p class="col-sm-9">
															<span>Prof. ${staff.firstName} ${staff.lastName} </span>
														</p>
													</div>
													
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Email
															ID</p>
														<p class="col-sm-9">
															<a class="__cf_email__"
																data-cfemail="a1cbcec9cfc5cec4e1c4d9c0ccd1cdc48fc2cecc">${staff.email }</a>
														</p>
													</div>
													<div class="row">
														<p class="col-sm-3 text-muted text-sm-end mb-0 mb-sm-3">Mobile</p>
														<p class="col-sm-9">${staff.mobile }</p>
													</div>
													
												</div>
											</div>
										</div>
										<div class="col-lg-3"></div>
									</div>

								</div>


								

							</div>
						</div>
					</div> 
					</c:forEach>
				
				
</div> 
				
		</div>
	</div>
	<script>
		// JavaScript code
		
		document.addEventListener("DOMContentLoaded",
				function() {
					// Initialize Chart.js
					var ctx = document.getElementById('student-chart')
							.getContext('2d');
					var chart = new Chart(ctx, {
						type : 'bar',
						data : {
							labels : [ 'Semester 1', 'Semester 2',
									'Semester 3', 'Semester 4', 'Semester 5',
									"Semester 6", "Semester 7", "Semester 8" ],
							datasets : [ {
								label : 'Number of Students',
								data: [
			                        <c:forEach items="${data}" var="count" varStatus="loop">
			                            ${count}<c:if test="${!loop.last}">, </c:if>
			                        </c:forEach>
			                    ], // Example data, replace with your own
								backgroundColor : [ 'rgba(255, 99, 132, 0.5)',
										'rgba(54, 162, 235, 0.5)',
										'rgba(255, 206, 86, 0.5)',
										'rgba(75, 192, 192, 0.5)',
										'rgba(153, 102, 255, 0.5)',
										'rgba(120, 140, 255, 0.5)',
										'rgba(123, 102, 255, 0.5)'],
								borderColor : [ 'rgba(255, 99, 132, 1)',
										'rgba(54, 162, 235, 1)',
										'rgba(255, 206, 86, 1)',
										'rgba(75, 192, 192, 1)',
										'rgba(153, 102, 255, 1)' ],
								borderWidth : 2
							} ]
						},
						options : {
							scales : {
								y : {
									beginAtZero : true
								}
							}
						}
					});
				});
	</script>

	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/feather.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/apexchart/apexcharts.min.js"></script>
	<script src="assets/plugins/apexchart/chart-data.js"></script>
	<script src="assets/js/script.js"></script>
</body>

</html>