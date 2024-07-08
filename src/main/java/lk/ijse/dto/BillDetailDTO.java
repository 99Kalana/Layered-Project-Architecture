package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BillDetailDTO {

    private String billId;
    private String medicineId;
    private int medicineQty;
    private double medicinePrice;

}
