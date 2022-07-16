package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.typeproduct.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.typeproduct.TypeProductService;
import vn.edu.hcmuaf.fit.service.impl.typeproduct.TypeProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "TypeProductAPI", urlPatterns = "/apple-store/api/type-product/*")
public class TypeProductAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private TypeProductService typeProductService;

    @Override
    public void init() throws ServletException {
        typeProductService = new TypeProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            DataResponse<List<TypeProductDto>> result = typeProductService.getTypeProductList();
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<TypeProductDto> result = typeProductService.getTypeProduct(id);
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
        TypeProductCreate create = new TypeProductCreate(sku, name);
        DataResponse<TypeProductDto> result = typeProductService.createTypeProduct(create);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = typeProductService.deleteTypeProduct(id);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));

        String sku = request.getParameter("updateSku");
        String name = request.getParameter("updateName");
        boolean active = Integer.parseInt(request.getParameter("updateActive")) == 1;
        TypeProductUpdate update = new TypeProductUpdate(id, sku, name, active);
        BaseResponse result = typeProductService.updateTypeProduct(update);
        response.getWriter().println(GSON.toJson(result));
    }

}
