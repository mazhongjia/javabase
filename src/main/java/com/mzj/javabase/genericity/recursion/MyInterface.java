package com.mzj.javabase.genericity.recursion;

public interface MyInterface<T extends MyInterface<T>> {

    T add();
}
