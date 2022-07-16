package vn.edu.hcmuaf.fit.controller.client;

import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.constant.Pagination;
import vn.edu.hcmuaf.fit.service.impl.product.ProductServiceImpl;
import vn.edu.hcmuaf.fit.service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
        if (pathInfo == null) {
            Pagination<ProductDto> pagination = productService.getListProductByPageNumber(page).getData();
            request.setAttribute("listProduct", pagination.getDataList());
            request.setAttribute("totalPage", pagination.getTotalPage());
            request.getRequestDispatcher("/view/client/category.jsp").forward(request, response);
        } else if (pathInfo.contains("/search")) {
            String[] params = pathInfo.split("/");
            String keyword = params[2];
            Pagination<ProductDto> pagination = productService.getListProductByKeyWord(keyword, page).getData();
            request.setAttribute("listProduct", pagination.getDataList());
            request.setAttribute("totalPage", pagination.getTotalPage());
            request.getRequestDispatcher("/view/client/category.jsp").forward(request, response);
        } else if (pathInfo.contains("/id")) {

            Long typeProductId = Long.parseLong(pathInfo.substring(3));
            Pagination<ProductDto> pagination = productService.getListProductByTypeProductId(typeProductId, page).getData();
            request.setAttribute("listProduct", pagination.getDataList());
            request.setAttribute("totalPage", pagination.getTotalPage());
            request.getRequestDispatcher("/view/client/category.jsp").forward(request, response);
        } else {
            response.sendError(404);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
