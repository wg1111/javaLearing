package proxy.jdk;

import com.sun.deploy.net.proxy.ProxyUtils;
import proxy.UserService;
import proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * author:insane
 * Date:2021/3/20:43
 * jdk动态代理的客户端
 * 获取动态生成的代理类的对象须借助 Proxy 类的 newProxyInstance 方法
 **/
public class client {
    public static void main(String[] args) {
        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //1.创建被代理的对象，UserService的实现类
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //2.获取对应的classLoader
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();
        //3.获取所有接口的class，这里的UserServiceImpl只实现了一个接口UserService
        Class[] interfaces = userServiceImpl.getClass().getInterfaces();
        //4.创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的实现
        //  这里将创建一个自定义的日志处理器（LogHandler），需传入实际的执行对象userServiceImpl
        InvocationHandler handler = new LogHandler(userServiceImpl);
        /* 5.根据上面提供的信息创建代理对象。创建过程中：
              a.jdk会根据传入的参数信息动态创建代理实例
         */
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        //调用代理的方法
        proxy.select();
        proxy.update();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        // ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }
}
