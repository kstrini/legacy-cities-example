package io.pivotal.cna.config.root;

import io.pivotal.cna.config.data.LocalJpaRepositoryConfig;
import io.pivotal.cna.repositories.CityRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {CityRepository.class, LocalJpaRepositoryConfig.class})
public class RepositoryConfig {}