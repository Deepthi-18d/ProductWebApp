<!DOCTYPE html>
<html>
<head>
<title>Reports</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h3 class="text-center mb-4">Reports</h3>

<%
String type = request.getParameter("type");

//  FIX: default value to avoid null
if(type == null){
    type = "price";
}
%>

    <form action="ReportServlet" method="post" class="card p-4 shadow">

        <input type="hidden" name="type" value="<%= type %>">

        <% if("price".equals(type)){ %>

            <label>Enter Price</label>
            <input type="number" name="value" class="form-control mb-3" required>

        <% } else if("category".equals(type)){ %>

            <label>Enter Category</label>
            <input type="text" name="value" class="form-control mb-3" required>

        <% } else { %>

            <label>Enter Top N Value</label>
            <input type="number" name="value" class="form-control mb-3" required>

        <% } %>

        <button class="btn btn-dark w-100">Generate Report</button>
    </form>
</div>

</body>
</html>