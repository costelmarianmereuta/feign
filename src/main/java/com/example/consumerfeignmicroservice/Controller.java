package com.example.consumerfeignmicroservice;

import com.example.consumerfeignmicroservice.client.DBFeignClient;
import com.example.consumerfeignmicroservice.model.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {


    private DBFeignClient feignClient;

    public Controller(DBFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return feignClient.listRoles();
    }
}
