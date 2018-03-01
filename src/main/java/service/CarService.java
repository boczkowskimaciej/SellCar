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
                carModel.getModel(),carModel.getYear(),carModel.getLink());
    }

    public Car fromEntityToModel(CarEntity carEntity){
        return new Car(carEntity.getId(), carEntity.getBrand(),carEntity.getModel(),
                carEntity.getYear(),carEntity.getLink());
    }

    public List<Car> fromEntityToModel(List<CarEntity> carEntity){
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carEntity.size(); i++) {
            carList.add(fromEntityToModel(carEntity.get(i)));
        }
        return carList;
    }

}
