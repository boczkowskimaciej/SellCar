package service;

import entity.CarEntity;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

//    public CarService() {
//    }

//    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car){
        carRepository.save(fromModelToEntity(car));
    }

    public void removeCar(Car car){
        carRepository.delete(fromModelToEntity(car));
    }

    public void removeCarById(Long id){
        carRepository.deleteById(id);
    }

    public List<Car> displayAllCars(){
        return fromEntityToModel(carRepository.findAll());
    }


    public CarEntity fromModelToEntity(Car carModel){
        return new CarEntity(carModel.getId(),carModel.getBrand(),
                carModel.getModel(),carModel.getYear(),carModel.getLink(),carModel.getPrice());
    }

    public Car fromEntityToModel(CarEntity carEntity){
        return new Car(carEntity.getId(), carEntity.getBrand(),carEntity.getModel(),
                carEntity.getYear(),carEntity.getLink(),carEntity.getPrice());
    }

    public List<Car> fromEntityToModel(List<CarEntity> carEntity){
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carEntity.size(); i++) {
            carList.add(fromEntityToModel(carEntity.get(i)));
        }
        return carList;
    }

    public List<Car> searchByBrand(String brand){
        return fromEntityToModel(carRepository.searchByBrand(brand));
    }

    public List<Car> searchByModel(String model){
        return fromEntityToModel(carRepository.searchByModel(model));
    }

    public List<Car> searchByBrandAndModel(String brand,String model){
        return fromEntityToModel(carRepository.searchByBrandAndModel(brand,model));
    }

    public List<Car> searchByYear(int yearFrom,int yearTo){
        return fromEntityToModel(carRepository.searchByYear(yearFrom,yearTo));
    }
    public List<Car> searchByBrandAndYear(String brand,int yearFrom,int yearTo){
        return fromEntityToModel(carRepository.searchByBrandAndYear(brand,yearFrom,yearTo));
    }
    public List<Car> searchByModelAndYear(String model,int yearFrom,int yearTo){
        return fromEntityToModel(carRepository.searchByModelAndYear(model,yearFrom,yearTo));
    }
    public List<Car> searchByBrandAndModelAndYear(String brand,String model,int yearFrom,int yearTo){
        return fromEntityToModel(carRepository.searchByBrandAndModelAndYear(brand,model,yearFrom,yearTo));
    }

    public List<Car> searchByPrice(int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByPrice(priceFrom,priceTo));
    }
    public List<Car> searchByBrandAndPrice(String brand,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByBrandAndPrice(brand,priceFrom,priceTo));
    }
    public List<Car> searchByModelAndPrice(String model,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByModelAndPrice(model,priceFrom,priceTo));
    }
    public List<Car> searchByYearAndPrice(int yearFrom,int yearTo,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByYearAndPrice(yearFrom,yearTo,priceFrom,priceTo));
    }
    public List<Car> searchByBrandAndModelAndPrice(String brand,String model,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByBrandAndModelAndPrice(brand,model,priceFrom,priceTo));
    }

    public List<Car> searchByBrandAndYearAndPrice(String brand,int yearFrom,int yearTo,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByBrandAndYearAndPrice(brand,yearFrom,yearTo,priceFrom,priceTo));
    }
    public List<Car> searchByModelAndYearAndPrice(String model,int yearFrom,int yearTo,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByModelAndYearAndPrice(model,yearFrom,yearTo,priceFrom,priceTo));
    }
    public List<Car> searchByBrandAndModelAndYearAndPrice(String brand,String model,int yearFrom,int yearTo,int priceFrom, int priceTo){
        return fromEntityToModel(carRepository.searchByBrandAndModelAndYearAndPrice(brand,model,yearFrom,yearTo,priceFrom,priceTo));
    }

}
