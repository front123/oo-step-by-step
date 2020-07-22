package practice10;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person{
    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.classes = new LinkedList<>();
    }
    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    @Override
    public String introduce() {
        String extraIntroduce = "I teach No Class.";
        if (classes.size()>0){
            String classNumbers = "";
            for (Klass klass : classes) {
                classNumbers += klass.getNumber()+", ";
            }
            extraIntroduce = "I teach Class "+ classNumbers.substring(0, classNumbers.length()-2) +".";
        }
        return super.introduce() + " I am a Teacher. " + extraIntroduce;
    }

    public String introduceWith(Student student){
        Klass studentKlass = student.getKlass();
        String extraIntroduce = " I don't teach "+ student.getName() +".";
        for (Klass klass: classes) {
            if (studentKlass.getNumber() == klass.getNumber()){
                extraIntroduce = " I teach " + student.getName() + ".";
                break;
            }
        }

        return super.introduce() + " I am a Teacher." + extraIntroduce;
    }

    public boolean isTeaching(Student student){
        for (Klass klass: classes) {
            if (klass.isIn(student)) return true;
        }
        return false;
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }
}
