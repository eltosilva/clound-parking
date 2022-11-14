package one.digitalinovation.parking.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.parking.controller.dto.ParkingDTO;
import one.digitalinovation.parking.controller.mapper.ParkingMapper;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.service.ParkingService;

@RestController
@RequestMapping("/parkings")
public class ParkingController {
  
  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper){
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }
  @GetMapping
  public List<ParkingDTO> findAll(){

    List<Parking> parkingList = this.parkingService.findAll();
    
    return this.parkingMapper.toParkingDTOList(parkingList);
    
  }
}
