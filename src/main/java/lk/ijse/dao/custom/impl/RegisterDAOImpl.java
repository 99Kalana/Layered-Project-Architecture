package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.RegisterDAO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.entity.RegisterEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {

    @Override
    public boolean saveUser(String userId, String password, String name) throws SQLException {

        /*String sql = "INSERT INTO user VALUES(?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, userId);
        pstm.setObject(2, password);
        pstm.setObject(3, name);
        pstm.setObject(4, null);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO user VALUES(?, ?, ?, ?)",userId,password,name,null);

    }

    @Override
    public RegisterEntity searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(RegisterEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(RegisterEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<RegisterEntity> getAll() throws SQLException {
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
