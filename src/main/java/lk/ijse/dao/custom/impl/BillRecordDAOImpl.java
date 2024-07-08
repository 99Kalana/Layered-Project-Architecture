package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillRecordDAO;
import lk.ijse.entity.BillRecordEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillRecordDAOImpl implements BillRecordDAO {
    @Override
    public  BillRecordEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM bills WHERE bill_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bills WHERE bill_id = ?",id);

        if (resultSet.next()){
            String bill_id = resultSet.getString(1);
            String client_id = resultSet.getString(2);
            String date = resultSet.getString(3);

            BillRecordEntity billRecord = new BillRecordEntity(bill_id, client_id, date);

            return billRecord;

        }

        return null;

    }

    @Override
    public boolean save(BillRecordEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BillRecordEntity entity) throws SQLException {
        return false;
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM bills WHERE bill_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM bills WHERE bill_id = ?",id);

    }
    @Override
    public  List<BillRecordEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM bills";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bills");

        List<BillRecordEntity> billRecordList = new ArrayList<>();

        while (resultSet.next()) {
            String billId = resultSet.getString(1);
            String clientId = resultSet.getString(2);
            String date = resultSet.getString(3);

            BillRecordEntity billRecord = new BillRecordEntity(billId, clientId, date);
            billRecordList.add(billRecord);
        }
        return billRecordList;

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
