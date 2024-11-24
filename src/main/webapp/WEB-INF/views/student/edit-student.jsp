<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Edit Students</title>

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
<link rel="stylesheet" href="assets/css/custom1.css">
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="student-dashboard?usn=${student.usn}&name=${student.firstName}&sem=${student.sem}&regid=${regid}&id=${id}"
					class="logo"
					style="background-color: royalblue; width: 95%; border-radius: 5px;">
					<img src="assets/mmec1.jpg" alt="Logo">
				</a> <a
					href="student-dashboard?usn=${student.usn}&name=${student.firstName}&sem=${student.sem}&regid=${regid}&id=${id}"
					class="logo logo-small"> <img src="assets/symbol.png"
					alt="Logo" width="30" height="30">
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
										alt="${name }">
								</c:when>
								<c:otherwise>
									<img class="rounded-circle"
										src="assets/img/profiles/avatar-01.jpg" width="31"
										alt="${name }">
								</c:otherwise>
							</c:choose>
							<div class="user-text">
								<h6>${student.firstName}</h6>
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
								<h6>${student.firstName}</h6>
								<p class="text-muted mb-0">Student</p>
							</div>
						</div>
						<a class="dropdown-item"
							href="Student-Profile?usn=${student.usn}&name=${student.firstName}&sem=${student.sem}&regid=${regid}&id=${id}">My
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

		<form action="updateStudent?regid=${regid}" method="post"
			enctype="multipart/form-data">
			<div class="page-wrapper">
				<div class="content container-fluid">

					<div class="page-header">
						<div class="row align-items-center">
							<div class="col-sm-12">
								<div class="page-sub-header">
									<h3 class="page-title">Edit Students</h3>
									<ul class="breadcrumb">
										<li class="breadcrumb-item"><a
											href="view-student-info?usn=${student.usn}&name=${student.firstName}&sem=${student.sem}&regid=${regid}&id=${id}">Student</a></li>
										<li class="breadcrumb-item active">Edit Students</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<div class="card comman-shadow">
								<div class="card-body">

									<div class="row">
										<div class="col-12">
											<h5 class="form-title student-info">
												Student Information <span><a href="javascript:;"><i
														class="feather-more-vertical"></i></a></span>
											</h5>
										</div>
										<input type="hidden" name="id" value="${student.id }" /> <input
											type="hidden" name="password" value="${student.password }" />
										<input type="hidden" name="imgId" value="${imgId }">



										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>First Name <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter First Name" name="firstName"
													value="${student.firstName }" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Last Name <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter First Name" name="lastName"
													value="${student.lastName }" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Gender <span class="login-danger">*</span></label> <select
													class="form-control select" name="gender"
													required="required">
													<option>${student.gender }</option>
													<option>Select Gender</option>
													<option>Female</option>
													<option>Male</option>
													<option>Others</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms calendar-icon">
												<label>Date Of Birth <span class="login-danger">*</span></label>
												<input class="form-control datetimepicker" type="text"
													placeholder="DD-MM-YYYY" name="dob" required="required"
													value="${student.dob }">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>USN </label> <input class="form-control" type="text"
													placeholder="Enter USN Number" name="usn"
													value="${student.usn}" required="required">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Blood Group <span class="login-danger">*</span></label>
												<select class="form-control select" name="blood_group"
													required="required">
													<option>${student.blood_group }</option>
													<option>Please Select Group</option>
													<option>B+</option>
													<option>A+</option>
													<option>O+</option>

												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Religion <span class="login-danger">*</span></label>
												<select class="form-control select" name="religion"
													required="required">
													<option>${student.religion }</option>
													<option>Please Select Religion</option>
													<option>Hindu</option>
													<option>Jain</option>
													<option>Christian</option>
													<option>Muslim</option>
													<option>Others</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Category <span class="login-danger">*</span></label>
												<select class="form-control select" name="category">
													<option>${student.category }</option>
													<option>Please Select Category</option>
													<option>GM</option>
													<option>SC</option>
													<option>ST</option>
													<option>Cat-1</option>
													<option>2A</option>
													<option>2B</option>
													<option>3A</option>
													<option>3B</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>E-Mail <span class="login-danger">*</span></label> <input
													class="form-control" type="text"
													placeholder="Enter Email Address" name="email"
													required="required" value=${student.email }>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Sem <span class="login-danger">*</span></label> <select
													class="form-control select" name="sem" required="required">
													<option>${student.sem }</option>
													<option>Please Select Sem</option>
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
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Department <span class="login-danger">*</span></label>
												<select class="form-control select" name="department"
													required="required">
													<option>${student.department }</option>
													<option>Please Select Department</option>
													<option>Computer Science</option>
													<option>Electronics And Communication</option>
													<option>Robotics And AI</option>
													<option>Mechanical</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label> Mobile </label> <input class="form-control"
													type="text" placeholder="Enter Mobile Number" name="mobile"
													required="required" value="${student.mobile }">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label> Address </label> <input class="form-control"
													type="text" placeholder="Enter Address" name="address"
													required="required" value="${student.address }">
											</div>
										</div>

										<div class="col-12 col-sm-4">
											<div class="form-group students-up-files">
												<label>Upload Student Photo (150px X 150px)</label> <span
													id="fileNameDisplay"></span>
												<div class="uplod">
													<label class="file-upload image-upbtn mb-0"> Choose
														File <input type="file" name="imageData" 
														onchange="displayFileName(this)">
													</label>
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


			<div class="page-wrapper">
				<div class="content container-fluid">

					<div class="page-header">
						<div class="row align-items-center">
							<div class="col-sm-12">
								<div class="page-sub-header">
									<h3 class="page-title">Add Some Other Information</h3>
									<ul class="breadcrumb">
										<li class="breadcrumb-item"><a href="students">Student</a></li>
										<li class="breadcrumb-item active">Add Students</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-12">
							<div class="card comman-shadow">
								<div class="card-body">

									<div class="row">
										<div class="col-12">
											<h5 class="form-title student-info">
												Other Information <span><a href="javascript:;"><i
														class="feather-more-vertical"></i></a></span>
											</h5>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Father Name <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter Father Name" name="fatherName"
													required="required" value="${student.fatherName }">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Mother Name <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter Mother Name" name="motherName"
													required="required" value="${student.motherName }">
											</div>
										</div>

										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Student Addhar <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter Addhar Number" name="addharNumber"
													required="required" value="${student.addharNumber }">
											</div>
										</div>

										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Domicile <span class="login-danger">*</span></label>
												<select class="form-control select" name="domicile"
													required="required">
													<option>${student.domicile }</option>
													<option>Please Select Domicile</option>
													<option>Karnataka</option>
													<option>Non Karnataka</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Education Medium <span class="login-danger">*</span></label>
												<select class="form-control select" name="educationMedium"
													required="required">
													<option>${student.educationMedium }</option>
													<option>Please Select Medium</option>
													<option>Hindi</option>
													<option>Marathi</option>
													<option>English</option>
													<option>Kannada</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Dayschooler/Hosteller<span
													class="login-danger">*</span></label> <select
													class="form-control select" name="schooler"
													required="required">
													<option>${student.schooler }</option>
													<option>Please Select</option>
													<option>Dayschooler</option>
													<option>Hosteller</option>
												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Year of admission<span class="login-danger">*</span></label>
												<select class="form-control select" name="admissionYear"
													required="required">
													<option>${student.admissionYear }</option>
													<option>Please Select Year</option>
													<option>2029</option>
													<option>2028</option>
													<option>2027</option>
													<option>2026</option>
													<option>2025</option>
													<option>2024</option>
													<option>2023</option>
													<option>2022</option>
													<option>2021</option>
													<option>2020</option>
													<option>2019</option>
													<option>2018</option>
													<option>2017</option>
													<option>2016</option>
													<option>2015</option>
													<option>2014</option>
													<option>2013</option>
													<option>2012</option>
													<option>2011</option>
													<option>2010</option>
												</select>
											</div>
										</div>

										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Anual Income <span class="login-danger">*</span></label>
												<select class="form-control select" name="income"
													required="required">
													<option>${student.income }</option>
													<option>Please Select Income</option>
													<option>100000</option>
													<option>200000</option>
													<option>500000</option>
													<option>Others</option>
												</select>
											</div>
										</div>



										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Nationality <span class="login-danger">*</span></label>
												<select class="form-control select" name="nationality">
													<option>${student.nationality }</option>
													<option>Please Select Nationality</option>
													<option>Indian</option>
													<option>NRI</option>


												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Village/Town <span class="login-danger">*</span></label>
												<input class="form-control" type="text"
													placeholder="Enter Village/Town " name="town"
													required="required" value="${student.town }">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Taluka<span class="login-danger">*</span></label> <input
													class="form-control" type="text" placeholder="Enter Taluka"
													name="taluka" required="required"
													value="${student.taluka }">
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>State<span class="login-danger">*</span></label> <input
													class="form-control" type="text" placeholder="Enter State"
													name="state" required="required" value="${student.state }">
											</div>
										</div>

										<div class="col-12">
											<div class="student-submit">
												<button type="submit" class="btn btn-primary">Update</button>
											</div>
										</div>
									</div>

								</div>

							</div>

						</div>
					</div>

				</div>

			</div>
		</form>

	</div>


	<script>
		function displayFileName(input) {
			var fileNameDisplay = document.getElementById("fileNameDisplay");

			if (input.files && input.files.length > 0) {
				fileNameDisplay.textContent = "Selected file: "
						+ input.files[0].name;
			} else {
				fileNameDisplay.textContent = "";
			}
		}
	</script>


	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/plugins/select2/js/select2.min.js"></script>

	<script src="assets/plugins/moment/moment.min.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>