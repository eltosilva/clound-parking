package one.digitalinovation.parking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import one.digitalinovation.parking.exception.ParkingNotFoundException;
import one.digitalinovation.parking.model.Parking;
import one.digitalinovation.parking.repository.ParkingRepository;

@Service
public class ParkingService{

  private ParkingRepository parkingRepository;
  private ParkingMeterService parkingMeterService;

  public ParkingService(ParkingRepository parkingRepository, ParkingMeterService parkingCMeterService){
    this.parkingRepository = parkingRepository;
    this.parkingMeterService = parkingCMeterService;
  }

  private static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public List<Parking> findAll(){
    return parkingRepository.findAll();
  }

  public Parking findById(String id){
    Parking parking = parkingRepository
      .findById(id)
      .orElseThrow(() -> new ParkingNotFoundException(id));

    return parking;
  }

  public Parking create(Parking parking) {
    parking.setId(getUUID());
    parking.setEntryDate(LocalDateTime.now().minusHours(4));
    parkingRepository.save(parking);

    return parking;
  }

  public void delete(String id) {
    findById(id);
    parkingRepository.deleteById(id);
  }

  public Parking update(String id, Parking parkingCreate) {
    Parking parking = findById(id);
    parking.setLicense(parkingCreate.getLicense());
    parking.setModel(parkingCreate.getModel());
    parking.setState(parkingCreate.getState());
    parking.setColor(parkingCreate.getColor());
    
    parkingRepository.save(parking);
    return parking;
  }

  public Parking exit(String id) {
    Parking parking = findById(id);
    parking.setExitDate(LocalDateTime.now());

    parking.setBill(parkingMeterService.getBill(parking));
    parkingRepository.save(parking);

    return parking;
  }

  
}