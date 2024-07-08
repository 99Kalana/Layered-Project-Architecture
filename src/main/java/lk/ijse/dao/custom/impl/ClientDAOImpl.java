package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClientDAO;
import lk.ijse.entity.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public  ClientEntity searchById(String id) throws SQLException {

        /*String sql = "SELECT * FROM client WHERE client_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM client WHERE client_id = ?",id);

        if (resultSet.next()){
            String c_id = resultSet.getString(1);
            String c_petId = resultSet.getString(2);
            String c_name = resultSet.getString(3);
            String c_address = resultSet.getString(4);
            String c_email = resultSet.getString(5);
            int c_contactNo = resultSet.getInt(6);

            ClientEntity client = new ClientEntity(c_id, c_petId, c_name, c_address, c_email, c_contactNo);

            return client;

        }

        return null;

    }

    @Override
    public  boolean save(ClientEntity entity) throws SQLException {

        /*String sql = "INSERT INTO client VALUES(?, ?, ?, ?, ?, ?)";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, client.getId());
        pstm.setObject(2, client.getPetId());
        pstm.setObject(3, client.getName());
        pstm.setObject(4, client.getAddress());
        pstm.setObject(5, client.getEmail());
        pstm.setObject(6, client.getContactNo());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO client VALUES(?, ?, ?, ?, ?, ?)",entity.getId(),entity.getPetId(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getContactNo());

    }

    @Override
    public  boolean update(ClientEntity entity) throws SQLException {

        /*String sql = "UPDATE client SET pet_id = ?, client_name = ?, client_address = ?, client_email = ?, client_contact_no = ? WHERE client_id = ? ";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, client.getPetId());
        pstm.setObject(2, client.getName());
        pstm.setObject(3, client.getAddress());
        pstm.setObject(4, client.getEmail());
        pstm.setObject(5, client.getContactNo());
        pstm.setObject(6, client.getId());


        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("UPDATE client SET pet_id = ?, client_name = ?, client_address = ?, client_email = ?, client_contact_no = ? WHERE client_id = ? ",entity.getPetId(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getContactNo(),entity.getId());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        /*String sql = "DELETE FROM client WHERE client_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("DELETE FROM client WHERE client_id = ?",id);

    }

    @Override
    public  List<ClientEntity> getAll() throws SQLException {
        /*String sql = "SELECT * FROM client";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT * FROM client");

        List<ClientEntity> clientList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String petId = resultSet.getString(2);
            String name = resultSet.getString(3);
            String address = resultSet.getString(4);
            String email = resultSet.getString(5);
            int contactNo = resultSet.getInt(6);


            ClientEntity client = new ClientEntity(id, petId, name, address, email, contactNo);
            clientList.add(client);
        }
        return clientList;
    }

    @Override
    public  List<String> getIds() throws SQLException {
        /*String sql = "SELECT client_id FROM client";
        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT client_id FROM client");

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
