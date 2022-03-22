package com.speakiv.apigateway.config;

import com.speakiv.speakivcore.model.response.DataResponse;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final WebClient.Builder webClientBuilder;

    public AuthFilter(WebClient.Builder webClientBuilder ){
        super(Config.class);
        this.webClientBuilder =webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) ->{

            if(!exchange.getRequest().getHeaders().containsKey("Authorization")){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
            List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
            String token = authHeader.get(0);
            String[] parts = token.split(" ");
            if(parts.length<2){
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }

            return webClientBuilder
                    .build()
                    .get()
                    .uri("lb://auth-service/api/auth/validateToken?token="+parts[1])
                    .retrieve()
                    .bodyToMono( new ParameterizedTypeReference<DataResponse<TokenValidationResponse>>(){})
                    .map((response)->{
                        if(!response.isSuccess()){
                            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                        }
                        TokenValidationResponse validationResponse = response.getData();
                        exchange.getRequest().mutate().header("x-auth-user-id",String.valueOf(validationResponse.getUserId()));
                        return exchange;

                    }).flatMap(chain::filter);

        } ;
    }

    public static class Config {

    }


}
