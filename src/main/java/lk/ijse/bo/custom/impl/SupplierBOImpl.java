package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SupplierBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public SupplierDTO searchById(String id) throws SQLException {

        SupplierEntity supplier = supplierDAO.searchById(id);
        return new SupplierDTO(supplier.getId(),supplier.getName(),supplier.getContactNo(),supplier.getLocation(),supplier.getEmail(),supplier.getProductType(),supplier.getQtyOnHand());

    }

    @Override
    public  boolean save(SupplierDTO dto) throws SQLException {

        return supplierDAO.save(new SupplierEntity(dto.getId(), dto.getName(), dto.getContactNo(), dto.getLocation(), dto.getEmail(), dto.getProductType(), dto.getQtyOnHand()));
    }

    @Override
    public  boolean update(SupplierDTO dto) throws SQLException {

        return supplierDAO.update(new SupplierEntity(dto.getId(), dto.getName(), dto.getContactNo(), dto.getLocation(), dto.getEmail(), dto.getProductType(), dto.getQtyOnHand()));
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return supplierDAO.delete(id);

    }

    @Override
    public  List<SupplierDTO> getAll() throws SQLException {

        List<SupplierDTO>supplierDTOList=new ArrayList<>();
        List<SupplierEntity>supplierEntities=supplierDAO.getAll();

        for (SupplierEntity supplier: supplierEntities){
            supplierDTOList.add(new SupplierDTO(supplier.getId(),supplier.getName(),supplier.getContactNo(),supplier.getLocation(),supplier.getEmail(),supplier.getProductType(),supplier.getQtyOnHand()));
        }

        return supplierDTOList;

    }


}
