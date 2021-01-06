<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="left.jsp"/>--%>
        <input type="checkbox" id="check">
        <label for="check" >
            <i class="fas fa-bars" id="btn"></i>
            <i class="fas fa-times" id="cancel"></i>
        </label>
        <div class="sidebar">
            <header>图书类别</header>
            <ul>
                <c:forEach items="${sessionScope.kinds}" var="item" varStatus="i">
                    <c:if test="${requestScope.type}==${item.f_name}">
                        <li class="active"><a href="/book/search?type=${item.f_name}"><i class="fas fa-qrcode"></i>${item.f_name}</a></li>
                    </c:if>
                    <li><a href="/book/search?type=${item.f_name}"><i class="fas fa-qrcode"></i>${item.f_name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <section>


<%--    <input type="checkbox" id="check">--%>
<%--    <label for="check" >--%>
<%--        <i class="fas fa-bars" id="btn"></i>--%>
<%--        <i class="fas fa-times" id="cancel"></i>--%>
<%--    </label>--%>
<%--    <div class="sidebar">--%>
<%--        <header>图书类别</header>--%>
<%--        <ul>--%>
<%--            <c:forEach items="${sessionScope.kinds}" var="item" varStatus="i">--%>
<%--                <c:if test="${requestScope.type}==${item.f_name}">--%>
<%--                    <li class="active"><a href="/book/search?type=${item.f_name}"><i class="fas fa-qrcode"></i>${item.f_name}</a></li>--%>
<%--                </c:if>--%>
<%--                <li><a href="/book/search?type=${item.f_name}"><i class="fas fa-qrcode"></i>${item.f_name}</a></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>

<%--    </div>--%>
