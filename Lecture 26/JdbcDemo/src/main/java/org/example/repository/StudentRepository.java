package org.example.repository;

import com.mysql.cj.protocol.Resultset;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {


    String url="jdbc:mysql://127.0.0.1:3306/student_db";
    String username="kartik";
    String password="kartik";

    //Connection connection=null;
    //PreparedStatement preparedStatement;

//    public void createUser(Student student){
//
//        try {
//             connection= DriverManager.getConnection(url,username,password);
//
//            String sql= """
//                        insert into student(name,email,age)
//                        values(?,?,?)
//                        """;
//            preparedStatement=
//                    connection.prepareStatement(sql);
//
//            preparedStatement.setString(1,student.getName());
//            preparedStatement.setString(2,student.getEmail());
//            preparedStatement.setInt(3,student.getAge());
//
//            int rowAffected= preparedStatement.executeUpdate();
//
//            if(rowAffected==1){
//                System.out.println("Create Student succesfully");
//            }
//            else{
//                System.out.println("Create Student failed");
//            }
//
//        }
//        catch (SQLException e){
//            System.out.println("connection failed");
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                preparedStatement.close();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }

    String sql= """
                        insert into student(name,email,age)
                        values(?,?,?)
                        """;
    public void createUser(Student student){

        try (
                //if we use try with resources then we don't have to close these manually they close automatically
                Connection connection= DriverManager.getConnection(url,username,password);

             PreparedStatement preparedStatement=
                     connection.prepareStatement(sql);){


            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());

            int rowAffected= preparedStatement.executeUpdate();

            if(rowAffected==1){
                System.out.println("Create Student succesfully");
            }
            else{
                System.out.println("Create Student failed");
            }

        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public void updateUser(Student student ,Long id){
        String sql= """
                        Update student 
                        set name =?,
                            email=?,
                            age=?
                        where id =?
                        """;
        try (
                Connection connection= DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement=
                        connection.prepareStatement(sql);
                ){

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,id);


            int result= preparedStatement.executeUpdate();

            if(result==1){
                System.out.println("update successfully");
            }
            else{
                System.out.println("update failed");
            }

        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }
    public void deleteUser(Long id){

        String sql="delete from student where id=?";
        try (
                Connection connection= DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement=
                        connection.prepareStatement(sql);
                ){
            preparedStatement.setLong(1,id);

            int rowAffected= preparedStatement.executeUpdate();

            if(rowAffected==1){
                System.out.println("delete successfully");
            }
            else{
                System.out.println("deletion failed");
            }

        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public void getUserById(Long id){

        String sql= """
                    select id,name,email,age from student
                    where id=?
                    """;
        try (
                Connection connection= DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement=
                        connection.prepareStatement(sql);
                ){

            preparedStatement.setLong(1,id);
            try ( ResultSet resultSet=preparedStatement.executeQuery()){

                if(resultSet.next()){
                    Student student =mapRow(resultSet);
                    System.out.println(student);
                }

            }

        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public void completeCrud(){
        try {
            Connection connection= DriverManager.getConnection(url,username,password);

            Statement statement= connection.createStatement();

            String sql="select id,name,email,age " +
                    " from student where id =2 ";

            boolean result=statement.execute(sql);

            if(result){
                ResultSet resultSet=statement.getResultSet();
            }
            else{
                int rowAffected=statement.getUpdateCount();
            }

            connection.close();
        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public void getAllUser(Long id){

        String sql= """
                    select id,name,email,age from student
                    """;
        try (
                Connection connection= DriverManager.getConnection(url,username,password);

                PreparedStatement preparedStatement=
                        connection.prepareStatement(sql);
        ){

            try ( ResultSet resultSet=preparedStatement.executeQuery()){
                List<Student> studentList=new ArrayList<>();

                while(resultSet.next()){
                    Student student =mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }

            }

        }
        catch (SQLException e){
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student=new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

        return student;
    }
}
