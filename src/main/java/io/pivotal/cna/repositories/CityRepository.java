package io.pivotal.cna.repositories;

import io.pivotal.cna.domain.City;
import io.pivotal.cna.repositories.CityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>
{
    City findByNameContainsIgnoreCase(@Param("q") String name);
}