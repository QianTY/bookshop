<%--
  Created by IntelliJ IDEA.
  User: QTY
  Date: 2020/12/25
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
    <%
        String basePath = request.getScheme()
                +"://"
                +request.getServerName()
                +":"
                +request.getServerPort()
                +request.getContextPath()
                +"/";
        pageContext.setAttribute("basePath",basePath);
    %>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="/plugins/jquery/jquery.min.js"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../../css/nav.css">
    <link rel="stylesheet" href="../../../css/bar.css">
    <link rel="stylesheet" href="../../../css/Csearch.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.css">



