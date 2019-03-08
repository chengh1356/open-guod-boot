package cn.hacz.edu.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/19 时间:14:53
 * @JDK 1.8
 * @Description 功能模块：
 */
@JobHandler(value = "demoJobHandler")
@Component
@Slf4j
public class DemoJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info(">>>>>>>>>>> xxl-job开启");
        System.out.println("<=====================>" + param);
        return SUCCESS;
    }
}
