package com.ibcs.primax.javaee.web;

import com.ibcs.primax.javaee.model.Person;
import com.ibcs.primax.javaee.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Oronno on 4/22/2015.
 */
@WebServlet(name = "PersonListServlet", urlPatterns = "/persons")
public class PersonListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get list of person");
        List<Person> personList = (List<Person>) getServletContext().getAttribute(Constants.CHAT_LIST);
        PrintWriter printWriter = response.getWriter();
        for(Person person : personList) {
            printWriter.println(person.getFirstName() + " " + person.getLastName());
        }
    }
}
