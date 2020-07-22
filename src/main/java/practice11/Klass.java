package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;
    private List<Teacher> teachers;

    public Klass(int number) {
        this.number = number;
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
    }

    public void appendTeacher(Teacher teacher){
        if(teachers.contains(teacher)){
            return;
        }
        teachers.add(teacher);
    }
    public void notifyTeacherTeachThisClassWithMessage(String extraMessage){
        for (Teacher teacher : teachers) {
            teacher.outPutMessage(extraMessage);
        }
    }

    public void appendMember(Student student){
        if (students.contains(student)){
            return;
        }
        if(students.add(student)){
            String extraMessage = " I know "+student.getName()+" has joined Class "+getNumber()+".\n";
            notifyTeacherTeachThisClassWithMessage(extraMessage);
        }

    }

    public boolean isIn(Student student){
        return student.getKlass() == this;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (students.contains(leader)){
            this.leader = leader;
            String extraMessage = " I know "+leader.getName()+" become Leader of Class "+getNumber()+".\n";
            notifyTeacherTeachThisClassWithMessage(extraMessage);
        }else {
            System.out.print("It is not one of us.\n");
        }
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getDisplayName(){
        return "Class "+number;
    }
}
