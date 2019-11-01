package com.example.consumerfeignmicroservice.client;


import com.example.consumerfeignmicroservice.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@org.springframework.cloud.openfeign.FeignClient(name = "zuul")
public interface DBFeignClient {

    @GetMapping(value = "db/roles")
    List<Role> listRoles();
}
