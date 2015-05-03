<%--
  Created by IntelliJ IDEA.
  User: Oronno
  Date: 4/22/2015
  Time: 11:42 PM
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
  <tr class="trfooter">
    <td colspan="2" >${userDetails}</td>
  </tr>
  <tr class="trChat">
    <td class="tdchat">
      <h3>Login User List</h3>
      <form action="form" method="POST">
        <div class="divuser">
          ${userData}
        </div>
        <br/><input type="submit" name="submit" value="Logout" />
      </form>
    </td>
    <td class="tdchat">

      <h3>Chat Box</h3>
      <form action="form" method="POST">
        <div class="divchat">
          ${chatData}
          </div>
        <br /> <br />
        <input type="text" name="txtSms" size="70" /><input type="submit" name="submit" value="Send" />
      </form>

    </td>
  </tr>
  <tr class="trfooter">
    <td colspan="2" >Developed by : Hasan</td>
  </tr>
</table>
</body>
</html>
