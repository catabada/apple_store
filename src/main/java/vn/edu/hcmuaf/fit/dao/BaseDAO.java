package vn.edu.hcmuaf.fit.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    boolean save(T object);

    boolean removeById(Long id);
}
