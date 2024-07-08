package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.PetDTO;
import lk.ijse.entity.PetEntity;

import java.sql.SQLException;
import java.util.List;

public interface PetBO extends SuperBO {

    public  boolean save(PetDTO dto) throws SQLException ;

    public  boolean update(PetDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;


    public  PetDTO searchById(String id) throws SQLException ;

    public List<PetDTO> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;

}
