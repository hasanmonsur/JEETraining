package com.ibcs.primax.javaee.web;

import com.ibcs.primax.javaee.model.*;
import com.ibcs.primax.javaee.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.text.*;

/**
 * Created by Oronno on 4/22/2015.
 */
@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String btnVal = request.getParameter("submit");
        Person loginPerson=new Person();
        HttpSession httpSession = null;
        Person person;
        System.out.println(btnVal);
        //System.out.println("Hello......");
        httpSession = request.getSession();
        loginPerson= (Person) httpSession.getAttribute("userStatus");
        System.out.println(loginPerson+"");


        if(btnVal.equals("Login")){
            //System.out.println("Hello dsadasdasdas");
            String userName = request.getParameter("txtname");
            String userEmail = request.getParameter("txtemail");
            loginPerson=new Person();
            loginPerson.setUserName(userName);
            loginPerson.setUserEmail(userEmail);
            //httpSession = request.getSession();
            httpSession.setAttribute("userStatus", loginPerson);

            String userDetails = "Hi ! "+userName;
            request.setAttribute("userDetails", userDetails);
            //System.out.println(userDetails);

            //---------------------User Retrive------------------
            String userListData="";
            List<Person> userList = (List<Person>) getServletContext().getAttribute(Constants.USER_LIST);
            //PrintWriter printWriter = response.getWriter();
            if(userList.isEmpty()){
                userList.add(loginPerson);
                for(Person per : userList) {
                        userListData=userListData+"<br/><b>"+per.getUserName();
                }
            }
            else {
                int count=0;
                for (Person per : userList) {
                    String lgName=loginPerson.getUserName();
                    String pName=per.getUserName();

                    if (lgName.equals(pName)){count=1;}
                }

                if(count==0)userList.add(loginPerson);

                for(Person per : userList) {
                    userListData=userListData+"<br/><b>"+per.getUserName();
                }
            }

            request.setAttribute("userData", userListData);
            //---------------------------------------------------

            //---------------------Chat Retrive------------------
            String chatListData="";
            List<Chat> chatList = (List<Chat>) getServletContext().getAttribute(Constants.CHAT_LIST);
            //PrintWriter printWriter = response.getWriter();
            for(Chat chat : chatList) {
                chatListData=chatListData+"<br/><b>"+chat.getUserName() + ":"+chat.getPostTime()+"</b>  " +chat.getPostSms();
            }
            request.setAttribute("chatData", chatListData);
            //---------------------------------------------------
        }
        else if(btnVal.equals("Send")){
            Chat chat = new Chat();
            String txtSms = request.getParameter("txtSms");
            chat.setUserName(loginPerson.getUserName());
            chat.setPostSms(txtSms);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            //System.out.println();

            chat.setPostTime(dateFormat.format(date));

            List<Chat> chatList = (List<Chat>) getServletContext().getAttribute(Constants.CHAT_LIST);
            chatList.add(chat);

            //---------------------User Retrive------------------
            String userListData="";
            List<Person> userList = (List<Person>) getServletContext().getAttribute(Constants.USER_LIST);
            for(Person per : userList) {
                userListData=userListData+"<br/><b>"+per.getUserName();
            }
            request.setAttribute("userData", userListData);
            //---------------------------------------------------

            //-------------------Chat List------------------
            String chatListData="";
            for(Chat ct : chatList) {
                chatListData=chatListData+"<br/><b>"+ct.getUserName() + ":"+ct.getPostTime()+"</b>  " +ct.getPostSms();
            }
            request.setAttribute("chatData", chatListData);

            //---------------------------------------

        }
        else if(btnVal.equals("Logout")){
            loginPerson= (Person) httpSession.getAttribute("userStatus");
            List<Person> userList = (List<Person>) getServletContext().getAttribute(Constants.USER_LIST);
            userList.remove(loginPerson);
            httpSession.setAttribute("userStatus", null);
            loginPerson=null;
        }
        //System.out.println("Hello......");
        //loginPerson= (Person) httpSession.getAttribute("userStatus");
        if(loginPerson==null)
        {
            request.getRequestDispatcher("/").forward(request, response);
        }
        else  {

            String userDetails = "Hi ! "+loginPerson.getUserName();
            request.setAttribute("userDetails", userDetails);

            request.getRequestDispatcher("/WEB-INF/view/form.jsp").forward(request, response);
        }

        //request.getRequestDispatcher("/WEB-INF/view/form.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Person loginPerson=new Person();
        HttpSession httpSession = null;
        httpSession = request.getSession();
        loginPerson= (Person) httpSession.getAttribute("userStatus");
        System.out.println(loginPerson+"");
        if(loginPerson==null)
        {
            request.getRequestDispatcher("/").forward(request, response);
        }
        else  {
            //---------------------User Retrive------------------
            String userListData="";
            List<Person> userList = (List<Person>) getServletContext().getAttribute(Constants.USER_LIST);
            for(Person per : userList) {
                userListData=userListData+"<br/><b>"+per.getUserName();
            }
            request.setAttribute("userData", userListData);
            //---------------------------------------------------

            //-------------------Chat List------------------
            List<Chat> chatList = (List<Chat>) getServletContext().getAttribute(Constants.CHAT_LIST);
            String chatListData="";
            for(Chat ct : chatList) {
                chatListData=chatListData+"<br/><b>"+ct.getUserName() + ":"+ct.getPostTime()+"</b>  " +ct.getPostSms();
            }
            request.setAttribute("chatData", chatListData);

            String userDetails = "Hi ! "+loginPerson.getUserName();
            request.setAttribute("userDetails", userDetails);
            request.getRequestDispatcher("/WEB-INF/view/form.jsp").forward(request, response);
        }
    }
}
