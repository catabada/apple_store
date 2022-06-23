package vn.edu.hcmuaf.fit.mapper.user;

import vn.edu.hcmuaf.fit.dto.user.UserDto;
import vn.edu.hcmuaf.fit.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserMapper() {
    }

    public UserDto toUserDto(final User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress(), user.getRole(), user.getCreatedDate(), user.isActive());
    }

    public User toUser(final UserDto UserDto) {
        return new User(UserDto.getId(), UserDto.getUsername(), UserDto.getPassword(), UserDto.getFirstName(), UserDto.getLastName(), UserDto.getEmail(), UserDto.getAddress(), UserDto.getRole(), UserDto.getCreatedDate(), UserDto.isActive());
    }

    public List<User> toUserList(final List<UserDto> UserDtoList) {
        List<User> listUser = new ArrayList<User>();
        for (UserDto UserDto : UserDtoList) {
            User User = new User(UserDto.getId(), UserDto.getUsername(), UserDto.getPassword(), UserDto.getFirstName(), UserDto.getLastName(), UserDto.getEmail(), UserDto.getAddress(), UserDto.getRole(), UserDto.getCreatedDate(), UserDto.isActive());
            listUser.add(User);
        }
        return listUser;
    }

    public List<UserDto> toUserDtoList(final List<User> UserList) {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        for (User User : UserList) {
            UserDto UserDto = new UserDto(User.getId(), User.getUsername(), User.getPassword(), User.getFirstName(), User.getLastName(), User.getEmail(), User.getAddress(), User.getRole(), User.getCreatedDate(), User.isActive());
            listUserDto.add(UserDto);
        }
        return listUserDto;
    }
}
