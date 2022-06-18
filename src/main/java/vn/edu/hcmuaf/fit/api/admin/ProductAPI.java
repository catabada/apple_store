package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.constant.FileConstant;
import vn.edu.hcmuaf.fit.dto.product.ProductCreate;
import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductCreate;
import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.product.ProductServiceImpl;
import vn.edu.hcmuaf.fit.service.product.ProductService;
import vn.edu.hcmuaf.fit.service.typeproduct.TypeProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
@WebServlet(name = "ProductAPI", urlPatterns = "/api/product/*")
public class ProductAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            DataResponse<List<ProductDto>> result = productService.getListProduct();
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<ProductDto> result = productService.getProductById(id);
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

        String sku = request.getParameter("addSku");
        String name = request.getParameter("addName");
        Integer price = Integer.parseInt(request.getParameter("addPrice"));
        Long typeId = Long.parseLong(request.getParameter("addTypeId"));
        double discount = Double.parseDouble(request.getParameter("addDiscount"));
        String urlImage = uploadFile(request, response, "addImage");
        ProductCreate create = new ProductCreate(sku, name, typeId, price, urlImage, discount);


        DataResponse<ProductDto> result = productService.createProduct(create);
        response.getWriter().println(GSON.toJson(result));
    }

    private String uploadFile(HttpServletRequest request, HttpServletResponse response, String partName) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Part part = request.getPart(partName);

        String fileName = System.currentTimeMillis() + "-" + part.getSubmittedFileName();

        File folder = new File(FileConstant.BASE_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        part.write(FileConstant.BASE_FOLDER + File.separator + fileName);

        return fileName;
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = productService.deleteProductById(id);
        response.getWriter().println(GSON.toJson(result));
    }


}
