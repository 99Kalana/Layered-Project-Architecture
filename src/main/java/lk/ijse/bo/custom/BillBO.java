package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.BillDTO;
import lk.ijse.entity.BillEntity;

import java.sql.SQLException;

public interface BillBO extends SuperBO {

    public  String getCurrentBillId() throws SQLException;

    public  boolean save(BillDTO dto) throws SQLException;

}
