package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.BillRecordDTO;
import lk.ijse.entity.BillRecordEntity;

import java.sql.SQLException;
import java.util.List;

public interface BillRecordBO extends SuperBO {

    public BillRecordDTO searchById(String id) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public  List<BillRecordDTO> getAll() throws SQLException;

}
