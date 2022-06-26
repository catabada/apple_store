package vn.edu.hcmuaf.fit.service.cart;

import vn.edu.hcmuaf.fit.dto.cart.CartCreate;
import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface CartService {
    public DataResponse<CartDto> getCartById(final Long id);

    public DataResponse<CartDto> getCartByUserId(final Long userId);

    public DataResponse<CartDto> createCart(final CartCreate create);

    public DataResponse<List<CartDto>> getListCart();

    public BaseResponse deleteCartById(final Long id);

}
