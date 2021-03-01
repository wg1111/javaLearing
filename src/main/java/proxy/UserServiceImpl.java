package proxy;

/**
 * author:insane
 * Date:2021/3/20:48
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }

    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
