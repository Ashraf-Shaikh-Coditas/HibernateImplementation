package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HibernateImplementation {

    public Student findById(int id) throws SQLException {
        Connection connection = ConnectionProvider.connect();
        ResultSet resultSet ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Student " +
                "where id = ?");
        preparedStatement.setInt(1,id);

        resultSet = preparedStatement.executeQuery();

        Student student = new Student();

        while (resultSet.next()) {
            student.setStudentId(resultSet.getInt(1));
            student.setStudentName(resultSet.getString(2));
        }
        return student;
    }

    public List<Student> findAll() throws SQLException {
        Connection connection = ConnectionProvider.connect();
        ResultSet resultSet ;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from Student");

        resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<Student>();

        while (resultSet.next()) {
            Student student = new Student();
            student.setStudentId(resultSet.getInt(1));
            student.setStudentName(resultSet.getString(2));
            studentList.add(student);
        }
        return studentList;
    }

    public int deleteById(int id) throws SQLException {
        Connection connection = ConnectionProvider.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from Student" +
                " where id = "+id);

        int status = preparedStatement.executeUpdate();

        return status;
    }

    public int deleteAll() throws SQLException {
        Connection connection = ConnectionProvider.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from Student");

        int status = preparedStatement.executeUpdate();

        return status;
    }

    public int save(Student student) throws SQLException {
        Connection connection = ConnectionProvider.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into student values" +
                " (?,?)");
        preparedStatement.setInt(1,student.getStudentId());
        preparedStatement.setString(2,student.getStudentName());
        int status = preparedStatement.executeUpdate();
        return status;

    }

    public int update(Student student) throws SQLException {
        Connection connection = ConnectionProvider.connect();
        PreparedStatement preparedStatement = connection.prepareStatement("update student set name = ? " +
                "where id = ?");
        preparedStatement.setString(1,student.getStudentName());
        preparedStatement.setInt(2,student.getStudentId());
        int status = preparedStatement.executeUpdate();
        return status;

    }


}
