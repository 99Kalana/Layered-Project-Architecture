package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QrDTO {

    private String clientId;
    private String petId;
    private String clientName;
    private String clientEmail;
    private int clientContactNo;


}
