package weatherforecast.cba.com.weatherforecast.weatherstationmodel.weathertools;

import junit.framework.TestCase;

import weatherforecast.cba.com.weatherforecast.builders.WeatherStationFactory;
import weatherforecast.cba.com.weatherforecast.utilities.Constants;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.WeatherStation;

/**
 * Created by 778363aypp on 7/9/2016.
 */
public class PsychrometerSimulatorTest extends TestCase {

    public void testGetAtmosphericHumidity() throws Exception {
        WeatherStation weatherStation = WeatherStationFactory.getWeatherStation(Constants.STATION_CODE_SYDNEY);
        BarometerSimulator barometerSimulator = new BarometerSimulator();
        float pressure = barometerSimulator.getAtmosphericPressure(weatherStation);
        ThermometerSimulator thermometerSimulator = new ThermometerSimulator();
        float temperature = thermometerSimulator.getTemperature(weatherStation);
        PsychrometerSimulator psychrometerSimulator = new PsychrometerSimulator();
        float humidity = psychrometerSimulator.getAtmosphericHumidity(pressure,temperature);
        assertEquals(humidity,52.0f);
    }
}