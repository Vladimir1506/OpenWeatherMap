package OpenWeather;

import java.util.Date;

public class DateTempPres {
    private Date date;
    private Double temp;
    private Long pres;

    public DateTempPres(Date date, Double temp, Long pres) {
        this.date = date;
        this.temp = temp;
        this.pres = pres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Long getPres() {
        return pres;
    }

    public void setPres(Long pres) {
        this.pres = pres;
    }

    @Override
    public String toString() {
        return "Дата: " + date +
                ", Температура: " + temp +
                ", Давление: " + pres + '\n';
    }
}
