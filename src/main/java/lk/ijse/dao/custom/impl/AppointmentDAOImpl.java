package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.AppointmentDAO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.entity.AppointmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public AppointmentEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM appointment WHERE ap_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM appointment WHERE ap_id = ?",id);

        if (resultSet.next()){
            String a_id = resultSet.getString(1);
            String a_clientId = resultSet.getString(2);
            int a_no = resultSet.getInt(3);
            String a_date = String.valueOf(resultSet.getDate(4));
            String a_time = String.valueOf(resultSet.getTime(5));


            AppointmentEntity appointment = new AppointmentEntity(a_id, a_clientId, a_no, a_date, a_time);

            return appointment;

        }

        return null;

    }

    @Override
    public boolean save(AppointmentEntity entity) throws SQLException {

        /*String sql = "INSERT INTO appointment VALUES(?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, appointment.getId());
        pstm.setObject(2, appointment.getClientId());
        pstm.setObject(3, appointment.getNo());
        pstm.setObject(4, appointment.getDate());
        pstm.setObject(5, appointment.getTime());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO appointment VALUES(?, ?, ?, ?, ?)",entity.getId(),entity.getClientId(),entity.getNo(),entity.getDate(),entity.getTime());

    }
    @Override
    public boolean update(AppointmentEntity entity) throws SQLException {

        /*String sql = "UPDATE appointment SET client_id = ?, ap_no = ?, ap_date = ?, ap_time = ? WHERE ap_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, appointment.getClientId());
        pstm.setObject(2, appointment.getNo());
        pstm.setObject(3, appointment.getDate());
        pstm.setObject(4, appointment.getTime());
        pstm.setObject(5, appointment.getId());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE appointment SET client_id = ?, ap_no = ?, ap_date = ?, ap_time = ? WHERE ap_id = ? ",entity.getClientId(),entity.getNo(),entity.getDate(),entity.getTime(),entity.getId());

    }
    @Override
    public boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM appointment WHERE ap_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM appointment WHERE ap_id = ?",id);

    }
    @Override
    public List<AppointmentEntity> getAll() throws SQLException {
        /*String sql = "SELECT * FROM appointment";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet =   SQLUtil.execute("SELECT * FROM appointment");

        List<AppointmentEntity> appointmentList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String clientId = resultSet.getString(2);
            int no = resultSet.getInt(3);
            String date = String.valueOf(resultSet.getDate(4));
            String time = String.valueOf(resultSet.getTime(5));

            AppointmentEntity appointment = new AppointmentEntity(id, clientId, no, date, time);
            appointmentList.add(appointment);
        }
        return appointmentList;
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
