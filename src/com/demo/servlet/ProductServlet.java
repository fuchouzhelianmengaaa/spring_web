package com.demo.servlet;

import com.demo.beans.ProductInfo;
import com.demo.service.ProductService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet" ,urlPatterns = {"/prdServlet"})
public class ProductServlet extends BaseServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
          String flag=request.getParameter("flag");
          if("list".equals(flag)){
              //拿到Spring的Loc容器
              ProductService productService=super.getService("productService",ProductService.class);
              List<ProductInfo> prdList= null;
              try {
                  prdList = productService.findAllProducts();
              } catch (Exception e) {
                  e.printStackTrace();
              }
              request.setAttribute("prdList",prdList);
              request.getRequestDispatcher("/prd/list.jsp").forward(request,response);

          }
    }
}
