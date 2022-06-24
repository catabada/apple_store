package vn.edu.hcmuaf.fit.mapper.cartitem;

import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.dto.cartitem.CartItemDto;
import vn.edu.hcmuaf.fit.mapper.cart.CartMapper;
import vn.edu.hcmuaf.fit.mapper.productdetail.ProductDetailMapper;
import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.cartitem.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartItemMapper {
    private CartMapper cartMapper;
    private ProductDetailMapper productDetailMapper;

    public CartItemMapper() {
        cartMapper = new CartMapper();
        productDetailMapper = new ProductDetailMapper();
    }

    public CartItem toCartItem(final CartItemDto dto) {
        return new CartItem(dto.getId(), cartMapper.toCart(dto.getCart()), productDetailMapper.toProductDetail(dto.getProductDetail()), dto.getQuantity());
    }

    public CartItemDto toCartItemDto(final CartItem model) {
        return new CartItemDto(model.getId(), cartMapper.toCartDto(model.getCart()), productDetailMapper.toProductDetailDto(model.getProductDetail()), model.getQuantity());
    }

    public List<CartItem> toCartItemList(final List<CartItemDto> dtoList) {
        List<CartItem> list = new ArrayList<>();
        for (CartItemDto dto : dtoList) {
            list.add(toCartItem(dto));
        }
        return list;
    }

    public List<CartItemDto> toCartItemDtoList(final List<CartItem> list) {
        List<CartItemDto> listDto = new ArrayList<>();
        for (CartItem model : list) {
            listDto.add(toCartItemDto(model));
        }
        return listDto;
    }

}
