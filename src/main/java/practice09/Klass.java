package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;

    public Klass(int number) {
        this.number = number;
        students = new ArrayList<Student>();
    }
    public void appendMember(Student newStudent){
        students.add(newStudent);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (students.contains(leader)){
            this.leader = leader;
        }else {
            System.out.print("It is not one of us.\n");
        }

    }

    public String getDisplayName(){
        return "Class "+number;
    }
}
