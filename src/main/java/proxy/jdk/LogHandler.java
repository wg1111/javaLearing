package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * author:insane
 * Date:2021/3/20:32
 **/
public class LogHandler implements InvocationHandler {
    Object target; //被代理的对象，实际方法的执行者

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args); //通过反射调用target的method方法
        after();
        return result;
    }


    //调用invoke方法之前执行
    private void before() {
        System.out.println("log start time :" + LocalDateTime.now());
    }

    //调用invoke方法之后执行
    private void after() {
        System.out.println("log end time : " + LocalDateTime.now());
    }
}
