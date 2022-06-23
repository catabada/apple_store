package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.constant.FileConstant;
import vn.edu.hcmuaf.fit.dto.option.OptionDto;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorCreate;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.productcolor.ProductColorServiceImpl;
import vn.edu.hcmuaf.fit.service.productcolor.ProductColorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
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
        } else if (pathInfo.contains("/listByProductId")) {
            Long productId = Long.parseLong(pathInfo.substring(16));
            DataResponse<List<ProductColorDto>> result = productColorService.getListByProductId(productId);
            response.getWriter().write(GSON.toJson(result));
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
        String bgImage = uploadFile(request, response, "addBgImage");
        String deImages = uploadFiles(request, response, "addDeImages");

        ProductColorCreate create = new ProductColorCreate(productId, colorId, bgImage, deImages);
        DataResponse<ProductColorDto> result = productColorService.createProductColor(create);
        response.getWriter().println(GSON.toJson(result));
    }

    private String uploadFiles(HttpServletRequest request, HttpServletResponse response, String partName) throws ServletException, IOException {
        List<Part> part = (List<Part>) request.getParts();
        StringBuilder sb = new StringBuilder();
        for (Part p : part) {
            if (p.getName().equals(partName)) {
                String fileName = System.currentTimeMillis() + "-" + p.getSubmittedFileName();
                String filePath = FileConstant.BASE_FOLDER + File.separator + fileName;
                p.write(filePath);
                sb.append(fileName).append("_");
            }
        }
        return sb.toString();
    }

    private String uploadFile(HttpServletRequest request, HttpServletResponse response, String partName) throws ServletException, IOException {
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
