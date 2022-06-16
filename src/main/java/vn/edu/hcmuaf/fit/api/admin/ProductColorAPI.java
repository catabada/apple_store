package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorCreate;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.productcolor.ProductColorServiceImpl;
import vn.edu.hcmuaf.fit.service.productcolor.ProductColorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ProductColorAPI", urlPatterns = "/api/product-color/*")
public class ProductColorAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private ProductColorService productColorService;

    @Override
    public void init() throws ServletException {
        productColorService = new ProductColorServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<ProductColorDto>> result = productColorService.getListProductColor();
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<ProductColorDto> result = productColorService.getProductColorById(id);
                response.getWriter().println(GSON.toJson(result));
            } catch (NumberFormatException e) {
                response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long productId = Long.parseLong(request.getParameter("addProductId"));
        Long colorId = Long.parseLong(request.getParameter("addColorId"));
        String bgImage = request.getParameter("addBgImage");
        String deImages = request.getParameter("addDeImages");

        ProductColorCreate create = new ProductColorCreate(productId, colorId, bgImage, deImages);
        DataResponse<ProductColorDto> result = productColorService.createProductColor(create);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = productColorService.deleteProductColorById(id);
        response.getWriter().println(GSON.toJson(result));


    }
}
