package javabase;

/**
 * author:insane
 * Date:2021/3/2520:55
 **/

public class InterfaceAndAbstractImpl implements  InterfaceAndAbstract{
    public static  void main(String[] args) {

        //接口静态方法调用
        InterfaceAndAbstract.staticMethod();

        System.out.println("----------");

        //接口默认方法调用
        InterfaceAndAbstractImpl interfaceAndAbstract = new InterfaceAndAbstractImpl();
        interfaceAndAbstract.defaultMethod();
    }
}
