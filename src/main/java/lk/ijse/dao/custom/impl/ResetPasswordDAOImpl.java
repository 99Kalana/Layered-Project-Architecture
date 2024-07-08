package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ResetPasswordDAO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.entity.ResetPasswordEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResetPasswordDAOImpl implements ResetPasswordDAO {

    @Override
    public boolean isValidUser(String userId, String name) throws SQLException {

        /*String sql = "SELECT user_id FROM user WHERE user_id = ? AND user_name = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userId);
        pstm.setString(2,name);

        ResultSet resultSet = pstm.executeQuery();*/

        //return resultSet.next();

        ResultSet resultSet = SQLUtil.execute("SELECT user_id FROM user WHERE user_id = ? AND user_name = ?",userId,name);

        if (resultSet.next()){
            return true;
        }else {
            return false;
        }




    }
    @Override
    public boolean resetPassword(String userId,String newPassword) throws SQLException {

        /*String sql = "UPDATE user SET password = ? WHERE user_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,newPassword);
        pstm.setString(2,userId);

        return pstm.executeUpdate()>0;*/

        return SQLUtil.execute("UPDATE user SET password = ? WHERE user_id = ?",newPassword,userId);



    }


    @Override
    public ResetPasswordEntity searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(ResetPasswordEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ResetPasswordEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<ResetPasswordEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public String getCurrentBillId() throws SQLException {
        return null;
    }
}
