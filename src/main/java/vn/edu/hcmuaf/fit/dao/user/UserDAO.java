package vn.edu.hcmuaf.fit.dao.user;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.user.User;

import java.util.Optional;

public interface UserDAO extends BaseDAO<User> {
    Optional<User> findByUsername(String username);

}
