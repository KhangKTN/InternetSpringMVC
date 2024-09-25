<%@include file="/common/taglib.jsp"%>
<html>
<head>
</head>
<body>
    <h1 class="text-primary">Create Service</h1>
    <form:form action="/service" method="post" modelAttribute="model" class="mt-4 w-75">
        <label class="form-label">ID:</label>
        <form:input class="form-control" type="text" value="${model.id}" path="id" placeholder="ID"/>
        <form:errors cssClass="text-danger d-block" path="id"/>

        <label class="form-label mt-3">Service name:</label>
        <form:input class="form-control" value="${model.name}" path="name" placeholder="Enter service name"/>
        <form:errors cssClass="text-danger d-block" path="name"/>

        <label class="mt-3 form-label">Unit:</label>
        <form:input class="form-control" value="${model.unit}" path="unit" placeholder="Enter unit"/>
        <form:errors cssClass="text-danger d-block" path="unit"/>

        <label class="mt-3 form-label">Price:</label>
        <form:input class="form-control" value="${model.price}" type="number" path="price" placeholder="Enter price"/>
        <form:errors cssClass="text-danger d-block" path="price"/>
        <button id="btnAddOrUpdateService" class="btn btn-primary mt-3" type="submit">${(model.id == null || model.id == "") ? "Add" : "Update"} service</button>
    </form:form>
</body>
</html>
