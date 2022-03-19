package com.speakiv.authservice.config.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "user-service")
public class UserServiceClient {

}
