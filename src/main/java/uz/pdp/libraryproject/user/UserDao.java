package uz.pdp.libraryproject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryproject.language.Language;

import java.sql.*;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public List<User> getAllLUsers() {
        String sql = "select * from users";
        return  jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));


    }

    public void saveUser(User user) {


        //add user
        String sql = "insert into users (full_name,phone_number,role,password,user_name) values (?,?,?,?,?)";

        jdbcTemplate.update(sql,user.getFullName(),user.getPhoneNumber(),user.getRole(),user.getPassword(),user.getUserName());

    }


    public User getUser(int id) {
        String sql = "select * from users where id="+id;
        return jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper.newInstance(User.class));
    }


    public void updateuser(User user) {
        //update language
        String sql = "update users set full_name=?,phone_number=?,role=?,password=?,user_name=? where id=?";

        jdbcTemplate.update(sql,user.getFullName(),user.getPhoneNumber(),user.getRole(),user.getPassword(),user.getUserName(),user.getId());
    }

    public void delete(int id) {
        String sql = "delete from users where id=?";
        jdbcTemplate.update(sql,id);

    }

    public static boolean checkUser(User user) {

        boolean check = false;
        try {

            // TODO: 31/07/2022 save user
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where users.user_name=? and users.password=?");

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            int user_id = 0;
            if (resultSet.next()) {
                check = true;
                user_id = resultSet.getInt("id");
            }


            preparedStatement = connection.prepareStatement("select  role from users where id=?");
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString(1);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return check;
    }

    public static String getRoleName() {
        return role;
    }



    static String role;



    static String url = "jdbc:postgresql://localhost:5432/library_project";
    static String username = "postgres";
    static String password = "root123";

    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public List<UserDto> read(){
        String sql = "select id, full_name, phone_number from users";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                UserDto.builder()
                        .id(rs.getInt(1))
                        .fullName(rs.getString(2))
                        .phoneNumber(rs.getString(3))
                        .build()
        );
    }

}
