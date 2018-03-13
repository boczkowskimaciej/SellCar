package service;

import entity.CarEntity;
import help.CarFilter;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

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

    public List<Car> searchBy(CarFilter carFilter){
        if (carFilter.getBrand() == null && (carFilter.getModel()) == null && (carFilter.getYearFrom() == 0)
                && (carFilter.getYearTo() == 0) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 0)) {
            return fromEntityToModel(carRepository.findAll());
        }
        else {
            //all
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.findAll());
            }

            //brand
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByBrand(carFilter.getBrand()));
            }

            //model
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByModel(carFilter.getModel()));
            }
            //brand, model
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900) &&
                    (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByBrandAndModel(carFilter.getBrand(), carFilter.getModel()));
            }
            //year
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByYear(carFilter.getYearFrom(), carFilter.getYearTo()));
            }
            //brand, year
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByBrandAndYear(carFilter.getBrand(), carFilter.getYearFrom(), carFilter.getYearTo()));
            }
            //model, year
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByModelAndYear(carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo()));
            }
            //brand, model, year
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                return fromEntityToModel(carRepository.searchByBrandAndModelAndYear(carFilter.getBrand(), carFilter.getModel(),
                        carFilter.getYearFrom(), carFilter.getYearTo()));
            }
            // price
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByPrice(carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            //brand, price
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByBrandAndPrice(carFilter.getBrand(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            //model, price
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByModelAndPrice(carFilter.getModel(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            //year, price
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByYearAndPrice(carFilter.getYearFrom(), carFilter.getYearTo(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            // brand,model,price
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByBrandAndModelAndPrice(carFilter.getModel(), carFilter.getModel(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            // brand, year, price
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByBrandAndYearAndPrice(carFilter.getBrand(), carFilter.getYearFrom(), carFilter.getYearTo(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            // model, year, price
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByModelAndYearAndPrice(carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
            // brand, model, year, price
        else {
//                if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                return fromEntityToModel(carRepository.searchByBrandAndModelAndYearAndPrice(carFilter.getBrand(), carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo(), carFilter.getPriceFrom(), carFilter.getPriceTo()));
            }
        }
    }



}
