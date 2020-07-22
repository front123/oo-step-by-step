package practice07;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String extraIntroduce = " I am a Teacher. I teach No Class.";
        if (klass != null){
            extraIntroduce = " I am a Teacher. I teach Class "+ klass.getNumber() +".";
        }
        return super.introduce() + extraIntroduce;
    }

    public  String introduceWith(Student student){
        Klass studentKlass = student.getKlass();
        String extraIntroduce = " I don't teach "+ student.getName() +".";
        if (studentKlass.getNumber() == klass.getNumber()){
            extraIntroduce = " I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher." + extraIntroduce;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
