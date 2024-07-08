package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BillDetailEntity {

    private String billId;
    private String medicineId;
    private int medicineQty;
    private double medicinePrice;

}
