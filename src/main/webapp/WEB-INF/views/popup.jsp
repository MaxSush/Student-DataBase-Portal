<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/popup.css">
</head>
<body>
	<div class="popup" id="popup">

		<h2>Thank You</h2>
		<p>You have successfully registered with MMEC</p>
		<p>Please use otp as your password that sent on email</p>
		<button type="button" class="ok" onclick="closepopup()">OK</button>
	</div>
	
	<script>
		let popup = document.getElementById("popup");
		function openPopup() {
			popup.classList.add("open-popup");
		}
		function closePopup() {
			popup.classList.remove("open-popup");
		}
	</script>
</body>
</html>