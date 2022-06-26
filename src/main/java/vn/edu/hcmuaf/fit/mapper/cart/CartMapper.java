package vn.edu.hcmuaf.fit.mapper.cart;

import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.mapper.user.UserMapper;
import vn.edu.hcmuaf.fit.model.cart.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {
    private UserMapper userMapper;

    public CartMapper() {
        this.userMapper = new UserMapper();
    }

    public Cart toCart(final CartDto dto) {
        return new Cart(dto.getId(), userMapper.toUser(dto.getUser()));
    }

    public CartDto toCartDto(final Cart model) {
        return new CartDto(model.getId(), userMapper.toUserDto(model.getUser()));
    }

    public List<Cart> toCartList(final List<CartDto> dtoList) {
        List<Cart> list = new ArrayList<>();
        for (CartDto dto : dtoList) {
            list.add(toCart(dto));
        }
        return list;
    }

    public List<CartDto> toCartDtoList(final List<Cart> list) {
        List<CartDto> listDto = new ArrayList<>();
        for (Cart model : list) {
            listDto.add(toCartDto(model));
        }
        return listDto;
    }
}
