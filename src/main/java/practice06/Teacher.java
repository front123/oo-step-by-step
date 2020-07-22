package practice06;

public class Teacher extends Person{

    private Integer klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String extraIntroduce = " I am a Teacher. I teach No Class.";
        if (klass != null){
            extraIntroduce = " I am a Teacher. I teach Class "+ klass +".";
        }
        return super.introduce() + extraIntroduce;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }
}
