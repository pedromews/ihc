package com.example.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment  implements SensorEventListener {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("ResourceType")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SensorManager sensorManager = (SensorManager) requireActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensorListener = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor temperatureSensorListener = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        Sensor acceleratorSensorListener = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (lightSensorListener != null) {
            sensorManager.registerListener(FirstFragment.this, lightSensorListener, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (temperatureSensorListener != null) {
            sensorManager.registerListener(FirstFragment.this, temperatureSensorListener, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (acceleratorSensorListener != null) {
            sensorManager.registerListener(FirstFragment.this, acceleratorSensorListener, SensorManager.SENSOR_DELAY_NORMAL);
        }

        ActivityCompat.requestPermissions(requireActivity(),
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                123);
        binding.gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GpsTracker gpsTracker = new GpsTracker(getContext());
                Location location = gpsTracker.getLocation();
                if (location != null) {
                    binding.latitude.setText(String.format(Double.toString(location.getLatitude())));
                    binding.longitude.setText(String.format(Double.toString(location.getLongitude())));
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_LIGHT:
                binding.lightValue.setText(String.format(Float.toString(sensorEvent.values[0])));
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                binding.temperatureValue.setText(String.format(Float.toString(sensorEvent.values[0])));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                binding.x.setText(String.format(Float.toString(sensorEvent.values[0])));
                binding.y.setText(String.format(Float.toString(sensorEvent.values[1])));
                binding.z.setText(String.format(Float.toString(sensorEvent.values[2])));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}