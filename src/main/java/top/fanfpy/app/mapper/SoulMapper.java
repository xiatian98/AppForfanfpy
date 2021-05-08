package top.fanfpy.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.fanfpy.app.entity.Soul;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 毒鸡汤 Mapper 接口
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
public interface SoulMapper extends BaseMapper<Soul> {
    public Soul getRand();
}
