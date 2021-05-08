package top.fanfpy.app.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fanfpy.app.config.PassToken;
import top.fanfpy.app.entity.User;
import top.fanfpy.app.service.impl.UserServiceImpl;
import top.fanfpy.app.util.JwtUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author znn
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/app/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;

    @PassToken
    @PostMapping("/login")
    public R login(@RequestBody Map<String,Object> res){
        logger.info("username ={} passwd={}",res.get("username"),res.get("password"));
        Map<String,Object> map = new HashMap<>();
       User user = userService.login(res.get("username").toString(),res.get("password").toString());
       if (user!=null){
           map.put("token",JwtUtil.sign(user.getId()));
           return R.ok(map);
       }else {
           return R.failed("账号或密码错误");
       }
    }

    @PassToken
    @GetMapping("info")
    public R info(String token){
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("admin");
        map.put("roles",list);
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","管理员");
       return R.ok(map);
    }

    @PostMapping("logout")
    public R logout(){
        return R.ok("success");
    }

    @GetMapping("list")
    public R list(@RequestParam(value = "page",defaultValue = "1") Integer page_num){
        Page<User> page = new Page<>(page_num,10);
        return R.ok(userService.page(page));
    }

    @GetMapping("detail")
    public R detail(@RequestParam(value = "id") Long id){
        return R.ok(userService.getById(id));
    }

    @PutMapping("addAndUpdate")
    public R update(User user){
        if (user.getId()!=null){
            if(userService.updateById(user)){
                return R.ok("成功");
            }else {
                return R.failed("失败");
            }
        }else {
            if(userService.save(user)){
                return R.ok("成功");
            }else {
                return R.failed("失败");
            }
        }


    }
}
