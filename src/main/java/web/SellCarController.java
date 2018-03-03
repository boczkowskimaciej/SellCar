package web;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CarService;

@Controller
@RequestMapping("/display")
public class SellCarController {

    private CarService carService;

    public SellCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public String displayAllCars(Model model){
        model.addAttribute("allCars",carService.displayAllCars());
        return "car";
    }

//    @PostMapping
//    public String addCar(@ModelAttribute Car car, Model model,
//                         @RequestParam(name = "addCar", defaultValue = "") String requestAdd){
//        if (requestAdd.equals("addCar")){
//            carService.addCar(car);
//            model.addAttribute("allCars",carService.displayAllCars());
//        }
//        return "redirect:display";
//    }


//    @PostMapping
//    public String removeCar(Model model,
//                             @RequestParam(name = "removeCar", defaultValue = "") String requestRemove){
//                carService.removeCarById(Long.valueOf(requestRemove));
//                model.addAttribute("allCars",carService.displayAllCars());
//        return "redirect:display";
//    }

    @PostMapping
    public String action(@ModelAttribute Car car,
                       Model model,
                       @RequestParam(name = "addCar", defaultValue = "") String requestAdd,
                       @RequestParam(name = "removeCar", defaultValue = "") String requestRemove,
                       @RequestParam(name = "search", defaultValue = "") String search){
        if (requestAdd.equals("addCar")){
            carService.addCar(car);
            model.addAttribute("allCars",carService.displayAllCars());
            return "redirect:display";
        }
        if (search.equals("search")){
            return "redirect:display/search";
        }

        if (Long.valueOf(requestRemove) != null){
            carService.removeCarById(Long.valueOf(requestRemove));
            model.addAttribute("allCars",carService.displayAllCars());
            return "redirect:display";
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    @RequestMapping("/search")
    public String displayAllCarsFilterByBrand(Model model1,
                                              @RequestParam(name = "brand", defaultValue = "all") String brand,
                                              @RequestParam(name = "model", defaultValue = "all") String model,
                                              @ModelAttribute Car car){

        if (brand.equals("all") || (model.equals("all"))){
            if (brand.equals("all")){
                model1.addAttribute("allCars",carService.displayAllCars());}
            if (model.equals("all")){
                model1.addAttribute("allCars",carService.displayAllCars());}
            return "carSearch";
        }

        if (brand.equals(car.getBrand())) {
            model1.addAttribute("allCars", carService.searchByBrand(brand));
        }
        if (model.equals(car.getModel())) {
            model1.addAttribute("allCars", carService.searchByModel(model));
        }

        return "carSearch";
    }



}
