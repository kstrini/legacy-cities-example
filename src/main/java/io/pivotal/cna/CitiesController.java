package io.pivotal.cna;

import io.pivotal.cna.domain.City;
import io.pivotal.cna.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class CitiesController extends HttpServlet
{

    private static final String NAME = "name";


    private CityRepository repository;

    @Autowired
    public CitiesController(CityRepository repository) {this.repository = repository;}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    {

        String name = Optional.ofNullable(req.getSession(false))
                .map(session -> (String) session.getAttribute(NAME))
                .orElse("San Diego");

        String foundZip = repository.findByNameContainsIgnoreCase(name).getPostalCode();

        try (ServletOutputStream out = resp.getOutputStream())
        {
            out.write(foundZip.getBytes(StandardCharsets.UTF_8));
            out.flush();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        String name = req.getParameter("name");
        City city = new City();
        city.setName(name);
        city.setCounty("Demo");
        city.setStateCode("Demo");
        city.setPostalCode("Demo");
        city.setLatitude("Demo");
        city.setLongitude("Demo");
        repository.save(city);
    }
}
