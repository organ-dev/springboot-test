package com.example.handle;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @Auther: ld
 * @Date: 2018/9/30 17:24
 * @Description:
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
//        SecurityContext ctx = SecurityContextHolder.getContext();
//        if (ctx == null) {
//            return null;
//        }
//        if (ctx.getAuthentication() == null) {
//            return null;
//        }
//        if (ctx.getAuthentication().getPrincipal() == null) {
//            return null;
//        }
//        Object principal = ctx.getAuthentication().getPrincipal();
//        if (principal.getClass().isAssignableFrom(String.class)) {
//            return (String) principal;
//        } else {
//            return null;
//        }
        return "admin";
    }
}
