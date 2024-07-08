package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.TreatmentsDAO;
import lk.ijse.entity.TreatmentsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreatmentsDAOImpl implements TreatmentsDAO {
    @Override
    public  TreatmentsEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM treatments WHERE t_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM treatments WHERE t_id = ?",id);

        if (resultSet.next()){
            String t_id = resultSet.getString(1);
            String t_type = resultSet.getString(2);
            String t_desc = resultSet.getString(3);

            TreatmentsEntity treatments = new TreatmentsEntity(t_id, t_type, t_desc);

            return treatments;

        }

        return null;

    }

   @Override
    public  boolean save(TreatmentsEntity entity) throws SQLException {

        /*String sql = "INSERT INTO treatments VALUES(?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, treatments.getId());
        pstm.setObject(2, treatments.getType());
        pstm.setObject(3, treatments.getDescription());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO treatments VALUES(?, ?, ?)",entity.getId(),entity.getType(),entity.getDescription());

    }

    @Override
    public  boolean update(TreatmentsEntity entity) throws SQLException {

        /*String sql = "UPDATE treatments SET t_type = ?, t_description = ? WHERE t_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, treatments.getType());
        pstm.setObject(2, treatments.getDescription());
        pstm.setObject(3, treatments.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE treatments SET t_type = ?, t_description = ? WHERE t_id = ? ",entity.getType(),entity.getDescription(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM treatments WHERE t_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM treatments WHERE t_id = ?",id);

    }

    @Override
    public  List<TreatmentsEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM treatments";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM treatments");

        List<TreatmentsEntity> treatmentsList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String type = resultSet.getString(2);
            String description = resultSet.getString(3);

            TreatmentsEntity treatments = new TreatmentsEntity(id, type, description);
            treatmentsList.add(treatments);
        }
        return treatmentsList;

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
