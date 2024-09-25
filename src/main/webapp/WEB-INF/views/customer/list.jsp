<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<head>
</head>
<body>
    <h1 class="text-primary">List Customer</h1>
    <form id="formSubmit" method="get">
            <div class="main-content-inner">
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <%--                            <c:if test="${not empty messageResponse}">--%>
                            <%--                                <div class="alert alert-${alert}">--%>
                            <%--                                        ${messageResponse}--%>
                            <%--                                </div>--%>
                            <%--                            </c:if>--%>
                            <div class="widget-box table-filter mb-3">
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container d-flex justify-content-between">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info"
                                               class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                               title='Thêm bài viết' >
                                                    <span>
                                                        <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                    </span>
                                            </a>
                                            <button id="btnDelete" type="button"
                                                    class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
                                                        <span>
                                                            <i class="fa fa-trash-o bigger-110 pink"></i>
                                                        </span>
                                            </button>
                                        </div>
                                        <div class="col-4">
                                            <div class="input-group">
                                                <input value="${search}" id="searchField" name="search" class="form-control col-9" placeholder="Search...">
                                                <button type="button" id="searchBtn" class="btn btn-secondary col-3">Search</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th><input type="checkbox" id="checkAll"></th>
                                                <th>Customer ID</th>
                                                <th>Name</th>
                                                <th>Address</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
                                                    <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                                    <td>${item.id}</td>
                                                    <td>${item.name}</td>
                                                    <td>${item.address}</td>
                                                    <td>${item.phone}</td>
                                                    <td>${item.email}</td>
                                                    <td>
                                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Update customer" href='/customer/${item.id}'><i class="fa-solid fa-pen-to-square"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <ul class="pagination" id="pagination"></ul>
                                        <input type="hidden" value="" id="page" name="page"/>
                                        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
<%--                                        <input type="hidden" value="" id="sortName" name="sortName"/>--%>
<%--                                        <input type="hidden" value="" id="sortBy" name="sortBy"/>--%>
<%--                                        <input type="hidden" value="" id="type" name="type"/>--%>
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

    $('#searchBtn').click(function (e) {
        e.preventDefault();
        $('#maxPageItem').val(limit);
        $('#page').val(1);
        // $('#searchField').val();
        $('#formSubmit').submit();
    })
</script>
<script>
</script>
</body>
