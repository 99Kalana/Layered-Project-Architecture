package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.PlaceBillDTO;

import java.sql.SQLException;

public interface PlaceBillBO extends SuperBO {

    public  boolean placeBill (PlaceBillDTO dto) throws SQLException;

}
