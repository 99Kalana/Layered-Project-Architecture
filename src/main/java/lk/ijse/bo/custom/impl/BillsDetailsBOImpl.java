package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BillsDetailsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillsDetailsDAO;
import lk.ijse.dto.BillsDetailsDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.BillsDetailsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillsDetailsBOImpl implements BillsDetailsBO {


    BillsDetailsDAO billsDetailsDAO = (BillsDetailsDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL_DETAILS);

    @Override
    public BillsDetailsDTO searchById(String id) throws SQLException {

        BillsDetailsEntity billsDetails = billsDetailsDAO.searchById(id);
        return new BillsDetailsDTO(billsDetails.getBillId(), billsDetails.getMedicineId(), billsDetails.getMedicineQty(), billsDetails.getMedicinePrice());

    }



    @Override
    public  boolean delete(String id) throws SQLException {

        return billsDetailsDAO.delete(id);

    }


    @Override
    public  List<BillsDetailsDTO> getAll() throws SQLException{

        List<BillsDetailsDTO>billsDetailsDTOList=new ArrayList<>();
        List<BillsDetailsEntity>billsDetailsEntities=billsDetailsDAO.getAll();

        for (BillsDetailsEntity billsDetails:billsDetailsEntities){
            billsDetailsDTOList.add(new BillsDetailsDTO(billsDetails.getBillId(), billsDetails.getMedicineId(), billsDetails.getMedicineQty(), billsDetails.getMedicinePrice()));
        }

        return billsDetailsDTOList;

    }


}
