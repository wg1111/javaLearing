package javabase;

/**
 * author:insane
 * Date:2021/3/2520:52
 **/

/**
 *jdk7及之前：1、接口中只有抽象方法，方法默认都是 public abstract，成员变量默认都是 public static final的；抽象类中可以有抽象方法和其他方法，但是有抽象方法的类必须定义为抽象类
 *           2、抽象类中有构造方法，接口中没有构造方法
 *           3、抽象类中可以有public、protected、default修饰的方法（private私有方法不能被继承，所以不能有）；接口只有public abstract 修饰的方法
 *           4、抽象类中有静态方法；接口中没有静态方法
 *           5、一个类只可以继承一个抽象类但可以实现多个接口
 *
 *JDK8：1、接口中新增了静态方法，只能通过  接口名.静态方法名来调用
 *      2、接口新增了默认方法，解决实现类实现方法混乱影响已有实现类问题。默认方法通过 对象名.默认方法 调用
 *
 * JDK9： 新增了私有方法（不能被继承），解决多个默认方法中重复代码的问题，但因为不能被实现类继承，所以是private
 */

/**
 * 接口特点：
 *          接口中的常量: 主要是供接口直接使用
 *          接口中的抽象方法: 供实现类重写的
 *          接口中的默认方法: 供实现类继承的(实现类中可以直接调用,实现类对象也可以直接调用)
 *          接口中的静态方法: 只供接口直接调用,实现类继承不了
 *          接口中的私有方法: 只能在接口中直接调用,实现类继承不了
 *
 */
public interface InterfaceAndAbstract {

    static void staticMethod() {
        System.out.println("接口静态方法测试！");
    }

    default void defaultMethod() {
        System.out.println("defaultMethod 输出！");
    }

}
