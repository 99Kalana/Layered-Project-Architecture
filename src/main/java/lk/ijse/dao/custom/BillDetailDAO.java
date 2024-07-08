package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.BillDetailEntity;

import java.sql.SQLException;
import java.util.List;

public interface BillDetailDAO extends CrudDAO<BillDetailEntity> {

    public  boolean isSaves(List<BillDetailEntity> entity) throws SQLException;



}
