package one.digitalinovation.parking.controller.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import one.digitalinovation.parking.controller.dto.ParkingMeterDTO;
import one.digitalinovation.parking.model.ParkingMeter;

@Component
public class ParkingMeterMapper {
  
  private static final ModelMapper MODEL_MAPPER = new ModelMapper();

  public ParkingMeter toParkingMeter(ParkingMeterDTO parkingMeterDTO){
    return MODEL_MAPPER.map(parkingMeterDTO, ParkingMeter.class);
  }
}
