package uz.pdp.libraryproject.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorDto {
    private Integer authorId;
    private String authorFullName;

}
