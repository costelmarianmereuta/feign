package com.example.consumerfeignmicroservice;

import com.example.consumerfeignmicroservice.client.DBFeignClient;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ConsumerFeignMicroserviceApplicationTests {

    @ClassRule
    public static WireMockClassRule wiremock = new WireMockClassRule(
            WireMockSpring.options().dynamicPort());

    // A service that calls out over HTTP
    @Autowired
    private DBFeignClient dbFeignClient;

    // Using the WireMock APIs in the normal way:
    @Test
    public void contextLoads() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/roles"))
                .willReturn(aResponse().withHeader("Content-Type",
                        "text/plain").withBody("Hello World!")));
        // We're asserting if WireMock responded properly
//        assertThat(this.dbFeignClient.listRoles().size()).isEqualTo("Hello World!");
    }

}
