package lk.ijse.bo.custom;

import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.SuperBO;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginBO extends SuperBO {


    public void checkCredential(String userId, String password, AnchorPane rootNode) throws SQLException, IOException;

}
