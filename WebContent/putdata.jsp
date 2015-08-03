<%@page import="java.sql.*,java.util.*"%>
<table>
<%
String email=request.getParameter("email");
String pass=request.getParameter("pass");
String ques=request.getParameter("ques");
String ans=request.getParameter("ans");
String acc=request.getParameter("acc");

        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement st=con.createStatement();
        int i=st.executeUpdate("insert into job_seeker_signup(email,pass_word,Security_Question,Security_Answer,Account_Type) values('"+email+"','"+pass+"','"+ques+"','"+ans+"','"+acc+"')");

        out.println("Account Created");

                    con.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
        %>
        </table>