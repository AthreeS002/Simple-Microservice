package cc.k3521004.lengthserver.controller;

import cc.k3521004.lengthserver.dto.InputDto;
import cc.k3521004.lengthserver.dto.OutputDto;
import cc.k3521004.lengthserver.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/api/convert-length")
    public ResponseEntity convertLength(@RequestBody InputDto inputDto) {
        double result = calculatorService.calculateValue(inputDto);

        OutputDto outputDto = new OutputDto();
        outputDto.setValue(inputDto.getValue());
        outputDto.setFrom(inputDto.getFrom());
        outputDto.setTo(inputDto.getTo());
        outputDto.setResult(result);

        return ResponseEntity.ok(outputDto);
    }
}
