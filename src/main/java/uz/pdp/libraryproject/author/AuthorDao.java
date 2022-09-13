package uz.pdp.libraryproject.author;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorDao {

    private final JdbcTemplate jdbcTemplate;


    public List<AuthorDto> getAllAuthorsForSelect() {
        String sql = "select a.id, a.\"full_name\"\n" +
                "from authors a;";
        return jdbcTemplate.query(sql, (rs, row) ->
                AuthorDto.builder()
                        .authorId(rs.getInt(1))
                        .authorFullName(rs.getString(2))
                        .build()
        );
    }


    public void saveAuthor(Author author) {


        //add author
        String sql = "insert into authors (full_name,biography) values (?,?)";

        jdbcTemplate.update(sql,author.getFullName(),author.getBiography());

    }


    public List<Author> getAllAuthors() {
        String sql = "select * from authors";
        return  jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Author.class));


    }



    public Author getAuthor(int id) {
        String sql = "select * from authors where id="+id;
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Author.class));
    }

    public void updateAuthor(Author author) {
        //update user
        String sql = "update authors set full_name=?,biography=? where id=?";

        jdbcTemplate.update(sql,author.getFullName(),author.getBiography(),author.getId());
    }



    public void delete(int id) {
        String sql = "delete from authors where id=?";
        jdbcTemplate.update(sql,id);

    }



}
