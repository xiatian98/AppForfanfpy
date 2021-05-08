package top.fanfpy.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public * top.fanfpy.app.controller..*.*(..)))")
    public void log(){
    }

    //启动前
    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpServletResponse response =attributes.getResponse();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("args={}",joinPoint.getArgs());

    }

    @AfterReturning(returning = "object" , pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
