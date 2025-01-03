package cc.k3521004.lengthserver.service;

import cc.k3521004.lengthserver.dto.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculateValue(InputDto inputDto) {
        double value = inputDto.getValue();
        String from = inputDto.getFrom();
        String to = inputDto.getTo();

        if (from.equals("Meter")) {
            if (to.equals("Kilometer")) {
                return (value / 1000);
            } else if (to.equals("Inch")){
                return (value * 39.37);
            } else if (to.equals("Centimeter")){
                return (value * 100);
            }
        } else if (from.equals("Kilometer")) {
            if (to.equals("Meter")) {
                return (value * 1000);
            } else if (to.equals("Inch")){
                return (value * 39370);
            } else if (to.equals("Centimeter")){
                return (value * 100000);
            }
        } else if (from.equals("Inch")) {
            if (to.equals("Meter")) {
                return (value / 39.37);
            } else if (to.equals("Kilometer")) {
                return (value / 39370);
            } else if (to.equals("Centimeter")){
                return (value * 2.54);
            }
        } else if (from.equals("Centimeter")) {
            if (to.equals("Meter")) {
                return (value / 100);
            } else if (to.equals("Inch")){
                return (value / 2.54);
            } else if (to.equals("Kilometer")){
                return (value /100000);
            }
        }

        throw new RuntimeException("Invalid from and to");
    }
}
