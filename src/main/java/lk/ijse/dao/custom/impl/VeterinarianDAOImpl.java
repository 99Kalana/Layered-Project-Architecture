package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.VeterinarianDAO;
import lk.ijse.entity.VeterinarianEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAOImpl implements VeterinarianDAO {
    @Override
    public  VeterinarianEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM veterinarian WHERE veterinarian_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM veterinarian WHERE veterinarian_id = ?",id);

        if (resultSet.next()){
            String v_id = resultSet.getString(1);
            String v_name = resultSet.getString(2);
            int v_contactNo = resultSet.getInt(3);
            String v_email = resultSet.getString(4);

            VeterinarianEntity veterinarian = new VeterinarianEntity(v_id, v_name, v_contactNo, v_email);

            return veterinarian;

        }

        return null;

    }

    @Override
    public  boolean save(VeterinarianEntity entity) throws SQLException {

        /*String sql = "INSERT INTO veterinarian VALUES(?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, veterinarian.getId());
        pstm.setObject(2, veterinarian.getName());
        pstm.setObject(3, veterinarian.getContactNo());
        pstm.setObject(4, veterinarian.getEmail());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO veterinarian VALUES(?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getContactNo(),entity.getEmail());

    }

    @Override
    public  boolean update(VeterinarianEntity entity) throws SQLException {

        /*String sql = "UPDATE veterinarian SET veterinarian_name = ?, veterinarian_contact_no = ?, veterinarian_email = ? WHERE veterinarian_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, veterinarian.getName());
        pstm.setObject(2, veterinarian.getContactNo());
        pstm.setObject(3, veterinarian.getEmail());
        pstm.setObject(4, veterinarian.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE veterinarian SET veterinarian_name = ?, veterinarian_contact_no = ?, veterinarian_email = ? WHERE veterinarian_id = ? ",entity.getName(),entity.getContactNo(),entity.getEmail(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM veterinarian WHERE veterinarian_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM veterinarian WHERE veterinarian_id = ?",id);

    }

    @Override
    public  List<VeterinarianEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM veterinarian";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM veterinarian");

        List<VeterinarianEntity> veterinarianList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            int contactNo = resultSet.getInt(3);
            String email = resultSet.getString(4);

            VeterinarianEntity veterinarian = new VeterinarianEntity(id, name, contactNo, email);
            veterinarianList.add(veterinarian);
        }
        return veterinarianList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        /*String sql = "SELECT veterinarian_id FROM veterinarian";
        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT veterinarian_id FROM veterinarian");

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


}
