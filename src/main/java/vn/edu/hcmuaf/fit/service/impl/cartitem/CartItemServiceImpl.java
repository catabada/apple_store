package vn.edu.hcmuaf.fit.service.impl.cartitem;

import vn.edu.hcmuaf.fit.dao.cartitem.CartItemDAO;
import vn.edu.hcmuaf.fit.dao.impl.cart.CartDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.cartitem.CartItemDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productdetail.ProductDetailDAOImpl;
import vn.edu.hcmuaf.fit.dto.cartitem.*;
import vn.edu.hcmuaf.fit.mapper.cartitem.CartItemMapper;
import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.cartitem.CartItem;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.cartitem.CartItemService;

import java.util.List;
import java.util.Optional;

public class CartItemServiceImpl implements CartItemService {
    private CartItemMapper cartItemMapper;
    private CartItemDAO cartItemDao;

    public CartItemServiceImpl() {
        cartItemDao = CartItemDAOImpl.getInstance();
        cartItemMapper = new CartItemMapper();
    }

    @Override
    public DataResponse<CartItemDto> getCartItemById(Long id) {
        Optional<CartItem> optional = cartItemDao.findById(id);
        return optional.map(CartItem -> {
            CartItemDto CartItemDto = cartItemMapper.toCartItemDto(CartItem);
            return new DataResponse<CartItemDto>(true, 200, "Success", CartItemDto);
        }).orElseGet(() -> new DataResponse<CartItemDto>(false, 401, "Cart item not found", null));
    }

    @Override
    public DataResponse<CartItemDto> createCartItem(CartItemCreate create) {
        Optional<CartItem> optional = cartItemDao.findByCartIdAndProductDetailId(create.getCartId(), create.getProductDetailId());
        if(!optional.isPresent()) {
            Cart cart = CartDAOImpl.getInstance().findById(create.getCartId()).orElse(null);
            ProductDetail productDetail = ProductDetailDAOImpl.getInstance().findById(create.getProductDetailId()).orElse(null);
            CartItem cartItem = new CartItem(cart, productDetail, create.getQuantity());
            cartItemDao.save(cartItem);
            return new DataResponse<CartItemDto>(true, 200, "Product has been add to cart", cartItemMapper.toCartItemDto(cartItem));
        } else {
            CartItem cartItemDto = optional.get();
            cartItemDto.setQuantity(cartItemDto.getQuantity() + 1);
            cartItemDao.save(cartItemDto);
            return new DataResponse<CartItemDto>(true, 200, "Quantity product increase by 1", cartItemMapper.toCartItemDto(cartItemDto));
        }

    }

    @Override
    public DataResponse<List<CartItemDto>> getListCartItem() {
        List<CartItem> cartItems = cartItemDao.findAll();
        return new DataResponse<List<CartItemDto>>(true, 200, "Success!", cartItemMapper.toCartItemDtoList(cartItems));
    }

    @Override
    public BaseResponse deleteCartItemById(Long id) {
        if (!cartItemDao.findById(id).isPresent()) {
            return new BaseResponse(false, 401, "Cart item not found");
        }
        cartItemDao.removeById(id);
        return new BaseResponse(true, 200, "Success");
    }

    @Override
    public BaseResponse updateAmount(CartItemUpdate update) {
        CartItem cartItem = cartItemDao.findById(update.getId()).orElse(null);
        if (cartItem == null) {
            return new BaseResponse(false, 401, "Cart item not found");
        }
        cartItem.setQuantity(update.getQuantity());
        cartItemDao.save(cartItem);
        return new BaseResponse(true, 200, "Success");
    }
}
