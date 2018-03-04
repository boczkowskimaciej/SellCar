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
                                              @RequestParam(name = "yearFrom", defaultValue = "1899") int yearFrom,
                                              @RequestParam(name = "yearTo", defaultValue = "2020") int yearTo,
                                              @ModelAttribute Car car){

            if (brand.equals("all") && (model.equals("all")) && (yearFrom == 1899) && (yearTo == 2020)) {
                model1.addAttribute("allCars",carService.displayAllCars());}

            if (brand.equals("all") || (model.equals("all")) || (yearFrom != 1899) || (yearTo != 2020)){
                if (!brand.equals("all") && (model.equals("all")) &&  (yearFrom == 1899) && (yearTo == 2020)){
                    model1.addAttribute("allCars",carService.searchByBrand(car.getBrand()));}

                if (brand.equals("all") && (!model.equals("all")) &&  (yearFrom == 1899) && (yearTo == 2020)){
                    model1.addAttribute("allCars",carService.searchByModel(car.getModel()));}

                if (!brand.equals("all") && (!model.equals("all")) &&  (yearFrom == 1899) && (yearTo == 2020)){
                    model1.addAttribute("allCars",carService.searchByBrandAndModel(car.getBrand(),car.getModel()));}

                if (brand.equals("all") && (model.equals("all")) &&  ((yearFrom != 1899) || (yearTo != 2020))){
                    model1.addAttribute("allCars",carService.searchByYear(yearFrom,yearTo));}

                if (!brand.equals("all") && (model.equals("all")) &&  ((yearFrom != 1899) || (yearTo != 2020))){
                    model1.addAttribute("allCars",carService.searchByBrandAndYear(car.getBrand(),yearFrom,yearTo));}

                if (brand.equals("all") && (!model.equals("all")) &&  ((yearFrom != 1899) || (yearTo != 2020))){
                    model1.addAttribute("allCars",carService.searchByModelAndYear(car.getModel(),yearFrom,yearTo));}

                if (!brand.equals("all") && (!model.equals("all")) &&  ((yearFrom != 1899) || (yearTo != 2020))){
                    model1.addAttribute("allCars",carService.searchByBrandAndModelAndYear(car.getBrand(),car.getModel(),yearFrom,yearTo));
                }
            }

        return "carSearch";
    }



}
