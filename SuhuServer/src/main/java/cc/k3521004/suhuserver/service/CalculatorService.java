package cc.k3521004.suhuserver.service;

import cc.k3521004.suhuserver.dto.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculateValue(InputDto inputDto) {
        double value = inputDto.getValue();
        String fromUnit = inputDto.getFrom();
        String toUnit = inputDto.getTo();
        if (fromUnit.equals("Celcius")){
            if (toUnit.equals("Fahrenheit")){
                return (value * 9 / 5) + 32;
            } else if (toUnit.equals("Kelvin")) {
                return value + 273.15;
            }
        } else if (fromUnit.equals("Fahrenheit")){
            if (toUnit.equals("Celcius")){
                return (value - 32) * 5 / 9;
            } else if (toUnit.equals("Kelvin")) {
                return (value - 32) * 5 / 9 + 273.15;
            }
        } else if (fromUnit.equals("Kelvin")){
            if(toUnit.equals("Celcius")){
                return value - 273.15;
            } else if (toUnit.equals("Fahrenheit")){
                return (value - 273.15) * 9 / 5 + 32;
            }
        }

        throw new IllegalArgumentException("Invalid temperature units");
    }
}
