package pers.dandandog.projects.config.aspect;

import com.dandandog.framework.faces.aspect.AbstractMessageAspect;
import com.dandandog.framework.faces.config.properties.MessageProperties;
import com.dandandog.framework.faces.utils.RequestContextUtil;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @author JohnnyLiu
 **/

@Aspect
@Component
@EnableConfigurationProperties({MessageProperties.class})
public class MessageAspect extends AbstractMessageAspect {


    @Autowired
    public MessageAspect(MessageSource messageSource, MessageProperties properties) {
        super(messageSource, properties);
    }

    @Override
    protected void renderMessages() {
        RequestContextUtil.update("globalMessageGrowl");
    }
}
