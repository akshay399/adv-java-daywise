<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
</head>
<%--session.getAttribute("user") -- null -- session.setAttribute("user",new UserBean()); --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />

<body>

	<section>
      <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
          <div
            class="row d-flex justify-content-center align-items-center h-100"
          >
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
              <div
                class="card"
                style="border-radius: 15px; background-color: grey"
              >
                <div class="card-body p-5">
                  <h2 class="text-uppercase text-center mb-5">
                    Sunbeam Blogs
                  </h2>

                  <form action="authenticate.jsp" method="post">
                    <div class="form-outline mb-4">
                      <input
                        type="text"
                        name="email"
                        id="form3Example1cg"
                        class="form-control form-control-lg"
                      />
                      <label class="form-label" for="form3Example1cg"
                        >Email</label
                      >
                    </div>

                    <div class="form-outline mb-4">
                      <input
                        type="password"
                        name="password"
                        id="form3Example3cg"
                        class="form-control form-control-lg"
                      />
                      <label class="form-label" for="form3Example3cg"
                        >Password</label
                      >
                    </div>

                    <div class="d-flex justify-content-center">
                      <input
                        type="submit"
                        value="login"
                        class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"
                      />
                    </div>
                    <hr />
                    <div>
                    <a style="color:white" class="d-flex justify-content-center" href="register.jsp">Sign Up</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>
