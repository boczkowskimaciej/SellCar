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
                       @RequestParam(name = "searchByBrand", defaultValue = "") String requestSearchByBrand,
                       @RequestParam(name = "searchByBrandValue", defaultValue = "") String requestSearchByBrandValue){
        if (requestAdd.equals("addCar")){
            carService.addCar(car);
            model.addAttribute("allCars",carService.displayAllCars());
            return "redirect:display";
        }
        if (requestSearchByBrand.equals("searchByBrand")){
            return "redirect:display/brand";
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

    @RequestMapping("/brand")
    public String displayAllCarsFilterByBrand(Model model,
                                              @RequestParam(name = "searchByBrandValue", defaultValue = "") String brand){
        model.addAttribute("allCars",carService.searchByBrand(brand));
        return "carSearch";
    }


}
