package vn.edu.hcmuaf.fit.service.impl.cart;

import vn.edu.hcmuaf.fit.dao.cart.CartDAO;
import vn.edu.hcmuaf.fit.dao.impl.cart.CartDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.user.UserDAOImpl;
import vn.edu.hcmuaf.fit.dto.cart.CartCreate;
import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.mapper.cart.CartMapper;
import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.user.User;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.cart.CartService;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {
    private CartMapper cartMapper;
    private CartDAO cartDao;


    public CartServiceImpl() {
        cartDao = CartDAOImpl.getInstance();
        cartMapper = new CartMapper();
    }

    @Override
    public DataResponse<CartDto> getCartById(Long id) {
        Optional<Cart> optional = cartDao.findById(id);
        return optional.map(cart -> {
            CartDto cartDto = cartMapper.toCartDto(cart);
            return new DataResponse<CartDto>(true, 200, "Success", cartDto);
        }).orElseGet(() -> new DataResponse<CartDto>(false, 401, "Cart not found", null));
    }

    @Override
    public DataResponse<CartDto> createCart(CartCreate create) {
        User user = UserDAOImpl.getInstance().findById(create.getUserId()).orElse(null);
        Cart cart = new Cart(user);
        cartDao.save(cart);
        return new DataResponse<CartDto>(true, 200, "Success", cartMapper.toCartDto(cart));
    }

    @Override
    public DataResponse<List<CartDto>> getListCart() {
        List<Cart> carts = cartDao.findAll();
        return new DataResponse<List<CartDto>>(true, 200, "Success!", cartMapper.toCartDtoList(carts));
    }

    @Override
    public BaseResponse deleteCartById(Long id) {
        if (!cartDao.findById(id).isPresent()) {
            return new BaseResponse(false, 401, "Cart not found");
        }
        cartDao.removeById(id);
        return new BaseResponse(true, 200, "Success");
    }
}
