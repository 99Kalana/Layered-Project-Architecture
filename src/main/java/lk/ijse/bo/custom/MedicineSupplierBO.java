package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.MedicineSupplierDTO;
import lk.ijse.entity.MedicineSupplierEntity;

import java.sql.SQLException;
import java.util.List;

public interface MedicineSupplierBO extends SuperBO {

    public MedicineSupplierDTO searchById(String id) throws SQLException;

    public  boolean save(MedicineSupplierDTO dto) throws SQLException;

    public  boolean update(MedicineSupplierDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<MedicineSupplierDTO> getAll() throws SQLException;

}
