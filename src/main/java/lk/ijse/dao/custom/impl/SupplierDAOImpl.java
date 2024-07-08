package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public  SupplierEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM supplier WHERE s_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM supplier WHERE s_id = ?",id);

        if (resultSet.next()){
            String s_id = resultSet.getString(1);
            String s_name = resultSet.getString(2);
            int s_contactNo = resultSet.getInt(3);
            String s_location = resultSet.getString(4);
            String s_email = resultSet.getString(5);
            String s_productType = resultSet.getString(6);
            int s_qtyOnHand = resultSet.getInt(7);

            SupplierEntity supplier = new SupplierEntity(s_id, s_name, s_contactNo, s_location, s_email, s_productType, s_qtyOnHand);

            return supplier;

        }

        return null;

    }

    @Override
    public  boolean save(SupplierEntity entity) throws SQLException {

        /*String sql = "INSERT INTO supplier VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, supplier.getId());
        pstm.setObject(2, supplier.getName());
        pstm.setObject(3, supplier.getContactNo());
        pstm.setObject(4, supplier.getLocation());
        pstm.setObject(5, supplier.getEmail());
        pstm.setObject(6, supplier.getProductType());
        pstm.setObject(7, supplier.getQtyOnHand());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO supplier VALUES(?, ?, ?, ?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getContactNo(),entity.getLocation(),entity.getEmail(),entity.getProductType(),entity.getQtyOnHand());

    }

    @Override
    public  boolean update(SupplierEntity entity) throws SQLException {

        /*String sql = "UPDATE supplier SET s_name = ?, s_contact_no = ?, s_location = ?, s_email = ?, product_type = ?, qty_on_hand = ?  WHERE s_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, supplier.getName());
        pstm.setObject(2, supplier.getContactNo());
        pstm.setObject(3, supplier.getLocation());
        pstm.setObject(4, supplier.getEmail());
        pstm.setObject(5, supplier.getProductType());
        pstm.setObject(6, supplier.getQtyOnHand());
        pstm.setObject(7, supplier.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE supplier SET s_name = ?, s_contact_no = ?, s_location = ?, s_email = ?, product_type = ?, qty_on_hand = ?  WHERE s_id = ? ",entity.getName(),entity.getContactNo(),entity.getLocation(),entity.getEmail(),entity.getProductType(),entity.getQtyOnHand(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM supplier WHERE s_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM supplier WHERE s_id = ?",id);

    }

    @Override
    public  List<SupplierEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM supplier";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM supplier");

        List<SupplierEntity> supplierList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            int contactNo = resultSet.getInt(3);
            String location = resultSet.getString(4);
            String email = resultSet.getString(5);
            String productType = resultSet.getString(6);
            int qtyOnHand = resultSet.getInt(7);


            SupplierEntity supplier = new SupplierEntity(id, name, contactNo, location, email, productType, qtyOnHand);
            supplierList.add(supplier);
        }
        return supplierList;

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
