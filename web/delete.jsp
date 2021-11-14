<%-- 
    Document   : delete
    Created on : Nov 7, 2021, 10:44:34 PM
    Author     : nemishappy
--%>
<%@page import="java.util.List"%>
<%@page import="db.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student By ID</title>
    </head>
    <body>
        <h1>Delete Student By ID</h1>
        List Student
        <br/>
        <%
            List<Student> StudentList = StudentTable.findAllStudent();
            if (StudentList.size() > 0) {
                for (Student stud : StudentList) {
                    out.print(stud.getId() + " ");
                    out.print(stud.getName() + " ");
                    out.print(stud.getGpa() + " ");
                    out.print("<br/>");
                }
            } else {
                out.println("No Data");
            }
        %>
        <br/>
        Enter id to delete <br/>
        <form name="main" action="delete" method="POST">
            ID: <input type="text" name="id" value="" /> <br/>
            <input type="submit" value="send" name="btn" />
        </form>
    </body>
</html>
