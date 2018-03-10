package web;

import help.CarFilter;
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
    public String displayAllCarsFilter(Model model1,
                                       @ModelAttribute CarFilter carFilter) {

        if (carFilter.getBrand() == null && (carFilter.getModel()) == null && (carFilter.getYearFrom() == 0)
                && (carFilter.getYearTo() == 0) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 0)) {
            model1.addAttribute("allCars", carService.displayAllCars());
        }

            else {
            //all
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.displayAllCars());
            }

            //brand
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrand(carFilter.getBrand()));
            }

            //model
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900) &&
                    (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByModel(carFilter.getModel()));
            }

            //brand, model
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900) &&
                    (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndModel(carFilter.getBrand(), carFilter.getModel()));
            }

            //year
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByYear(carFilter.getYearFrom(), carFilter.getYearTo()));
            }

            //brand, year
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndYear(carFilter.getBrand(), carFilter.getYearFrom(), carFilter.getYearTo()));
            }

            //model, year
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByModelAndYear(carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo()));
            }

            //brand, model, year
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYear(carFilter.getBrand(), carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo()));
            }

            // price
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByPrice(carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            //brand, price
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndPrice(carFilter.getBrand(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            //model, price
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByModelAndPrice(carFilter.getModel(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            //year, price
            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByYearAndPrice(carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            // brand,model,price
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndPrice(carFilter.getModel(),carFilter.getModel(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            // brand, year, price
            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndYearAndPrice(carFilter.getBrand(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }

            // model, year, price
            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByModelAndYearAndPrice(carFilter.getModel(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }
            // brand, model, year, price
            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYearAndPrice(carFilter.getBrand(),carFilter.getModel(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
            }
        }
        return "carSearch";
    }






}
