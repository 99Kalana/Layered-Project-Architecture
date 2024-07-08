package lk.ijse.dao.custom;

import javafx.scene.layout.AnchorPane;
import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.LoginEntity;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDAO extends CrudDAO<LoginEntity> {

    public void checkCredential(String userId, String password, AnchorPane rootNode) throws SQLException, IOException;

}
