package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BillDetailBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillDetailDAO;
import lk.ijse.dto.BillDetailDTO;
import lk.ijse.entity.BillDetailEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDetailBOImpl implements BillDetailBO {

    BillDetailDAO billDetailDAO = (BillDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL_DETAIL);


    /*@Override
    public boolean isSaves(List<BillDetailDTO> dto) throws SQLException {


        for (BillDetailDTO bd : dto){
            boolean isSaved = saved(bd);
            if (!isSaved){
                return false;
            }
        }
        return true;


    }*/

    @Override
    public boolean isSaves(List<BillDetailDTO> dtoList) throws SQLException {
        List<BillDetailEntity> entityList = new ArrayList<>();
        for (BillDetailDTO dto : dtoList) {
            BillDetailEntity entity = new BillDetailEntity(dto.getBillId(), dto.getMedicineId(), dto.getMedicineQty(), dto.getMedicinePrice());
            entityList.add(entity);
        }
        return billDetailDAO.isSaves(entityList);
    }


    /*private boolean saved(BillDetailDTO bd) throws SQLException {

        return SQLUtil.execute("INSERT INTO bills_details VALUES(?, ?, ?, ?)",bd.getBillId(),bd.getMedicineId(),bd.getMedicineQty(),bd.getMedicinePrice());

    }*/




    
}
