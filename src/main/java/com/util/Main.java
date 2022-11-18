package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

            boolean flag = true;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while(flag) {

                System.out.println("1.For adding new student");
                System.out.println("2.For findingAll Students");
                System.out.println("3.For finding by id");
                System.out.println("4.Delete student By Id");
                System.out.println("5.Delete All students");
                System.out.println("6.Update  student");
                System.out.println("Enter the option you want");

                int choice = Integer.parseInt(bufferedReader.readLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter the student id");
                        int id=Integer.parseInt(bufferedReader.readLine());
                        System.out.println("Enter the student name");
                        String name=bufferedReader.readLine();
                        Student student=new Student(id,name);
                        int status = new HibernateImplementation().save(student);
                        if(status>0) {
                            System.out.println("Student added successfully");
                        } else {
                            System.out.println("Student not added successfully");
                        }
                        break;

                    case 2:
                        List<Student> students = new HibernateImplementation().findAll();
                        System.out.println("The list of the students is as follows : ");
                        students.stream().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("Enter the id of the student you want to find information of");
                        int id1=Integer.parseInt(bufferedReader.readLine());
                        Student student1 = new HibernateImplementation().findById(id1);
                        System.out.println("The student is "+student1);
                        break;

                    case 4:
                        System.out.println("Enter the id of the student you want to delete");
                        int id2=Integer.parseInt(bufferedReader.readLine());
                        int status1 =  new HibernateImplementation().deleteById(id2);
                        if(status1>0) {
                            System.out.println("Student deleted successfully");
                        } else {
                            System.out.println("Student not deleted successfully");
                        }
                        break;

                    case 5:
                        System.out.println("Delete all the information");
                        new HibernateImplementation().deleteAll();
                        break;

                    case 6 :
                        System.out.println("Enter the id to be updated : ");
                        int id3 = Integer.parseInt(bufferedReader.readLine());
                        Student student2 = new HibernateImplementation().findById(id3);

                        System.out.println("Enter new Name : ");
                        student2.setStudentName(bufferedReader.readLine());
                        new HibernateImplementation().update(student2);
                        System.out.println("Student Updated Successfully...");

                    default :
                        flag = false;
                        break;

                }


            }

    }
}
