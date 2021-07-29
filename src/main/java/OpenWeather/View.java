package OpenWeather;

import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class View {

    public void start() throws ParseException, java.text.ParseException {
        boolean exit = false;
        do {
            System.out.println("Выберите номер пункта меню:");
            System.out.println("1. Узнать максимальное давление за предстоящие 5 дней");
            System.out.println("2. Узнать день с минимальной разницей между ночной и утренней температурой");
            System.out.println("3. Выход");

            int choice = scanner().nextInt();
            switch (choice) {
                case 1:
                    DateTempPres dateTempPres = new DataGetter().getMaxPressure();
                    System.out.println("Максимальное давление за предстоящие 5 дней = " +
                            dateTempPres.getPres() + ".\n" +
                            "Дата: " +
                            dateTempPres.getDate() + "\n");
                    break;
                case 2:
                    System.out.println(new DataGetter().getMinTempDif());
                    break;
                case 3:
                    exit = true;
            }
        } while (!exit);
    }

    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
