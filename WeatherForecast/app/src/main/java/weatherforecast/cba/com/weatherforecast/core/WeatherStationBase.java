package weatherforecast.cba.com.weatherforecast.core;

import java.util.Calendar;
import java.util.TimeZone;

import weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools.BarometerSimulator;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools.PsychrometerSimulator;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools.ThermometerSimulator;

/**
 * This is the Base class for all weather stations. All generic calculations are done here
 * As weather stations are highly affected by environmental factors and Gps factors, this class
 * takes such factors also in account.
 * Created by Antony Philip on 7/8/2016.
 */
public abstract class WeatherStationBase implements EnvironmentalFactors, GpsFactors{
    //month string array used for finding weather season.
    public String monthOfYear[]={
        "JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"
    };

    /*abstract Methods */

    /**
     * This Abstract method Returns weather station code
     * @return
     */
    public abstract String getWeatherStationCode();

    /**
     * This Abstract method Returns time zone for weather station
     * @return
     */
    public abstract String getTimeZone();

    /*Concrete Methods */

    /**
     * Gets the time in milliseconds using the weather station timezone.
     * @return Time in MilliSeconds
     */
    public long getTime(){
        TimeZone.setDefault(TimeZone.getTimeZone(getTimeZone()));
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    /**
     * Gets the moth of Year in 3 letter text(eg:JAN)
     * @return Month of year(JAN...DEC)
     */
    public String getMonthOfYear(){
        long timeInMilliSeconds = getTime();
        Calendar c = Calendar.getInstance();
        //Set time in milliseconds
        c.setTimeInMillis(timeInMilliSeconds);
        return monthOfYear[c.get(Calendar.MONTH)];
    }

    /**
     * Gets the moth of year in digits (1-12)
     * @return Month of year (1-12)
     */
    public int getMonthOfYearInDigits(){
        long timeInMilliSeconds = getTime();
        Calendar c = Calendar.getInstance();
        //Set time in milliseconds
        c.setTimeInMillis(timeInMilliSeconds);
        return c.get(Calendar.MONTH);
    }

    @Override
    public Season getSeason(WeatherStationBase weatherStationBase) {
        int monthOfYear = weatherStationBase.getMonthOfYearInDigits();
        if(monthOfYear >=1 && monthOfYear <= 3){
            return Season.SUMMER;
        }
        else if(monthOfYear >=4 && monthOfYear <= 6){
            return Season.AUTUMN;
        }
        else if(monthOfYear >=7 && monthOfYear <= 9){
            return Season.SPRING;
        }
        else if(monthOfYear >=10 && monthOfYear <= 12){
            return Season.WINTER;
        }
        return null;
    }

    /**
     * Generates Atmospheric temperature using Thermometer Simulator
     * @return Atmospheric temperature
     */
    public float getAtmosphericTemperature(){
        ThermometerSimulator thermometerSimulator = new ThermometerSimulator();
        return thermometerSimulator.getTemperature(this);
    }

    /**
     *  Generates Atmospheric Pressure using Barometer Simulator
     * @return Atmospheric Pressure
     */
    public float getAtmosphericPressure(){
        BarometerSimulator barometerSimulator = new BarometerSimulator();
        return barometerSimulator.getAtmosphericPressure(this);
    }


    /**
     * Generates Atmospheric Humidity using Psychrometer Simulator
     * @return Atmospheric Humidity
     */
    public float getAtmosphericHumidity(){
        float pressure = getAtmosphericPressure();
        float temperature = getAtmosphericTemperature();
        PsychrometerSimulator psychrometerSimulator = new PsychrometerSimulator();
        return psychrometerSimulator.getAtmosphericHumidity(pressure, temperature);
    }

    /**
     * Gets weather condition based on Temperature, Humidity and Time of Day.
     * @return Weather Condition enum value
     */
    public WeatherCondition getWeatherCondition() {
        float temperature = getAtmosphericTemperature();
        float humidity = getAtmosphericHumidity();
        Season season = getSeason(this);
        int hourOfDay = getHourOfDay();
        if (season == Season.WINTER) {

            if (temperature >= 0 && temperature <= 28 &&
                    hourOfDay >= 10 && hourOfDay <= 17) {
                if (humidity < 60) {
                    return WeatherCondition.SUNNY;
                } else {
                    return WeatherCondition.RAIN;
                }
            } else if (temperature > 28) {
                return WeatherCondition.SUNNY;
            } else if (hourOfDay < 10 && hourOfDay > 17) {
                return WeatherCondition.CLEAR;
            } else if (temperature < 0) {
                return WeatherCondition.SNOW;
            }
        } else if (season == Season.SUMMER ||
                season == Season.AUTUMN ||
                season == Season.SPRING) {

            if (hourOfDay >= 10 && hourOfDay <= 17) {
                return WeatherCondition.SUNNY;
            } else {
                return WeatherCondition.CLEAR;
            }
        }
        return WeatherCondition.CLEAR;
    }


    /**
     * Gets Hour of Day from a milliseconds time.
     * @return Hour of day (0-23)
     */
    private int getHourOfDay() {
        Calendar time = Calendar.getInstance();
        time.setTimeInMillis(getTime());
        return time.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Enum for representing different seasons
     */
    private enum WeatherCondition{RAIN, SNOW,SUNNY,CLEAR}


}


