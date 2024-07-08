package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.MedicineDAO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.MedicineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAOImpl implements MedicineDAO {

    @Override
    public  MedicineEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM medicine WHERE m_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM medicine WHERE m_id = ?",id);

        if (resultSet.next()){
            String m_id = resultSet.getString(1);
            String m_name = resultSet.getString(2);
            String m_type = resultSet.getString(3);
            double m_price = resultSet.getDouble(4);
            String m_desc = resultSet.getString(5);
            int m_qtyOnHand = resultSet.getInt(6);

            MedicineEntity medicine = new MedicineEntity(m_id, m_name, m_type, m_price, m_desc, m_qtyOnHand);

            return medicine;

        }

        return null;

    }

    @Override
    public  boolean save(MedicineEntity entity) throws SQLException {

        /*String sql = "INSERT INTO medicine VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, medicine.getId());
        pstm.setObject(2, medicine.getName());
        pstm.setObject(3, medicine.getType());
        pstm.setObject(4, medicine.getPrice());
        pstm.setObject(5, medicine.getDescription());
        pstm.setObject(6, medicine.getQtyOnHand());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO medicine VALUES(?, ?, ?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getType(),entity.getPrice(),entity.getDescription(),entity.getQtyOnHand());

    }

    @Override
    public  boolean update(MedicineEntity entity) throws SQLException {

        /*String sql = "UPDATE medicine SET m_name = ?, m_type = ?, m_price = ?, m_description = ?, m_qty_on_hand = ? WHERE m_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, medicine.getName());
        pstm.setObject(2, medicine.getType());
        pstm.setObject(3, medicine.getPrice());
        pstm.setObject(4, medicine.getDescription());
        pstm.setObject(5, medicine.getQtyOnHand());
        pstm.setObject(6, medicine.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE medicine SET m_name = ?, m_type = ?, m_price = ?, m_description = ?, m_qty_on_hand = ? WHERE m_id = ? ",entity.getName(),entity.getType(),entity.getPrice(),entity.getDescription(),entity.getQtyOnHand(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM medicine WHERE m_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM medicine WHERE m_id = ?",id);

    }

    @Override
    public  List<MedicineEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM medicine";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM medicine");

        List<MedicineEntity> medicineList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String type = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            int qtyOnHand = resultSet.getInt(6);



            MedicineEntity medicine = new MedicineEntity(id, name, type, price, description, qtyOnHand);
            medicineList.add(medicine);
        }
        return medicineList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        /*String sql = "SELECT m_id FROM medicine";
        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT m_id FROM medicine");

        List<String> idList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;

    }

    @Override
    public String getCurrentBillId() throws SQLException {
        return null;
    }





    @Override
    public  boolean updates(List<BillDetailEntity> entities) throws SQLException {

        for (BillDetailEntity bd : entities){

            boolean isUpdateQty = updateQty(bd.getMedicineId(), bd.getMedicineQty());

            if (!isUpdateQty){
                return false;
            }

        }
        return true;
    }


    private  boolean updateQty(String medicineId, int medicineQty) throws SQLException {

        /*String sql = "UPDATE medicine SET m_qty_on_hand = m_qty_on_hand - ? WHERE m_id = ?";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection().prepareStatement(sql);

        pstm.setInt(1,medicineQty);
        pstm.setString(2,medicineId);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute( "UPDATE medicine SET m_qty_on_hand = m_qty_on_hand - ? WHERE m_id = ?",medicineQty,medicineId);

    }


}
