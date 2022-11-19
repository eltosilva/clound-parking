package one.digitalinovation.parking.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ParkingMeterDTO {
  private Double oneHourValue;
  private Double additionalPerHourValue;
  private Double dayValue;
}
