package proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import proxy.UserDao;

/**
 * author:insane
 * Date:2021/3/2 1:33
 **/
public class CglibProxyTest {
    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java\\java_workapace");

        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(UserDao.class);
        //设置回调函数
        enhancer.setCallback(new LogInterceptor());
        //这里的creat方法就是正式创建代理类
        UserDao proxy = (UserDao)enhancer.create();

        //调用代理类方法
        proxy.select();
        proxy.update();

    }
}
