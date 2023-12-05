package test.generic;

import java.util.List;

//public class SaltClass <E extends Comparable<? super E>>{
//public class SaltClass <E extends Student>{
public class SaltClass<E extends Student> {

    private E type;

    E get() {
        return type;
    }

    void set(E type) {
        this.type = type;
    }

    void method1(List<? super Integer> p) {
    }
}





