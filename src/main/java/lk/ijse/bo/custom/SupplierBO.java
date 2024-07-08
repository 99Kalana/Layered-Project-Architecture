package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {

    public SupplierDTO searchById(String id) throws SQLException;

    public  boolean save(SupplierDTO dto) throws SQLException;

    public  boolean update(SupplierDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<SupplierDTO> getAll() throws SQLException;

}
