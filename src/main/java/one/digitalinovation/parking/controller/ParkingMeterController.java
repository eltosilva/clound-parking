package one.digitalinovation.parking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.parking.controller.dto.ParkingMeterDTO;
import one.digitalinovation.parking.controller.mapper.ParkingMeterMapper;
import one.digitalinovation.parking.model.ParkingMeter;
import one.digitalinovation.parking.service.ParkingMeterService;

@RestController
@RequestMapping("/parkingmeter")
public class ParkingMeterController {
  
  private ParkingMeterService parkingMeterService;
  private ParkingMeterMapper parkingMeterMapper;

  public ParkingMeterController(ParkingMeterService parkingMeterService, ParkingMeterMapper parkingMeterMapper){
    this.parkingMeterService = parkingMeterService;
    this.parkingMeterMapper = parkingMeterMapper;
  }

  @PostMapping
  public ResponseEntity<ParkingMeter> create(@RequestBody ParkingMeterDTO parkingMeterDTO){
    ParkingMeter parkingMeter = parkingMeterMapper.toParkingMeter(parkingMeterDTO);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingMeterService.create(parkingMeter));
  }

  @GetMapping
  public ResponseEntity<ParkingMeter> currentTable(){
    return ResponseEntity.ok(parkingMeterService.currentTable());
  }
}
