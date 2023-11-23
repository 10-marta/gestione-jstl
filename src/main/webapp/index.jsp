<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=width-device, initial-scale=1.0">
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Gestione Gare</title>
<style>
.footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #f8f8ff;
	padding: 10px;
	text-align: center;
}

#carouselExampleAutoplaying {
	width: 40%;
	margin: auto;
	margin-top: 20px;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>

	<main>
		<div id="carouselExampleAutoplaying" class="carousel slide"
			data-bs-ride="carousel" style="width: 40%; margin: auto;">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img alt="bici" src="immaginiProgetto/mtb.jpg"
						class="d-block w-100" style="width: 100%; height: 100%;"
						height="200">
				</div>
				<div class="carousel-item">
					<img src="immaginiProgetto/strada.jpg" class="d-block w-100"
						alt="bicistrada" style="width: 50%; height: 50%;" height="200">
				</div>
				<div class="carousel-item">
					<img src="immaginiProgetto/enduro.jpg" class="d-block w-100"
						alt="enduro" style="width: 50%; height: 50%;" height="200">
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>

