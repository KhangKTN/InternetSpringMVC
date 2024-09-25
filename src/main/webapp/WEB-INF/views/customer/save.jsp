<%@include file="/common/taglib.jsp"%>
<html>
<head>
</head>
<body>
<div>
    <h1 class="text-primary">Create Customer</h1>
    <form:form action="/customer" method="post" modelAttribute="model" class="mt-5">
        <form:input class="form-control" type="text" value="${model.id}" path="id" placeholder="ID"/>
        <form:errors cssClass="text-danger mt-3" path="id"/>
        <form:input class="form-control mt-3" path="name" value="${model.name}" placeholder="Enter Name"/>
        <form:errors cssClass="text-danger mt-3" path="name"/>
        <form:input class="form-control mt-3" path="address" value="${model.address}" placeholder="Enter Address"/>
        <form:errors cssClass="text-danger mt-3" path="address"/>
        <form:input class="form-control mt-3" path="phone" value="${model.phone}" placeholder="Enter phone"/>
        <form:errors cssClass="text-danger mt-3" path="phone"/>
        <form:input class="form-control mt-3" type="text" value="${model.email}" path="email" placeholder="Enter email"/>
        <form:errors cssClass="text-danger mt-3" path="email"/>
        <div>
            <button id="btnAddOrUpdateCustomer" class="btn btn-primary mt-5" type="submit">${(model.id == null || model.id == "") ? "Add" : "Update"} computer</button>
        </div>
    </form:form>
</div>
</body>
<script>

</script>
</html>
