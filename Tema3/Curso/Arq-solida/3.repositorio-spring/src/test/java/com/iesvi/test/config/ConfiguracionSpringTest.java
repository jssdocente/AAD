package com.iesvi.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.iesvi.services","com.iesvi.repos.generic"})
@Import({ConfiguracionPersistenciaTest.class})
public class ConfiguracionSpringTest {


}
