package weatherforecast.cba.com.weatherforecast.weatherstationmodel;

import weatherforecast.cba.com.weatherforecast.core.WeatherStationBase;

/**
 * Created by 778363aypp on 7/9/2016.
 */
public class WeatherStation extends WeatherStationBase {
    String weatherStationCode;
    String timeZone;
    boolean isOceanCurrent;
    SoilColor soilColor;
    double latitude;
    double longitude;
    float altitude;

    public WeatherStation(String weatherStationCode, String timeZone, boolean isOceanCurrent,
                          SoilColor soilColor, double latitude, double longitude, float altitude) {
        this.weatherStationCode = weatherStationCode;
        this.timeZone = timeZone;
        this.isOceanCurrent = isOceanCurrent;
        this.soilColor = soilColor;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }


    @Override
    public String getWeatherStationCode() {
        return weatherStationCode;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public boolean isOceanCurrent() {
        return isOceanCurrent;
    }

    @Override
    public SoilColor getSoilColor() {
        return soilColor;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public float getAltitudeInMeters() {
        return altitude;
    }
}
