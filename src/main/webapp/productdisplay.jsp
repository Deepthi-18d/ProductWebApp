<%@ page import="java.util.*,com.model.Product" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">

<h3 class="text-center mb-4">Product List</h3>

<!--  MESSAGE SAFE CHECK -->
<%
String msg = request.getParameter("msg");

if("added".equals(msg)){
%>
<div class="alert alert-success text-center">Product Added Successfully!</div>
<% } else if("updated".equals(msg)){ %>
<div class="alert alert-warning text-center">Product Updated Successfully!</div>
<% } else if("deleted".equals(msg)){ %>
<div class="alert alert-danger text-center">Product Deleted Successfully!</div>
<% } %>

<table class="table table-bordered table-striped">

<tr class="table-dark">
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Qty</th>
<th>Sold Quantity</th>
</tr>

<%
List<Product> list = (List<Product>)request.getAttribute("products");

if(list != null && !list.isEmpty()){

    for(Product p : list){
%>

<tr>
<td><%= p.getProductId() %></td>
<td><%= p.getProductName() %></td>
<td><%= p.getCategory() %></td>
<td><%= p.getPrice() %></td>
<td><%= p.getQuantity() %></td>
<td><%= p.getSoldQuantity() %></td>
</tr>

<%
    }
} else {
%>

<tr>
<td colspan="6" class="text-center">No Products Found</td>
</tr>

<%
}
%>

</table>
</div>
<div class="text-center mt-3">
    <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
</div>