 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Staff Details</title>

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
				<a href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}" class="logo" style="background-color:royalblue;width:95%; border-radius:5px;"> <img
					src="assets/mmec1.jpg" alt="Logo" >
				</a> <a href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}" class="logo logo-small"> <img
					src="assets/symbol.png" alt="Logo" width="30" height="30">
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
								<h6>${name}</h6>
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
						<a class="dropdown-item" href="profile?name=${name }&lastname=${lastname }&usn=${usn}&staffregid=${staffregid}">My Profile</a>  <a
							class="dropdown-item" href="log-out">Logout</a>
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
								
								<li><a href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Staff Dashboard</a></li>
								
							</ul></li>
						
						<li class="submenu active"><a href="#"><i
								class="fas fa-chalkboard-teacher"></i> <span> Staff</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="view-staff?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}" class="active">View Info</a></li>
								
								
							</ul></li>
						<li class="submenu"><a href="#"><i
								class="fas fa-building"></i> <span> Departments</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="departments">View Department</a></li>
								
							</ul></li>
						<li class="submenu "><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="view-subjects?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}" >Subject List</a></li>
								<li><a href="add-subject?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Subject Add</a></li>
								
							</ul></li>
						
						
						
						
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Exam</span> <span class="menu-arrow"></span></a>
							<ul>
								<li><a href="view-exams?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam List</a></li>
								<li><a href="exam-declaration?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam Declaration</a></li>
								<li><a href="add-exam-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"> IA Exam Results</a></li>
								<li><a href="view-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}""> Exam Results</a></li>
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
					<div class="row align-items-center">
						<div class="col">
							<h3 class="page-title">Staff</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Dashboard</a></li>
								<li class="breadcrumb-item active">Staff</li>
							</ul>
						</div>
					</div>
				</div>

				
				<div class="row">
					
						<div class="card card-table">
							<div class="card-body">

								<div class="page-header">
									<div class="row align-items-center">
										<div class="col">
											<h3 class="page-title">Staff</h3>
										</div>
										
									</div>
								</div>

								<div class="table-responsive">
									<table
										class="table border-0 star-student table-hover table-center mb-0  table-striped" style="text-align:center;">
										<thead class="student-thread">
											<tr>
											<th>ID</th>
												<th>Name</th>
												<th>Username</th>
												<th>Department</th>
												<th>Gender</th>
												<th>Mobile Number</th>
												<th>Email</th>
												<th class="text-end">Action</th>
											</tr>
										</thead>
										<c:forEach var="staff" items="${staff }">
										<tbody>
											<tr>
												<td>${staff.id }</td>
												<td>
													<h2 class="table-avatar">
														<a href="staff-details?usn=${staff.usn }&staffregid=${staffregid}&name=${staff.firstName}&lastname=${staff.lastName }">${staff.firstName } ${staff.lastName }</a>
													</h2>
												</td>
												<td>${staff.usn }</td>
												<td>${staff.department }</td>
												<td>${staff.gender }</td>
												<td>${staff.mobile }</td>
												<td>${staff.email }</td>
												
												<td class="text-end">
													<div class="actions">
														<a href="javascript:;"
															class="btn btn-sm bg-success-light me-2"> <i
															class="feather-eye"></i>
														</a> <a href="edit-teacher?usn=${staff.usn }&id=${staff.id}&staffregid=${staffregid}&name=${staff.firstName}&lastname=${staff.lastName }"
															class="btn btn-sm bg-danger-light"> <i
															class="feather-edit"></i>
														</a>
													</div>
												</td>
											</tr>
											
											
											
												
											
											
										</tbody>
										</c:forEach>
									</table>
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

	<script src="assets/plugins/datatables/datatables.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>