package practice11;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String extraIntroduce = "I am at Class "+klass.getNumber() +".";
        if (this == klass.getLeader()){
            extraIntroduce = "I am Leader of Class "+ klass.getNumber() +".";
        }
        return super.introduce() + " I am a Student. " + extraIntroduce;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
