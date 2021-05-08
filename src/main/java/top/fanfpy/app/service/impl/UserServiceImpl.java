package top.fanfpy.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import top.fanfpy.app.entity.User;
import top.fanfpy.app.mapper.UserMapper;
import top.fanfpy.app.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(String username, String password) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username).eq(User::getPasswd,password));
    }
}
