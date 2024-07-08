package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionTreatmentDAO;
import lk.ijse.entity.PrescriptionTreatmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionTreatmentDAOImpl implements PrescriptionTreatmentDAO {

    @Override
    public  PrescriptionTreatmentEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM prescription_treatment WHERE p_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription_treatment WHERE p_id = ?",id);

        if (resultSet.next()){
            String pt_pId = resultSet.getString(1);
            String pt_tId = resultSet.getString(2);
            double pt_price = resultSet.getInt(3);
            String pt_date = resultSet.getString(4);
            String pt_time = resultSet.getString(5);

            PrescriptionTreatmentEntity prescriptionTreatment = new PrescriptionTreatmentEntity(pt_pId, pt_tId, pt_price, pt_date, pt_time);

            return prescriptionTreatment;

        }

        return null;

    }

    @Override
    public  boolean save(PrescriptionTreatmentEntity entity) throws SQLException {

        /*String sql = "INSERT INTO prescription_treatment VALUES(?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, prescriptionTreatment.getpId());
        pstm.setObject(2, prescriptionTreatment.gettId());
        pstm.setObject(3, prescriptionTreatment.getPrice());
        pstm.setObject(4, prescriptionTreatment.getDate());
        pstm.setObject(5, prescriptionTreatment.getTime());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO prescription_treatment VALUES(?, ?, ?, ?, ?)",entity.getpId(),entity.gettId(),entity.getPrice(),entity.getDate(),entity.getTime());

    }

    @Override
    public  boolean update(PrescriptionTreatmentEntity entity) throws SQLException {

        /*String sql = "UPDATE prescription_treatment SET t_id = ?, treatment_price = ?, pt_date = ?, pt_time = ? WHERE p_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, prescriptionTreatment.gettId());
        pstm.setObject(2, prescriptionTreatment.getPrice());
        pstm.setObject(3, prescriptionTreatment.getDate());
        pstm.setObject(4, prescriptionTreatment.getTime());
        pstm.setObject(5, prescriptionTreatment.getpId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE prescription_treatment SET t_id = ?, treatment_price = ?, pt_date = ?, pt_time = ? WHERE p_id = ? ",entity.gettId(),entity.getPrice(),entity.getDate(),entity.getTime(),entity.getpId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM prescription_treatment WHERE p_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM prescription_treatment WHERE p_id = ?",id);

    }

    @Override
    public  List<PrescriptionTreatmentEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM prescription_treatment";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM prescription_treatment");

        List<PrescriptionTreatmentEntity> prescriptionTreatmentList = new ArrayList<>();

        while (resultSet.next()) {
            String pId = resultSet.getString(1);
            String tId = resultSet.getString(2);
            double price = resultSet.getDouble(3);
            String date = String.valueOf(resultSet.getDate(4));
            String time = String.valueOf(resultSet.getTime(5));


            PrescriptionTreatmentEntity prescriptionTreatment = new PrescriptionTreatmentEntity(pId, tId, price, date, time);
            prescriptionTreatmentList.add(prescriptionTreatment);
        }
        return prescriptionTreatmentList;

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
