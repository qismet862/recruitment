package com.recruitment.util;

import com.recruitment.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
    public static UserEntity getCurrentUser() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserEntity) principal;
        }
        throw new NullPointerException("SecurityUtil.getCurrentUser : user is null");
    }
}
