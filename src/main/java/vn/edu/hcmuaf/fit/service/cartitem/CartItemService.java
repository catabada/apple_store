package vn.edu.hcmuaf.fit.service.cartitem;

import vn.edu.hcmuaf.fit.dto.cartitem.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface CartItemService {
    public DataResponse<CartItemDto> getCartItemById(final Long id);

    public DataResponse<List<CartItemDto>> getListCartItemByCartId(final Long cartId);

    public DataResponse<CartItemDto> createCartItem(final CartItemCreate create);

    public DataResponse<Integer> totalPriceInCart(final Long cartId);

    public DataResponse<List<CartItemDto>> getListCartItem();

    public BaseResponse deleteCartItemById(final Long id);

    public DataResponse<CartItemDto> updateAmount(final CartItemUpdate update);



}
