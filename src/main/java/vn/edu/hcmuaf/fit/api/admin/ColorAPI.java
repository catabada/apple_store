package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.color.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.color.ColorService;
import vn.edu.hcmuaf.fit.service.impl.color.ColorServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ColorAPI", urlPatterns = "/apple-store/api/color/*")
public class ColorAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private ColorService colorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        colorService = new ColorServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<ColorDto>> result = colorService.getListColor();
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<ColorDto> result = colorService.getColorById(id);
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
        String hex = request.getParameter("addHex");

        ColorCreate create = new ColorCreate(sku, name, hex);
        DataResponse<ColorDto> result = colorService.createColor(create);
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
        String hex = request.getParameter("updateHex");

        ColorUpdate update = new ColorUpdate(id, sku, name, hex);
        BaseResponse result = colorService.updateColor(update);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = colorService.deleteColorById(id);
        response.getWriter().println(GSON.toJson(result));
    }
}
