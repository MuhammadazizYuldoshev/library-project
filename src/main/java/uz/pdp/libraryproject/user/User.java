package uz.pdp.libraryproject.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private Integer id;
    private String userName;
    private String fullName;
    private String phoneNumber;
    private String role=Role.USER.name();
    private String password;
}
