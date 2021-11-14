<%-- 
    Document   : update
    Created on : Nov 7, 2021, 10:53:05 PM
    Author     : nemishappy
--%>

<%@page import="java.util.List"%>
<%@page import="db.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student By id</title>
    </head>
    <body>
        <h1>Update Student</h1>
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
        Enter update student <br/>
        <form name="main" action="update" method="POST">            
            ID: <input type="text" name="id" value="" /> <br/>
            Name: <input type="text" name="name" value="" size="20" /> <br/>
            GPA: <input type="text" name="gpa" value="" /> <br/>
            <input type="submit" value="send" name="btn" />
        </form>
    </body>
</html>
