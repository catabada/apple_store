package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productdetail.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.productdetail.ProductDetailServiceImpl;
import vn.edu.hcmuaf.fit.service.productdetail.ProductDetailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ProductDetailAPI", urlPatterns = "/apple-store/api/product-detail/*")
public class ProductDetailAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private ProductDetailService productDetailService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDetailService = new ProductDetailServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        if (path == null) {
            DataResponse<List<ProductDetailDto>> result = productDetailService.getListProductDetail();
            response.getWriter().println(GSON.toJson(result));
        } else if (path.contains("/listByProductColorId")) {
            Long productColorId = Long.parseLong(path.substring(21));
            DataResponse<List<ProductDetailDto>> result = productDetailService.getListByProductColorId(productColorId);
            response.getWriter().write(GSON.toJson(result));
        } else if (path.contains("/listByProductOptionId")) {
            Long productColorId = Long.parseLong(path.substring(22));
            DataResponse<List<ProductDetailDto>> result = productDetailService.getListByProductOptionId(productColorId);
            response.getWriter().write(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(path.substring(1));
                DataResponse<ProductDetailDto> result = productDetailService.getProductDetailById(id);
                response.getWriter().println(GSON.toJson(result));
            } catch (NumberFormatException e) {
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long productId = Long.parseLong(request.getParameter("addProductId"));
        Long productColorId = Long.parseLong(request.getParameter("addProductColorId"));
        Long productOptionId = Long.parseLong(request.getParameter("addProductOptionId"));
        Integer price = Integer.parseInt(request.getParameter("addPrice"));
        Integer amount = Integer.parseInt(request.getParameter("addAmount"));

        ProductDetailCreate create = new ProductDetailCreate(productId, productColorId, productOptionId, price, amount);
        DataResponse<ProductDetailDto> result = productDetailService.createProductDetail(create);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        if (path == null) {
            response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
        } else {
            try {
                Long id = Long.parseLong(path.substring(1));
                Long productId = Long.parseLong(request.getParameter("updateProductId"));
                Long productColorId = Long.parseLong(request.getParameter("updateProductColorId"));
                Long productOptionId = Long.parseLong(request.getParameter("updateProductOptionId"));
                Integer price = Integer.parseInt(request.getParameter("updatePrice"));
                Integer amount = Integer.parseInt(request.getParameter("updateAmount"));
                boolean isActive = Integer.parseInt(request.getParameter("updateActive")) == 1;
                System.out.println(productId + " " + productColorId + " " + productOptionId + " " + price + " " + amount + " " + isActive);

                ProductDetailUpdate update = new ProductDetailUpdate(id, productId, productColorId, productOptionId, price, amount, isActive);
                BaseResponse result = productDetailService.updateProductDetail(update);
                response.getWriter().println(GSON.toJson(result));
            } catch (NumberFormatException e) {
                response.getWriter().println(GSON.toJson(new BaseResponse(false, 400, "NumberFormatException")));
            }

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        if (path == null) {
            response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
        } else {
            try {
                Long id = Long.parseLong(path.substring(1));
                BaseResponse result = productDetailService.deleteProductDetailById(id);
                response.getWriter().println(GSON.toJson(result));
            } catch (NumberFormatException e) {
                response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
            }
        }

    }
}
