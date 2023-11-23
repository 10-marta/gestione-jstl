<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<a  href="<%=request.getContextPath() %>/">
<img class="logo" src="immaginiProgetto/Logo_FCI_2023.png" alt="Logo F.C.I" align="left" width="150" height="50" >
</a>
<nav class="nav nav-tabs justify-content-end">
	<a class="nav-link dropdown-toggle" href="#" role="button"
		data-bs-toggle="dropdown" aria-expanded="false"> Gestione</a>
	<ul class="dropdown-menu">
		<li><a class="dropdown-item nav-link" href="<%=request.getContextPath() %>/gara?action=list">Gare</a></li>
		<li><a class="dropdown-item nav-link" href="<%=request.getContextPath() %>/atleta?action=list">Atleti</a></li>
	</ul>
	<a class="nav-link" href="https://www.federciclismo.it">Info</a>

</nav>
