package one.digitalinovation.parking.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.digitalinovation.parking.exception.ParkingNotFoundException;
import one.digitalinovation.parking.model.Parking;

@Service
public class ParkingService{

  private static final Map<String, Parking> parkingMap = new HashMap<>();

  static{
    Parking parking = new Parking(getUUID(), "DMS-1111", "SC", "CELTA", "PRETO", null, null, null);
    Parking parking1 = new Parking(getUUID(), "WAS-1234", "SP", "VW GOL", "VERMELHO", null, null, null);

    parkingMap.put(parking.getId(), parking);
    parkingMap.put(parking1.getId(), parking1);
  }

  private static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public List<Parking> findAll(){
    System.out.println(parkingMap.size());
    return parkingMap.values().stream().collect(Collectors.toList());
  }

  public Parking findById(String id){
    Parking parking = parkingMap.get(id);

    if(parking == null)
      throw new ParkingNotFoundException(id);
    
    return parking;
  }

  public Parking create(Parking parking) {
    parking.setId(getUUID());
    parking.setEntryDate(LocalDateTime.now());
    parkingMap.put(parking.getId(), parking);

    return parking;
  }
}