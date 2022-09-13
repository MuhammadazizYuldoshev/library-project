package uz.pdp.libraryproject.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto {

    private Integer categoryIds;

    private String categoryName;

    private String categoryDescription;
}
