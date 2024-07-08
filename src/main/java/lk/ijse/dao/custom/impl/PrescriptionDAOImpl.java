package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionDAO;
import lk.ijse.entity.PrescriptionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAOImpl implements PrescriptionDAO {
    @Override
    public  PrescriptionEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM prescription WHERE p_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription WHERE p_id = ?",id);

        if (resultSet.next()){
            String p_id = resultSet.getString(1);
            String p_type = resultSet.getString(2);
            String p_veterinarianId = resultSet.getString(3);

            PrescriptionEntity prescription = new PrescriptionEntity(p_id, p_type, p_veterinarianId);

            return prescription;

        }

        return null;

    }

    @Override
    public  boolean save(PrescriptionEntity entity) throws SQLException {

        /*String sql = "INSERT INTO prescription VALUES(?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, prescription.getId());
        pstm.setObject(2, prescription.getType());
        pstm.setObject(3, prescription.getVeterinarianId());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO prescription VALUES(?, ?, ?)",entity.getId(),entity.getType(),entity.getVeterinarianId());

    }

    @Override
    public  boolean update(PrescriptionEntity entity) throws SQLException {

        /*String sql = "UPDATE prescription SET p_type = ?, veterinarian_id = ? WHERE p_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, prescription.getType());
        pstm.setObject(2, prescription.getVeterinarianId());
        pstm.setObject(3, prescription.getId());

        return pstm.executeUpdate() > 0;*/

        return  SQLUtil.execute("UPDATE prescription SET p_type = ?, veterinarian_id = ? WHERE p_id = ? ",entity.getType(),entity.getVeterinarianId(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM prescription WHERE p_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM prescription WHERE p_id = ?",id);

    }

    @Override
    public  List<PrescriptionEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM prescription";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription");

        List<PrescriptionEntity> prescriptionList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String type = resultSet.getString(2);
            String veterinarianId = resultSet.getString(3);

            PrescriptionEntity prescription = new PrescriptionEntity(id, type, veterinarianId);
            prescriptionList.add(prescription);
        }
        return prescriptionList;

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
