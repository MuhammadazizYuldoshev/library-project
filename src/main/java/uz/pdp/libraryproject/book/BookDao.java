package uz.pdp.libraryproject.book;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryproject.author.AuthorDto;
import uz.pdp.libraryproject.category.Category;
import uz.pdp.libraryproject.category.CategoryDto;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDao {
    private final JdbcTemplate jdbcTemplate;


    public List<BookDto> getAllBooksFromDb() {

        String sql = "select b.id, b.title ,json_agg(json_build_object('authorId',a.id,'authorFullName', a.full_name)) as authors , l.lang, total_count,isbn from books b join books_authors ba on b.id = ba.book_id\n" +
                "                join authors a on a.id = ba.author_id join languages l on b.language_id = l.id group by b.id, l.id";
        return jdbcTemplate.query(sql, (rs, row) -> {
                    String categorySql = "select c.id, c.name from books_categories bc join categories c on c.id = bc.category_id join books b on b.id = bc.book_id where b.id=" + rs.getInt(1) + ";";
                    List<CategoryDto> categoryDtoList = jdbcTemplate.query(categorySql, (rs1, rowNum) -> {
                        return CategoryDto.builder()
                                .categoryIds(rs1.getInt(1))
                                .categoryName(rs1.getString(2))
                                .build();
                    });
                    Array array = rs.getArray(3);
                    Type type = new TypeToken<List<AuthorDto>>() {
                    }.getType();
                    List<AuthorDto> authorDtoList = new Gson().fromJson(array.toString(), type);
                    return BookDto.builder()
                            .id(rs.getInt(1))
                            .title(rs.getString(2))
                            .authorDtoList(authorDtoList)
                            .categoryList(categoryDtoList)
                            .total_count(rs.getInt(5))
                            .languageName(rs.getString(4))
                            .isbn(rs.getString(6))
                            .build();

                }
        );


    }

    public void addBook(BookDto bookDto) {
        System.out.println(bookDto);
        String sql = "insert into books (title,isbn,total_count,description,language_id) values (?,?,?,?,?);";
        jdbcTemplate.update(sql, bookDto.getTitle(), bookDto.getIsbn(), bookDto.getTotal_count(), bookDto.getDescription(), bookDto.getLanguage_id());
        String bookIdSql = "select id from books where isbn = '" + bookDto.getIsbn() + "';";
        Integer bookId = jdbcTemplate.query(bookIdSql, rs -> {
            rs.next();
            return rs.getInt(1);
        });
        for (Integer authorsId : bookDto.getAuthorsIds()) {
            String Insetsql = "insert into books_authors (book_id,author_id) values (" + bookId + "," + authorsId + ") ;";
            jdbcTemplate.update(Insetsql);
        }
        for (Integer categoryId : bookDto.getCategoryIds()) {
            String sqlInsert = "insert into books_categories (book_id,category_id) values (" + bookId + "," + categoryId + ")";
            jdbcTemplate.update(sqlInsert);
        }
    }


    public Book getBook(int id) {
        String sql = "select * from books where id=" + id;
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Book.class));
    }


    public void delete(int id) {

        String sql1 = "delete from books_authors where book_id=?";
        jdbcTemplate.update(sql1, id);
        String sql2 = "delete from books_categories where book_id=?";
        jdbcTemplate.update(sql2, id);
        String sql3 = "delete from books where id=?";
        jdbcTemplate.update(sql3, id);
    }

    public BookDto getBookById(int id) {
        String sql1 = "select b.id, b.title ,json_agg(json_build_object('authorId',a.id,'authorFullName', a.full_name)) as authors , l.id, total_count,isbn,description from books b join books_authors ba on b.id = ba.book_id\n" +
                "                join authors a on a.id = ba.author_id join languages l on b.language_id = l.id where b.id=? group by b.id, l.id";
        BookDto bookDto = jdbcTemplate.query(sql1, rs -> {
            rs.next();
            Array array = rs.getArray(3);
            Type type = new TypeToken<List<AuthorDto>>() {
            }.getType();
            List<AuthorDto> authorDtoList = new Gson().fromJson(array.toString(), type);


            return BookDto.builder()
                    .id(rs.getInt(1))
                    .title(rs.getString(2))
                    .isbn(rs.getString(6))
                    .description(rs.getString(7))
                    .total_count(rs.getInt(5))
                    .language_id(rs.getInt(4))
                    .authorDtoList(authorDtoList)
                    .build();
        },id);

        String langSql = "select lang from languages where id = " + bookDto.getLanguage_id() + ";";
        bookDto.setLanguageName(jdbcTemplate.query(langSql, rs -> {
            rs.next();
            return rs.getString(1);
        }));

        String categorySql = "select c.id, c.name from books_categories bc join categories c on c.id = bc.category_id join books b on b.id = bc.book_id where b.id=" + bookDto.getId() + ";";
        bookDto.setCategoryList(jdbcTemplate.query(categorySql, (rs, rowNum) -> {
            return CategoryDto.builder()
                    .categoryIds(rs.getInt(1))
                    .categoryName(rs.getString(2))
                    .build();
        }));



        return bookDto;
    }

    public void update(BookDto bookDto) {
        String bookSql = "update books set title = ?, isbn = ?, total_count = ?, description = ?, language_id = ? where id = ?;";
        jdbcTemplate.update(bookSql, bookDto.getTitle(), bookDto.getIsbn(), bookDto.getTotal_count(), bookDto.getDescription(), bookDto.getLanguage_id(), bookDto.getId());
        String categorySql = "delete from books_categories where book_id = ?;";
        jdbcTemplate.update(categorySql, bookDto.getId());
        String authorSql = "delete from books_authors where book_id = ?;";
        jdbcTemplate.update(authorSql, bookDto.getId());
        for (Integer authorsId : bookDto.getAuthorsIds()) {
            String bookAuthorsSql = "insert into books_authors(book_id, author_id) values (?,?);";
            jdbcTemplate.update(bookAuthorsSql, bookDto.getId(), authorsId);
        }
        for (Integer categoriesId : bookDto.getCategoryIds()) {
            String bookCategoriesSql = "insert into books_categories(book_id, category_id) values (?,?);";
            jdbcTemplate.update(bookCategoriesSql, bookDto.getId(), categoriesId);
        }
    }
}
