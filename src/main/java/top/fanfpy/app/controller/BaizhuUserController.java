package top.fanfpy.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.app.config.PassToken;
import top.fanfpy.app.entity.BaizhuUser;
import top.fanfpy.app.service.impl.BaizhuUserServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author znn
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/app/baizhu-user")
public class BaizhuUserController {

    @Autowired
    BaizhuUserServiceImpl baizhuUserService;

    @PassToken
    @GetMapping("/list")
    public List<BaizhuUser> getAllUser(){
      return   baizhuUserService.list();
    }

    @PassToken
    @GetMapping("/add")
    public void insert(){
        BaizhuUser baizhuUse = new BaizhuUser();

        baizhuUse.setUsername("123");
        baizhuUse.setPassword("123");
        baizhuUserService.save(baizhuUse);
    }
}
