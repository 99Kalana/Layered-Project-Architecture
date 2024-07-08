package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.BillsDetailsDTO;
import lk.ijse.entity.BillsDetailsEntity;

import java.sql.SQLException;
import java.util.List;

public interface BillsDetailsBO extends SuperBO {

    public BillsDetailsDTO searchById(String id) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public  List<BillsDetailsDTO> getAll() throws SQLException;

}
