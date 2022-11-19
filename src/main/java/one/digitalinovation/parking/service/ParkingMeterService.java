package one.digitalinovation.parking.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.model.ParkingMeter;
import one.digitalinovation.parking.repository.ParkingMeterRepository;

@Service
public class ParkingMeterService {
  
  private ParkingMeterRepository parkingMeterRepository;

  public ParkingMeterService(ParkingMeterRepository parkingMeterRepository){
    this.parkingMeterRepository = parkingMeterRepository;
  }

  public ParkingMeter create(ParkingMeter parkingMeter){
    parkingMeter.setInitialDate(LocalDate.now());
    parkingMeterRepository.save(parkingMeter);

    return parkingMeter;
  }

  public ParkingMeter currentTable(){
    Optional<ParkingMeter> parkingMeter = parkingMeterRepository.findFirstByOrderByInitialDateDesc();

    return parkingMeter.get();
  }

  public Double getBill(Parking parking){
    ParkingMeter parkingMeter = currentTable();

    return parkingMeter.getBill(parking);
  }
}
