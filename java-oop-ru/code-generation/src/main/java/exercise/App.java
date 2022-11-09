package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {

    public static void save(Path path, Car car) {
        String s = car.serialize();
        try {
            Files.writeString(path, s, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("не получилось сохранить файл на диск");
        }
    }

    public static Car extract(Path path) {
        String s = null;
        try {
            s = Files.readString(path);
        } catch (IOException e) {
            System.out.println("не получилось прочитать файл с диска");
        }

        return Car.unserialize(s);
    }
}
// END
