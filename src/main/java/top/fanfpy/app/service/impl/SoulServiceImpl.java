package top.fanfpy.app.service.impl;

import top.fanfpy.app.entity.Soul;
import top.fanfpy.app.mapper.SoulMapper;
import top.fanfpy.app.service.ISoulService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 毒鸡汤 服务实现类
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
@Service
public class SoulServiceImpl extends ServiceImpl<SoulMapper, Soul> implements ISoulService {
    public Soul getRand(){
       return baseMapper.getRand();
    }

}
