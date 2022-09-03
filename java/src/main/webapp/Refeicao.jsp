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
    <!--Offcanvas menu-->
    <div class="offcanvas offcanvas-start sidebar-nav"  data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
        <div class="offcanvas-header">
          <img class="profile-pic" src="../img/foto perfil.jpg" width="90" alt="profile picture">
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
              <a href="./dashboard.html" target="_self">Overview</a>
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
    <!--Main-->
    <main class="min-vh-100">
      <div class="main-container container-fluid">
        <div class="d-flex justify-content-between align-items-center" style="border-radius: 5rem; margin-bottom: 20px;">
            <div class="overview-title">             
              <div class="dropdown">
                <a class="dropdown-text btn dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                  Today
                </a>
              
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                  <li><a class="dropdown-item" href="#">Week</a></li>
                  <li><a class="dropdown-item" href="#">Month</a></li>
                  <li><a class="dropdown-item" href="#">Year</a></li>
                </ul>
              </div>
            </div>
        </div>  
        <div class="row">
            <!--Meal Calories card-->
            <div class="col-md-12 col-lg-6 mb-3">
              <div class="card mb-3 h-100">
                <div class="row g-0">
                  <div class="card-title">
                      <h5 style="color: #7A34AE;">Meal Calories
                      </h5>
                  </div>
                </div>
                <div class="calorie-card card-body">
                  <img src="./resources/img/Imagem3.png" width="310">
                </div>
              </div>
            </div>
            <!--Meal Calories-->
            <!--History card-->
            <div class="col-md-12 col-lg-6 mb-3">
              <div class="card mb-3 h-100">
                <div class="row g-0">
                  <h5 class="card-title">History
                  </h5>
                </div>
                <div class="calorie-card card-body">
                  <div class="carrousel-container">
                    <div id="carouselExampleControls" class="carousel carousel-dark slide" data-bs-ride="carousel" data-bs-interval="false" style="width: 100%;">
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <div class="d-block w-100">
                            <div class="carousel-item-title">
                              <button type="button" class="btn btn-sm carousel-btn">
                                Breakfast
                              </button>
                              <h6 style="color: #C20303;">Total: 400 cal</h6>
                            </div>
                            <div class="carousel-item-body">
                              <div class="carousel-table">
                                <div class="row mb-2">
                                  <div class="col-2 p-0"><span class="circle prot">P</span></div>
                                  <div class="col-6">Eggs</div>
                                  <div class="col-4 pe-0"> + 50 cal</div>
                                </div>
                                <div class="row mb-2"> 
                                  <div class="col-2 p-0"><span class="circle sug">S</span></div>
                                  <div class="col-6">Avocado</div>
                                  <div class="col-4 pe-0"> + 200 cal</div>
                                </div>
                                <div class="row">
                                  <div class="col-2 p-0"><span class="circle carb">C</span></div>
                                  <div class="col-6">Oatmeal</div>
                                  <div class="col-4 pe-0"> + 150 cal</div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="carousel-item">
                          <div class="d-block w-100">
                            <div class="carousel-item-title">
                              <button type="button" class="btn btn-sm carousel-btn">
                                Lunch                              </button>
                              <h6 style="color: #C20303;">Total: 550 cal</h6>
                            </div>
                            <div class="carousel-item-body">
                              <div class="carousel-table">
                                <div class="row mb-2">
                                  <div class="col-2 p-0"><span class="circle prot">P</span></div>
                                  <div class="col-6">Pork</div>
                                  <div class="col-4 pe-0"> + 100 cal</div>
                                </div>
                                <div class="row mb-2"> 
                                  <div class="col-2 p-0"><span class="circle sug">S</span></div>
                                  <div class="col-6">Strawberry</div>
                                  <div class="col-4 pe-0"> + 50 cal</div>
                                </div>
                                <div class="row">
                                  <div class="col-2 p-0"><span class="circle carb">C</span></div>
                                  <div class="col-6">Pesto Pasta</div>
                                  <div class="col-4 pe-0"> + 400 cal</div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="carousel-item">
                          <div class="d-block w-100">
                            <div class="carousel-item-title">
                              <button type="button" class="btn btn-sm carousel-btn">
                                Snack
                              </button>
                              <h6 style="color: #C20303;">Total: 100 cal</h6>
                            </div>
                            <div class="carousel-item-body">
                              <div class="carousel-table">
                                <div class="row mb-2">
                                  <div class="col-2 p-0"><span class="circle prot">P</span></div>
                                  <div class="col-6">Yogurt</div>
                                  <div class="col-4 pe-0"> + 30 cal</div>
                                </div>
                                <div class="row mb-2"> 
                                  <div class="col-2 p-0"><span class="circle sug">S</span></div>
                                  <div class="col-6">Apple</div>
                                  <div class="col-4 pe-0"> + 20 cal</div>
                                </div>
                                <div class="row">
                                  <div class="col-2 p-0"><span class="circle carb">C</span></div>
                                  <div class="col-6">Toast</div>
                                  <div class="col-4 pe-0"> + 50 cal</div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                      </button>
                      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!--History card-->
          </div>
        <!--Form card-->
        <div class="card">        	
          <c:if test="${not empty msg}">
          	<div class="alert alert-sucess">${msg}</div>
          </c:if>
          <c:if test="${not empty erro}">
          	<div class="alert alert-danger">${erro}</div>
          </c:if>
          <form class="form" method="post">
            <div class="row g-0 row-form">
                <div class="card-title-container">
                  <h5 style="color: #7A34AE;">Add Meal
                  </h5>
                  <div class="input-form">
                    <label for="meal-date" class="form-label m-0 pe-2">Date/Time:</label>
                    <input type="datetime-local" name="dtRef" class="form-control-date" id="meal-date" required/>
                  </div>
                  <select class="type-meal" name="tipoRef" required id="tipoRef">
                    <option value="" disabled selected>Select...</option>
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
                  <input type="text" name="pesoRef" class="form-control" id="meal-weight" required/> 
                  <select class="form-label" name="unMed" required id="un-med" style="border: none;">
                    <option value="kg">kg</option>
                    <option value="g">g</option>
                    <option value="oz">oz</option>
                    <option value="libra">lb</option>
                  </select>                
                </div>
                <div class="mb-2 input-form">
                  <label for="meal-protein" class="form-label ps-5">Protein (g):</label>
                  <input type="text" name="proteina" class="form-control" id="meal-protein" />
                </div>
                <div class="mb-2 input-form">
                  <label for="meal-fat" class="form-label ps-5">Fat (g):</label>
                  <input type="text" name="gordura" class="form-control" id="meal-fat" />
                </div>
              </div>
              <div class="row g-0 row-form">
                <div class="mb-2 input-form">
                  <label for="meal-carbs" class="form-label ps-5">Carbs (g):</label>
                  <input type="text" name="carboidrato" class="form-control" id="meal-carbs" />
                </div>
                <div class="mb-2 input-form">
                  <label for="meal-calorie" class="form-label">Calorie Intake (g):</label>
                  <input type="text" name="calorias" class="form-control" id="meal-calorie" />
                </div>
                <div class="mb-2 input-form">
                  <label for="meal-sugar" class="form-label">Sugar (g):</label>
                  <input type="text" name="acucar" class="form-control" id="meal-sugar" />
                </div>
              </div>
              <select class="mb-2 type-meal" style="margin-left: 3rem" name="ingrediente" required id="tipoRef">
                <option value="" disabled selected>Select...</option>
                <c:forEach items="${ingredientes}" var="ingrediente">
	                <option value=${ingrediente["cdIngrediente"]}>${ingrediente["dsIngrediente"]}</option>
	            </c:forEach>
              </select>
            </div>
            <button type="submit" class="add-meal-btn btn">Save</button>
          </form>
        </div>
        <!--Form card-->
      </div>
    </main>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
