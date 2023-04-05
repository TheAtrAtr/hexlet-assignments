package exercise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> getPogoda(@PathVariable Long id) throws JsonProcessingException {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));
        String nane = city.getName();
        return weatherService.getPogo(nane);
    }

    @GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Map<String, String>> listCity(@RequestParam(value = "name", defaultValue = "") String name) throws JsonProcessingException {
        List<Map<String, String>> res = new ArrayList<>();
        Iterable<City> spisok_gorodov;
        if (name.equals("")) {
            spisok_gorodov = cityRepository.findAllByOrderByName();
        }
        else {
            spisok_gorodov = cityRepository.findByNameIgnoreCaseStartsWith(name);
        }

        for (var x : spisok_gorodov) {
            long id = x.getId();
            City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));
            String nane = city.getName();
            Map<String, String> pogo = weatherService.getPogo(nane);
            Map<String, String> map = Map.of(
                    "name", nane,
                    "temperature", pogo.get("temperature"));
            res.add(map);
        }
        return res;
    }
    // END
}

