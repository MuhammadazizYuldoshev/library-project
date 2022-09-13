package uz.pdp.libraryproject.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.libraryproject.author.Author;
import uz.pdp.libraryproject.category.Category;
import uz.pdp.libraryproject.language.Language;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Entity
public class Book {
    private Integer id;
    private String title;
    private String description;
//    @ManyToMany
    private List<Author> authors;
    private String isbn;
//    @ManyToMany
    private List<Category> category;
    private Language language;
}
