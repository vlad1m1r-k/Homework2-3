package homeWork3;

public class Student extends Human {
    private  int iq;

    public Student(String firstName, String lastName, int age, int iq) {
        super(firstName, lastName, age);
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    @Override
    public String toString(){
        return super.toString() + " IQ: " + iq;
    }
}
