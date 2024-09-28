<%@include file="/common/taglib.jsp"%>

<h1 class="text-primary">Register Service</h1>
<form:form id="formSubmit" class="mt-5 col-9" modelAttribute="model">
    <div class="row">
        <div class="col">
            <label class="form-label">Choose Customer</label>
            <form:select path="customerServiceId.customer.id" class="form-select">
                <c:forEach var="customer" items="${customerList}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="col">
            <label class="form-label">Choose Service</label>
            <form:select path="customerServiceId.serviceDomain.id" class="form-select">
                <c:forEach var="service" items="${serviceList}">
                    <option value="${service.id}">${service.name}</option>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div>

    </div>
    <div class="row mt-3">
        <div class="col">
            <label class="form-label">Date use:</label>
            <form:input type="date" value="" path="customerServiceId.dateUse" class="form-control"/>
        </div>
        <div class="col">
            <label class="form-label">Time use:</label>
            <form:input type="time" value="" path="customerServiceId.timeUse" class="form-control"/>
        </div>
        <div class="col">
            <label class="form-label">Quantity:</label>
            <form:input type="number" value="1" path="quantity" class="form-control"/>
        </div>
    </div>
    <button id="btnAddOrUpdateRegister" class="btn btn-primary mt-4">Register</button>
</form:form>
<script>
</script>
