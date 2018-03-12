package web;

import model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import service.CarService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes = {Config.class})
//@WebAppConfiguration
public class SellCarControllerTest {

//    @Mock
//    private CarService carService;

    CarService carService = mock(CarService.class);
    private MockMvc mockMvc;


    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        SellCarController controller = new SellCarController(carService);
        mockMvc = standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }


    @Test
    public void displayAllCars() throws Exception {
        given(carService.displayAllCars()).willReturn(Collections.emptyList());

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Ferrari", "F40", 1990, "www.ferrari.pl", 256000));
//        carList.add(new Car("Porsche","Macan",2016,"www.porsche.pl",199000));
//        carList.add(new Car("Maseratti","Quatroporte",2010,"www.maseratti.pl",65500));

        given(carService.displayAllCars()).willReturn(carList);

//        mockMvc.perform(get("/display")).andExpect(status().isOk());
        mockMvc.perform(get("/display")).andExpect(status().isOk()).andExpect(content()
                .json("[{brand:'Ferrari',model:'F40',year:1990,link:'www.ferrari.pl',price:256000}]"));
    }

    @Test
    public void action() throws Exception {
    }

    @Test
    public void displayAllCarsFilter() throws Exception {

    }

}