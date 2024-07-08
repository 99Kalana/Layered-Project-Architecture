package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.custom.PrescriptionMedicineDAO;
import lk.ijse.dto.PrescriptionMedicineDTO;
import lk.ijse.entity.PrescriptionMedicineEntity;

import java.sql.SQLException;
import java.util.List;

public interface PrescriptionMedicineBO extends SuperBO {

    public PrescriptionMedicineDTO searchById(String id) throws SQLException;

    public  boolean save(PrescriptionMedicineDTO dto) throws SQLException;

    public  boolean update(PrescriptionMedicineDTO dto) throws SQLException ;

    public  boolean delete(String id) throws SQLException;

    public List<PrescriptionMedicineDTO> getAll() throws SQLException;

}
