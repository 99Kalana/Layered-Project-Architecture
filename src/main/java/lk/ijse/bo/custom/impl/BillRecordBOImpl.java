package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BillRecordBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillRecordDAO;
import lk.ijse.dto.BillRecordDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.BillRecordEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillRecordBOImpl implements BillRecordBO {

    BillRecordDAO billRecordDAO = (BillRecordDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL_RECORD);

    @Override
    public BillRecordDTO searchById(String id) throws SQLException {

        BillRecordEntity billRecord = billRecordDAO.searchById(id);
        return new BillRecordDTO(billRecord.getBillId(), billRecord.getClientId(), billRecord.getDate());

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return billRecordDAO.delete(id);

    }
    @Override
    public  List<BillRecordDTO> getAll() throws SQLException {

        List<BillRecordDTO>billRecordDTOList=new ArrayList<>();
        List<BillRecordEntity>billRecordEntities=billRecordDAO.getAll();

        for(BillRecordEntity billRecord:billRecordEntities){
            billRecordDTOList.add(new BillRecordDTO(billRecord.getBillId(),billRecord.getClientId(),billRecord.getDate()));
        }

        return billRecordDTOList;

    }


}
