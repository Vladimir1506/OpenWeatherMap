package OpenWeather;

import org.json.simple.parser.ParseException;

import java.util.List;

public class DataGetter {
    private final String url = "https://api.openweathermap.org/data/2.5/forecast?id=617486&appid=6effb036fa67dc82c25b5fa162ec5c59&units=metric";
    List<DateTempPres> dateTempPres;

    public DataGetter() throws ParseException, java.text.ParseException {
        Parser parser = new Parser();
        String response = parser.parse(url);
        this.dateTempPres = new StrToJson().getDataList(response);
    }

    public MinTempDif getMinTempDif() {
        double difTemp;
        double minDifTemp = 100d;
        DateTempPres minMornDTP = null;
        DateTempPres minNightDTP = null;
        DateTempPres currentNightDTP = null;
        DateTempPres currentMornDTP = null;
        for (DateTempPres dtp :
                dateTempPres) {
            if (dtp.getDate().getHours() == 0) {
                currentNightDTP = dtp;
            }
            if (dtp.getDate().getHours() == 6) {
                currentMornDTP = dtp;
            }
            if (currentNightDTP != null &&
                    currentMornDTP != null &&
                    currentNightDTP.getDate().getDay() == currentMornDTP.getDate().getDay()) {
                difTemp = Math.abs(currentNightDTP.getTemp() - currentMornDTP.getTemp());
                if (difTemp < minDifTemp) {
                    minDifTemp = difTemp;
                    minMornDTP = currentMornDTP;
                    minNightDTP = currentNightDTP;
                }
            }
        }
        return new MinTempDif(minMornDTP, minNightDTP, minDifTemp);
    }

    public DateTempPres getMaxPressure() {
        Long maxPressure = 0L;
        Long currentPressure;
        DateTempPres maxPresDTP = null;
        for (DateTempPres dtp :
                dateTempPres) {
            currentPressure = dtp.getPres();
            if (currentPressure > maxPressure) {
                maxPressure = currentPressure;
                maxPresDTP = dtp;
            }
        }
        return maxPresDTP;
    }
}
