package one.digitalinovation.parking.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinovation.parking.model.ParkingMeter;

@Repository
public interface ParkingMeterRepository extends JpaRepository<ParkingMeter, LocalDate> {
  
  public Optional<ParkingMeter> findFirstByOrderByInitialDateDesc();
}
