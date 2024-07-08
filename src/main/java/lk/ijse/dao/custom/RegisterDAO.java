package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.RegisterEntity;

import java.sql.SQLException;

public interface RegisterDAO extends CrudDAO<RegisterEntity> {

    public boolean saveUser(String userId, String password, String name) throws SQLException;

}
