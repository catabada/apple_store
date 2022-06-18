package vn.edu.hcmuaf.fit.controller.client;

import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryController", value = "/apple-store/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("listProduct", ProductDAOImpl.getInstance().findAllByTypeProductId(id));
        request.getRequestDispatcher("/view/client/category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
