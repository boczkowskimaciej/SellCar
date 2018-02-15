package web;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CarService;

@Controller
//@RequestMapping("/car")
public class SellCarController {

    private CarService carService;

    public SellCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/display")
    public String displayAllCars(Model model){
        model.addAttribute("allCars",carService.displayAllCars());
        return "car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, Model model){
        carService.addCar(car);
        model.addAttribute("allCars", carService.displayAllCars());
        return "car";
    }
//    @RequestMapping
//    public String testController(@ModelAttribute Car car, Model model){
//        model.addAttribute("car",car);
//
//        return "car";
//    }
}
