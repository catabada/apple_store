package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.option.*;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;
import vn.edu.hcmuaf.fit.dto.productoption.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.productoption.ProductOptionServiceImpl;
import vn.edu.hcmuaf.fit.service.productoption.ProductOptionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ProductOptionAPI", urlPatterns = "/apple-store/api/product-option/*")
public class ProductOptionAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private ProductOptionService productOptionService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        productOptionService = new ProductOptionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<ProductOptionDto>> result = productOptionService.getListProductOption();
            response.getWriter().write(GSON.toJson(result));
        } else if (pathInfo.contains("/listByProductId")) {
            Long productId = Long.parseLong(pathInfo.substring(16));
            DataResponse<List<ProductOptionDto>> result = productOptionService.getListByProductId(productId);
            response.getWriter().write(GSON.toJson(result));
        } else if (pathInfo.contains("/listByProductColorId")) {
            Long productColorId = Long.parseLong(pathInfo.substring(21));
            DataResponse<List<ProductDetailDto>> result = productOptionService.getListByProductColorId(productColorId);
            response.getWriter().write(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1)); // /1 => 1
                DataResponse<ProductOptionDto> result = productOptionService.getProductOptionById(id);
                response.getWriter().write(GSON.toJson(result));
            } catch (NumberFormatException e) {
                DataResponse<OptionDto> result = new DataResponse<OptionDto>(false, 401, "Number format wrong", null);
                response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String sku = request.getParameter("addSku");
        String name = request.getParameter("addName");
        Long productId = Long.parseLong(request.getParameter("addProductId"));
        Long optionId = Long.parseLong(request.getParameter("addOptionId"));

        ProductOptionCreate create = new ProductOptionCreate(sku, name, productId, optionId);

        DataResponse<ProductOptionDto> result = productOptionService.createProductOption(create);
        response.getWriter().write(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("updateId"));
        String sku = request.getParameter("updateSku");
        String name = request.getParameter("updateName");
        Long productId = Long.parseLong(request.getParameter("updateProductId"));
        Long optionId = Long.parseLong(request.getParameter("updateOptionId"));

        ProductOptionUpdate update = new ProductOptionUpdate(id, sku, name, productId, optionId);
        BaseResponse result = productOptionService.updateProductOption(update);
        response.getWriter().write(GSON.toJson(result));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getPathInfo().substring(1));
        BaseResponse result = productOptionService.deleteProductOptionById(id);

        response.getWriter().write(GSON.toJson(result));
    }
}
