<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Preskool - Exam</title>

<link rel="shortcut icon" href=assets/symbol.png>

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
<link rel="stylesheet" href="assets/college.css">
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}"
					class="logo"
					style="background-color: royalblue; width: 95%; border-radius: 5px;">
					<img src="assets/mmec1.jpg" alt="Logo">
				</a> <a
					href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}"
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
								<h6>${name }</h6>
								<p class="text-muted mb-0">Student</p>
							</div>
						</div>
						<a class="dropdown-item"
							href="Student-Profile?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">My
							Profile</a> <a class="dropdown-item" href="login">Logout</a>
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
					<div class="row align-items-center">
						<div class="col">
							<h3 class="page-title">Exam</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a
									href="student-dashboard?usn=${usn}&name=${name}&sem=${sem}&regid=${regid}&id=${id}">Dashboard</a></li>
								<li class="breadcrumb-item active">Exam</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<form
									action="exam-list?usn=${usn}&name=${name}&sem1=${sem}&regid=${regid}&id=${id}"
									method="post">
									<div class="row">
										<div class="col-12">
											<h5 class="form-title">
												<span>Exam Information</span> <span
													style="color: red; font-size: 15px">${msg }</span>
											</h5>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Semester <span class="login-danger">*</span></label>
												<select class="form-control select" name="sem"
													required="required">

													<option>Please Select Semester</option>
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
												<label>Scheme <span class="login-danger">*</span></label> <select
													class="form-control select" name="scheme"
													required="required">

													<option>Please Select Scheme</option>
													<option>2010</option>
													<option>2011</option>
													<option>2012</option>
													<option>2013</option>
													<option>2014</option>
													<option>2015</option>
													<option>2016</option>
													<option>2017</option>
													<option>2018</option>
													<option>2019</option>
													<option>2020</option>
													<option>2021</option>
													<option>2022</option>
													<option>2023</option>
													<option>2024</option>
													<option>2025</option>
													<option>2026</option>
													<option>2027</option>
													<option>2028</option>
													<option>2029</option>
													<option>2030</option>
													<option>2031</option>
													<option>2032</option>
													<option>2033</option>
													<option>2034</option>
													<option>2035</option>
													<option>2036</option>
													<option>2037</option>
													<option>2038</option>
													<option>2039</option>
													<option>2040</option>

												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Exam Type <span class="login-danger">*</span></label>
												<select class="form-control select" name="examType"
													required="required">


													<option>1st IA</option>
													<option>2nd IA</option>
													<option>3rd IA</option>

												</select>
											</div>
										</div>
										<div class="col-12">
											<div class="student-submit">
												<button type="submit" class="btn btn-primary">Get
													the Exams</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

				<c:set var="exam" value="${exams}" />
				<c:set var="processedSemesters" value="${processedSemesters}" />
				<c:choose>
					<c:when test="${exam!=null}">
						<c:forEach var="exam" items="${ exams}" varStatus="loop">
							<c:if test="${!processedSemesters.contains(exam.sem)}">
								<c:set var="dummy" value="${processedSemesters.add(exam.sem)}" />


								<div class="row">

									<div class="card card-table">
										<div class="card-body">

											<div class="page-header">
												<div class="row align-items-center">
													<div class="col">
														<h3 class="page-title">Semester - ${exam.sem } Exam</h3>
													</div>

												</div>
											</div>

											<div class="table-responsive">
												<table
													class="table border-0 star-student table-hover table-center mb-1 table-striped"
													style="text-align: center;">
													<thead class="student-thread">
														<tr>

															<th>Exam ID</th>
															<th>Subject Code</th>
															<th>Subject Name</th>
															<th>Semester</th>
															<th>Department</th>
															<th>Exam Type</th>
															<th>Date</th>
															<th>Time</th>


														</tr>
													</thead>

													<c:forEach items="${ exams}" var="e">
														<c:if test="${e.sem==exam.sem }">


															<tbody>


																<tr>

																	<td>${e.examId }</td>
																	<td>
																		<h2>
																			<a>${e.subjectCode }</a>
																		</h2>
																	</td>
																	<td>
																		<h2>
																			<a>${e.subjectName }</a>
																		</h2>
																	</td>
																	<td>${e.sem }</td>
																	<td>${e.department }</td>
																	<td>${e.examType }</td>
																	<td>${e.date }</td>
																	<td>${e.time }</td>

																</tr>

															</tbody>
														</c:if>


													</c:forEach>

												</table>
											</div>

										</div>
									</div>

								</div>

							</c:if>
						</c:forEach>

					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
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