package repository;


import entity.CarEntity;
import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE brand LIKE ?1%")
    List<CarEntity> searchByBrand(String brand);

    @Query("SELECT c FROM CarEntity c WHERE model LIKE ?1%")
    List<CarEntity> searchByModel(String model);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model LIKE ?2%")
    List<CarEntity> searchByBrandAndModel(String brand,String model);

    @Query("SELECT c FROM CarEntity c WHERE c.year >= ?1 and c.year <= ?2 ")
    List<CarEntity> searchByYear(int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1%  and year >=?2 and year <=?3")
    List<CarEntity> searchByBrandAndYear(String brand,int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE model LIKE ?1% and year >=?2 and year <=?3")
    List<CarEntity> searchByModelAndYear(String model,int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model LIKE ?2% and year >=?3 and year <=?4")
    List<CarEntity> searchByBrandAndModelAndYear(String brand,String model,int yearFrom, int yearTo);

    @Query("SELECT c FROM CarEntity c WHERE c.price >= ?1 and c.price <= ?2 ")
    List<CarEntity> searchByPrice(int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and c.price >= ?2 and c.price <= ?3 ")
    List<CarEntity> searchByBrandAndPrice(String brand,int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE model like ?1% and c.price >= ?2 and c.price <= ?3 ")
    List<CarEntity> searchByModelAndPrice(String model,int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE c.year >= ?1 and c.year <= ?2 and c.price >= ?3 and c.price <= ?4 ")
    List<CarEntity> searchByYearAndPrice(int yearFrom,int yearTo,int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model like ?2% and c.price >= ?3 and c.price <= ?4 ")
    List<CarEntity> searchByBrandAndModelAndPrice(String brand,String model, int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and c.year >= ?2 and c.year <= ?3 and c.price >= ?4 and c.price <= ?5 ")
    List<CarEntity> searchByBrandAndYearAndPrice(String brand, int yearFrom,int yearTo,int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE model like ?1% and c.year >= ?2 and c.year <= ?3 and c.price >= ?4 and c.price <= ?5 ")
    List<CarEntity> searchByModelAndYearAndPrice(String model, int yearFrom,int yearTo,int priceFrom,int priceTo);

    @Query("SELECT c FROM CarEntity c WHERE brand like ?1% and model like ?2% and c.year >= ?3 and c.year <= ?4 and c.price >= ?5 and c.price <= ?6 ")
    List<CarEntity> searchByBrandAndModelAndYearAndPrice(String brand,String model, int yearFrom,int yearTo,int priceFrom,int priceTo);


}

