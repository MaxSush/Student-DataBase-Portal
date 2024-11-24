<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Fees History</title>

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

<link rel="stylesheet"
	href="assets/plugins/datatables/datatables.min.css">

<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="accountant-dashboard?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"
					class="logo"> <img src="assets/mmec1.jpg" alt="Logo">
				</a> <a
					href="accountant-dashboard?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"
					class="logo logo-small"> <img src="assets/symbol.png"
					alt="Logo" width="30" height="30">
				</a>
			</div>

			

			


			


			<ul class="nav user-menu">
				

				

				

				<li class="nav-item dropdown has-arrow new-user-menus"><a
					href="#" class="dropdown-toggle nav-link" data-bs-toggle="dropdown">
						<span class="user-img"> <img class="rounded-circle"
							src="assets/img/profiles/avatar-01.jpg" width="31"
							alt="Soeng Souy">
							<div class="user-text">
								<h6>Soeng Souy</h6>
								<p class="text-muted mb-0">Administrator</p>
							</div>
					</span>
				</a>
					<div class="dropdown-menu">
						<div class="user-header">
							<div class="avatar avatar-sm">
								<img src="assets/img/profiles/avatar-01.jpg" alt="User Image"
									class="avatar-img rounded-circle">
							</div>
							<div class="user-text">
								<h6>Soeng Souy</h6>
								<p class="text-muted mb-0">Administrator</p>
							</div>
						</div>
						<a class="dropdown-item" href="profile">My Profile</a>  <a
							class="dropdown-item" href="login">Logout</a>
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

								<li><a href="" class="active">Accountant Dashboard</a></li>

							</ul></li>







						


						<li class="submenu"><a href="#"><i
								class="fas fa-comment-dollar"></i> <span> Fees Management </span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a href="add-fees?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"><i class="fas fa-comment-dollar"></i>
								<span>Add Fess</span></a></li>
								<li><a href="add-students?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"><i class="fas fa-graduation-cap"></i>
								<span>Add Students</span></a></li>
								<li><a href="fees-collection?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"><i class="fas fa-comment-dollar"></i>
								<span>Fees Collection</span></a></li>
								<li><a href="fees-add-history?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"><i class="fas fa-comment-dollar"></i>
								<span>Fees History</span></a></li>

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
							<h3 class="page-title">Fees Collections</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="index">Dashboard</a></li>
								<li class="breadcrumb-item active">Fees Collections</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card card-table">
							<div class="card-body">

								<div class="page-header">
									<div class="row align-items-center">
										<div class="col">
											<h3 class="page-title">Fees Collections</h3>
										</div>
										<div class="col-auto text-end float-end ms-auto download-grp">
											<a href="#" class="btn btn-outline-primary me-2"><i
												class="fas fa-download"></i> Download</a> 
										</div>
									</div>
								</div>

								<div class="table-responsive">
									<table
										class="table border-0 star-student table-hover table-center mb-0 datatable table-striped" style="text-align:center;">
										<thead class="student-thread">
											<tr>
											<th>Reciept Id</th>
												<th>USN</th>
												
												<th>Semester</th>
												<th>Year</th>
												
												<th>Paid Fees</th>
												<th>Paid Date</th>
												
												
												<th class="text-end">Status</th>
											</tr>
										</thead>
										<c:forEach items="${all}" var="all">
										<tbody>
											<tr>
											<td>${all.recieptId }</td>
												<td>${all.studentUsn }</td>
												
												<td>${all.sem }</td>
												<td>${all.year }</td>
												
												<td>${all.feesAmount }</td>
												<td>${all.date }</td>
												
												
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

	</div>


	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/plugins/datatables/datatables.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>