package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.VeterinarianDTO;
import lk.ijse.entity.VeterinarianEntity;

import java.sql.SQLException;
import java.util.List;

public interface VeterinarianBO extends SuperBO {

    public VeterinarianDTO searchById(String id) throws SQLException;

    public  boolean save(VeterinarianDTO dto) throws SQLException;

    public  boolean update(VeterinarianDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<VeterinarianDTO> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;

}
