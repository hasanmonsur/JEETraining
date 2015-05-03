<%--
  Created by IntelliJ IDEA.
  User: Oronno
  Date: 4/22/2015
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Open ChatBox</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/css/style.css" />
  </head>
  <body>
  <table class="tbstyle">
    <tr class="trheader">
      <td colspan="2" class="tdheader">WELCOME TO CHATBOX</td>
    </tr>
    <tr class="trbody">
      <td colspan="2" class="tdbody">
        <h3>Entry Login Information</h3>
        <form action="form" method="POST">
          Name: <input type="text" name="txtname">
          <br /> <br />
          Email: <input type="text" name="txtemail" />
          <br /> <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="submit" value="Login" />
        </form>
      </td>
    </tr>
    <tr class="trfooter">
     <td>Developed by : Hasan</td>
    </tr>
  </table>
  </body>
</html>
