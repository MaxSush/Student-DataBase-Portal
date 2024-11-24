<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Preskool - Subjects</title>

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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css"
	rel="stylesheet">

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
								<h6>${name}</h6>
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
						<li class="submenu active"><a href="#"><i
								class="fas fa-book-reader"></i> <span> Subjects</span> <span
								class="menu-arrow"></span></a>
							<ul>
								<li><a
									href="view-subjects?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
									class="active">Subject List</a></li>
								<li><a
									href="add-subject?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Subject
										Add</a></li>

							</ul></li>


						<li><a href="fees"><i class="fas fa-comment-dollar"></i>
								<span>Fees</span></a></li>
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Exam</span> <span class="menu-arrow"></span></a>
							<ul>
								<li><a href="view-exams?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam List</a></li>
								<li><a href="exam-declaration?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Exam Declaration</a></li>
								<li><a href="add-exam-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"> IA Exam Results</a></li>
								<li><a href="view-result?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"> Exam Results</a></li>
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
							<h3 class="page-title">Subjects</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a
									href="staff-dashboard?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}">Dashboard</a></li>
								<li class="breadcrumb-item active">Subjects</li>
							</ul>
						</div>
					</div>
				</div>
				<form action="get-Subjects?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}" method="post">
				<div class="col-12 col-sm-4">
					<div class="form-group local-forms">
						<label>Scheme <span class="login-danger">*</span></label> <select
							class="form-control select" name="scheme" required="required">

							<option>${scheme }</option>
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
				<div class="col-12">
					<div class="student-submit">
						<button type="submit" class="btn btn-primary">View Subjects</button>
					</div>
				</div>
				</form>
				<c:set var="subject" value="${subjects}" />
				<c:set var="processedSemesters" value="${processedSemesters}" />
				
				<c:choose>
					<c:when test="${subject!=null}">
						<c:forEach var="subject" items="${ subjects}" varStatus="loop">
							<c:if test="${!processedSemesters.contains(subject.sem)}">
								
									<c:set var="dummy"
										value="${processedSemesters.add(subject.sem)}" />
									



									<div class="row">

										<div class="card card-table">
											<div class="card-body">

												<div class="page-header">
													<div class="row align-items-center">
														<div class="col">
															<h3 class="page-title">Semester - ${subject.sem }
																Subjects ${subject.scheme } - Scheme</h3>
														</div>

													</div>
												</div>

												<div class="table-responsive">
													<table
														class="table border-0 star-student table-hover table-center mb-1 table-striped"
														style="text-align: center;">
														<thead class="student-thread">
															<tr>

																<th>ID</th>
																<th>Subject Code</th>
																<th>Subject Name</th>
																<th>Semester</th>
																<th>Department</th>
																<th>Scheme</th>
																<th>Edit</th>
																<th>Delete</th>

															</tr>
														</thead>

														<c:forEach items="${ subjects}" var="s">
															<c:if test="${s.sem==subject.sem }">
																

																	<tbody>


																		<tr>

																			<td>${s.subid }</td>
																			<td>
																				<h2>
																					${s.subjectCode }
																				</h2>
																			</td>
																			<td>
																				<h2>
																					<a href="upload-notes?usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}&subjectCode=${s.subjectCode }&subjectName=${s.subjectName}">${s.subjectName }</a>
																				</h2>
																			</td>
																			<td>${s.sem }</td>
																			<td>${s.department }</td>
																			<td>${s.scheme }</td>
																			<td><a
																				href="edit-subject?subid=${s.subid }&usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"><i
																					class="bi bi-pencil-square"></i></a></td>
																			<td><a
																				href="deleteSubject?subid=${s.subid }&usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"><i
																					class="bi bi-trash"></i></a></td>

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