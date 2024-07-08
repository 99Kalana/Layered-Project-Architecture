package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PlaceBillBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BillDAO;
import lk.ijse.dao.custom.BillDetailDAO;
import lk.ijse.dao.custom.MedicineDAO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.dto.BillDTO;
import lk.ijse.dto.BillDetailDTO;
import lk.ijse.dto.PlaceBillDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.BillEntity;
/*import lk.ijse.repository.BillDetailRepo;
import lk.ijse.repository.BillRepo;
import lk.ijse.repository.MedicineRepo;*/

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceBillBOImpl implements PlaceBillBO {

    /*Transaction*/
    /*public  boolean placeBill (PlaceBill pb) throws SQLException {

        Connection connection = DbConnectionPET.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isBillSaved = BillRepo.save(pb.getBill());
            if(isBillSaved){
                boolean isQtyUpdated = MedicineRepo.updates(pb.getBillList());
                if (isQtyUpdated){
                    boolean isBillDetailSaved = BillDetailRepo.save(pb.getBillList());
                    if (isBillDetailSaved){
                        connection.commit();
                        return true;
                    }
                }
            }

            connection.rollback();
            return false;

        }catch (Exception e){
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }

    }*/

    BillDAO billDAO = (BillDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL);
    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MEDICINE);
    BillDetailDAO billDetailDAO = (BillDetailDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.BILL_DETAIL);

    @Override
    public boolean placeBill(PlaceBillDTO dto) throws SQLException {
        Connection connection = DbConnectionPET.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            //boolean isBillSaved = billDAO.save(dto.getBill());      //BillRepo.save(pb.getBill());

            BillEntity billEntity = convertToBillEntity(dto.getBill());

            boolean isBillSaved = billDAO.save(billEntity);

            if(isBillSaved){
                //boolean isQtyUpdated = medicineDAO.updates(dto.getBillList());//MedicineRepo.updates(pb.getBillList());

                List<BillDetailEntity> entityLists = new ArrayList<>();
                for (BillDetailDTO detailDTO : dto.getBillList()) {
                    BillDetailEntity entity = new BillDetailEntity(
                            detailDTO.getBillId(),
                            detailDTO.getMedicineId(),
                            detailDTO.getMedicineQty(),
                            detailDTO.getMedicinePrice()
                    );
                    entityLists.add(entity);
                }

                boolean isQtyUpdated = medicineDAO.updates(entityLists);

                if (isQtyUpdated){
                    //boolean isBillDetailSaved = billDetailDAO.isSaves(dto.getBillList());  //BillDetailRepo.save(pb.getBillList());

                    // Convert List<BillDetailDTO> to List<BillDetailEntity>
                    List<BillDetailEntity> entityList = new ArrayList<>();
                    for (BillDetailDTO detailDTO : dto.getBillList()) {
                        BillDetailEntity entity = new BillDetailEntity(
                                detailDTO.getBillId(),
                                detailDTO.getMedicineId(),
                                detailDTO.getMedicineQty(),
                                detailDTO.getMedicinePrice()
                        );
                        entityList.add(entity);
                    }

                    boolean isBillDetailSaved = billDetailDAO.isSaves(entityList);

                    if (isBillDetailSaved){
                        connection.commit();
                        return true;
                    }
                }
            }

            connection.rollback();
            return false;

        }catch (Exception e){
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }


    private BillEntity convertToBillEntity(BillDTO billDTO) {
        return new BillEntity(
                billDTO.getBillId(),
                billDTO.getClientId(),
                billDTO.getDate()
        );
    }


}
