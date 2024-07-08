package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.MedicineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MedicineDAO extends CrudDAO<MedicineEntity> {

    /*public MedicineEntity searchById(String id) throws SQLException ;

    public  boolean save(MedicineEntity medicine) throws SQLException;

    public  boolean update(MedicineEntity medicine) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<MedicineEntity> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;*/

    public  boolean updates(List<BillDetailEntity> entity) throws SQLException;





}
