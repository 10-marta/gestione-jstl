<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Lista Gare</title>
	<style>
	.footer {
      position: fixed;
      bottom: 0;
      width: 100%;
      background-color: #f8f8ff;
      padding: 10px;
      text-align: center;
    }</style>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<main>
		<h4>Visualizzazione Gare</h4>
		<a href="<%=request.getContextPath()%>/gara?action=new" class="btn btn-primary">Nuovo</a>
		<table class="table table-bordered">
  			<thead>
				<tr>
					<th scope="col">Id Gara</th>
					<th scope="col">Denominazione</th>
					<th scope="col">Luogo</th>
					<th scope="col">Data della gara</th>
					<th scope="col">Data svolta</th>
				</tr>
			</thead>
			<tbody class="table-group-divider table-light">
			<c:forEach items="${listaGare}" var="gara">
			<tr>
            					<td scope="col"><c:out value="${gara.id_gara}" /></td>
            					<td scope="col"><c:out value="${gara.denominazione}"/></td>
            					<td scope="col"><c:out value="${gara.luogo}" /></td>
            				    <td scope="col"><c:out value="${gara.datagara}" /></td>
            				    <td scope="col"><c:out value="${gara.datasvoltasi}" /></td>
            					<td scope="col"><a href="<%= request.getContextPath()%>/gara?action=edit&id=<c:out value='${gara.id_gara}'/>" class="btn btn-warning">Modifica</a>
                                                    								&nbsp;&nbsp;&nbsp;&nbsp; <a
                                                    								href="<%= request.getContextPath()%>/gara?action=delete&id=<c:out value='${gara.id_gara}' />" class="btn btn-danger">Elimina</a></td>
            				</tr>
            	</c:forEach>
			</tbody>
		</table>

	</main>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>