<%@include file="/common/taglib.jsp"%>
<h1 class="text-primary">Register Computer</h1>
<%--@elvariable id="model" type="org.example.domain"--%>
<form:form id="formSubmit" modelAttribute="model" action="/computer/register" class="mt-5 col-9">
    <div class="row">
        <div class="col">
            <label class="form-label">Choose Customer</label>
            <form:select path="customerComputerId.customer.id" class="form-select">
                <c:forEach var="customer" items="${customerList}">
                    <form:option value="${customer.id}">${customer.name} (${customer.phone})</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Choose Computer</label>
            <form:select path="customerComputerId.computer.id" class="form-select">
                <c:forEach var="computer" items="${computerList}">
                    <option value="${computer.id}">${computer.id} - ${computer.position}</option>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div>

    </div>
    <div class="row mt-3">
        <div class="col">
            <label class="form-label">Date use:</label>
            <form:input type="date" value="" path="customerComputerId.startDate" class="form-control"/>
        </div>
        <div class="col">
            <label class="form-label">Time start:</label>
            <form:input type="time" value="" path="customerComputerId.startTime" class="form-control"/>
        </div>
        <div class="col">
            <label class="form-label">Time use:</label>
            <form:input cssErrorClass="form-control is-invalid" type="text" value="" min="1" path="timeUsed" class="form-control"/>
            <form:errors cssClass="invalid-feedback" path="timeUsed"/>
        </div>
    </div>

    <button id="btnAddOrUpdateRegister" class="btn btn-primary mt-4">Register</button>
</form:form>
<script>
    $('input#[customerComputerId.startDate]').val(getDateTodayHtml())
    $('input#customerComputerId.startTime').val(getCurrentTime())
</script>