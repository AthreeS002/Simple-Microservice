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
            } else if (toUnit.equals("Reamur")) {
                return value * 4 / 5;
            }
        } else if (fromUnit.equals("Fahrenheit")){
            if (toUnit.equals("Celcius")){
                return (value - 32) * 5 / 9;
            } else if (toUnit.equals("Kelvin")) {
                return (value - 32) * 5 / 9 + 273.15;
            }  else if (toUnit.equals("Reamur")) {
                return (value - 32) * 4 / 9;
            }
        } else if (fromUnit.equals("Kelvin")){
            if(toUnit.equals("Celcius")){
                return value - 273.15;
            } else if (toUnit.equals("Fahrenheit")){
                return (value - 273.15) * 9 / 5 + 32;
            } else if (toUnit.equals("Reamur")) {
                return (value - 273.15) * 4 / 5;
            }
        } else if (fromUnit.equals("Reamur")){
            if(toUnit.equals("Celcius")){
                return value * 5 / 4;
            } else if (toUnit.equals("Fahrenheit")){
                return (value * 9 / 4) + 32;
            } else if (toUnit.equals("Kelvin")) {
                return (value * 5 / 4) + 273.15;
            }
        }

        throw new IllegalArgumentException("Invalid temperature units");
    }
}
