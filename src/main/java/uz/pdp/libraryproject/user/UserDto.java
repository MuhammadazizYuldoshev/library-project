package uz.pdp.libraryproject.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private int id;
    private String fullName;
    private String phoneNumber;
}
