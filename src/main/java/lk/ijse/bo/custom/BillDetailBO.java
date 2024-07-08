package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.BillDetailDTO;
import lk.ijse.entity.BillDetailEntity;

import java.sql.SQLException;
import java.util.List;

public interface BillDetailBO extends SuperBO {

    public boolean isSaves(List<BillDetailDTO> dtoList) throws SQLException;

}
