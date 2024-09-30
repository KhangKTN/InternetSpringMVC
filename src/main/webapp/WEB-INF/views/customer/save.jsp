<%@include file="/common/taglib.jsp"%>
<html>
<head>
</head>
<body>
<div>
    <h1 class="text-primary">${type == 'edit' ? "Update" : "Create"} Customer</h1>
    <form:form action="${type == 'edit' ? '/customer/update' : '/customer'}" method="post" modelAttribute="model" class="mt-5 col-9">
        <div>
            <label class="form-label">Customer ID:</label>
            <form:input readonly="${type == 'edit'}" cssErrorClass="is-invalid form-control" class="form-control" type="text" value="${model.id}" path="id" placeholder="ID"/>
            <form:errors cssClass="text-danger mt-3" path="id"/>
        </div>
        <div>
            <label class="form-label mt-3">Name:</label>
            <form:input cssErrorClass="is-invalid form-control" class="form-control" path="name" value="${model.name}" placeholder="Enter Name"/>
            <form:errors cssClass="text-danger mt-3" path="name"/>
        </div>
        <div>
            <label class="form-label mt-3">Address:</label>
            <form:input cssErrorClass="is-invalid form-control" class="form-control" path="address" value="${model.address}" placeholder="Enter Address"/>
            <form:errors cssClass="text-danger mt-3" path="address"/>
        </div>
        <div>
            <label class="form-label mt-3">Phone:</label>
            <form:input cssErrorClass="is-invalid form-control" class="form-control" path="phone" value="${model.phone}" placeholder="Enter phone"/>
            <form:errors cssClass="text-danger mt-3" path="phone"/>
        </div>
        <div>
            <label class="form-label mt-3">Email:</label>
            <form:input cssErrorClass="is-invalid form-control" class="form-control" type="text" value="${model.email}" path="email" placeholder="Enter email"/>
            <form:errors cssClass="text-danger mt-3" path="email"/>
        </div>
        <div>
            <button id="btnAddOrUpdateCustomer" class="btn btn-primary mt-4" type="submit">${type == 'edit' ? "Update" : "Create"} Customer</button>
        </div>
    </form:form>
</div>
</body>
<script>

</script>
</html>
