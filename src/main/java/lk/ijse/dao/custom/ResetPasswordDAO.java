package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.entity.ResetPasswordEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResetPasswordDAO extends CrudDAO<ResetPasswordEntity> {

    public boolean isValidUser(String userId, String name) throws SQLException;

    public boolean resetPassword(String userId,String newPassword) throws SQLException;


}
