package vn.edu.hcmuaf.fit.dto.cart;

import vn.edu.hcmuaf.fit.dto.user.UserDto;

public class CartDto {
    private Long id;
    private UserDto user;

    public CartDto() {
    }

    public CartDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }

    public CartDto(UserDto user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
