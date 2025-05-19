<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList" %>

<html>
<body>
<h2>果物リスト</h2>

<%
    List<String> items = (List<String>) request.getAttribute("items");
    if (items != null) {
%>
    <ul>
    <%
        for (String item : items) {
    %>
        <li><%= item %></li>
    <%
        }
    %>
    </ul>
<%
    } else {
%>
    <p>データがありません。</p>
<%
    }
%>

</body>
</html>

