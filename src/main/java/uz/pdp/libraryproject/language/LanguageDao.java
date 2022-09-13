package uz.pdp.libraryproject.language;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryproject.category.Category;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LanguageDao {

    private final JdbcTemplate jdbcTemplate;


    public List<LanguageDto> getAllLanguagesForSelect() {
        String sql = "select l.id, l.lang\n" +
                "from languages l;";
        return jdbcTemplate.query(sql, (rs, row) ->
                LanguageDto.builder()
                        .languageIds(rs.getInt(1))
                        .lang(rs.getString(2))
                        .build()
        );
    }


    public List<Language> getAllLanguages() {
        String sql = "select * from languages";
        return  jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Language.class));


    }

    public void saveLanguage(Language language) {


        //add category
        String sql = "insert into languages (lang) values (?)";

        jdbcTemplate.update(sql,language.getLang());

    }


    public Language getLanguage(int id) {
        String sql = "select * from languages where id="+id;
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(Language.class));
    }


    public void updateLanguage(Language language) {
        //update language
        String sql = "update languages set lang=? where id=?";

        jdbcTemplate.update(sql,language.getLang(),language.getId());
    }

    public void delete(int id) {
        String sql = "delete from languages where id=?";
        jdbcTemplate.update(sql,id);

    }
}
