package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN

@Getter
@NoArgsConstructor
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("не получилось сериализовать");
        }
        return s;
    }

    public static Car unserialize(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = null;
        try {
            car = objectMapper.readValue(json, Car.class);
        } catch (IOException e) {
            System.out.println("не получилось десериализовать");
        }
        return car;
    }
    // END
}
