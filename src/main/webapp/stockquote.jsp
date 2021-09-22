<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Request</title>
</head>
<body>
<br>
<br>
<form name="form" action="servlets/StockSearch/" method="post">

    Please Enter a stock symbol  <input type="text" name="symbol" value="AMZN">
    <br>
    please enter a start date (formatted as yyyy-mm-dd)  <input type="text" name="start" value="2015-02-09 00:01:01">
    <br>
    please enter a end date (formatted as yyyy-mm-dd)  <input type="text" name="end" value="2015-02-11 01:08:01">
    <br>
    <p>Please enter an interval:</p>
    <input type="radio" id="day"name="interval" value="day">
    <label for="day">Day</label><br>
    <input type="radio" id="minute" name="interval" value="minute">
    <label for="minute">Minute</label><br>
    <br>
    <input type="submit" name="submit" value="submit">

</form>
</body>
</html>
