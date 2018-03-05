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
                                              @RequestParam(name = "priceFrom", defaultValue = "0") int priceFrom,
                                              @RequestParam(name = "priceTo", defaultValue = "2147483647") int priceTo,
                                              @ModelAttribute Car car) {

        if (brand.equals("all") && (model.equals("all")) && (yearFrom == 1899) && (yearTo == 2020) && (priceFrom == 0) && (priceTo == 2147483647)) {
            model1.addAttribute("allCars", carService.displayAllCars());
        }

        if (brand.equals("all") || (model.equals("all")) || (yearFrom != 1899) || (yearTo != 2020) || (priceFrom > 0) || (priceTo < 2147483647)) {
            //brand
            if (!brand.equals("all") && (model.equals("all")) && (yearFrom == 1899) && (yearTo == 2020) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrand(car.getBrand()));
            }

            //model
            if (brand.equals("all") && (!model.equals("all")) && (yearFrom == 1899) && (yearTo == 2020) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByModel(car.getModel()));
            }

            //brand, model
            if (!brand.equals("all") && (!model.equals("all")) && (yearFrom == 1899) && (yearTo == 2020) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndModel(car.getBrand(), car.getModel()));
            }

            //year
            if (brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByYear(yearFrom, yearTo));
            }

            //brand, year
            if (!brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndYear(car.getBrand(), yearFrom, yearTo));
            }

            //model, year
            if (brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByModelAndYear(car.getModel(), yearFrom, yearTo));
            }

            //brand, model, year
            if (!brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && (priceFrom == 0) && (priceTo == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYear(car.getBrand(), car.getModel(), yearFrom, yearTo));
            }

            // price
            if (brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByPrice(priceFrom,priceTo));
            }

            //brand, price
            if (!brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndPrice(car.getBrand(),priceFrom,priceTo));
            }

            //model, price
            if (brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByModelAndPrice(car.getModel(),priceFrom,priceTo));
            }

            //year, price
            if (brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByYearAndPrice(yearFrom,yearTo,priceFrom,priceTo));
            }

            // brand,model,price
            if (!brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndPrice(car.getModel(),car.getModel(),priceFrom,priceTo));
            }

            // brand, year, price
            if (!brand.equals("all") && (model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndYearAndPrice(car.getBrand(),yearFrom,yearTo,priceFrom,priceTo));
            }

            // model, year, price
            if (brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByModelAndYearAndPrice(car.getModel(),yearFrom,yearTo,priceFrom,priceTo));
            }
            // brand, model, year, price
            if (!brand.equals("all") && (!model.equals("all")) && ((yearFrom != 1899) || (yearTo != 2020)) && ((priceFrom > 0) || (priceTo < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYearAndPrice(car.getBrand(),car.getModel(),yearFrom,yearTo,priceFrom,priceTo));
            }
        }
        return "carSearch";
    }






}
