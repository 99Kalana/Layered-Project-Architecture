package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.PrescriptionTreatmentDTO;
import lk.ijse.entity.PrescriptionTreatmentEntity;

import java.sql.SQLException;
import java.util.List;

public interface PrescriptionTreatmentBO extends SuperBO {

    public PrescriptionTreatmentDTO searchById(String id) throws SQLException;

    public  boolean save(PrescriptionTreatmentDTO dto) throws SQLException;

    public  boolean update(PrescriptionTreatmentDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<PrescriptionTreatmentDTO> getAll() throws SQLException;

}
