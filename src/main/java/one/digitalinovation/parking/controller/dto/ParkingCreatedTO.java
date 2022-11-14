package one.digitalinovation.parking.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingCreatedTO {
  private String license;
  private String state;
  private String model;
  private String color;
}
