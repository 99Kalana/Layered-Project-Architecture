package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ClientBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ClientDAO;
import lk.ijse.dto.ClientDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.ClientEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientBOImpl implements ClientBO {

    ClientDAO clientDAO = (ClientDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CLIENT);

    @Override
    public ClientDTO searchById(String id) throws SQLException {

        ClientEntity client = clientDAO.searchById(id);
        return new ClientDTO(client.getId(), client.getPetId(), client.getName(), client.getAddress(), client.getEmail(), client.getContactNo());


    }

    @Override
    public  boolean save(ClientDTO dto) throws SQLException {

        return clientDAO.save(new ClientEntity(dto.getId(), dto.getPetId(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getContactNo()));

    }

    @Override
    public  boolean update(ClientDTO dto) throws SQLException {

        return clientDAO.update(new ClientEntity(dto.getId(), dto.getPetId(), dto.getName(), dto.getAddress(), dto.getEmail(), dto.getContactNo()));

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return clientDAO.delete(id);

    }

    @Override
    public  List<ClientDTO> getAll() throws SQLException {

        List<ClientDTO>clientDTOList=new ArrayList<>();
        List<ClientEntity>clientEntities=clientDAO.getAll();

        for (ClientEntity client:clientEntities){
            clientDTOList.add(new ClientDTO(client.getId(), client.getPetId(), client.getName(), client.getAddress(), client.getEmail(), client.getContactNo()));
        }

        return clientDTOList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        List<String> idList = new ArrayList<>();
        List<String> clientIds = clientDAO.getIds();

        for (String id : clientIds) {
            idList.add(id);
        }

        return idList;

    }




}
