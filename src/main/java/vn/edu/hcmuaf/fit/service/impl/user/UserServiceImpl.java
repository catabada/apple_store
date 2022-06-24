package vn.edu.hcmuaf.fit.service.impl.user;

import vn.edu.hcmuaf.fit.dao.impl.user.UserDAOImpl;
import vn.edu.hcmuaf.fit.dao.user.UserDAO;
import vn.edu.hcmuaf.fit.dto.user.*;
import vn.edu.hcmuaf.fit.mapper.user.UserMapper;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.user.User;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.User.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDAO userDao;
    private UserMapper userMapper;
    public UserServiceImpl() {
        this.userDao = UserDAOImpl.getInstance();
        this.userMapper = new UserMapper();
    }


    @Override
    public DataResponse<UserDto> getUserById(Long id) {
        Optional<User> optional = userDao.findById(id);
        return optional.map(
                        user -> new DataResponse<>(true, 200, "Success", userMapper.toUserDto(user)))
                .orElseGet(() -> new DataResponse<>(false, 401, "Can't find by id = " + id, null));

    }

    @Override
    public DataResponse<UserDto> getUserByName(String name) {return null;}


    @Override
    public DataResponse<UserDto> createUser(UserCreate create) {
        User user = new User(create.getUsername(),create.getPassword(),create.getFirstName(),create.getLastName(),create.getPhone(),create.getEmail(),create.getAddress());
        userDao.save(user);
        return new DataResponse<>(true, 200, "Success!", userMapper.toUserDto(user));
    }

    @Override
    public DataResponse<List<UserDto>> getListUser() {
        List<User> listUser = userDao.findAll();
        return new DataResponse<List<UserDto>>(true, 200, "Success!", userMapper.toUserDtoList(listUser));
    }

    @Override
    public BaseResponse deleteUserById(Long id) {
        if (!userDao.findById(id).isPresent()) {
            return new BaseResponse(false, 404, "Not found!");
        }
        userDao.removeById(id);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public BaseResponse updateUser(UserUpdate update) {
        Optional<User> optional = userDao.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 404, "Not found!");
        }
        else {
            User user = optional.get();
            user.setUsername(update.getUsername());
            user.setPassword(update.getPassword());
            user.setFirstName(update.getFirstName());
            user.setLastName(update.getLastName());
            user.setPhone(update.getPhone());
            user.setEmail(update.getEmail());
            user.setAddress(update.getAddress());
            user.setRole(update.getRole());
            user.setActive(update.isActive());
            userDao.save(user);
            return new BaseResponse(true, 200, "Success!");
        }

    }

    @Override
    public DataResponse<User> signIn(UserSignIn user) {
        Optional<User> optional = userDao.signIn(user.getUsername(), user.getPassword());
        if(optional.isPresent()) {
            return new DataResponse<User>(true,200,"Success",optional.get());
        }
        return new DataResponse<User>(false,401,"Username or password is wrong",null);
    }

    @Override
    public BaseResponse signUp(UserSignUp signUp) {
        User user = new User(0L,signUp.getUsername(), signUp.getPassword(), signUp.getFirstName(),signUp.getLastName()," ", signUp.getEmail()," ",0,null,true);
        if (userDao.checkUsername(user.getUsername()).isPresent()){
            return new BaseResponse(false,401,"Username Exist");
        }
        userDao.signUp(user);
        return new BaseResponse(true,200,"Success");
    }

    @Override
    public DataResponse<User> updateProfile(UserUpdate update) {
        Optional<User> optional = userDao.findById(update.getId());
        if(optional.isPresent()) {
            User user = optional.get();
            user.setFirstName(update.getFirstName());
            user.setLastName(update.getLastName());
            user.setPhone(update.getPhone());
            user.setEmail(update.getEmail());
            user.setAddress(update.getAddress());
            userDao.save(user);
            return new DataResponse<User>(true,200,"Success",optional.get());
        }
        return new DataResponse<User>(false,401,"Can't update profile",null);
    }
}

