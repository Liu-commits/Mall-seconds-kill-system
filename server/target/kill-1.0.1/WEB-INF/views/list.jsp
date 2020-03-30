<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="tag.jsp" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>商城高并发抢单-商品列表</title>
    <%@include file="head.jsp" %>
</head>
<body>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>商城高并发抢单-秒杀商品列表</h2>
        </div>

        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr align="center" valign="center">
                    <td style="font-size: 15px"><strong style="color: red">商品名称</strong></td>
                    <td style="font-size: 15px"><strong style="color: red">剩余数量</strong></td>
                    <td style="font-size: 15px"><strong style="color: red">开始时间</strong></td>
                    <td style="font-size: 15px"><strong style="color: red">结束时间</strong></td>
                    <td style="font-size: 15px"><strong style="color: red">详情</strong></td>
                </tr>
                </thead>
                <tbody >
                <c:forEach items="${list}" var="item">
                    <tr align="center" valign="center">
                        <td>${item.itemName}</td>
                        <td>${item.total}</td>
                        <td><fmt:formatDate value="${item.startTime}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
                        <td><fmt:formatDate value="${item.endTime}" pattern='yyyy-MM-dd HH:mm:ss'/></td>
                        <td>
                            <c:choose>
                                <c:when test="${item.canKill==1}">
                                    <a class="btn btn-info" href="${ctx}/item/detail/${item.id}" target="_blank">秒杀</a>
                                </c:when>
                                <c:when test="${item.total==0 && item.canKill != 1}">
                                    <a class="btn btn-info">库存不足且不在时间段内！</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-info">商品不在抢购时间段哦!</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script src="${ctx}/static/plugins/jquery.js"></script>
<script src="${ctx}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</html>









