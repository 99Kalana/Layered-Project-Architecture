package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QrEntity {

    private String clientId;
    private String petId;
    private String clientName;
    private String clientEmail;
    private int clientContactNo;


}
