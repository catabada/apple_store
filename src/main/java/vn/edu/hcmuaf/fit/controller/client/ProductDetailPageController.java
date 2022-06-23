package vn.edu.hcmuaf.fit.controller.client;

import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.service.impl.product.ProductServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.productcolor.ProductColorServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.productdetail.ProductDetailServiceImpl;
import vn.edu.hcmuaf.fit.service.product.ProductService;
import vn.edu.hcmuaf.fit.service.productcolor.ProductColorService;
import vn.edu.hcmuaf.fit.service.productdetail.ProductDetailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailPageController", value = "/apple-store/product-detail")
public class ProductDetailPageController extends HttpServlet {
    private ProductDetailService productDetailService;
    private ProductColorService productColorService;
    private ProductService productService;


    @Override
    public void init() throws ServletException {
        productDetailService = new ProductDetailServiceImpl();
        productColorService = new ProductColorServiceImpl();
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("id"));

        ProductDto product = productService.getProductById(productId).getData();
        request.setAttribute("product", product);

        List<ProductDetailDto> listProductDetail = productDetailService.getListByProductId(productId).getData();
        System.out.println(listProductDetail.get(0).getProduct().getName());
        request.setAttribute("listProductDetail", listProductDetail);

        List<ProductColorDto> listProductColor = productColorService.getListByProductId(productId).getData();
        request.setAttribute("listProductColor" , listProductColor);

        request.getRequestDispatcher("/view/client/product-detail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
