package one.digitalinovation.parking.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ParkingMeter {
  private final int ONE_HOUR = 60;
  private final int ONE_DAY = 24 * ONE_HOUR;

  @Id
  @Getter @Setter
  private LocalDate initialDate;
  @Getter @Setter
  private Double oneHourValue;
  @Getter @Setter
  private Double additionalPerHourValue;
  @Getter @Setter
  private Double dayValue;

  public Double getBill(Parking parking){
    return getBill(parking.getEntryDate(), parking.getExitDate());
  }

  private Double getBill (LocalDateTime entryDate, LocalDateTime exitDate){
    long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
    long days = minutes / ONE_DAY;
    long hours = (minutes % ONE_DAY) / ONE_HOUR;
    return days * dayValue + hours * additionalPerHourValue + oneHourValue;
  }
}
