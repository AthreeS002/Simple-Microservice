package cc.k3521004.orchestratorserver.controller;

import cc.k3521004.orchestratorserver.dto.ResultDto;
import cc.k3521004.orchestratorserver.dto.TransferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class GateController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/convert")
    public ResponseEntity<ResultDto> convert(@RequestBody TransferDto transferDto) {
        ServiceInstance serviceInstance;
        String endpoint;

        if("Celcius".equalsIgnoreCase(transferDto.getFrom()) || "Fahrenheit".equalsIgnoreCase(transferDto.getFrom()) || "Kelvin".equalsIgnoreCase(transferDto.getFrom())) {
            serviceInstance = loadBalancerClient.choose("SuhuServer");
            endpoint = "/api/convert-temperature";
        } else {
            serviceInstance = loadBalancerClient.choose("LengthServer");
            endpoint = "/api/convert-length";
        }

        String selectedServiceInstanceUri = serviceInstance.getUri().toString();
        String url = selectedServiceInstanceUri + endpoint;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> response = restTemplate.postForEntity(url, transferDto, ResultDto.class);

        ResultDto resultDto = response.getBody();
        return ResponseEntity.ok(resultDto);
    }


}
