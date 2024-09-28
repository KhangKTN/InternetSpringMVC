<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Create Computer</title>
</head>
<body>
<div>
    <h1 class="text-primary">${(model.id == null || model.id == '0') ? 'Create' : 'Update'} Computer</h1>
    <form:form id="formSubmit" method="post" action="/computer" modelAttribute="computer" class="mt-5 col-9">
        <div>
            <label class="form-label">Position:</label>
            <form:input class="form-control" value="${model.position}" path="position" placeholder="Enter position"/>
            <form:errors cssClass="text-danger" path="position"/>
        </div>
        <div>
            <label class="form-label mt-3">Status:</label>
            <form:input class="form-control" value="${model.status}" path="status" placeholder="Enter status"/>
            <form:errors class="text-danger" path="status"/>
        </div>
        <form:input type="hidden" value="${model.id}" path="id"/>
        <div>
            <button id="btnAddOrUpdateComputer" class="btn btn-primary mt-4" type="submit">${(model.id == null || model.id == '0') ? 'Create' : 'Update'} computer</button>
        </div>
    </form:form>
</div>
</body>
<script>
</script>
</html>