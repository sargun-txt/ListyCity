package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView cityList;
    private ArrayAdapter<String> cityAdapter;
    private ArrayList<String> dataList;
    private CityList cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        EditText cityNameEditText = findViewById(R.id.city_name_edit_text);
        EditText provinceNameEditText = findViewById(R.id.province_name_edit_text);
        Button addCityButton = findViewById(R.id.add_city_button);

        dataList = new ArrayList<>();
        cities = new CityList();

        cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        cityList.setAdapter(cityAdapter);

        addCityButton.setOnClickListener(v -> {
            String cityName = cityNameEditText.getText().toString();
            String provinceName = provinceNameEditText.getText().toString();

            if (!cityName.isEmpty() && !provinceName.isEmpty()) {
                cities.add(new City(cityName, provinceName));
                updateCityList();
                cityNameEditText.setText("");
                provinceNameEditText.setText("");
            }
        });
    }

    private void updateCityList() {
        dataList.clear();
        for (City city : cities.getCities()) {
            dataList.add(city.getCityName());
        }
        cityAdapter.notifyDataSetChanged();
    }
}
