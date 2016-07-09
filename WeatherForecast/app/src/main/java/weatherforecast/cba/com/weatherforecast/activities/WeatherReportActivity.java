package weatherforecast.cba.com.weatherforecast.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import weatherforecast.cba.com.weatherforecast.R;
import weatherforecast.cba.com.weatherforecast.weatherstationmodel.WeatherReportCenter;

public class WeatherReportActivity extends AppCompatActivity {
    private TextView weatherReportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        weatherReportText = (TextView) findViewById(R.id.weather_text);
        refreshWeatherData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            refreshWeatherData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method Used for refresh weather report on screen when tap on Menu > Refresh
     */
    private void refreshWeatherData(){
        WeatherReportCenter weatherReportCenter = WeatherReportCenter.getInstance();
        if(weatherReportText != null) {
            weatherReportText.setText(weatherReportCenter.getWeatherReportFromAllStations());
        }
    }
}
