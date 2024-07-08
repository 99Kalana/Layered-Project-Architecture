package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillDAO;
import lk.ijse.entity.BillEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillDAOImpl implements BillDAO {


    @Override
    public  String getCurrentBillId() throws SQLException {

        /*String sql = "SELECT bill_id FROM bills ORDER BY bill_id DESC LIMIT 1";
        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT bill_id FROM bills ORDER BY bill_id DESC LIMIT 1");

        if(resultSet.next()) {
            String  billId = resultSet.getString(1);
            return billId;
        }
        return null;

    }



    @Override
    public BillEntity searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public  boolean save(BillEntity entity) throws SQLException {

        /*String sql = "INSERT INTO bills VALUES(?, ?, ?)";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection().prepareStatement(sql);

        pstm.setString(1, bill.getBillId());
        pstm.setString(2, bill.getClientId());
        pstm.setDate(3, bill.getDate());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO bills VALUES(?, ?, ?)",entity.getBillId(),entity.getClientId(),entity.getDate());

    }

    @Override
    public boolean update(BillEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<BillEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }


}
