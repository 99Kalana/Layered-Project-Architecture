package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResetPasswordBO extends SuperBO {


    public boolean isValidUser(String userId, String name) throws SQLException;

    public boolean resetPassword(String userId,String newPassword) throws SQLException;

}
