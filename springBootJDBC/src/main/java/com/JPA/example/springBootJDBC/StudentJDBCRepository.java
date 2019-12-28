package com.JPA.example.springBootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentJDBCRepository {
    // Repository method to read student information
    @Autowired
    JdbcTemplate studentJdbcTemplate;


    /*
    * JdbcTemplate has a number of methods to execute queries. In this example, we are using the queryForObject method.
new Object[] { id } - We are passing id as a parameter to the query
new BeanPropertyRowMapper<Student>(Student.class) - We are using a BeanPropertyRowMapper to map the results from ResultSet to the Student bean.*/

    public Student findById(Long id) {
        return studentJdbcTemplate.queryForObject("select * from STUDENT where id=?", new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }

    class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setPassportNumber(resultSet.getString("passport_number"));
            return student;
        }
    }

    public List<Student> findAll(){
        return studentJdbcTemplate.query("select * from STUDENT", new StudentRowMapper());
    }

    public int deleteById(Long id){
        return studentJdbcTemplate.update("delete from student where id=?", new Object[]{id});
    }

    public int insert(Student student) {
        return studentJdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
                new Object[] { student.getId(), student.getName(), student.getPassportNumber() });
    }

    public int update(Student student) {
        return studentJdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
                new Object[] { student.getName(), student.getPassportNumber(), student.getId() });
    }

}
