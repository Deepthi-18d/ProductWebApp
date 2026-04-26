<%@ page import="java.util.*,com.model.Product" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
<h3 class="mb-4 text-center">Report Result</h3>

<table class="table table-bordered table-striped">

<tr class="table-dark">
<th>ID</th>
<th>Name</th>
<th>Category</th>
<th>Price</th>
<th>Qty</th>
<th>Sold Quantity</th> <!-- ADD THIS -->
</tr>

<%
List<Product> list = (List<Product>) request.getAttribute("products");

if (list != null && !list.isEmpty()) {
    for (Product p : list) {
%>

<tr>
<td><%=p.getProductId()%></td>
<td><%=p.getProductName()%></td>
<td><%=p.getCategory()%></td>
<td><%=p.getPrice()%></td>
<td><%=p.getQuantity()%></td>
<td><%=p.getSoldQuantity()%></td> <!--  ADD THIS -->
</tr>

<%
    }
} else {
%>
<tr>
<td colspan="6" class="text-center">No records found</td> <!-- changed to 6 -->
</tr>
<%
}
%>

</table>
</div>
<div class="text-center mt-4">

    <a href="index.jsp" class="btn btn-secondary">
        Home
    </a>

</div>