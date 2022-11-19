package one.digitalinovation.parking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Parking {
  @Id
  private String id;
  private String license;
  private String state;
  private String model;
  private String color;
  private LocalDateTime entryDate;
  private LocalDateTime exitDate;
  private Double bill;
}
