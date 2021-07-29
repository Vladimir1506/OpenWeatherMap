package OpenWeather;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.*;

public class StrToJson {

    public List<DateTempPres> getDataList(String response) throws java.text.ParseException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsobj = (JSONObject) jsonParser.parse(response);
        JSONArray jsonArray = (JSONArray) jsobj.get("list");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<DateTempPres> dateTempPres = new ArrayList<>();
        for (Object jsob :
                jsonArray) {
            JSONObject jsonObject = (JSONObject) jsob;
            Date date = formatter.parse(jsonObject.get("dt_txt").toString());
            JSONObject mainObj = (JSONObject) jsonObject.get("main");
            Long pressure = (Long) mainObj.get("pressure");
            Double temp = new Double(mainObj.get("temp").toString());
            dateTempPres.add(new DateTempPres(date, temp, pressure));
        }
        return dateTempPres;
    }


}
