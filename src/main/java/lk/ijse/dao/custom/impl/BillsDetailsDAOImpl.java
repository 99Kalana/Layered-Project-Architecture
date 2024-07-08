package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillsDetailsDAO;
import lk.ijse.entity.BillsDetailsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillsDetailsDAOImpl implements BillsDetailsDAO {

    @Override
    public  BillsDetailsEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM bills_details WHERE bill_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bills_details WHERE bill_id = ?",id);

        if (resultSet.next()){

            String bill_id = resultSet.getString(1);
            String medicine_id = resultSet.getString(2);
            int medicine_qty = resultSet.getInt(3);
            double medicine_price = resultSet.getDouble(4);

            BillsDetailsEntity billsDetails = new BillsDetailsEntity(bill_id,medicine_id,medicine_qty,medicine_price);

            return billsDetails;

        }

        return null;

    }

    @Override
    public boolean save(BillsDetailsEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BillsDetailsEntity entity) throws SQLException {
        return false;
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM bills_details WHERE bill_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM bills_details WHERE bill_id = ?",id);

    }


    @Override
    public  List<BillsDetailsEntity> getAll() throws SQLException{

        /*String sql = "SELECT * FROM bills_details";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM bills_details");

        List<BillsDetailsEntity> billsDetailsList = new ArrayList<>();

        while (resultSet.next()) {
            String billId = resultSet.getString(1);
            String medicineId = resultSet.getString(2);
            int medicineQty = resultSet.getInt(3);
            double medicinePrice = resultSet.getDouble(4);

            BillsDetailsEntity billsDetails = new BillsDetailsEntity(billId, medicineId, medicineQty, medicinePrice);
            billsDetailsList.add(billsDetails);
        }
        return billsDetailsList;

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
