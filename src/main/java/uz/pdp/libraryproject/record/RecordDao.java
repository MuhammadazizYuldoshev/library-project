package uz.pdp.libraryproject.record;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryproject.book.Book;
import uz.pdp.libraryproject.user.UserDto;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecordDao {

    private final JdbcTemplate jdbcTemplate;

    public List<RecordDto> getAllRecords() {
        String sql = "select r.*, json_agg(json_build_object('id', b.id, 'title', b.title)),u.full_name from records r join records_books rb on r.id = rb.record_id join books b on b.id = rb.book_id join users u on r.user_id = u.id group by u.full_name, r.id ,user_id;";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Array array = rs.getArray(5);
            Type type = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> bookList = new Gson().fromJson(array.toString(), type);
            return RecordDto.builder()
                    .id(rs.getInt(1))
                    .isReturned(rs.getBoolean(2))
                    .dateTime(rs.getTimestamp(3).toLocalDateTime())
                    .userId(rs.getInt(4))
                    .bookList(bookList)
                    .userFullName(rs.getString(6))
                    .build();
        });
    }


    public List<Book> readBooks(){
        String sql = "select id, title from books";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                Book.builder()
                        .id(rs.getInt(1))
                        .title(rs.getString(2))
                        .build()
        );
    }


    public void create(RecordDto recordDto) {
        String recordSql = "insert into records (user_id) values (" + recordDto.getUserId() + ") returning  id";
        Integer recordId = jdbcTemplate.query(recordSql, rs -> {
            rs.next();
            return rs.getInt(1);
        });
        for (Integer bookId : recordDto.getBooksId()) {
            String sql = "insert into records_books values (?,?)";
            jdbcTemplate.update(sql, recordId, bookId);
        }
    }


    public void delete(int id) {
        String rbSql = "delete from records_books where record_id = ?";
        jdbcTemplate.update(rbSql, id);
        String recordSql = "delete from records where id = ? ";
        jdbcTemplate.update(recordSql, id);
    }



    public void returned(int id) {
        String sql = "update records set is_returned = true, date_time = now() where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void notReturned(int id) {
        String sql = "update records set is_returned = false, date_time = now() where id = ?";
        jdbcTemplate.update(sql, id);
    }




    public RecordDto readToEdit(Integer id) {
        String sql = "select r.user_id, json_agg(json_build_object('id', b.id, 'title', b.title)) from records r join records_books rb on r.id = rb.record_id join books b on b.id = rb.book_id  where r.id = "+id+" group by  r.id ,user_id ;";
        return jdbcTemplate.query(sql, rs -> {
            rs.next();
            Array array = rs.getArray(2);
            Type type = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> bookList = new Gson().fromJson(array.toString(), type);
            return RecordDto.builder()
                    .id(id)
                    .userId(rs.getInt(1))
                    .bookList(bookList)
                    .build();
        });
    }


    public void update(RecordDto recordDto) {
        String sql = "update records set user_id = ? where id = ?";
        jdbcTemplate.update(sql, recordDto.getUserId(), recordDto.getId());
        sql = "delete from records_books where record_id = ?";
        jdbcTemplate.update(sql, recordDto.getId());
        for (Integer bookId : recordDto.getBooksId()) {
            sql = "insert into records_books values (?,?)";
            jdbcTemplate.update(sql, recordDto.getId(), bookId);
        }
    }

}
