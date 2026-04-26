<!DOCTYPE html>
<html>
<head>
<title>Delete Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h3 class="mb-4 text-center"> Delete Product</h3>

    <% 
    String msg = (String)request.getAttribute("msg");
    if(msg != null){
    %>
    <div class="alert alert-danger text-center">
        <%= msg %>
    </div>
    <% } %>

    <form action="DeleteProductServlet" method="post" class="card p-4 shadow">

        <label>Enter Product ID</label>
        <input type="number" name="id" class="form-control mb-3">

        <button class="btn btn-danger">Delete</button>
    </form>
</div>
<div class="text-center mt-4">

    <a href="index.jsp" class="btn btn-secondary">
        Home
    </a>

</div>

</body>
</html>