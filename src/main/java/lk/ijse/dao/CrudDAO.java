package lk.ijse.dao;

import lk.ijse.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{

    public T searchById(String id) throws SQLException;

    public  boolean save(T entity) throws SQLException;

    public  boolean update(T entity) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public List<T> getAll() throws SQLException;

    public  List<String> getIds() throws SQLException;

    public  String getCurrentBillId() throws SQLException;


    //public  boolean isSaves(List<BillDetailEntity> entity) throws SQLException;


   // public  boolean updates(List<BillDetailEntity> entity) throws SQLException;



}
