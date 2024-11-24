<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>MMEC - Student Details</title>

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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
								<c:when test="${adminimage!=null }">
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
								<p class="text-muted mb-0">Administrator</p>
							</div>
					</span>
				</a>
					<div class="dropdown-menu">
						<div class="user-header">
							<div class="avatar avatar-sm">
								<c:choose>
									<c:when test="${adminimage!=null }">
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
								<p class="text-muted mb-0">Administrator</p>
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
					<div class="row">
						<div class="col-sm-12">
							<div class="page-sub-header">
								<h3 class="page-title">Student Details</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="view-students?usn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}">Student</a></li>
									<li class="breadcrumb-item active">Student Details</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<c:forEach var="student" items="${student}">
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
														<h4>${student.firstName} ${student.lastName}</h4>
														<h5>${student.department}</h5>
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
														<h5>${student.firstName} ${student.lastName}</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<img src="assets/img/icons/buliding-icon.svg" alt="">
													</div>
													<div class="views-personal">
														<h4>Department</h4>
														<h5>${student.department }</h5>
													</div>

												</div>

												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-phone-call"></i>
													</div>
													<div class="views-personal">
														<h4>Mobile</h4>
														<h5>${student.mobile }</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-mail"></i>
													</div>
													<div class="views-personal">
														<h4>Email</h4>
														<h5>
															<a
																class="__cf_email__"
																>${student.email }</a>
														</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-user"></i>
													</div>
													<div class="views-personal">
														<h4>Gender</h4>
														<h5>${student.gender }</h5>
													</div>
												</div>
												<div class="personal-activity">
													<div class="personal-icons">
														<i class="feather-calendar"></i>
													</div>
													<div class="views-personal">
														<h4>Date of Birth</h4>
														<h5>${student.dob }</h5>
													</div>
												</div>

												<div class="personal-activity mb-0">
													<div class="personal-icons">
														<i class="feather-map-pin"></i>
													</div>
													<div class="views-personal">
														<h4>Address</h4>
														<h5>${student.address }</h5>
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
																<h4>Father Name</h4>
																<h5>${student.fatherName}</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Mother Name</h4>
																<h5>${student.motherName }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Student Addhar</h4>
																<h5>${student.addharNumber }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Domicile</h4>
																<h5>${student.domicile }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Category</h4>
																<h5>${student.category }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Semester</h4>
																<h5>${student.sem }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Education Medium</h4>
																<h5>${student.educationMedium }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Schooler</h4>
																<h5>${student.schooler }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Blood Group</h4>
																<h5>${student.blood_group }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Admission Year</h4>
																<h5>${student.admissionYear }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Annual Income</h4>
																<h5>${student.income }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Nationality</h4>
																<h5>${student.nationality }</h5>
															</div>
														</div>

														<div class="personal-activity">

															<div class="views-personal">
																<h4>Village/Town</h4>
																<h5>${student.town }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>Taluka</h4>
																<h5>${student.taluka }</h5>
															</div>
														</div>
														<div class="personal-activity">

															<div class="views-personal">
																<h4>State</h4>
																<h5>${student.state }</h5>
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
				<form id="resultForm"
					action="getResults-for-students?adminusn=${usn }&firstname=${firstname}&lastname=${lastname}&adminRegId=${adminRegId}&department=${department}"
					method="post">
					<div class="col-12 col-sm-4">
						<div class="form-group local-forms">
							<label style="background-color: cyan; color: black;">Exam
								Type <span class="login-danger">*</span>
							</label> <select class="form-control select" name="examType"
								required="required" id="examType"
								style="background-color: royalblue; color: white;">


								<option>Choose Exam Type</option>
								<option>1st IA</option>
								<option>2nd IA</option>
								<option>3rd IA</option>

							</select>
						</div>
					</div>
					<input type="hidden" name="studentUsn" value="${studentusn }">
				</form>
				<script>
					$('#examType').change(function() {
						$('#resultForm').submit();
					});
				</script>
				<c:set var="result" value="${results}" />
				<c:set var="processedSemesters" value="${processedSemesters}" />

				<c:choose>
					<c:when test="${result != null}">
						<c:forEach var="res" items="${result}" varStatus="loop">
							<c:if test="${!processedSemesters.contains(res.sem)}">
								<c:set var="dummy" value="${processedSemesters.add(res.sem)}" />

								<div class="row">
									<div class="card card-table">
										<div class="card-body">
											<div class="page-header">
												<div class="row align-items-center">
													<div class="col">
														<h3 class="page-title">Semester - ${res.sem}
															${res.examType} Exam Result</h3>
													</div>
												</div>
											</div>

											<div class="table-responsive">
												<table
													class="table border-0 star-student table-hover table-center mb-1 table-striped"
													style="text-align: center;">
													<thead class="student-thread">
														<tr>
															<th>USN</th>
															<th>Subject Name</th>
															<th>Subject Code</th>
															<th>Maximum marks</th>
															<th>Obtained Marks</th>
															<th>Department</th>
															<th>Exam Type</th>
														</tr>
													</thead>

													<tbody>
														<c:forEach items="${results}" var="s">
															<c:if test="${s.sem == res.sem}">
																<tr>
																	<td>${s.studentUsn}</td>
																	<td>${s.subjectName}</td>
																	<td>${s.subjectCode}</td>
																	<td>${s.maxMarks}</td>
																	<td>${s.obtainedMarks}</td>
																	<td>${s.department}</td>
																	<td>${s.examType}</td>
																</tr>
															</c:if>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<!-- Add code for handling the case when results are null -->
					</c:otherwise>
				</c:choose>

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