 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
<meta charset="UTF-8">
<title>Getione Gare</title>
<style>
	.footer {
      position: fixed;
      bottom: 0;
      width: 100%;
      background-color: #f8f8ff;
      padding: 10px;
      text-align: center;
    }
</style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<jsp:include page="../common/header.jsp"></jsp:include>

	<h4 class="area"> Gestione Gara</h4>

    <div class="container col-md-3">
        <div class="card border-info">
			<div class="card-body">

			<form
            <c:if test="${gara != null}">
                action="gara?action=update"
            </c:if>
            <c:if test="${gara == null}">
	          action="gara?action=insert"
	        </c:if>
            method="post">

    <fieldset class="form-group">
	    <legend>Nuova Gara</legend>

	    <fieldset class="form-group">
	        <label>Id Gara<input type="text" class="form-control" name="id" value="<c:out value='${gara.id_gara}'/>"></label>
	    </fieldset>

	    <fieldset class="form-group">
			<label>Nome Gara<input type="text" class="form-control" name="nomeGara" value="<c:out value='${gara.denominazione}'/>"></label>
		</fieldset>

		<fieldset class="form-group">
			<label>Luogo di svolgimento<input type="text" class="form-control" name="luogo" value="<c:out value='${gara.luogo}' />"></label>
		</fieldset>

		<fieldset class="form-group">
			<label>Data<input type="date" class="form-control" name="data" value="<c:out value='${gara.datagara}' />"></label>
		</fieldset>

        <fieldset class="form-group">
        	<label>Data svoltasi<input type="date" class="form-control" name="svolta"  value="<c:out value='${gara.datasvoltasi}' />"></label>
        </fieldset>

		<button type="submit" class="btn btn-info">Salva</button>
		<button type="reset"  class="btn btn-light" onclick="history.go(-1);">Cancella</button>

    </fieldset>
            </form>
         </div>
       </div>
    </div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>