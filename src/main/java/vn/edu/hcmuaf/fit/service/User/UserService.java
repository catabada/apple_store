package vn.edu.hcmuaf.fit.service.User;

import vn.edu.hcmuaf.fit.dto.user.*;
import vn.edu.hcmuaf.fit.model.user.User;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface UserService {
    public DataResponse<UserDto> getUserById(final Long id);


    public DataResponse<UserDto> getUserByName(final String name);

    public DataResponse<UserDto> createUser(final UserCreate create);

    public DataResponse<List<UserDto>> getListUser();

    public BaseResponse deleteUserById(final Long id);

    public BaseResponse updateUser(final UserUpdate update);
    public DataResponse<User> signIn(final UserSignIn user);
    public BaseResponse signUp(final UserSignUp user);


}
