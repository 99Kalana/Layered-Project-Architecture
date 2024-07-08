package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.BillDetailDTO;
import lk.ijse.dto.MedicineDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.MedicineEntity;

import java.sql.SQLException;
import java.util.List;

public interface MedicineBO extends SuperBO {

    public MedicineDTO searchById(String id) throws SQLException ;

    public  boolean save(MedicineDTO dto) throws SQLException;

    public  boolean update(MedicineDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<MedicineDTO> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;

    public  boolean updates(List<BillDetailDTO> dto) throws SQLException;



}
