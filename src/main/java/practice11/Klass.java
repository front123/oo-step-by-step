package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private final List<Teacher> teachers;

    public Klass(int number) {
        this.number = number;
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
        student.setKlass(this);
        String extraMessage = String.format(" I know %s has joined Class %d.\n", student.getName(), getNumber());
        notifyTeacherTeachThisClassWithMessage(extraMessage);

    }

    public boolean isIn(Student student){
        return student.getKlass() == this;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (leader.getKlass() == this){
            this.leader = leader;
            String extraMessage = String.format(" I know %s become Leader of Class %d.\n", leader.getName(), getNumber());
            notifyTeacherTeachThisClassWithMessage(extraMessage);
        }else {
            System.out.print("It is not one of us.\n");
        }
    }
    public int getNumber() {
        return number;
    }
    
    public String getDisplayName(){
        return "Class "+number;
    }
}
