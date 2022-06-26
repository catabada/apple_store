package vn.edu.hcmuaf.fit.controller.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.dto.cart.CartCreate;
import vn.edu.hcmuaf.fit.dto.user.UserDto;
import vn.edu.hcmuaf.fit.dto.user.UserSignUp;
import vn.edu.hcmuaf.fit.model.user.User;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;
import vn.edu.hcmuaf.fit.service.cart.CartService;
import vn.edu.hcmuaf.fit.service.impl.cart.CartServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "SignUpController", value = "/apple-store/sign-up")
public class SignUpController extends HttpServlet {
    private UserService userService;
    private CartService cartService;
    private final Gson GSON = new GsonBuilder().create();

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
        cartService = new CartServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        UserSignUp signUp = new UserSignUp(username, password, email, firstName, lastName);
        BaseResponse result = userService.signUp(signUp);
        if (result.isSuccess()) {
            UserDto user = userService.getUserByUsername(username).getData();
            CartCreate cart = new CartCreate(user.getId());
            cartService.createCart(cart);
        }
        response.getWriter().println(GSON.toJson(result));

    }
}
