package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.option.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.impl.option.OptionServiceImpl;
import vn.edu.hcmuaf.fit.service.option.OptionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "OptionAPI", urlPatterns = "/api/option/*")
public class OptionAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private OptionService optionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        optionService = new OptionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<OptionDto>> result = optionService.getListOption();
            response.getWriter().write(GSON.toJson(result));
        } else if (pathInfo.contains("/listByTypeProductId")) {
            Long productId = Long.parseLong(pathInfo.substring(20));
            DataResponse<List<OptionDto>> result = optionService.getListOptionByTypeProductId(productId);
            response.getWriter().write(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1)); // /1 => 1
                DataResponse<OptionDto> result = optionService.getOptionById(id);
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
        Long typeProductId = Long.parseLong(request.getParameter("addTypeProductId"));

        OptionCreate create = new OptionCreate(sku, name, typeProductId);

        DataResponse<OptionDto> result = optionService.createOption(create);
        response.getWriter().write(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("updateId"));
        String sku = request.getParameter("updateSku");
        String name = request.getParameter("updateName");
        Long typeProductId = Long.parseLong(request.getParameter("updateTypeProductId"));

        OptionUpdate update = new OptionUpdate(id, sku, name, typeProductId);
        BaseResponse result = optionService.updateOption(update);
        response.getWriter().write(GSON.toJson(result));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getPathInfo().substring(1));
        BaseResponse result = optionService.deleteOptionById(id);

        response.getWriter().write(GSON.toJson(result));
    }
}
