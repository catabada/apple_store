package vn.edu.hcmuaf.fit.controller.client;

import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.constant.Pagination;
import vn.edu.hcmuaf.fit.service.impl.product.ProductServiceImpl;
import vn.edu.hcmuaf.fit.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CategoryController", urlPatterns = "/apple-store/category/*")
public class CategoryController extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        int page = Integer.parseInt(request.getParameter("page"));
        String sort = request.getParameter("sort") == null ? "none" : request.getParameter("sort");

        Pagination<ProductDto> pagination = new Pagination<>();

        if (pathInfo == null) {
            pagination = productService.getListProductByPageNumber(page, sort).getData();
        } else if (pathInfo.contains("/search")) {
            String[] params = pathInfo.split("/");
            String keyword = params[2];
            pagination = productService.getListProductByKeyWord(keyword, page, sort).getData();
        } else if (pathInfo.contains("/id")) {
            Long typeProductId = Long.parseLong(pathInfo.substring(3));
            pagination = productService.getListProductByTypeProductId(typeProductId, page, sort).getData();
        } else {
            response.sendError(404);
        }
        List<ProductDto> listProduct = pagination.getDataList();
        int totalPage = pagination.getTotalPage();

        request.setAttribute("listProduct", listProduct);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("/view/client/category.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
