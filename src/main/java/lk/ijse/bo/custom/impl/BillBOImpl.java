package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BillBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillDAO;
import lk.ijse.dto.BillDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.BillEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillBOImpl implements BillBO {

    BillDAO billDAO = (BillDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL);

    @Override
    public  String getCurrentBillId() throws SQLException {

        return  billDAO.getCurrentBillId();

    }



    @Override
    public  boolean save(BillDTO dto) throws SQLException {

        return billDAO.save(new BillEntity(dto.getBillId(),dto.getClientId(),dto.getDate()));

    }




}
