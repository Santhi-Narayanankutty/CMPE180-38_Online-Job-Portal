<%@page import="java.sql.*,java.util.*"%>
<table>
<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String pass=request.getParameter("pass");
String ques=request.getParameter("ques");
String ans=request.getParameter("ans");
int num = Integer.parseInt(request.getParameter("num"));
String acc=request.getParameter("acc");

        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement st=con.createStatement();
        int i=st.executeUpdate("insert into employer_signup(eName,e_email,e_password,Security_Question,Security_Answer,Number_of_Openings,Account_Type) values('"+name+"','"+email+"','"+pass+"','"+ques+"','"+ans+"','"+num+"','"+acc+"')");

        out.println("Account Created");

                    con.close();
        }
        catch(Exception e){
        System.out.println(e);
        }
        %>
        </table>