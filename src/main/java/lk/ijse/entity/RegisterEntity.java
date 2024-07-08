package lk.ijse.entity;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class RegisterEntity {

    private String userId;
    private String name;
    private String password;

}
