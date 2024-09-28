<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-primary">Internet Using</h1>
<form id="formSubmit" method="get" class="mt-5">
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Customer ID</th>
                                        <th>Customer Name</th>
                                        <th>Computer ID</th>
                                        <th>Position</th>
                                        <th>Date use computer</th>
                                        <th>Time use computer</th>
                                        <th>Time Used</th>
                                        <th>Service Name</th>
                                        <th>Date use service</th>
                                        <th>Time use service</th>
                                        <th>Quantity</th>
                                        <th>Total price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${list}">
                                        <c:set var="size"  value="${item.serviceUsingDTOList.size()}"/>
                                        <tr class="align-middle">
                                            <td>${item.customerId}</td>
                                            <td>${item.customerName}</td>
                                            <td>${item.computerId}</td>
                                            <td>${item.position}</td>
                                            <td>${item.startDate}</td>
                                            <td>${item.startTime}</td>
                                            <td>${item.timeUse}</td>
                                            <c:if test="${size > 0}">
                                                <td rowspan="1">${item.serviceUsingDTOList[0].serviceName}</td>
                                                <td rowspan="1">${item.serviceUsingDTOList[0].dateUse}</td>
                                                <td rowspan="1">${item.serviceUsingDTOList[0].timeUse}</td>
                                                <td rowspan="1">${item.serviceUsingDTOList[0].quantity}</td>
                                            </c:if>
                                            <c:if test="${size == 0}">
                                                <td colspan="4"></td>
                                            </c:if>
                                            <td>
                                                <fmt:setLocale value = "vi-VN"/>
                                                <fmt:formatNumber value = "${item.totalPrice}" currencySymbol="vnd" maxFractionDigits="0" type = "currency"/>
                                            </td>
                                        </tr>
                                        <c:forEach var="idx" begin="1" end="${(fn:length(item.serviceUsingDTOList))}">
                                            <c:if test="${not empty item.serviceUsingDTOList[idx]}">
                                                <tr>
                                                    <td colspan="7"></td>
                                                    <td>${item.serviceUsingDTOList[idx].serviceName}</td>
                                                    <td>${item.serviceUsingDTOList[idx].dateUse}</td>
                                                    <td>${item.serviceUsingDTOList[idx].timeUse}</td>
                                                    <td>${item.serviceUsingDTOList[idx].quantity}</td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <ul class="pagination mt-5" id="pagination"></ul>
                                <input type="hidden" value="" id="page" name="page"/>
                                <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                <%--                                <input type="hidden" value="" id="sortName" name="sortName"/>--%>
                                <%--                                <input type="hidden" value="" id="sortBy" name="sortBy"/>--%>
                                <%--                                <input type="hidden" value="" id="type" name="type"/>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
    var totalPages = ${totalPage};
    var currentPage = ${page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    // $('#sortName').val('title');
                    // $('#sortBy').val('desc');
                    // $('#type').val('list');
                    // $('#searchField').val();
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
