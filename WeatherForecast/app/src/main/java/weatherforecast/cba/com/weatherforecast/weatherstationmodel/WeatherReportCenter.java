package weatherforecast.cba.com.weatherforecast.weatherstationmodel;

import java.util.ArrayList;
import java.util.List;

import weatherforecast.cba.com.weatherforecast.builders.WeatherStationFactory;
import weatherforecast.cba.com.weatherforecast.utilities.Constants;
import weatherforecast.cba.com.weatherforecast.utilities.Utils;

/**
 * Singleton Class used as Weather reporting center which generates reports for all weather stations
 * Created by Antony Philip on 7/9/2016.
 */
public final class WeatherReportCenter {

    //Static instance for implementing singleton design pattern
    private static WeatherReportCenter sInstance;


    /**
     * Private Constructor
     */
    private WeatherReportCenter(){}

    /**
     * Singleton getInstance Method
     * @return
     */
    public static WeatherReportCenter getInstance(){
        if(sInstance == null){
            sInstance = new WeatherReportCenter();
        }
        return sInstance;
    }

    /**
     * Method used for generating list of weather stations
     * @return list of WeatherStation
     */
    private List<WeatherStation> getWeatherStations(){
        List<WeatherStation> weatherStations = new ArrayList<>();
        List<String> weatherStationList = new ArrayList<>();
        weatherStationList.add(Constants.STATION_CODE_ADELAIDE);
        weatherStationList.add(Constants.STATION_CODE_BRISBANE);
        weatherStationList.add(Constants.STATION_CODE_CAIRNS);
        weatherStationList.add(Constants.STATION_CODE_CANBERRA);
        weatherStationList.add(Constants.STATION_CODE_DARWIN);
        weatherStationList.add(Constants.STATION_CODE_GOLD_COAST);
        weatherStationList.add(Constants.STATION_CODE_HOBART);
        weatherStationList.add(Constants.STATION_CODE_MELBOURNE);
        weatherStationList.add(Constants.STATION_CODE_PERTH);
        weatherStationList.add(Constants.STATION_CODE_SYDNEY);

        for(String weatherStationCode : weatherStationList){
            weatherStations.add(WeatherStationFactory.getWeatherStation(weatherStationCode));
        }
        return weatherStations;
    }

    /**
     * Method for generating weather report for all weather stations
     * @return
     */
    public String getWeatherReportFromAllStations(){
        StringBuilder weatherReport = new StringBuilder();
        List<WeatherStation> weatherStations = getWeatherStations();
        for(WeatherStation weatherStation : weatherStations){
            weatherReport.append(weatherStation.getWeatherStationCode()+"|");
            weatherReport.append(weatherStation.getLatitude()+",");
            weatherReport.append(weatherStation.getLongitude()+",");
            weatherReport.append(weatherStation.getAltitudeInMeters()+"|");
            weatherReport.append(Utils.getTimeStampFromMills(weatherStation.getTime(), Constants.LOCATION_TIME_STAMP_FORMAT)+"|");
            weatherReport.append(weatherStation.getWeatherCondition()+"|");
            weatherReport.append(Utils.round(weatherStation.getAtmosphericTemperature(),1)+"|");
            weatherReport.append(Utils.round(weatherStation.getAtmosphericPressure(),1)+"|");
            weatherReport.append(weatherStation.getAtmosphericHumidity());
            weatherReport.append("\n");
            weatherReport.append("\n");

        }
        return weatherReport.toString();
    }
}
