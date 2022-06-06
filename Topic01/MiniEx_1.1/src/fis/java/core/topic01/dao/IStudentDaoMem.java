package fis.java.core.topic01.dao;

import fis.java.core.topic01.core.Student;

public interface IStudentDaoMem {
    public void addStudent(Student student);
    public Student removeStudent(int code);
    public void display();
    public void sort();

}
