package upec.episen.eco.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import upec.episen.eco.controllers.User.UserController;

@TestConfiguration
@ComponentScan(
    basePackages = "upec.episen.eco",
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = UserController.class
    )
)
public class TestAppConfig {}
