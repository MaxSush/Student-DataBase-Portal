
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Preskool - Subject</title>

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
<link rel="stylesheet" href="assets/college.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.align-center {
	text-align: center;
}
</style>
</head>
<body>

	<div class="main-wrapper">

		<div class="header">

			<div class="header-left">
				<a
					href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
					class="logo"> <img src="assets/mmec1.jpg" alt="Logo">
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
									href="view-subjects?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Subject
										List</a></li>
								<li><a
									href="add-subject?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Subject
										Add</a></li>

							</ul></li>




						<li><a href="fees"><i class="fas fa-comment-dollar"></i>
								<span>Fees</span></a></li>
						<li class="submenu"><a href="#"><i class="feather-grid"
								class="active"></i> <span> Exam</span> <span class="menu-arrow"></span></a>
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
									href="view-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">
										Exam Results</a></li>
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
							<h3 class="page-title">Add Result</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="subjects">Result</a></li>
								<li class="breadcrumb-item active">Add Result</li>
							</ul>
						</div>
					</div>
				</div>

				<form
					action="findAllStudents?usn=${usn }&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
					method="post" id="form">

					<div class="col-11 col-sm-4">
						<div class="form-group local-forms">
							<label>Semester <span class="login-danger">*</span></label> <select
								class="form-control select" name="sem" required="required">

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
							<label>Scheme <span class="login-danger">*</span></label> <select
								class="form-control select" name="scheme" required="required"
								id="scheme">

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




				</form>
				<script>
					$('#scheme').change(function() {
						$('#form').submit();
					});
				</script>

				<form id="subjectForm"
					action="subject?usn=${usn }&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
					method="post">
					<input type="hidden" name="department" value="${department }">
					<input type="hidden" name="scheme" value="${scheme }"> <input
						type="hidden" name="sem" value="${sem }" /> <input type="hidden"
						name="studentUsn" value="${studentUsn }">

					<div class="col-12 col-sm-4">
						<div class="form-group local-forms">
							<label> <span class="login-danger">*</span></label> <select
								class="form-control select" name="subjectName"
								required="required" id="subject">


								<option>Select Subject</option>
								<c:forEach items="${subjects }" var="subject">

									<c:choose>
										<c:when test="${subject!=null }">
											<option>${subject.subjectName}</option>
										</c:when>
									</c:choose>



								</c:forEach>

							</select>
						</div>
					</div>


				</form>
				<script>
					$('#subject').change(function() {
						$('#subjectForm').submit();
					});
				</script>
				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">

								<div class="row">
									<div class="col-12">
										<h5 class="form-title">
											<span>Result Information</span> <span
												style="color: red; font-size: 15px">${examresult }</span>
										</h5>
									</div>

									<div class="table-responsive">
										<table
											class="table border-0 star-student table-hover table-center mb-0 datatable table-striped"
											style="text-align: center;">
											<thead class="student-thread">


												<tr>
													<th>USN</th>
													<th>Semester</th>
													<th>Subject Name</th>

													<th>1st IA Marks</th>
													<th>2nd IA Marks</th>
													<th>3rd IA Marks</th>
													<th>Maximum Marks</th>
													<th>Result</th>





												</tr>
											</thead>

											<c:set var="student" value="${student}" />
											<c:choose>
												<c:when test="${student!=null}">

													<c:forEach var="student" items="${student }">



														<form
															action="Declare-result?usn=${usn }&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
															method="post">
															<tbody>

																<tr>

																	<td>${student.usn }</td>
																	<td>${student.sem }</td>
																	<td>${subjectName }</td>
																	<input type="hidden" name="studentUsn"
																		value="${student.usn }" />
																	<input type="hidden" name="department"
																		value="${student.department }" />
																	<input type="hidden" name="scheme" value="${scheme}" />

																	<input type="hidden" name="sem" value="${student.sem }" />
																	<input type="hidden" name="subjectName"
																		value="${subjectName }" />
																	<c:choose>
																		<c:when test="${id!=null }">
																			<input type="hidden" name="id" value="${id}" />
																		</c:when>

																	</c:choose>
																	<c:set var="result" value="${results[student.usn]}" />
																	<td>
																		<div class="form-group local-forms">

																			<input type="text" class="form-control"
																				required="required" name="FirstIA"
																				value="${result.FirstIA}">
																		</div>
																	</td>


																	<td>
																		<div class="form-group local-forms">

																			<input type="text" class="form-control"
																				required="required" name="SecondIA"
																				value="${result.SecondIA}">
																		</div>
																	</td>
																	<td>
																		<div class="form-group local-forms">

																			<input type="text" class="form-control"
																				required="required" name="ThirdIA"
																				value="${result.ThirdIA}">
																		</div>
																	</td>
																	<td>
																		<div class="form-group local-forms">

																			<input type="text" class="form-control"
																				required="required" name="maxMarks"
																				value="${result.maxMarks}">
																		</div>
																	</td>
																	<td>${result.result}</td>


																	<td>
																		<button type="submit" class="btn btn-primary">
																			Result</button>
																	</td>



																</tr>






															</tbody>
														</form>
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

	</div>


	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>