package weatherforecast.cba.com.weatherforecast.builders;

import weatherforecast.cba.com.weatherforecast.core.EnvironmentalFactors;
import weatherforecast.cba.com.weatherforecast.utilities.Constants;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.WeatherStation;

/**
 * Created by Antony Philip on 7/9/2016.
 * This is the factory class used for building WeatherStations
 */
public final class WeatherStationFactory {

    /**
     * Build a Weather station using the constructor.
     * @param stationCode Station code of weather station
     * @return Weather station
     */
    public static WeatherStation getWeatherStation(String stationCode){
        switch(stationCode){
            case Constants.STATION_CODE_ADELAIDE :
                return  new WeatherStation(Constants.STATION_CODE_ADELAIDE,Constants.TIMEZONE_ADELAIDE,false,
                        EnvironmentalFactors.SoilColor.BLACK,-33.8678500,151.2073200,58);
            case Constants.STATION_CODE_BRISBANE :
                return  new WeatherStation(Constants.STATION_CODE_BRISBANE,Constants.TIMEZONE_BRISBANE,false,
                        EnvironmentalFactors.SoilColor.YELLOW,-27.4679400,153.0280900,27);
            case Constants.STATION_CODE_CAIRNS :
                return  new WeatherStation(Constants.STATION_CODE_CAIRNS,Constants.TIMEZONE_CAIRNS,true,
                        EnvironmentalFactors.SoilColor.BROWN,-16.9230400,145.7662500,7);
            case Constants.STATION_CODE_CANBERRA :
                return  new WeatherStation(Constants.STATION_CODE_CANBERRA,Constants.TIMEZONE_CANBERRA,false,
                        EnvironmentalFactors.SoilColor.BROWN,-35.2834600,149.1280700,580);
            case Constants.STATION_CODE_DARWIN :
                return  new WeatherStation(Constants.STATION_CODE_DARWIN,Constants.TIMEZONE_DARWIN,true,
                        EnvironmentalFactors.SoilColor.YELLOW,-12.4611300,130.8418500,31);
            case Constants.STATION_CODE_GOLD_COAST:
                return  new WeatherStation(Constants.STATION_CODE_GOLD_COAST,Constants.TIMEZONE_GOLD_COAST,true,
                        EnvironmentalFactors.SoilColor.BLACK,-28.0002900,153.4308800,12);
            case Constants.STATION_CODE_HOBART:
                return  new WeatherStation(Constants.STATION_CODE_HOBART,Constants.TIMEZONE_HOBART,false,
                        EnvironmentalFactors.SoilColor.BROWN,-42.8793600,147.3294100,19);
            case Constants.STATION_CODE_MELBOURNE:
                return  new WeatherStation(Constants.STATION_CODE_MELBOURNE,Constants.TIMEZONE_MELBOURNE,true,
                        EnvironmentalFactors.SoilColor.YELLOW,-37.8140000,144.9633200,25);
            case Constants.STATION_CODE_PERTH:
                return  new WeatherStation(Constants.STATION_CODE_PERTH,Constants.TIMEZONE_PERTH,false,
                        EnvironmentalFactors.SoilColor.BLACK,-31.9522400,115.8614000,34);
            case Constants.STATION_CODE_SYDNEY:
                return  new WeatherStation(Constants.STATION_CODE_SYDNEY,Constants.TIMEZONE_SYDNEY,true,
                        EnvironmentalFactors.SoilColor.YELLOW,-33.8678500,151.2073200,58);
            default :
                return null;
        }
    }
}
