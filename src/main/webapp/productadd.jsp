<!DOCTYPE html>
<html>
<head>
<title>Add Product</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>
function validate(){
    let id = document.f.id.value;
    let name = document.f.name.value;

    if(id=="" || name==""){
        alert("All fields are required!");
        return false;
    }
}
</script>

</head>

<body class="bg-light">

<div class="container mt-5">
    <h3>Add Product</h3>

    <!-- MESSAGE SECTION ADDED -->
    <%
    String msg = (String)request.getAttribute("msg");
    if(msg != null){
    %>
    <div class="alert alert-danger">
        <%= msg %>
    </div>
    <% } %>

    <form name="f" action="AddProductServlet" method="post" onsubmit="return validate()" class="card p-4 shadow">

        ID <input type="number" name="id" class="form-control mb-2">
        Name <input type="text" name="name" class="form-control mb-2">
        Category <input type="text" name="category" class="form-control mb-2">
        Price <input type="number" name="price" class="form-control mb-2">
        Quantity <input type="number" name="quantity" class="form-control mb-3">
        Sold Quantity <input type="number" name="soldQuantity" value="0" class="form-control mb-3">

        <button class="btn btn-success">Add</button>
    </form>
</div>
<div class="text-center mt-4">

  
    <a href="index.jsp" class="btn btn-secondary">
        Home
    </a>

</div>

</body>
</html>