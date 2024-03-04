package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private final JdbcTemplate springjdbcTemplate;

    private static String INSERT_QUERY =
              """
                insert into course (id, name, author)
                values(?, ?, ?);
              """;

    private static String DELETE_QUERY =
            """
              delete from course where
              id = ?
            """;

    private static String SELECT_QUERY =
            """
              select * from course where
              id = ?
            """;



    public CourseJdbcRepository(JdbcTemplate springjdbcTemplate) {
        this.springjdbcTemplate = springjdbcTemplate;
    }

    public void insert(Course course){
        springjdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        springjdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        //ResultSet -> Bean => Row Mapper =>
        return springjdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);
    }

}
