package com.example.myapplication;

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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
        Sensor sensorListener = sensorManager.getDefaultSensor(Sensor.TYPE_ALL);

        if (sensorListener != null) {
            sensorManager.registerListener(FirstFragment.this, sensorListener, SensorManager.SENSOR_DELAY_NORMAL);
        }

        GpsTracker gpsTracker = new GpsTracker(getContext());
        Location location = gpsTracker.getLocation();
        if (location != null) {
            binding.latitude.setText(String.format(Double.toString(location.getLatitude())));
            binding.longitude.setText(String.format(Double.toString(location.getLongitude())));
        }
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