<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Create Computer</title>
</head>
<body>
<div>
    <h1 class="text-primary">Create Computer</h1>
    <form:form id="formSubmit" method="post" action="/computer" modelAttribute="computer" class="mt-4">
        <form:input class="form-control" value="${model.position}" path="position" placeholder="Enter position"/>
        <form:errors cssClass="text-danger mt-3" path="position"/>
        <form:input class="form-control mt-3" value="${model.status}" path="status" placeholder="Enter status"/>
        <form:errors class="text-danger mt-3" path="status"/>
        <form:input type="hidden" value="id" path="id"/>
        <div>
            <button id="btnAddOrUpdateComputer" class="btn btn-primary mt-3" type="submit">Add computer</button>
        </div>
    </form:form>
</div>
</body>
<script>

</script>
</html>