package service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    List<Car> carList = new ArrayList<>();

    public CarService() {

    }

    public void addCar(Car car){
        carList.add(car);
    }

    public void removeCar(Car car){
        carList.remove(car);
    }

    public List<Car> displayAllCars(){
        return carList;
    }

}
