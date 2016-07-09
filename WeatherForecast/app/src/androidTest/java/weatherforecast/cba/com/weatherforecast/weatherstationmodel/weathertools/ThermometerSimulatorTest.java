package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

import junit.framework.TestCase;

import weatherforecast.cba.com.weatherforecast.builders.WeatherStationFactory;
import weatherforecast.cba.com.weatherforecast.utilities.Constants;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.WeatherStation;

/**
 * Created by 778363aypp on 7/9/2016.
 */
public class ThermometerSimulatorTest extends TestCase {

    public void testGetTemperature() throws Exception {
        WeatherStation weatherStation = WeatherStationFactory.getWeatherStation(Constants.STATION_CODE_SYDNEY);
        ThermometerSimulator thermometerSimulator = new ThermometerSimulator();
        float temperature = thermometerSimulator.getTemperature(weatherStation);
        assertEquals(temperature,16.901358f);
    }
}