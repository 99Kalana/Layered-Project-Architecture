package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

import java.sql.SQLException;

public interface RegisterBO extends SuperBO {

    public boolean saveUser(String userId, String password, String name) throws SQLException;

}
