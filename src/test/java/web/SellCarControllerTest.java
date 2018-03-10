package web;

import config.Config;
import entity.CarEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import repository.CarRepository;
import service.CarService;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
@WebAppConfiguration
public class SellCarControllerTest {

    @Autowired
    private CarRepository carRepository;
    private CarService carService = new CarService(carRepository);
    private SellCarController controller = new SellCarController(carService);
    private MockMvc mockMvc;


    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        mockMvc = standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }


    @Test
    public void displayAllCars() throws Exception {
        MvcResult result = mockMvc.perform(get("/display")).andExpect(status().isOk()).andReturn();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("car");
        softly.assertThat(carService.displayAllCars()).hasSize(0);
        softly.assertAll();
    }

    @Test
    public void action() throws Exception {
    }

    @Test
    public void displayAllCarsFilter() throws Exception {
    }

}