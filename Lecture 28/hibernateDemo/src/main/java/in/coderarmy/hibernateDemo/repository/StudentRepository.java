package in.coderarmy.hibernateDemo.repository;

import in.coderarmy.hibernateDemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    //private StudentRowMapper studentRowMapper=new StudentRowMapper();
    private RowMapper<Student> rowMapper=new BeanPropertyRowMapper<>();

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void createStudent(Student student){
        String sql= """
                        insert into student(name,email,age)
                        values(?,?,?)
                        """;

        int rowAffected=jdbcTemplate.update(sql,
                student.getName(),student.getEmail(),student.getAge());

        if(rowAffected==1){
            System.out.println("Create Student successfully");
        }
        else{
            System.out.println("Create Student failed");
        }
    }

    public void updateStudent(Student student ,Long id){
        String sql= """
                        Update student 
                        set name =?,
                            email=?,
                            age=?
                        where id =?
                        """;
        int rowAffected= jdbcTemplate.update(sql,
                student.getName(),student.getEmail(),student.getAge(),
                id);

        if(rowAffected==1){
            System.out.println("update successfully");
        }
        else{
            System.out.println("update failed");
        }
    }
    public void deleteStudent(Long id){

        String sql="delete from student where id=?";

        int rowAffected= jdbcTemplate.update(sql,id);

        if(rowAffected==1){
            System.out.println("delete successfully");
        }
        else{
            System.out.println("deletion failed");
        }
    }

    public Student getStudentById(Long id){

        String sql= """
                    select id,name,email,age from student
                    where id=?
                    """;

        return jdbcTemplate.queryForObject(sql,
                rowMapper,
                id);
    }
}
