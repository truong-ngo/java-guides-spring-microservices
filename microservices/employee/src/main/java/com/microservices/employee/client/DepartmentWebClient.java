package com.microservices.employee.client;

import com.microservices.employee.dto.DepartmentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DepartmentWebClient {
    public final String DEPARTMENT_ROOT_URL = "http://localhost:7000";
    public final String DEPARTMENT_BY_CODE_ENDPOINT = "/api/departments/code";

    private final WebClient webClient = WebClient.builder().build();

    public DepartmentDto findByCode(String code) {
        return webClient.get()
                .uri(DEPARTMENT_ROOT_URL + DEPARTMENT_BY_CODE_ENDPOINT + "/" + code)
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
    }
}
