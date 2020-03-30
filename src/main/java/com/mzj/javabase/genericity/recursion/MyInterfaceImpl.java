package com.mzj.javabase.genericity.recursion;

public class MyInterfaceImpl implements MyInterface<MyInterfaceImpl> {

    /**
     * 注意，此处类`MyInterfaceImpl`里的add方法返回类型`MyInterfaceImpl`。也就是说，
     * 接口`MyInterface`里声明的方法时并不知道子类型`MyInterfaceImpl`的存在，通过继承和泛型，
     * 可以放返回值动态的适配子类型，这一切都要归功于`<T extends MyInterface<T>>`
     *
     * @return
     */
    @Override
    public MyInterfaceImpl add() {
        return null;
    }
}
