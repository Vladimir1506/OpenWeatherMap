package OpenWeather;

public class MinTempDif {
    private DateTempPres mornDTP;
    private DateTempPres nightDTP;
    private Double minTempDif;

    public MinTempDif(DateTempPres mornDTP, DateTempPres nightDTP, Double minTempDif) {
        this.mornDTP = mornDTP;
        this.nightDTP = nightDTP;
        this.minTempDif = minTempDif;
    }


    public DateTempPres getMornDTP() {
        return mornDTP;
    }

    public void setMornDTP(DateTempPres mornDTP) {
        this.mornDTP = mornDTP;
    }

    public DateTempPres getNightDTP() {
        return nightDTP;
    }

    public void setNightDTP(DateTempPres nightDTP) {
        this.nightDTP = nightDTP;
    }

    public Double getMinTempDif() {
        return minTempDif;
    }

    public void setMinTempDif(Double minTempDif) {
        this.minTempDif = minTempDif;
    }

    @Override
    public String toString() {
        String cels = "\u2103";
        return "Минимальная разница между ночной и утренней температурой составляет "
                + getMinTempDif() + cels + ".\n" +
                "Приходится на следующие даты:" + "\n" +
                getNightDTP().getDate() + " Температура: " + getNightDTP().getTemp() + cels + "\n" +
                getMornDTP().getDate() + " Температура: " + getMornDTP().getTemp() + cels + "\n";
    }
}
