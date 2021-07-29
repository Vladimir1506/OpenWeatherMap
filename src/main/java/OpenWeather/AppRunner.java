package OpenWeather;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AppRunner {
    public static void main(String[] args) throws ParseException, java.text.ParseException, IOException {
        new View().start();
    }
}
