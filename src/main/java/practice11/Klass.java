package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int number;
    private Student leader;
    private final List<AppendMemberObserver> appendMemberObservers;
    private final List<AssignLeaderObserver> assignLeaderObservers;

    public Klass(int number) {
        this.number = number;
        appendMemberObservers = new ArrayList<>();
        assignLeaderObservers = new ArrayList<>();
    }

    public void appendTeacher(Teacher teacher){
        if(appendMemberObservers.contains(teacher) || assignLeaderObservers.contains(teacher)){
            return;
        }
        appendMemberObservers.add(teacher);
        assignLeaderObservers.add(teacher);
    }

    public void appendMember(Student student){
        student.setKlass(this);
        String extraMessage = String.format(" I know %s has joined Class %d.\n", student.getName(), getNumber());
        for (AppendMemberObserver observer : appendMemberObservers) {
            observer.notifyAppendMemberWithMessage(extraMessage);
        }

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
            for (AssignLeaderObserver observer : assignLeaderObservers) {
                observer.notifyAssignLeaderWithMessage(extraMessage);
            }
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
