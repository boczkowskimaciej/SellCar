package repository;


import entity.CarEntity;
import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE brand LIKE ?1%")
    List<CarEntity> searchByBrand(String brand);

    @Query("SELECT c FROM CarEntity c WHERE model LIKE ?1%")
    List<CarEntity> searchByModel(String model);
}