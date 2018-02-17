package web;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CarService;

@Controller
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

    @PostMapping
    public String addCar(Model model, @RequestParam("brand") String brand,
                         @RequestParam("model") String modelCar,
                         @RequestParam("year") int year,
                         @RequestParam("link") String link,
                         @RequestParam("addCar") String request
                         ){
        Car car = new Car(brand,modelCar,year,link);
        if (request.equals("addCar")){
            carService.addCar(car);
            model.addAttribute("allCars",carService.displayAllCars());
        }
        return "redirect:display";
    }



//    @RequestMapping
//    public String testController(@ModelAttribute Car car, Model model){
//        model.addAttribute("car",car);
//
//        return "car";
//    }
}
