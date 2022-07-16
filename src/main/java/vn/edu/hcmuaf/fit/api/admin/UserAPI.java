package vn.edu.hcmuaf.fit.api.admin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.color.ColorCreate;
import vn.edu.hcmuaf.fit.dto.color.ColorDto;
import vn.edu.hcmuaf.fit.dto.user.UserCreate;
import vn.edu.hcmuaf.fit.dto.user.UserDto;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;
import vn.edu.hcmuaf.fit.service.impl.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserAPI", value = "/apple-store/api/user/*")
public class UserAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<UserDto>> result = userService.getListUser();
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<UserDto> result = userService.getUserById(id);
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
        String username = request.getParameter("addUserName");
        String password = request.getParameter("addPassword");
        String firstName = request.getParameter("addFirstName");
        String lastName = request.getParameter("addLastName");
String phone = request.getParameter("addPhone");
        String email = request.getParameter("addEmail");
        String address = request.getParameter("addAddress");
        UserCreate create = new UserCreate(username, password, firstName, lastName,phone, email, address);
        DataResponse<UserDto> result = userService.createUser(create);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPut(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = userService.deleteUserById(id);
        response.getWriter().println(GSON.toJson(result));
    }
}
