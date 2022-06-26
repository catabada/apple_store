package vn.edu.hcmuaf.fit.controller.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vn.edu.hcmuaf.fit.dto.cartitem.CartItemDto;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.cartitem.CartItemService;
import vn.edu.hcmuaf.fit.service.impl.cartitem.CartItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "CartPageController", urlPatterns = "/apple-store/cart")
public class CartPageController extends HttpServlet {
    private final Gson GSON = new GsonBuilder().create();
    private CartItemService cartItemService;

    @Override
    public void init() throws ServletException {
        cartItemService = new CartItemServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long cartId = (Long) session.getAttribute("cartId");
        if (cartId == null) {
            response.sendRedirect("/apple-store");
            return;
        } else {
            List<CartItemDto> listCartItem = cartItemService.getListCartItemByCartId(cartId).getData();
            Integer totalPrice = cartItemService.totalPriceInCart(cartId).getData();
            request.setAttribute("listCartItem", listCartItem);
            request.setAttribute("totalPrice", totalPrice);
        }
        request.getRequestDispatcher("/view/client/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
