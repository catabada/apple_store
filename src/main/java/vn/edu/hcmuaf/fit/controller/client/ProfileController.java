package vn.edu.hcmuaf.fit.controller.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.dto.user.UserDto;
import vn.edu.hcmuaf.fit.dto.user.UserUpdate;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;
import vn.edu.hcmuaf.fit.service.impl.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@MultipartConfig
@WebServlet(name = "ProfileController", value = "/apple-store/profile")
public class ProfileController extends HttpServlet {
    private UserService userService;
    private final Gson GSON = new GsonBuilder().create();

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        UserDto user = userService.getUserById(userId).getData();
        request.setAttribute("user", user);

        request.getRequestDispatcher("/view/client/profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Long id = Long.parseLong(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        UserUpdate userUpdateProfile = new UserUpdate (id,firstName, lastName, phone,email, address);
        BaseResponse result = userService.updateProfile(userUpdateProfile);

        response.getWriter().println(GSON.toJson(result));
    }
}
