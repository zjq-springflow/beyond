package cn.tsxygfy.blog.freemarker;

import cn.tsxygfy.blog.core.BeyondConst;
import cn.tsxygfy.blog.service.TagsService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author feiyang
 * @version v1.0
 * @className TagTagDirective
 * @description
 * @date 2020/02/04 周二 18:39
 */
@Component
public class TagTagDirective implements TemplateDirectiveModel {

    private final TagsService tagsService;

    public TagTagDirective(TagsService tagsService, Configuration configuration) {
        this.tagsService = tagsService;
        configuration.setSharedVariable("tagTag", this);
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        final DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        String param = params.get(BeyondConst.METHOD_KEY).toString();
        switch (param) {
            case "list":
                env.setVariable("tags", builder.build().wrap(tagsService.findAllWithArticleCount()));
                break;
            default:
                break;
        }
        body.render(env.getOut());
    }
}
