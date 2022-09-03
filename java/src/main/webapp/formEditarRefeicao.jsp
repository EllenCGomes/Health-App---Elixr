<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="resources/css/nutrition.css" />
    <link
      class="logo-tab"
      rel="shortcut icon"
      href="../img/LogoTab.ico"
      type="image/png"
    />
    <script
      src="https://kit.fontawesome.com/de846246dd.js"
      crossorigin="anonymous"
    ></script>
    <title>Elixr</title>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<jsp:include page="Navbar.jsp"></jsp:include>
	</nav> 
<div class="container">
   
	<div class="card" style="position: absolute; top: 30%; left: 15%; margin-right: 5rem;">   
 	
	    <form class="form" method="post">
	      <div class="row g-0 row-form">
	          <div class="card-title-container">
	            <h5 style="color: #7A34AE;">Editar Refeição
	            </h5>
	            <div class="input-form">
	              <label for="meal-date" class="form-label m-0 pe-2">Date/Time:</label>
	              <input type="datetime-local" value='<fmt:formatDate value="${refeicao['dtRefeicao'].time}" pattern="yyyy-MM-dd'T'hh:mm"/>' name="dtRef" class="form-control-date" id="meal-date" required/>
	            </div>
	            <select class="type-meal" name="tipoRef" required id="tipoRef">
	              <option value="${refeicao['tpRefeicao']}" selected>${refeicao['tpRefeicao']}</option>
	              <option value="Breakfast">Breakfast</option>
	              <option value="Lunch">Lunch</option>
	              <option value="Snack">Snack</option>
	              <option value="Dinner">Dinner</option>
	            </select>
	          </div>
	      </div>
	      <div class="row-form-container">
	        <div class="row g-0 row-form">
	          <div class="mb-2 input-form">
	            <label for="meal-weight" class="form-label ps-5">Peso:</label>
	            <input type="text" name="pesoRef" value="${refeicao['pesoRefeicao']}" class="form-control" id="meal-weight" required/> 
	            <select class="form-label" name="unMed" required id="un-med" style="border: none;">
	              <option value="kg">kg</option>
	              <option value="g">g</option>
	              <option value="oz">oz</option>
	              <option value="libra">lb</option>
	            </select>                
	          </div>
	          <div class="mb-2 input-form">
	            <label for="meal-protein" class="form-label ps-5">Protein (g):</label>
	            <input type="text" name="proteina" value="${refeicao['qtProteina']}" class="form-control" id="meal-protein" />
	          </div>
	          <div class="mb-2 input-form">
	            <label for="meal-fat" class="form-label ps-5">Fat (g):</label>
	            <input type="text" name="gordura" value="${refeicao['qtGordura']}" class="form-control" id="meal-fat" />
	          </div>
	        </div>
	        <div class="row g-0 row-form">
	          <div class="mb-2 input-form">
	            <label for="meal-carbs" class="form-label ps-5">Carbs (g):</label>
	            <input type="text" name="carboidrato" value="${refeicao['qtCarboidrato']}" class="form-control" id="meal-carbs" />
	          </div>
	          <div class="mb-2 input-form">
	            <label for="meal-sugar" class="form-label">Sugar (g):</label>
	            <input type="text" name="acucar" value="${refeicao['qtAcucar']}" class="form-control" id="meal-sugar" />
	          </div>
	        </div>
	        <select class="mb-2 type-meal" style="margin-left: 3rem" name="ingrediente" required id="tipoRef">
	          <option value="${ingrediente[refeicao['cdIngrediente']]}" disabled selected>Select...</option>
	          <c:forEach items="${ingredientes}" var="ingrediente">
	           	<option value=${ingrediente["cdIngrediente"]}>${ingrediente["dsIngrediente"]}</option>
	          </c:forEach>
	        </select>
	      </div>
	      <button type="submit" class="add-meal-btn btn">Save</button>
	    </form>
	</div>
</div>
        <!--Form card-->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>

</body>
</html>