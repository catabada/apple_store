package vn.edu.hcmuaf.fit.dao.option;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.option.Option;

import java.util.List;

public interface OptionDAO extends BaseDAO<Option> {
    List<Option> findAllByTypeProductId(Long typeProductId);
}
