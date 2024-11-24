
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Preskool - Subject</title>

<link rel="shortcut icon" href="assets/symbol.png">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,500;0,600;0,700;1,400&display=swap">

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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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

						<li class="submenu"><a href="#"><i
								class="fas fa-chalkboard-teacher"></i> <span> Staffs</span> <span
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




						<li><a href="fees"><i class="fas fa-comment-dollar" ></i>
								<span>Fees</span></a></li>
						<li class="submenu"><a href="#"><i class="feather-grid" class="active"></i>
								<span> Exam</span> <span class="menu-arrow" ></span></a>
							<ul>
								<li><a href="view-exams?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam List</a></li>
								<li><a href="exam-declaration?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam Declaration</a></li>
								<li><a href="add-exam-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"> IA Exam Results</a></li>
								<li><a href="view-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"> Exam Results</a></li>
							</ul></li>





						<li class="menu-title"><span>Pages</span></li>
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
							<h3 class="page-title">Exam Declaration</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a
									href="exam-declaration?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam</a></li>
								<li class="breadcrumb-item active">Exam Declaration</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<form
									action="getSubjects?usn=${usn }&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
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
													<c:choose>
														<c:when test="${sem!=null }">
															<option>${sem }</option>
														</c:when>
														<c:otherwise>
															<option>Please Select Semester</option>
															<option>1</option>
															<option>2</option>
															<option>3</option>
															<option>4</option>
															<option>5</option>
															<option>6</option>
															<option>7</option>
															<option>8</option>
														</c:otherwise>
													</c:choose>
												</select>
											</div>
										</div>


										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Department <span class="login-danger">*</span></label>
												<select class="form-control select" name="department"
													required="required">
													<c:choose>
														<c:when test="${department!=null }">
															<option>${department }</option>
														</c:when>
														<c:otherwise>
															<option>Please Select Department</option>
															<option>Computer Science</option>
															<option>Electronics And Communication</option>
															<option>Robotics And AI</option>
															<option>Mechanical</option>
														</c:otherwise>
													</c:choose>

												</select>
											</div>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group local-forms">
												<label>Scheme <span class="login-danger">*</span></label> <select
													class="form-control select" name="scheme"
													required="required">
													<c:choose>
														<c:when test="${scheme!=null }">
															<option>${scheme }</option>
														</c:when>
														<c:otherwise>
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
														</c:otherwise>

													</c:choose>
												</select>
											</div>
										</div>
										<div class="col-12">
											<div class="student-submit">
												<button type="submit" class="btn btn-primary">Get
													the Subjects</button>
											</div>
										</div>
									</div>
								</form>
							</div>
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
											<h3 class="page-title">Subjects</h3>

										</div>
										<span style="font-size: 20px; color: red;"> ${examMsg }</span>

									</div>
								</div>

								<div class="table-responsive">
									<table style="text-align: center;"
										class="table border-0 star-student table-hover table-center mb-0 datatable table-striped">
										<thead class="student-thread">


											<tr>
												<th>ID</th>
												<th>Subject Code</th>
												<th>Subject Name</th>
												<th>Department</th>
												<th>Semester</th>
												<th>Date</th>
												<th>Time</th>
												<th>Exam Type</th>
												<th>Scheme</th>




											</tr>
										</thead>

										<c:set var="subjects" value="${subjects}" />
										<c:choose>
											<c:when test="${subjects!=null}">

												<c:forEach var="subject" items="${subjects }">




													<tbody>

														<tr>

															<form
																action="examDeclared?usn=${usn }&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
																method="post">

																<td>${subject.subid }</td>
																<td>${subject.subjectCode }</td>
																<td>${subject.subjectName }</td>
																<td>${subject.department }</td>
																<td>${subject.sem }</td>

																<td><input class="form-control datetimepicker"
																	type="date" placeholder="00-00-0000" name="date"></td>
																<td><input type="time" class="form-control"
																	name="time"></td>
																<td><select class="form-control select"
																	name="examType" required="required">


																		<option>1st IA</option>
																		<option>2nd IA</option>
																		<option>3rd IA</option>

																</select></td>
																<td>${subject.scheme }</td>
																<td>
																	<div class="col-12">
																		<div class="student-submit">
																			<input type="hidden" value="${subject.subid  }"
																				name="subid" /> <input type="hidden"
																				value="${subject.subjectCode  }" name="subjectCode" />
																			<input type="hidden" value="${subject.subjectName  }"
																				name="subjectName" /> <input type="hidden"
																				value="${subject.department }" name="department" />
																			<input type="hidden" value="${subject.sem }"
																				name="sem" /> <input type="hidden"
																				value="${subject.scheme }" name="scheme" />
																			<button type="submit" class="btn btn-primary">Exam
																				Declare</button>
																		</div>
																	</div>
																</td>
															</form>

														</tr>






													</tbody>

												</c:forEach>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose>



									</table>

								</div>


							</div>
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
											<h3 class="page-title">Exam Declared</h3>
										</div>


									</div>
								</div>

								<div class="table-responsive">
									<table style="text-align: center;"
										class="table border-0 star-student table-hover table-center mb-0 datatable table-striped">
										<thead class="student-thread">


											<tr>
												<th>Exam ID</th>
												<th>Subject Code</th>
												<th>Subject Name</th>
												<th>Department</th>
												<th>Semester</th>
												<th>Date</th>
												<th>Time</th>
												<th>Exam Type</th>




											</tr>
										</thead>

										<c:set var="exam" value="${exams}" />
										<c:choose>
											<c:when test="${exam!=null}">

												<c:forEach var="exam" items="${exam }">




													<tbody>

														<tr>



															<td>${exam.examId }</td>
															<td>${exam.subjectCode }</td>
															<td>${exam.subjectName }</td>
															<td>${exam.department }</td>
															<td>${exam.sem }</td>
															<td>${exam.date }</td>
															<td>${exam.time }</td>
															<td>${exam.examType }</td>







														</tr>






													</tbody>

												</c:forEach>
											</c:when>
											<c:otherwise>

											</c:otherwise>
										</c:choose>



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

	<script src="assets/js/script.js"></script>
</body>
</html>