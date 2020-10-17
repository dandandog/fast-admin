package pers.dandandog.projects.config.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author JohnnyLiu
 */
public class CaptchaErrorException extends AuthenticationException {
    public CaptchaErrorException(String msg) {
        super(msg);
    }

    public CaptchaErrorException(String msg, Throwable t) {
        super(msg, t);
    }
}
