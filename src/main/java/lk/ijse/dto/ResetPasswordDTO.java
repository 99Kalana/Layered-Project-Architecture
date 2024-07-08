package lk.ijse.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class ResetPasswordDTO {

    private String userId;
    private String name;
    private String password;

}
