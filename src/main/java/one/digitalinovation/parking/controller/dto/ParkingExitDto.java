package one.digitalinovation.parking.controller.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ParkingExitDto {
  private LocalDateTime exitDate;
}
