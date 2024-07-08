package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.PrescriptionDTO;
import lk.ijse.entity.PrescriptionEntity;

import java.sql.SQLException;
import java.util.List;

public interface PrescriptionBO extends SuperBO {

    public PrescriptionDTO searchById(String id) throws SQLException;

    public  boolean save(PrescriptionDTO dto) throws SQLException;

    public  boolean update(PrescriptionDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<PrescriptionDTO> getAll() throws SQLException;

}
