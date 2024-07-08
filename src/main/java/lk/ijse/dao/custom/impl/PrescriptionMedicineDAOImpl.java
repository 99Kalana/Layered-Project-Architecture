package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionMedicineDAO;
import lk.ijse.entity.PrescriptionMedicineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionMedicineDAOImpl implements PrescriptionMedicineDAO {

    @Override
    public  PrescriptionMedicineEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM prescription_medicine WHERE m_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription_medicine WHERE m_id = ?",id);

        if (resultSet.next()){
            String m_id = resultSet.getString(1);
            String p_id = resultSet.getString(2);

            PrescriptionMedicineEntity prescriptionMedicine = new PrescriptionMedicineEntity(m_id, p_id);

            return prescriptionMedicine;

        }

        return null;

    }

    @Override
    public  boolean save(PrescriptionMedicineEntity entity) throws SQLException {

        /*String sql = "INSERT INTO prescription_medicine VALUES(?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, prescriptionMedicine.getId());
        pstm.setObject(2, prescriptionMedicine.getpId());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO prescription_medicine VALUES(?, ?)",entity.getId(),entity.getpId());

    }

    @Override
    public  boolean update(PrescriptionMedicineEntity entity) throws SQLException {

        /*String sql = "UPDATE prescription_medicine SET p_id = ? WHERE m_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1,prescriptionMedicine.getpId());
        pstm.setObject(2,prescriptionMedicine.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE prescription_medicine SET p_id = ? WHERE m_id = ? ",entity.getpId(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM prescription_medicine WHERE m_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM prescription_medicine WHERE m_id = ?",id);

    }


    @Override
    public  List<PrescriptionMedicineEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM prescription_medicine";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription_medicine");

        List<PrescriptionMedicineEntity> prescriptionMedicineList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String pId = resultSet.getString(2);

            PrescriptionMedicineEntity prescriptionMedicine = new PrescriptionMedicineEntity(id, pId);
            prescriptionMedicineList.add(prescriptionMedicine);
        }
        return prescriptionMedicineList;

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
