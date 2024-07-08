package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PlaceBillDTO {

        private BillDTO bill;
        private List<BillDetailDTO> billList;

}
