package vn.edu.hcmuaf.fit.controller.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.Session;
import vn.edu.hcmuaf.fit.dto.user.UserSignIn;
import vn.edu.hcmuaf.fit.dto.user.UserSignUp;
import vn.edu.hcmuaf.fit.model.user.User;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;
import vn.edu.hcmuaf.fit.service.impl.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@MultipartConfig
@WebServlet(name = "SignInController", value = "/apple-store/sign-in")
public class SignInController extends HttpServlet {
    private UserService userService;
    private final Gson GSON = new GsonBuilder().create();
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserSignIn signIn = new UserSignIn(username, password);
        DataResponse<User> result = userService.signIn(signIn);
        User user = result.getData();
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        response.getWriter().println(GSON.toJson(result));

    }
}
