package com.demo.servlet;

import com.demo.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet" ,urlPatterns = {"/cstServlet"})
public class CustomerServlet extends BaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String flag=request.getParameter("flag");
         if("list".equals(flag)){
             request.setAttribute("cstList",super.getService("customerService", CustomerService.class).findAllCustomers());
             request.getRequestDispatcher("/cst/list.jsp").forward(request,response);
         }

    }
}
