<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEc - Staff Details</title>

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
	href="assets/plugins/datatables/datatables.min.css">

<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
					class="logo"
					>
					<img src="assets/mmec1.jpg" alt="Logo">
				</a> <a
					href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
					class="logo logo-small"> <img src="assets/symbol.png"
					alt="Logo" width="30" height="30">
				</a>
			</div>

			<div class="menu-toggle">
				<a href="javascript:void(0);" id="toggle_btn"> <i
					class="fas fa-bars"></i>
				</a>
			</div>






			<ul class="nav user-menu">




				<li class="nav-item dropdown has-arrow new-user-menus"><a
					href="#" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
						<span class="user-img"> <c:choose>
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
								<h6>${name }</h6>
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
								<h6>${name }</h6>
								<p class="text-muted mb-0">Staff</p>
							</div>
						</div>
						<a class="dropdown-item"
							href="profile?name=${name }&lastname=${lastname }&usn=${usn}&staffregid=${staffregid}">My
							Profile</a> <a class="dropdown-item" href="log-out">Logout</a>
					</div></li>

			</ul>

		</div>


		<div class="sidebar" id="sidebar">
			<div class="sidebar-inner slimscroll">
				<div id="sidebar-menu" class="sidebar-menu">
					<ul>
						<li class="menu-title"><span>Main Menu</span></li>
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Dashboard</span> <span class="menu-arrow"></span></a>
							<ul>

								<li><a
									href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Staff
										Dashboard</a></li>

							</ul></li>

						<li class="submenu active"><a href="#"><i
								class="fas fa-chalkboard-teacher"></i> <span> Staff</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-staff?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">View
										Info</a></li>


							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-building"></i> <span> Departments</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="departments">Department List</a></li>

							</ul></li>
						<li class="submenu "><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-subjects?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
									>Subject List</a></li>
								<li><a
									href="add-subject?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Subject
										Add</a></li>

							</ul></li>




						<li><a href="fees"><i class="fas fa-comment-dollar"></i>
								<span>Fees</span></a></li>
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Exam</span> <span class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-exams?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam
										List</a></li>
								<li><a
									href="exam-declaration?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam
										Declaration</a></li>
								<li><a
									href="add-exam-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">
										IA Exam Results</a></li>
								<li><a
									href="view-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"">
										Exam Results</a></li>
							</ul></li>



						<li class="submenu"><a href="#"><i
								class="fas fa-shield-alt"></i> <span> Authentication </span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="login">Login</a></li>
								<li><a href="register">Register</a></li>
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
								<h3 class="page-title">Staff Details</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="view-staff?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Staff</a></li>
									<li class="breadcrumb-item active">Staff Details</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="staff" items="${staff}">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-md-12">
									<div class="about-info">
										<h4>
											Profile <span><a href="javascript:;"><i
													class="feather-more-vertical"></i></a></span>
										</h4>
									</div>

									<div class="student-profile-head">
										<div class="profile-bg-img">
											<img src="assets/mmec.webp" alt="Profile">
										</div>
										<div class="row">
											<div class="col-lg-4 col-md-4">
												<div class="profile-user-box">
													<div class="profile-user-img">
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
													<div class="names-profiles">
														<h4>Prof. ${staff.firstName} ${staff.lastName}</h4>
														<h5>${staff.department}</h5>
													</div>
												</div>
											</div>


										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4">
									<div class="student-personals-grp">
										<div class="card">
											<div class="card-body">
												<div class="heading-detail">
													<h4>Personal Details :</h4>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-user"></i>
													</div>
													<div class="views-personal">
														<h4>Name</h4>
														<h5>Prof. ${staff.firstName} ${staff.lastName}</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<img src="assets/img/icons/buliding-icon.svg" alt="">
													</div>
													<div class="views-personal">
														<h4>Department</h4>
														<h5>${staff.department }</h5>
													</div>

												</div>

												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-phone-call"></i>
													</div>
													<div class="views-personal">
														<h4>Mobile</h4>
														<h5>${staff.mobile }</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-mail"></i>
													</div>
													<div class="views-personal">
														<h4>Email</h4>
														<h5>
															<a class="__cf_email__"
																data-cfemail="81e5e0e8f2f8c1e6ece0e8edafe2eeec">${staff.email }</a>
														</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-user"></i>
													</div>
													<div class="views-personal">
														<h4>Gender</h4>
														<h5>${staff.gender }</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-calendar"></i>
													</div>
													<div class="views-personal">
														<h4>Date of Birth</h4>
														<h5>${staff.dob }</h5>
													</div>
												</div>

												<div class="personal-activity mb-0">
													<div class="personal-icons">
														<i class="feather-map-pin"></i>
													</div>
													<div class="views-personal">
														<h4>Address</h4>
														<h5>${staff.address }</h5>
													</div>
												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="col-lg-8">

									<div class="row">
										<div class="col-lg-10">
											<div class="student-personals-grp">
												<div class="card">
													<div class="card-body">

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Joining Date</h4>
																<h5>${staff.joininDate}</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Experience</h4>
																<h5>${staff.experience }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Qualification</h4>
																<h5>${staff.qualification }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>City</h4>
																<h5>${staff.city }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>State</h4>
																<h5>${staff.state }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Zip code</h4>
																<h5>${staff.zipcode }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Country</h4>
																<h5>${staff.country }</h5>
															</div>
														</div>



													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>



		</div>

	</div>


	<script data-cfasync="false"
		src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>