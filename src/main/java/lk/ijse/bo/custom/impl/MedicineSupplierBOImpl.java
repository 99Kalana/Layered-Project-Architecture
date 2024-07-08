package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.MedicineSupplierBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.MedicineSupplierDAO;
import lk.ijse.dto.MedicineSupplierDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.MedicineSupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineSupplierBOImpl implements MedicineSupplierBO {

    MedicineSupplierDAO medicineSupplierDAO = (MedicineSupplierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MEDICINE_SUPPLIER);

    @Override
    public MedicineSupplierDTO searchById(String id) throws SQLException {

        MedicineSupplierEntity medicineSupplier = medicineSupplierDAO.searchById(id);
        return new MedicineSupplierDTO(medicineSupplier.getId(), medicineSupplier.getmId(), medicineSupplier.getDate());

    }

    @Override
    public  boolean save(MedicineSupplierDTO dto) throws SQLException {
        return medicineSupplierDAO.save(new MedicineSupplierEntity(dto.getId(), dto.getmId(), dto.getDate()));
    }

    @Override
    public  boolean update(MedicineSupplierDTO dto) throws SQLException {

        return medicineSupplierDAO.update(new MedicineSupplierEntity(dto.getId(), dto.getmId(), dto.getDate()));

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return medicineSupplierDAO.delete(id);
    }

    @Override
    public  List<MedicineSupplierDTO> getAll() throws SQLException {

        List<MedicineSupplierDTO>medicineSupplierDTOList=new ArrayList<>();
        List<MedicineSupplierEntity>medicineSupplierEntities=medicineSupplierDAO.getAll();

        for (MedicineSupplierEntity medicineSupplier:medicineSupplierEntities){
            medicineSupplierDTOList.add(new MedicineSupplierDTO(medicineSupplier.getId(), medicineSupplier.getmId(), medicineSupplier.getDate()));
        }

        return medicineSupplierDTOList;

    }


}
