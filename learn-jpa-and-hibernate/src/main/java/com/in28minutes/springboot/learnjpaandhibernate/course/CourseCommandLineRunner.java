package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.sptringdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

   /* private final CourseJdbcRepository repository;*/

    /*public CourseCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }*/
    /*private final CourseJpaRepository repository;

    public CourseCommandLineRunner(CourseJpaRepository repository) {
        this.repository = repository;
    }*/
    private final CourseSpringDataJpaRepository repository;

    public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
        repository.save(new Course(3, "Learn DebOps Jpa!", "in28minutes"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn DebOps Jpa!"));
        System.out.println(repository.findByAuthor(""));




    }
}
