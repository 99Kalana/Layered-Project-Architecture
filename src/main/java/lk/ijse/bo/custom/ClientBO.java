package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.ClientDTO;
import lk.ijse.entity.ClientEntity;

import java.sql.SQLException;
import java.util.List;

public interface ClientBO extends SuperBO {

    public ClientDTO searchById(String id) throws SQLException ;

    public  boolean save(ClientDTO dto) throws SQLException ;

    public  boolean update(ClientDTO dto) throws SQLException ;

    public  boolean delete(String id) throws SQLException ;

    public List<ClientDTO> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;

}
