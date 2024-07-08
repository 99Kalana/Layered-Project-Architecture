package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PetDAO;
import lk.ijse.entity.PetEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO {

    @Override
    public  boolean save(PetEntity entity) throws SQLException {

        /*String sql = "INSERT INTO pet VALUES(?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, pet.getId());
        pstm.setObject(2, pet.getName());
        pstm.setObject(3, pet.getBreed());
        pstm.setObject(4, pet.getWeight());
        pstm.setObject(5, pet.getColour());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO pet VALUES(?, ?, ?, ?, ?)",entity.getId(),entity.getName(),entity.getBreed(),entity.getWeight(),entity.getColour());

    }

    @Override
    public  boolean update(PetEntity entity) throws SQLException {

        /*String sql = "UPDATE pet SET pet_name = ?, pet_breed = ?, pet_weight = ?, pet_colour = ? WHERE pet_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, pet.getName());
        pstm.setObject(2, pet.getBreed());
        pstm.setObject(3, pet.getWeight());
        pstm.setObject(4, pet.getColour());
        pstm.setObject(5, pet.getId());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE pet SET pet_name = ?, pet_breed = ?, pet_weight = ?, pet_colour = ? WHERE pet_id = ?",entity.getName(),entity.getBreed(),entity.getWeight(),entity.getColour(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM pet WHERE pet_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM pet WHERE pet_id = ?",id);
    }


    @Override
    public  PetEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM pet WHERE pet_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM pet WHERE pet_id = ?",id);

        if (resultSet.next()){
            String p_id = resultSet.getString(1);
            String p_name = resultSet.getString(2);
            String p_breed = resultSet.getString(3);
            double p_weight = resultSet.getDouble(4);
            String p_colour = resultSet.getString(5);

            PetEntity pet = new PetEntity(p_id, p_name, p_breed, p_weight, p_colour);

            return pet;

        }

        return null;

    }

    @Override
    public  List<PetEntity> getAll() throws SQLException {

        /*String sql = "SELECT * FROM pet";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM pet");

        List<PetEntity> petList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String breed = resultSet.getString(3);
            double weight = resultSet.getDouble(4);
            String colour = resultSet.getString(5);


            PetEntity pet = new PetEntity(id, name, breed, weight, colour);
            petList.add(pet);
        }
        return petList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        /*String sql = "SELECT pet_id FROM pet";
        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT pet_id FROM pet");

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
