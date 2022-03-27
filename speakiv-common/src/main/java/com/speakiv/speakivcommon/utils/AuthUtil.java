package com.speakiv.speakivcommon.utils;

import org.springframework.security.core.context.SecurityContext;

public class AuthUtil {
    public static Long getUserIdFromSecurityContext(SecurityContext securityContext){
        String principal = (String) securityContext.getAuthentication().getPrincipal();
        return Long.valueOf(principal);
    }
}
