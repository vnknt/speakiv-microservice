package com.speakiv.apigateway.config;

import java.io.Serializable;
import java.util.List;

public class TokenValidationResponse implements Serializable {
    private Long userId;
    private List<String> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
