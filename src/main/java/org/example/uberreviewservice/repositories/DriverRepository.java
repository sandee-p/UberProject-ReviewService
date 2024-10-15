package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


    Optional<Driver> findByIdAndLicenseNumber(Long aLong,String licenseNumber);

/*    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);

    @Query("SELECT d from Driver d where d.id = :id AND d.licenseNumber = :ln")
    Optional<Driver> rawFindByIdAndLicense(Long id, String ln);*/

    List<Driver> findAllByIdIn(List<Long> ids);

}
