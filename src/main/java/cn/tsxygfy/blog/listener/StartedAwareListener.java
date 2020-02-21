package cn.tsxygfy.blog.listener;

import cn.tsxygfy.blog.properties.BeyondProperties;
import cn.tsxygfy.blog.service.OptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author feiyang
 * @version v1.0
 * @className StartedListener
 * @description
 * @date 2020/01/07 周二 14:50
 */
@Slf4j
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class StartedAwareListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    private BeyondProperties beyondProperties;

    @Autowired
    private OptionService optionService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        this.printStartInfo();
    }

    private void printStartInfo() {
        String blogUrl = optionService.getBlogBaseUrl();

        log.info("Beyond started at         {}", blogUrl);
        log.info("Beyond admin started at   {}/{}", blogUrl, beyondProperties.getAdminPath());
        log.info("Beyond has started successfully!");
    }


    /**
     * Init internal themes
     */
    private void initThemes() {
        // Whether the blog has initialized

    }

}
