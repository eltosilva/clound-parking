package one.digitalinovation.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinovation.parking.controller.dto.ParkingCreatedTO;
import one.digitalinovation.parking.controller.dto.ParkingDTO;
import one.digitalinovation.parking.controller.mapper.ParkingMapper;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.service.ParkingService;

@RestController
@RequestMapping("/parkings")
@Api("Parking Controller")
public class ParkingController {
  
  private final ParkingService parkingService;
  private final ParkingMapper parkingMapper;

  public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper){
    this.parkingService = parkingService;
    this.parkingMapper = parkingMapper;
  }
  @GetMapping
  @ApiOperation("Find all parkings")
  public ResponseEntity<List<ParkingDTO>> findAll(){

    List<Parking> parkingList = parkingService.findAll();
    List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);

    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  @ApiOperation("Find one parking by id")
  public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
    ParkingDTO result = parkingMapper.toParkingDTO(parkingService.findById(id));

    return ResponseEntity.ok(result);
  }

  @PostMapping
  @ApiOperation("Create new parking")
  public ResponseEntity<ParkingDTO> create (@RequestBody ParkingCreatedTO dto){
    Parking parkingCreate = parkingMapper.toParking(dto);
    Parking parking = parkingService.create(parkingCreate);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);

    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @DeleteMapping("/{id}")
  @ApiOperation("Delete one parking")
  public ResponseEntity<String> delete(@PathVariable String id){
    parkingService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ParkingDTO> exit(@PathVariable String id){
    Parking parking = parkingService.exit(id);
    ParkingDTO parkingDTO = parkingMapper.toParkingDTO(parking);

    return ResponseEntity.ok(parkingDTO);
  }

  @PutMapping("/{id}")
  @ApiOperation("Update one parking")
  public ResponseEntity<ParkingDTO> update (@PathVariable String id, @RequestBody ParkingCreatedTO dto){
    Parking parkingCreate = parkingMapper.toParking(dto);
    Parking parking = parkingService.update(id, parkingCreate);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);

    return ResponseEntity.ok(result);
  }

}