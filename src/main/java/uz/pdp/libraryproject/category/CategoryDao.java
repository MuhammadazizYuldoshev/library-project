package uz.pdp.libraryproject.category;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;


    public List<CategoryDto> getAllCategoriesForSelect() {
        String sql = "select c.id, c.name,c.description\n" +
                "from categories c;";
        return jdbcTemplate.query(sql, (rs, row) ->
                CategoryDto.builder()
                        .categoryIds(rs.getInt(1))
                        .categoryName(rs.getString(2))
                        .categoryDescription(rs.getString(3))
                        .build()
        );
    }

    public List<Category> getAllCategories() {
        String sql = "select c.id,c.name from categories c";
        return  jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Category.class));


    }

    public void saveCategory(Category category) {


        //add category
        String sql = "insert into categories (name,description) values (?,?)";

        jdbcTemplate.update(sql,category.getName(),category.getDescription());

    }

    public Category getCategory(int id) {
        String sql = "select * from categories where id="+id;
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Category.class));
    }

    public void updateCategory(Category category) {
        //update category
        String sql = "update categories set name=?,description=? where id=?";

        jdbcTemplate.update(sql,category.getName(),category.getDescription(),category.getId());
    }

    public void delete(int id) {
        String sql = "delete from categories where id=?";
        jdbcTemplate.update(sql,id);

    }
}
