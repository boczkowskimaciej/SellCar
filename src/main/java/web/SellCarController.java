package web;

import help.CarFilter;
import model.Car;
import model.Holder;
import model.Password;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CarService;
import service.HolderService;
import service.PasswordService;

@Controller
@RequestMapping("/display")
public class SellCarController {

    private CarService carService;
    private HolderService holderService;
    private PasswordService passwordService;

//    public SellCarController(CarService carService) {
//        this.carService = carService;
//    }
//
//    public SellCarController(HolderService holderService) {
//        this.holderService = holderService;
//    }


    public SellCarController(CarService carService, HolderService holderService, PasswordService passwordService) {
        this.carService = carService;
        this.holderService = holderService;
        this.passwordService = passwordService;
    }

    @GetMapping("")
    public String displayAllCars(Model model){
        model.addAttribute("allCars",carService.displayAllCars());
        return "car";
    }


    @PostMapping
    public String action(@ModelAttribute Car car,
                       Model model,
                       @RequestParam(name = "addCar", defaultValue = "") String requestAdd,
                       @RequestParam(name = "removeCar", defaultValue = "") String requestRemove,
                       @RequestParam(name = "login", defaultValue = "") String login,
                       @RequestParam(name = "search", defaultValue = "") String search){
        if (requestAdd.equals("addCar")){
            carService.addCar(car);
            model.addAttribute("allCars",carService.displayAllCars());
            return "redirect:display";
        }
        if (search.equals("search")){
            return "redirect:display/search";
        }
        if (login.equals("login")){
            return "redirect:display/login";
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

    @RequestMapping("/login")
    public String login(
            @RequestParam(name = "email", defaultValue = "") String email,
            @RequestParam(name = "password", defaultValue = "") String password,
            @RequestParam(name = "register", defaultValue = "") String register){
        if (register.equals("register")){
//            return "redirect:register";
            return "redirect:login/register";
        }
        return "login";
    }

    @RequestMapping("login/register")
    public String register(
            @ModelAttribute Holder holder,
//            @ModelAttribute Password password,
            @RequestParam(name = "password", defaultValue = "") String password,
            @RequestParam(name = "register", defaultValue = "") String register){

        if (register.equals("register")){
            holderService.addHolder(holder);
            passwordService.addPassword(new Password(password,holder));
//            passwordService.addPassword(password);
            return "registered";
        }

        return "register";
    }

    @RequestMapping("/search")
    public String displayAllCarsFilter(Model model1,
                                       @ModelAttribute CarFilter carFilter) {
        model1.addAttribute("allCars",carService.searchBy(carFilter));
        //start
//        if (carFilter.getBrand() == null && (carFilter.getModel()) == null && (carFilter.getYearFrom() == 0)
//                && (carFilter.getYearTo() == 0) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 0)) {
//            model1.addAttribute("allCars", carService.displayAllCars());
//        }
//
//            else {
//            //all
//            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
//                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.displayAllCars());
//            }
//
//            //brand
//            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900)
//                    && (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByBrand(carFilter.getBrand()));
//            }
//
//            //model
//            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900) &&
//                    (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByModel(carFilter.getModel()));
//            }
//
//            //brand, model
//            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && (carFilter.getYearFrom() == 1900) &&
//                    (carFilter.getYearTo() == 2018) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByBrandAndModel(carFilter.getBrand(), carFilter.getModel()));
//            }
//
//            //year
//            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByYear(carFilter.getYearFrom(), carFilter.getYearTo()));
//            }
//
//            //brand, year
//            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByBrandAndYear(carFilter.getBrand(), carFilter.getYearFrom(), carFilter.getYearTo()));
//            }
//
//            //model, year
//            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByModelAndYear(carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo()));
//            }
//
//            //brand, model, year
//            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && (carFilter.getPriceFrom() == 0) && (carFilter.getPriceTo() == 2147483647)) {
//                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYear(carFilter.getBrand(), carFilter.getModel(), carFilter.getYearFrom(), carFilter.getYearTo()));
//            }
//
//            // price
//            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByPrice(carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            //brand, price
//            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByBrandAndPrice(carFilter.getBrand(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            //model, price
//            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByModelAndPrice(carFilter.getModel(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            //year, price
//            if (carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByYearAndPrice(carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            // brand,model,price
//            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByBrandAndModelAndPrice(carFilter.getModel(),carFilter.getModel(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            // brand, year, price
//            if (!carFilter.getBrand().equals("all") && (carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByBrandAndYearAndPrice(carFilter.getBrand(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//
//            // model, year, price
//            if (carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByModelAndYearAndPrice(carFilter.getModel(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//            // brand, model, year, price
//            if (!carFilter.getBrand().equals("all") && (!carFilter.getModel().equals("all")) && ((carFilter.getYearFrom() != 1900) ||
//                    (carFilter.getYearTo() != 2018)) && ((carFilter.getPriceFrom() > 0) || (carFilter.getPriceTo() < 2147483647))) {
//                model1.addAttribute("allCars", carService.searchByBrandAndModelAndYearAndPrice(carFilter.getBrand(),carFilter.getModel(),carFilter.getYearFrom(),carFilter.getYearTo(),carFilter.getPriceFrom(),carFilter.getPriceTo()));
//            }
//        }
        return "carSearch";
    }






}
