package vn.edu.hcmuaf.fit.api.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.constant.AppError;
import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.dto.cartitem.*;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;
import vn.edu.hcmuaf.fit.dto.user.UserCreate;
import vn.edu.hcmuaf.fit.dto.user.UserDto;
import vn.edu.hcmuaf.fit.model.cartitem.CartItem;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;
import vn.edu.hcmuaf.fit.service.cart.CartService;
import vn.edu.hcmuaf.fit.service.cartitem.CartItemService;
import vn.edu.hcmuaf.fit.service.impl.cart.CartServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.cartitem.CartItemServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.productdetail.ProductDetailServiceImpl;
import vn.edu.hcmuaf.fit.service.impl.user.UserServiceImpl;
import vn.edu.hcmuaf.fit.service.productdetail.ProductDetailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "CartUserAPI", urlPatterns = "/api/cart-item/*")
public class CartUserAPI extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private CartItemService cartItemService;
    private CartService cartService;
    private ProductDetailService productDetailService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartItemService = new CartItemServiceImpl();
        cartService = new CartServiceImpl();
        productDetailService = new ProductDetailServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            DataResponse<List<CartItemDto>> result = cartItemService.getListCartItem();
            response.getWriter().println(GSON.toJson(result));
        } else if (pathInfo.contains("/totalPriceInCart")) {
            Long cartId = Long.parseLong(pathInfo.substring(17));
            DataResponse<Integer> result = cartItemService.totalPriceInCart(cartId);
            response.getWriter().println(GSON.toJson(result));
        } else {
            try {
                Long id = Long.parseLong(pathInfo.substring(1));
                DataResponse<CartItemDto> result = cartItemService.getCartItemById(id);
                response.getWriter().println(GSON.toJson(result));
            } catch (NumberFormatException e) {
                response.sendError(AppError.Unknown.errorCode(), AppError.Unknown.errorMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            Long productId = Long.parseLong(request.getParameter("productId"));
            CartDto cart = cartService.getCartByUserId(userId).getData();
            Long productColorId = Long.parseLong(request.getParameter("productColorId"));
            Long productOptionId = Long.parseLong(request.getParameter("productOptionId"));

            ProductDetailDto productDetail = productDetailService.getProductDetailByProductIdAndProductColorIdAndProductOptionId(productId, productColorId, productOptionId).getData();

            CartItemCreate cartItemCreate = new CartItemCreate(cart.getId(), productDetail.getId(), 1);
            DataResponse<CartItemDto> result = cartItemService.createCartItem(cartItemCreate);

            response.getWriter().println(GSON.toJson(result));
            return;
        }
        BaseResponse result = new BaseResponse(false, 401, "You must login to add to cart");
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        CartItemUpdate cartItemUpdate = new CartItemUpdate(id, quantity);
        DataResponse<CartItemDto> result = cartItemService.updateAmount(cartItemUpdate);
        response.getWriter().println(GSON.toJson(result));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathInfo = request.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        BaseResponse result = cartItemService.deleteCartItemById(id);
        response.getWriter().println(GSON.toJson(result));
    }
}
