<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Add Fees</title>

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

<link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">

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
			<div class="menu-toggle">
				<a href="javascript:void(0);" id="toggle_btn"> <i
					class="fas fa-bars"></i>
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
								<li class="active"><a href="add-fees?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&department=${department}"><i class="fas fa-comment-dollar"></i>
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
							<h3 class="page-title">Add Fees</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="fees">Fees</a></li>
								<li class="breadcrumb-item active">Add Fees</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<form action="Add-Fees?usn=${usn }&firstName=${firstName}&lastName=${lastName}&acRegId=${acRegId}&Acdepartment=${department}" method="post" enctype="multipart/form-data">
									<div class="row">
										<div class="col-12">
											<h5 class="form-title">
												<span>Fees Information</span>
											</h5>
										</div>
										
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Fees ID</label> <input type="text"
													class="form-control" name="recieptId" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>USN</label> <input type="text"
													class="form-control" name="studentUsn" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Student Name</label> <input type="text"
													class="form-control" name="studentname" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Department</label> <select
													class="form-control select" name="department" required="required">
													<option>${Student_department }</option>
													<option>Select Department</option>
													<option>Computer Science</option>
													<option>Electronics and Communication</option>
													<option>Robotics and AI</option>
													<option>Mechanical</option>
													
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Semeter</label> <select class="form-control select" name="sem" required="required">
													<option>${sem }</option>
													<option>Select Semeter</option>
													
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
													<option>6</option>
													<option>7</option>
													<option>8</option>
													
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Year</label> <select class="form-control select" name="year" required="required">
													<option>${year }</option>
													<option>Select Year</option>
													
													<option>1st year</option>
													<option>2nd year</option>
													<option>3rd year</option>
													<option>4th year</option>
													
													
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Fees Amount</label> <input type="text"
													class="form-control" name="feesAmount" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-6">
											<div class="form-group">
												<label>Date</label> <input type="date"
													class="form-control" name="date" value="${date }" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group students-up-files">
												<label>Upload Fees Reciept Image</label>
												<div class="uplod">
													<label class="file-upload image-upbtn mb-0"> Choose
														File <input type="file" name="feesImageData" required="required">
													</label>
												</div>
											</div>
										</div>
										<div class="col-12">
											<button type="submit" class="btn btn-primary">Submit</button>
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

	<script src="assets/plugins/select2/js/select2.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>