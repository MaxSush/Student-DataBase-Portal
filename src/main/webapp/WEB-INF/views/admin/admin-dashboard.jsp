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
					href="admin-dashboard?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}"
					class="logo"> <img src="assets/mmec1.jpg" alt="Logo">
				</a> <a
					href="admin-dashboard?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}"
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
						<span class="user-img"> <c:choose>
								<c:when test="${image!=null }">
									<img class="rounded-circle"
										src="data:image/jpeg;base64,${image}" width="31"
										alt="${firstname }">
								</c:when>
								<c:otherwise>
									<img class="rounded-circle"
										src="assets/img/profiles/avatar-01.jpg" width="31"
										alt="${firstname }">
								</c:otherwise>
							</c:choose>
							<div class="user-text">
								<h6>${firstname }</h6>
								<p class="text-muted mb-0">Staff</p>
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
										alt="${firstname }">
								</c:when>
								<c:otherwise>
									<img class="rounded-circle"
										src="assets/img/profiles/avatar-01.jpg" width="31"
										alt="${firstname }">
								</c:otherwise>
							</c:choose>
							</div>
							<div class="user-text">
								<h6>${firstname }</h6>
								<p class="text-muted mb-0">Staff</p>
							</div>
						</div>
						<a class="dropdown-item" href="admin-profile?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">My Profile</a> <a
							class="dropdown-item" href="log-out">Logout</a>
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
									href="admin-dashboard?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}"
									class="active">Admin Dashboard</a></li>
								<li><a
									href="view-admin-info?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">View
										Info</a></li>

							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-graduation-cap"></i> <span> Students</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-students?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Student
										List</a></li>
								<li><a
									href="promote-students?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Promote Student
										</a></li>

							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-chalkboard-teacher"></i> <span> Staffs</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="admin-staff-list?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Staff List</a></li>
								


							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-building"></i> <span> Departments</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="departments">Department List</a></li>
								
							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="subjects">Subject List</a></li>
								<li><a href="subjects">Add Subjects</a></li>

							</ul></li>




						<li class="submenu"><a href="#"><i
								class="fas fa-comment-dollar"></i> <span> Fees Management </span> <span
								class="menu-arrow"></span></a>
							<ul>
								
								
								<li><a href="fees-collection-admin?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}"><i class="fas fa-comment-dollar"></i>
								<span>Fees Collection</span></a></li>
								

							</ul></li>
						<li><a href="exam"><i class="fas fa-clipboard-list"></i>
								<span>Exam list</span></a></li>




						<li class="submenu"><a href="#"><i
								class="fas fa-shield-alt"></i> <span> Authentication </span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="login">Login</a></li>
								<li><a href="register">Register</a></li>
								<li><a href="forgot-password">Forgot Password</a></li>
								<li><a href="error-404">Error Page</a></li>
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
								<h3 class="page-title">Welcome Prof. ${firstname }
									${lastname } - Admin!</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="admin-dashboard?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Home</a></li>
									<li class="breadcrumb-item active">Admin</li>
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
					<div class="col-md-12 col-lg-6">

						<div class="card flex-fill student-space comman-shadow">
							<div class="card-header d-flex align-items-center">
								<h5 class="card-title">Registered Staff</h5>
								<ul class="chart-list-out student-ellips">

								</ul>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table
										class="table star-student table-hover table-center table-borderless table-striped"
										style="text-align: center;">
										<thead class="thead-light">
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th class="text-center">Department</th>


											</tr>
										</thead>
										<c:forEach items="${staff}" var="staff">
											<tbody>
												<tr>
													<td>${staff.id }</td>
													<td>${staff.firstName } ${staff.lastName }</td>
													<td>${staff.department }</td>


												</tr>





											</tbody>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-xl-6 d-flex">

						<div class="card flex-fill student-space comman-shadow">
							<div class="card-header d-flex align-items-center">
								<h5 class="card-title">Recent Registered Students</h5>
								<ul class="chart-list-out student-ellips">

								</ul>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table
										class="table star-student table-hover table-center table-borderless table-striped"
										style="text-align: center;">
										<thead class="thead-light">
											<tr>
												<th>ID</th>
												<th>Name</th>
												<th class="text-center">Department</th>
												<th class="text-center">Sem</th>

											</tr>
										</thead>
										<c:forEach items="${recentStudent}" var="students">
											<tbody>
												<tr>
													<td>${students.id }</td>
													<td>${students.firstName } ${students.lastName }</td>
													<td>${students.department }</td>
													<td>${students.sem }</td>

												</tr>





											</tbody>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>

					</div>
					<div class="col-xl-6 d-flex">

						<div class="card flex-fill comman-shadow">
							<div class="card-header d-flex align-items-center">
								<h5 class="card-title ">Student Activity</h5>
								<ul class="chart-list-out student-ellips">
									<li class="star-menus"><a href="javascript:;"><i
											class="fas fa-ellipsis-v"></i></a></li>
								</ul>
							</div>
							<div class="card-body">
								<div class="activity-groups">
									<div class="activity-awards">
										<div class="award-boxs">
											<img src="assets/img/icons/award-icon-01.svg" alt="Award">
										</div>
										<div class="award-list-outs">
											<h4>1st place in "Chess”</h4>
											<h5>John Doe won 1st place in "Chess"</h5>
										</div>
										<div class="award-time-list">
											<span>1 Day ago</span>
										</div>
									</div>
									<div class="activity-awards">
										<div class="award-boxs">
											<img src="assets/img/icons/award-icon-02.svg" alt="Award">
										</div>
										<div class="award-list-outs">
											<h4>Participated in "Carrom"</h4>
											<h5>Justin Lee participated in "Carrom"</h5>
										</div>
										<div class="award-time-list">
											<span>2 hours ago</span>
										</div>
									</div>
									<div class="activity-awards">
										<div class="award-boxs">
											<img src="assets/img/icons/award-icon-03.svg" alt="Award">
										</div>
										<div class="award-list-outs">
											<h4>Internation conference in "St.John School"</h4>
											<h5>Justin Leeattended internation conference in
												"St.John School"</h5>
										</div>
										<div class="award-time-list">
											<span>2 Week ago</span>
										</div>
									</div>
									<div class="activity-awards mb-0">
										<div class="award-boxs">
											<img src="assets/img/icons/award-icon-04.svg" alt="Award">
										</div>
										<div class="award-list-outs">
											<h4>Won 1st place in "Chess"</h4>
											<h5>John Doe won 1st place in "Chess"</h5>
										</div>
										<div class="award-time-list">
											<span>3 Day ago</span>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="row">
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card flex-fill fb sm-box">
							<div class="social-likes">
								<p>Like us on facebook</p>
								<h6>50,095</h6>
							</div>
							<div class="social-boxs">
								<img src="assets/img/icons/social-icon-01.svg" alt="Social Icon">
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card flex-fill twitter sm-box">
							<div class="social-likes">
								<p>Follow us on twitter</p>
								<h6>48,596</h6>
							</div>
							<div class="social-boxs">
								<img src="assets/img/icons/social-icon-02.svg" alt="Social Icon">
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card flex-fill insta sm-box">
							<div class="social-likes">
								<p>Follow us on instagram</p>
								<h6>52,085</h6>
							</div>
							<div class="social-boxs">
								<img src="assets/img/icons/social-icon-03.svg" alt="Social Icon">
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 col-12">
						<div class="card flex-fill linkedin sm-box">
							<div class="social-likes">
								<p>Follow us on linkedin</p>
								<h6>69,050</h6>
							</div>
							<div class="social-boxs">
								<img src="assets/img/icons/social-icon-04.svg" alt="Social Icon">
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer> </footer>
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