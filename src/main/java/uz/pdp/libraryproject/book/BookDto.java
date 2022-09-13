package uz.pdp.libraryproject.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.libraryproject.author.AuthorDto;
import uz.pdp.libraryproject.category.CategoryDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {
    private Integer id;
    private String title;
    private String isbn;
    private Integer total_count;
    private String description;
    private List<AuthorDto> authorDtoList;
    private List<CategoryDto> categoryList;
    private List<Integer> authorsIds;
    private List<Integer> categoryIds;
    private Integer language_id;
    private String languageName;
}
