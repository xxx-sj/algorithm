package test.generic;

public class Student extends Person implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public void methodB() {
        System.out.println("child");
    }

    @Override
    public void methodA() {
        System.out.println("call child");
    }
}
