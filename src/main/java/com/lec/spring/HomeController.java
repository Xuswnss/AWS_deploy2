package com.lec.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class HomeController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @GetMapping("/aws/v2")
    public String hello(@RequestParam(defaultValue = "1") Integer num){
        if(num == 1)
        log.info("["+activeProfile +"]/aws/v2/ 호출. info 로그 ######");
        else if (num == -1) {
            log.error("["+activeProfile +"]/aws/v2/ 호출. info error ######");
        }
        else if (num == 0){
            log.warn("["+activeProfile +"]/aws/v2/ 호출. warn 로그 ######");
        }

        return "<h1>AWS 배포 v2.0</h1>";
    }
}
