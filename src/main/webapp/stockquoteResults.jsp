<%@ page import="com.origami.teach.model.StockQuote" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="stockQuoteList" class="com.origami.teach.model.StockQuote" scope="session">
    <c:set target='${stockQuoteList}' value='${sessionScope.get("quotes")}'/>
    <c:forEach items="${stockQuoteList}" var="quotes">
        <c:forEach items="${quotes}" var="quote">
            <tr>
                <td>${quote.symbol}</td>
                <td>${quote.date}</td>
                <td>${quote.price}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</jsp:useBean>





<html>
<head>
    <title>Stock Quote Results</title>
</head>
<body>
<br> Hello
session.setAttribute("symbol", symbol);
session.setAttribute("start_date", startDate);
session.setAttribute("end_date", endDate);
</body>
</html>
