package config;

import model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = SqlConfig.class)
    @ActiveProfiles("test")
    public class SqlConfigTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void smoke() {
            assertThat(dataSource).isNotNull();
        }

        @Test
        public void selectAllCars() {
            NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
            List<Car> cars = template.query("SELECT * FROM carH2", (rs, rowNum) ->
                    new Car(rs.getInt("id"),rs.getString("brand"),
                            rs.getString("model"),rs.getInt("year"),
                            rs.getString("link")));

            assertThat(cars).hasSize(2);
        }
    }

