<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Computer List</title>
</head>
<body>
<h1 class="text-primary">List Computer</h1>
<form id="formSubmit" method="get" class="mt-5">
    <div class="main-content-inner">
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <%--                            <c:if test="${not empty messageResponse}">--%>
                    <%--                                <div class="alert alert-${alert}">--%>
                    <%--                                        ${messageResponse}--%>
                    <%--                                </div>--%>
                    <%--                            </c:if>--%>
                    <div class="widget-box table-filter">
                        <div class="table-btn-controls">
                            <div class="pull-right tableTools-container">
                                <a flag="info"
                                   href="/computer"
                                   class="dt-button buttons-colvis btn btn-lg btn-white btn-outline-primary btn-bold" data-toggle="tooltip"
                                   title='Add computer' >
                                            <span>
                                                <i class="fa-solid fa-plus me-2"></i>
                                            </span>
                                    Add new
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive my-3">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th><input type="checkbox" id="checkAll"></th>
                                        <th>Computer ID</th>
                                        <th>Position</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <td>${item.id}</td>
                                            <td>${item.position}</td>
                                            <td>${item.status}</td>
                                            <td class="text-center">
                                                <a data-bs-custom-class="bg-info" data-bs-toggle="popover" data-bs-placement="top" data-bs-trigger="hover focus" data-bs-content="Edit computer" class="btn btn-sm btn-outline-info me-2" href='/computer/${item.id}'>
                                                    <i class="fa-solid fa-pen-to-square"></i>
                                                </a>
                                                <a data-bs-custom-class="bg-danger" data-bs-toggle="popover" data-bs-placement="top" data-bs-trigger="hover focus" data-bs-content="Delete computer" class="btn btn-sm btn-outline-danger"
                                                   href='/computer/delete/${item.id}'><i class="fa-solid fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <ul class="pagination" id="pagination"></ul>
                            <input type="hidden" value="" id="page" name="page"/>
                            <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
<%--                            <input type="hidden" value="" id="sortName" name="sortName"/>--%>
<%--                            <input type="hidden" value="" id="sortBy" name="sortBy"/>--%>
<%--                            <input type="hidden" value="" id="type" name="type"/>--%>
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
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
<script>
    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
        return new bootstrap.Popover(popoverTriggerEl)
    })
</script>
</body>
</html>
