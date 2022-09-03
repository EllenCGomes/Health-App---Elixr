<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" href="./resources/css/info-meal.css" />
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
    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<jsp:include page="Navbar.jsp"></jsp:include>
	</nav>
  	<!--Navbar-->
  <!--Offcanvas menu-->
  <div class="offcanvas offcanvas-start sidebar-nav"  data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
      <div class="offcanvas-header">
        <div class="header-title">
          <h5 class="offcanvas-title" id="offcanvasExampleLabel">Ellen Gomes</h5>
          <p>Female, 32 years</p>
        </div>
      </div>
      <div class="offcanvas-body">
        <table class="profile-info">
            <tr class="t-row">
                <th>Height</th>
                <th>Weight</th>
                <th class="goal">Goal</th>
            </tr>
            <tr class="t-row">
                <td><b>169</b> cm</td>
                <td><b>57</b> kg</td>
                <td class="goal"><b class="goal">65</b>kg</td>
            </tr>
        </table>
        <hr class="profile-info-divider">
        <ul class="menu-list navbar-nav py-2">
          <li>
            <a href="#" target="_self">Overview</a>
          </li>
          <li>
              <a href="./profile.html" target="_self">Profile</a>
          </li>
          <li>
            <a href="#" target="_self">Workouts</a>
          </li>
          <li>
            <a href="nutrition.html" target="_self">Nutrition</a>
          </li>
          <li>
            <a href="#" target="_self">Achievements</a>
          </li>
          <li>
            <a href="#" target="_self">Settings</a>
          </li>
        </ul>
      </div>
  </div>
  <!--Offcanvas menu-->
    <main class="min-vh-100">
      <div class="main-container container-fluid">
        <table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Data Refeicao</th>
		      <th scope="col">Tipo Refeicao</th>
		      <th scope="col">Proteina</th>
		      <th scope="col">Carboidrato</th>
		      <th scope="col">Acucar</th>
		      <th scope="col">Gordura</th>
		      <th scope="col">Peso Refeicao</th>
		      <th scope="col">Tipo Refeicao</th>
		      <th scope="col">Opcoes</th>
		    </tr>
		  </thead>
		  <tbody>
           <c:forEach items="${refeicoes}" var="refeicao">
             <tr>
	           	<th scope="row">1</th>
	             <td>
	             	<fmt:formatDate value="${refeicao['dtRefeicao'].time}" pattern="dd/MM/yyyy"/>
	             </td>
	             <td>${refeicao["tpRefeicao"]}</td>
	             <td>${refeicao["qtProteina"]}</td>
	             <td>${refeicao["qtCarboidrato"]}</td>
	             <td>${refeicao["qtAcucar"]}</td>
	             <td>${refeicao["qtGordura"]}</td>
	             <td>${refeicao["pesoRefeicao"]}</td>
	             <td>${refeicao["tpRefeicao"]}</td>
	             <td>
	             	 <!-- botao editar -->
	             	 
		             <a href="<c:url value="listaRefeicoes">
						<c:param name="action" value="edit"/>
						<c:param name="codigo" value="${refeicao['cdRefeicao']}"/>
		             </c:url>" class="">Editar</a>
		             
		             <!-- botao deletar -->
		             <c:url value="listaRefeicoes" var="link-delete">
						<c:param name="action" value="delete"/>
						<c:param name="codigo" value="${refeicao['cdRefeicao']}"/>
		             </c:url>
		             <a href="${link-delete }" class="">Deletar</a>
	             </td>
             </tr>
           </c:forEach>
		  </tbody>
		</table>
      </div>
    </main>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
