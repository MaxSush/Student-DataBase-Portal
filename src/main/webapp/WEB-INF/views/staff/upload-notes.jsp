
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
						<li class="submenu active"><a href="#"><i
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
						<li class="submenu"><a href="#"><i class="feather-grid"></i>
								<span> Exam</span> <span class="menu-arrow"></span></a>
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
							<h3 class="page-title">Add Subject</h3>
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a href="subjects">Subject</a></li>
								<li class="breadcrumb-item active">Add Subject</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card">
							<div class="card-body">
								<form
									action="uploadNotes?usn=${usn}&name=${name}&lastname=${lastname}&staffregid=${staffregid}"
									method="post" enctype="multipart/form-data">
									<input type="hidden" name="subjectCode" value="${subjectCode }">
									<input type="hidden" name="subjectName" value="${subjectName }">
									<div class="row">
										<div class="col-12">
											<h5 class="form-title">
												<span>Subject Information</span>
											</h5>
										</div>
										<div class="col-12 col-sm-4">
											<div class="form-group students-up-files">
												<label>Upload Notes</label> <span id="fileNameDisplay"></span>
												<div class="uplod">
													<label class="file-upload image-upbtn mb-0"> Choose
														File <input type="file" name="sujectNotesFile"
														onchange="displayFileName(this)" accept=".pdf"
														id="pdfInput">
													</label>
													<div id="errorMessage" style="color: red;"></div>
												</div>
											</div>
										</div>

										<!-- Moved the element here -->



										<!-- End of moved element -->

										<div class="col-12">
											<div class="student-submit">
												<button type="submit" class="btn btn-primary">Add
													Subject</button>
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

									</div>
								</div>
								<div class="table-responsive">
									<table
										class="table border-0 star-student table-hover table-center mb-0 datatable table-striped"
										style="text-align: center;">
										<thead class="student-thread">


											<tr>
												<th>ID</th>
												<th>Subject Code</th>
												<th>Subject Name</th>
												<th>File Name</th>

												<th>Download</th>
												<th>Delete</th>
												


											</tr>
										</thead>

										<c:set var="subjects" value="${notes}" />
										<c:choose>
											<c:when test="${notes!=null}">

												<c:forEach var="notes" items="${notes }">
													<tbody>
														<tr>
															<td>${notes.id }</td>
															<td>${notes.subjectCode }</td>
															<td>${notes.subjectName }</td>
															<td>${notes.fileName }</td>


															<td><a
																href="download-notes?fileName=${notes.fileName }"
																style="background-color: royalblue; color: white;"
																class="btn btn-outline-primary me-2"><i
																	class="fas fa-download"></i> Download</a></td>
																	
																	<td><a
																href="delete-notes?notesid=${notes.id }&subjectCode=${notes.subjectCode }&subjectName=${notes.subjectName }&usn=${usn}&name=${name}&lastname=${lastname }&staffregid=${staffregid}"
																style="background-color: red; color: white;"
																class="btn btn-outline-primary me-2"><i
																	class="bi bi-trash"></i> Delete</a></td>
															


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

	<script>
		document
				.getElementById('pdfInput')
				.addEventListener(
						'change',
						function(event) {
							const file = event.target.files[0];
							const maxSizeInBytes = 20 * 1024 * 1024; // 20 MB

							if (file && file.type === 'application/pdf') {
								if (file.size > maxSizeInBytes) {
									document.getElementById('errorMessage').textContent = 'File size exceeds the limit (20MB)';
									event.target.value = ''; // Reset file input
								} else {
									document.getElementById('errorMessage').textContent = ''; // Clear error message
									// Process the file
								}
							} else {
								document.getElementById('errorMessage').textContent = 'Please upload a PDF file';
								event.target.value = ''; // Reset file input
							}
						});
	</script>

	<script src="assets/js/jquery-3.6.0.min.js"></script>

	<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="assets/js/feather.min.js"></script>

	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<script src="assets/plugins/datatables/datatables.min.js"></script>

	<script src="assets/js/script.js"></script>
</body>
</html>