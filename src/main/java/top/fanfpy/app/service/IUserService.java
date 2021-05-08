package top.fanfpy.app.service;

import top.fanfpy.app.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
public interface IUserService extends IService<User> {
    public User login(String username,String passwd);
}
