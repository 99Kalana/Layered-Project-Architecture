package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.MedicineSupplierDAO;
import lk.ijse.entity.MedicineSupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineSupplierDAOImpl implements MedicineSupplierDAO {
    @Override
    public  MedicineSupplierEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM medicine_supplier WHERE s_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM medicine_supplier WHERE s_id = ?",id);

        if (resultSet.next()){
            String ms_id = resultSet.getString(1);
            String ms_mId = resultSet.getString(2);
            String ms_date = resultSet.getString(3);

            MedicineSupplierEntity medicineSupplier = new MedicineSupplierEntity(ms_id, ms_mId, ms_date);

            return medicineSupplier;

        }

        return null;

    }

    @Override
    public  boolean save(MedicineSupplierEntity entity) throws SQLException {

        /*String sql = "INSERT INTO medicine_supplier VALUES(?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, medicineSupplier.getId());
        pstm.setObject(2,medicineSupplier.getmId());
        pstm.setObject(3,medicineSupplier.getDate());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO medicine_supplier VALUES(?, ?, ?)",entity.getId(),entity.getmId(),entity.getDate());

    }

    @Override
    public  boolean update(MedicineSupplierEntity entity) throws SQLException {

        /*String sql = "UPDATE medicine_supplier SET m_id = ?, supply_date = ?  WHERE s_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1,medicineSupplier.getmId());
        pstm.setObject(2,medicineSupplier.getDate());
        pstm.setObject(3, medicineSupplier.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE medicine_supplier SET m_id = ?, supply_date = ?  WHERE s_id = ? ",entity.getmId(),entity.getDate(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM medicine_supplier WHERE s_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM medicine_supplier WHERE s_id = ?",id);

    }

    @Override
    public  List<MedicineSupplierEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM medicine_supplier";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM medicine_supplier");

        List<MedicineSupplierEntity> medicineSupplierList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String mId = resultSet.getString(2);
            String date = String.valueOf(resultSet.getDate(3));

            MedicineSupplierEntity medicineSupplier = new MedicineSupplierEntity(id, mId, date);
            medicineSupplierList.add(medicineSupplier);
        }
        return medicineSupplierList;

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
