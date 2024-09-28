<%@include file="/common/taglib.jsp"%>

<h1 class="text-primary">List Service</h1>
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
                            <div class="pull-right tableTools-container d-flex justify-content-between">
                                <a flag="info"
                                   href="/computer"
                                   class="dt-button buttons-colvis btn btn-lg btn-white btn-outline-primary btn-bold" data-toggle="tooltip"
                                   title='Add computer' >
                                            <span>
                                                <i class="fa-solid fa-plus me-2"></i>
                                            </span>
                                    Add new
                                </a>
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
                            <div class="table-responsive my-3">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th><input type="checkbox" id="checkAll"></th>
                                        <th>Service ID</th>
                                        <th>Name</th>
                                        <th>Unit</th>
                                        <th>Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${list}">
                                        <tr>
                                            <td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td>${item.unit}</td>
                                            <td>${item.price}</td>
                                            <td>
                                                <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                   title="Update service" href='/service/${item.id}'><i class="fa-solid fa-pen-to-square"></i>
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
                            <%--                                <input type="hidden" value="" id="sortName" name="sortName"/>--%>
                            <%--                                <input type="hidden" value="" id="sortBy" name="sortBy"/>--%>
                            <%--                                <input type="hidden" value="" id="type" name="type"/>--%>
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
                    $('#sortName').val('title');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });

    $('#searchBtn').click(function (e) {
        e.preventDefault();
        $('#maxPageItem').val(limit);
        $('#page').val(1);
        $('#searchField').val();
        $('#formSubmit').submit();
    })
</script>
<script>
</script>
