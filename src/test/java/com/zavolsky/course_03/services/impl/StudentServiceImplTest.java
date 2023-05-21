package com.zavolsky.course_03.services.impl;

import com.zavolsky.course_03.models.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class StudentServiceImplTest {

    private final StudentServiceImpl students = new StudentServiceImpl();

    @BeforeEach
    public void beforeEach() {
        students.add("Harry Potter", 13);
        students.add("Ronald Weasley", 13);
        students.add("Hermione Granger", 13);
        students.add("Draco Malfoy", 12);
        students.add("Cedric Diggory", 17);
        students.add("Fred Weasley", 15);
        students.add("George Weasley", 15);
    }

    @Test
    public void addTest() {
        int sizeBefore = students.getAll().size();
        Student actual = students.add("Luna Lovegood", 13);
        Student expected = new Student("Luna Lovegood", 13);

        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .comparingOnlyFields("name", "age")
                .isEqualTo(expected);

        Assertions.assertThat(students.getAll().size())
                .isEqualTo(sizeBefore + 1);
    }



    @Test // This test doesn't work. Need to fix.
    public void getAllTest() {
        int size = students.getAll().size();
        Assertions.assertThat(students.getAll())
                .usingRecursiveComparison()
                .comparingOnlyFields("name", "age")
                .isEqualTo(
                        Map.of(
                                1, new Student("Harry Potter", 13),
                                2, new Student("Ronald Weasley", 13),
                                3, new Student("Hermione Granger", 13),
                                4, new Student("Draco Malfoy", 12),
                                5, new Student("Cedric Diggory", 17),
                                6, new Student("Fred Weasley", 15),
                                7, new Student("George Weasley", 15)
                        )
                );

        Assertions.assertThat(students.getAll().size())
                .isEqualTo(size);
    }

    @Test
    public void getAllByAge() {
        Assertions.assertThat(students.getAllByAge(13))
                .usingRecursiveComparison()
                .comparingOnlyFields("name", "age")
                .isEqualTo(
                        Map.of(
                                1, new Student("Harry Potter", 13),
                                2, new Student("Ronald Weasley", 13),
                                3, new Student("Hermione Granger", 13)
                        )
                );

        Assertions.assertThat(students.getAllByAge(13).size())
                .isEqualTo(3);
    }

}
