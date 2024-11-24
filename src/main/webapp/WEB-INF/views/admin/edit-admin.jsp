<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Edit Staff</title>

<link rel="shortcut icon" href="assets/symbol.png">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="assets/plugins/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" href="assets/plugins/feather/feather.css">

<link rel="stylesheet" href="assets/plugins/icons/flags/flags.css">

<link rel="stylesheet"
	href="assets/css/bootstrap-datetimepicker.min.css">

<link rel="stylesheet"
	href="assets/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">

<link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">

<link rel="stylesheet" href="assets/css/style.css">
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
								<h6>${firstname }</h6>
								<p class="text-muted mb-0">Staff</p>
							</div>
						</div>
						<a class="dropdown-item"
							href="admin-profile?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">My
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
								class="fas fa-chalkboard-teacher"></i> <span> Teachers</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="teachers">Teacher List</a></li>
								<li><a href="teacher-details">Teacher View</a></li>


							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-building"></i> <span> Departments</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="departments">Department List</a></li>
								<li><a href="add-department">Department Add</a></li>
								<li><a href="edit-department">Department Edit</a></li>
							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="subjects">Subject List</a></li>

							</ul></li>




						<li><a href="fees"><i class="fas fa-comment-dollar"></i>
								<span>Fees</span></a></li>
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
					<div class="row align-items-center">
						<div class="col">
							<h3 class="page-title">Edit Staff</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a
									href="view-staff?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Staff</a></li>
								<li class="breadcrumb-item active">Edit Staff</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<form action="updateAdmin?staffregid=${adminRegId }"
									method="post" enctype="multipart/form-data">
									<div class="row">
										<div class="col-12">
											<h5 class="form-title">
												<span>Basic Details</span>
											</h5>
										</div>
										<input type="hidden" name="adminId" value="${admin.adminId }">
										<input type="hidden" name="adminRegId" value="${adminRegId }">
										<input type="hidden" name="password"
											value="${admin.password }">
											<input type="hidden" name="adminImgId" value="${adminImgId }"> 
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>First Name <span class="login-danger">*</span></label>
												<input type="text" class="form-control"
													value="${admin.firstName }" required="required"
													name="firstName">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Last Name <span class="login-danger">*</span></label>
												<input type="text" class="form-control"
													value="${admin.lastName }" required="required"
													name="lastName">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Username <span class="login-danger">*</span></label>
												<input type="text" class="form-control"
													value="${admin.usn }" required="required" name="usn">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Gender <span class="login-danger">*</span></label> <select
													class="form-control select" required="required"
													name="gender">
													<option>${admin.gender }</option>
													<option>Male</option>
													<option>Female</option>
													<option>Others</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms calendar-icon">
												<label>Date Of Birth <span class="login-danger">*</span></label>
												<input class="form-control datetimepicker" type="text"
													value="${admin.dob }" required="required"
													placeholder="00-00-0000" name="dob">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Mobile <span class="login-danger">*</span></label> <input
													type="text" class="form-control" value="${admin.mobile }"
													required="required" name="mobile">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms calendar-icon">
												<label>Joining Date <span class="login-danger">*</span></label>
												<input class="form-control datetimepicker" type="text"
													value="${admin.joininDate }" required="required"
													placeholder="00-00-0000" name="joininDate">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Department <span class="login-danger">*</span></label>
												<select class="form-control select" required="required"
													name="department">
													<option>${admin.department }</option>
													<option>Computer Science</option>
													<option>Electronics and Communication</option>
													<option>Robotics and AI</option>
													<option>Mechanical</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Qualification <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													value="${admin.qualification }" required="required"
													name="qualification">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Experience <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													value="${admin.experience }" required="required"
													name="experience">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Email <span class="login-danger">*</span></label> <input
													class="form-control" type="text" value="${admin.email }"
													required="required" name="email">
											</div>
										</div>



										<div class="col-12">
											<h5 class="form-title">
												<span>Address</span>
											</h5>
										</div>
										<div class="col-12 ">
											<div class="form-group local-forms">
												<label>Address <span class="login-danger">*</span></label> <input
													type="text" class="form-control" value="${admin.address }"
													required="required" name="address">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>City <span class="login-danger">*</span></label> <input
													type="text" class="form-control" value="${admin.city }"
													required="required" name="city">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>State <span class="login-danger">*</span></label> <input
													type="text" class="form-control" value="${admin.state }"
													required="required" name="state">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Zip Code <span class="login-danger">*</span></label>
												<input type="text" class="form-control"
													value="${admin.zipcode }" required="required"
													name="zipcode">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Country <span class="login-danger">*</span></label> <input
													type="text" class="form-control" value="${admin.country }"
													required="required" name="country">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group students-up-files">
												<label>Upload Staff Photo (150px X 150px)</label>
												<div class="uplod">
													<label class="file-upload image-upbtn mb-0"> Choose
														File <input type="file" name="AdminImageData">
													</label>
												</div>
											</div>
										</div>
										<div class="col-12">
											<div class="student-submit">
												<button type="submit" class="btn btn-primary">Submit</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/plugins/moment/moment.min.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>

	<script src="assets/plugins/select2/js/select2.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>