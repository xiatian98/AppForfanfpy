package top.fanfpy.app.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import top.fanfpy.app.config.PassToken;
import top.fanfpy.app.entity.Soul;
import top.fanfpy.app.service.impl.SoulServiceImpl;

/**
 * <p>
 * 毒鸡汤 前端控制器
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/app/soul")
public class SoulController {

    Logger logger = LoggerFactory.getLogger(SoulController.class);

    @Autowired
    private SoulServiceImpl soulService;

    @PassToken
    @GetMapping()
    public R jiTang(){
        return R.ok(soulService.getRand());
    }

    @GetMapping("/{id}")
    public R getSoul(@PathVariable("id") Integer id){
        logger.info("id={}",id);
        return R.ok(soulService.getById(id));
    }


    @GetMapping("list")
    public R list(@RequestParam(value = "page",defaultValue = "1") Integer page_num){
        Page<Soul> page = new Page<>(page_num,10);
        return R.ok(soulService.page(page));
    }
}
