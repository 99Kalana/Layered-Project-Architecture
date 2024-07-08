package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.BillDetailDAO;
import lk.ijse.entity.BillDetailEntity;

import java.sql.SQLException;
import java.util.List;

public class BillDetailDAOImpl implements BillDetailDAO {

    @Override
    public BillDetailEntity searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(BillDetailEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BillDetailEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<BillDetailEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public String getCurrentBillId() throws SQLException {
        return null;
    }

    @Override
    public  boolean isSaves(List<BillDetailEntity> entity) throws SQLException {

        for (BillDetailEntity bd : entity){
            boolean isSaved = saved(bd);
            if (!isSaved){
                return false;
            }
        }
        return true;
    }


    private static boolean saved(BillDetailEntity bd) throws SQLException {

        /*String sql = "INSERT INTO bills_details VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = DbConnectionPET.getInstance().getConnection().prepareStatement(sql);

        pstm.setString(1, bd.getBillId());
        pstm.setString(2, bd.getMedicineId());
        pstm.setInt(3,bd.getMedicineQty());
        pstm.setDouble(4,bd.getMedicinePrice());

        return pstm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO bills_details VALUES(?, ?, ?, ?)",bd.getBillId(),bd.getMedicineId(),bd.getMedicineQty(),bd.getMedicinePrice());

    }




}
