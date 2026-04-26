<!DOCTYPE html>
<html>
<head>
<title>Update Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h3 class="mb-4 text-center">Update Product</h3>

    <% 
    String msg = (String)request.getAttribute("msg");
    if(msg != null){
    %>
    <div class="alert alert-danger text-center">
        <%= msg %>
    </div>
    <% } %>

    <form action="UpdateProductServlet" method="post" class="card p-4 shadow">

        <label>ID</label>
        <input type="number" name="id" class="form-control mb-2">

        <label>Name</label>
        <input type="text" name="name" class="form-control mb-2">

        <label>Category</label>
        <input type="text" name="category" class="form-control mb-2">

        <label>Price</label>
        <input type="number" name="price" class="form-control mb-2">

        <label>Quantity</label>
        <input type="number" name="quantity" class="form-control mb-2">

        <!--  ADD THIS -->
        <label>Sold Quantity</label>
        <input type="number" name="soldQuantity" class="form-control mb-3">

        <button class="btn btn-warning">Update</button>
    </form>
<div class="text-center mt-4">

  

    <a href="index.jsp" class="btn btn-secondary">
        Home
    </a>

</div>

</body>
</html>