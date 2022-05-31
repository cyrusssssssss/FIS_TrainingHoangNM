package fis.java.core.topic01.dao.mem;

import fis.java.core.topic01.core.Student;
import fis.java.core.topic01.dao.BubbleSortStrategy;
import fis.java.core.topic01.dao.ISortStrategy;
import fis.java.core.topic01.dao.IStudentDaoMem;

public class StudentDaoMem implements IStudentDaoMem {
    private Student[] students ;
    private int count;
    private ISortStrategy sortStrategy;
    public StudentDaoMem() {
        this.students = new Student[100];
        this.count = 0;
        this.sortStrategy = new BubbleSortStrategy();
    }

    public Student[] getStudents() {
        return students;
    }

    public int getCount() {
        return count;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void addStudent(Student student){
        //TODO
    }
    public Student removeStudent(int code){
        //TODO
        return null;
    }
    public void display(){
        //TODO
    }


    public void sort() {
        //TODO
    }
    public void setSortStrategy(ISortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;

    }
}

