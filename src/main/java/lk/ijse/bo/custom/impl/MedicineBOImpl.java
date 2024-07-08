package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.MedicineBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.MedicineDAO;
import lk.ijse.dto.BillDetailDTO;
import lk.ijse.dto.MedicineDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.MedicineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineBOImpl implements MedicineBO {

    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MEDICINE);

    @Override
    public MedicineDTO searchById(String id) throws SQLException {

        MedicineEntity medicine = medicineDAO.searchById(id);
        return new MedicineDTO(medicine.getId(), medicine.getName(), medicine.getType(), medicine.getPrice(), medicine.getDescription(), medicine.getQtyOnHand());

    }

    @Override
    public  boolean save(MedicineDTO dto) throws SQLException {

        return medicineDAO.save(new MedicineEntity(dto.getId(), dto.getName(), dto.getType(), dto.getPrice(), dto.getDescription(), dto.getQtyOnHand()));

    }

    @Override
    public  boolean update(MedicineDTO dto) throws SQLException {

        return medicineDAO.update(new MedicineEntity(dto.getId(), dto.getName(), dto.getType(), dto.getPrice(), dto.getDescription(), dto.getQtyOnHand()));

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return medicineDAO.delete(id);

    }

    @Override
    public  List<MedicineDTO> getAll() throws SQLException {

        List<MedicineDTO>medicineDTOList=new ArrayList<>();
        List<MedicineEntity>medicineEntities=medicineDAO.getAll();

        for (MedicineEntity medicine:medicineEntities){
            medicineDTOList.add(new MedicineDTO(medicine.getId(), medicine.getName(), medicine.getType(), medicine.getPrice(), medicine.getDescription(), medicine.getQtyOnHand()));
        }

        return medicineDTOList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        List<String> idList = new ArrayList<>();
        List<String> medicineIds = medicineDAO.getIds();

        for (String id : medicineIds) {
            idList.add(id);
        }

        return idList;

    }





    /*@Override
    public  boolean updates(List<BillDetailDTO> dto) throws SQLException {

        for (BillDetailDTO bd : dto){

            boolean isUpdateQty = updateQty(bd.getMedicineId(), bd.getMedicineQty());

            if (!isUpdateQty){
                return false;
            }

        }
        return true;
    }*/

    @Override
    public boolean updates(List<BillDetailDTO> dto) throws SQLException {

        List<BillDetailEntity> entityList = new ArrayList<>();
        for (BillDetailDTO detailDTO : dto) {
            BillDetailEntity entity = new BillDetailEntity(
                    detailDTO.getBillId(),
                    detailDTO.getMedicineId(),
                    detailDTO.getMedicineQty(),
                    detailDTO.getMedicinePrice()
            );
            entityList.add(entity);
        }

        return medicineDAO.updates(entityList);
    }


    /*private  boolean updateQty(String medicineId, int medicineQty) throws SQLException {

        return SQLUtil.execute( "UPDATE medicine SET m_qty_on_hand = m_qty_on_hand - ? WHERE m_id = ?",medicineQty,medicineId);

    }*/


}
