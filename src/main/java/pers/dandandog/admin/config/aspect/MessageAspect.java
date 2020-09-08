package pers.dandandog.admin.config.aspect;

import com.dandandog.framework.faces.aspect.AbstractMessageAspect;
import com.dandandog.framework.faces.utils.RequestContextUtil;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author JohnnyLiu
 **/

@Aspect
@Component
public class MessageAspect extends AbstractMessageAspect {

    public MessageAspect() {
        setMessageCodePrefix("framework.");
    }

    @Override
    protected void renderMessages() {
        RequestContextUtil.update("globalMessageGrowl");
    }
}
