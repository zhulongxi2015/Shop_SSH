<%--
  Created by IntelliJ IDEA.
  User: zhulongxi
  Date: 2018/10/25
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../public/head.jsp"%>
</head>
<body>

<!-- 框架体，里面包含了3+1个页面 -->
<frameset border="5" rows="150,*">
    <frame src="top.jsp" />
    <frameset border="5" cols="150,*">
        <frame src="left.jsp" />
        <frame src="right.jsp" />
    </frameset>
</frameset>
</body>
</html>
