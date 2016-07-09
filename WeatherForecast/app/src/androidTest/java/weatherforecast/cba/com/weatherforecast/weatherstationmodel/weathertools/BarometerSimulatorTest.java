package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

import junit.framework.TestCase;

import weatherforecast.cba.com.weatherforecast.builders.WeatherStationFactory;
import weatherforecast.cba.com.weatherforecast.utilities.Constants;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.WeatherStation;

/**
 * Created by 778363aypp on 7/9/2016.
 */
public class BarometerSimulatorTest extends TestCase {

    public void testGetAtmosphericPressure() throws Exception {
        WeatherStation weatherStation = WeatherStationFactory.getWeatherStation(Constants.STATION_CODE_PERTH);
        BarometerSimulator barometerSimulator = new BarometerSimulator();
        float pressure = barometerSimulator.getAtmosphericPressure(weatherStation);
        assertEquals(pressure,1009.1738f);

    }
}