package com.mzj.javabase.genericity.clazz;

public class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }

    public static void main(String[] args) {
        //传入的实参类型需与泛型的类型参数类型相同
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic<String> genericString = new Generic<String>("key_vlaue");
        //定义的泛型类，就一定要声明泛型具体类型？
        // 并不是这样，在使用泛型的时候如果声明泛型具体类型，则会根据这个类型做相应的限制，此时泛型才会起到本应起到的限制作用。
        // 如果不声明泛型具体类型的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        Generic other = new Generic("123");

    }
}
