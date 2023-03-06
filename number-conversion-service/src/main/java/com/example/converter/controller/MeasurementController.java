package com.example.converter.controller;

import com.example.converter.model.Measurement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.converter.model.Measurement;

@RestController
@CrossOrigin("*")
@RequestMapping("/measurement")
public class MeasurementController {

    Measurement measurement1=new Measurement();

    @PostMapping("/")
    public ResponseEntity<?> postData(@RequestBody Measurement measurement)
    {
        measurement1.setFrom(measurement.getFrom());
        measurement1.setTo(measurement.getTo());
        measurement1.setInput(measurement.getInput());
        measurement1.setType(measurement.getType());
        return getMeasurement(measurement1);
    }

    public ResponseEntity<?> getMeasurement(Measurement measurement1)
    {

        if(measurement1.getType().equals("Mass")){
            if(measurement1.getFrom().equals("Kilogram")){
                if(measurement1.getTo().equals("Gram"))
                {
                    return ResponseEntity.ok(measurement1.getInput()*1000);
                }
            }
            else if(measurement1.getFrom().equals("Gram"))
            {
                if(measurement1.getTo().equals("Kilogram"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/1000);
                }
            }
        }
        else if(measurement1.getType().equals("Measurement"))
        {
            if(measurement1.getFrom().equals("Feet"))
            {
                if(measurement1.getTo().equals("Inch"))
                {
                    return ResponseEntity.ok(measurement1.getInput()*12);
                }
            } else if (measurement1.getFrom().equals("Inch")) {
                if(measurement1.getTo().equals("Feet"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/12);
                }

            }

        }
        else if(measurement1.getType().equals("Distance"))
        {
            if(measurement1.getFrom().equals("Kilometer"))
            {
                if(measurement1.getTo().equals("Meter"))
                {
                    return ResponseEntity.ok(measurement1.getInput()*1000);
                }
                else if(measurement1.getTo().equals("Centimeter"))
                {
                    return ResponseEntity.ok(measurement1.getInput()*100000);
                }
                else if(measurement1.getTo().equals("Milimeter")) {
                    return ResponseEntity.ok(measurement1.getInput()*1000000);
                }

            } else if (measurement1.getFrom().equals("Meter")) {

                 if(measurement1.getTo().equals("Centimeter"))
                {
                    return ResponseEntity.ok(measurement1.getInput()*100);
                }
                else if(measurement1.getTo().equals("Milimeter")) {
                    return ResponseEntity.ok(measurement1.getInput()*10000);
                }
                else if(measurement1.getTo().equals("KiloMeter"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/1000);
                }


            }
            else if (measurement1.getFrom().equals("Centimeter")) {
                if(measurement1.getTo().equals("Meter")){
                    return ResponseEntity.ok((double)measurement1.getInput()/100);
                }
                else if(measurement1.getTo().equals("Milimeter")) {
                    return ResponseEntity.ok(measurement1.getInput()*10);
                }
                else if(measurement1.getTo().equals("Kilometer"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/100000);
                }
            }
            else if (measurement1.getFrom().equals("Milimeter")) {
                if(measurement1.getTo().equals("Meter"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/10000);
                }
                else if(measurement1.getTo().equals("Kilometer"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/1000000);
                }
                else if(measurement1.getTo().equals("Centimeter"))
                {
                    return ResponseEntity.ok((double)measurement1.getInput()/10);
                }
            }

        }
        return ResponseEntity.ok(0);
    }
}
