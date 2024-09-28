<%@include file="/common/taglib.jsp"%>
<html>
<head>
</head>
<body>
    <h1 class="text-primary">${(type == 'edit') ? "Update" : "Create"} Service</h1>
    <form:form action="${model.id == null || model.id == '' ? '/service' : '/service/update'}" method="post" modelAttribute="model" class="mt-5 w-75">
        <label class="form-label">ID:</label>
        <form:input class="form-control" type="text" readonly="${type == 'edit'}" value="${model.id}" path="id" placeholder="ID"/>
        <form:errors cssClass="text-danger d-block" path="id"/>

        <label class="form-label mt-3">Service name:</label>
        <form:input class="form-control" value="${model.name}" path="name" placeholder="Enter service name"/>
        <form:errors cssClass="text-danger d-block" path="name"/>

        <label class="mt-3 form-label">Unit:</label>
        <form:input class="form-control" value="${model.unit}" path="unit" placeholder="Enter unit"/>
        <form:errors cssClass="text-danger d-block" path="unit"/>

        <label class="mt-3 form-label">Price:</label>
        <form:input class="form-control" value="${model.price != null ? model.price : 0}" type="number" path="price" placeholder="Enter price"/>
        <form:errors cssClass="text-danger d-block" path="price"/>
        <button id="btnAddOrUpdateService" class="btn btn-primary mt-4" type="submit">${type == 'edit' ? "Update" : "Create"} service</button>
    </form:form>
</body>
</html>
