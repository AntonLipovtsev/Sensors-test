package by.lipovtsev.anton.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Button btn1;
    private boolean action1;

    private File sdFilePrisedAccel;
    private File sdFilePrisedLinearAccel;
    private File sdFilePrisedGyroscope;
    private File sdFilePrisedProximity;
    private File sdFilePrisedMagneticField;
    private File sdFilePrisedGravity;
    private File sdFilePrisedGameRotationVector;
    private File sdFilePrisedLowLatency;
    private File sdFilePrisedMotion;
    private File sdFilePrisedRotationVector;
    private File sdFilePrisedSignMotion;
    private File sdFilePrisedStepCounter;
    private File sdFilePrisedStepDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor mLinearAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        Sensor mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        Sensor mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        Sensor mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        Sensor mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor mGameRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        Sensor mLowLatency = mSensorManager.getDefaultSensor(Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT);
        Sensor mMotion = mSensorManager.getDefaultSensor(Sensor.TYPE_MOTION_DETECT);
        Sensor mRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        Sensor mSignMotion = mSensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);
        Sensor mStepCounter = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor mStepDetect = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mLinearAccelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mGameRotationVector, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mLowLatency, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mMotion, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mRotationVector, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mSignMotion, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this, mStepDetect, SensorManager.SENSOR_DELAY_UI);

        setContentView(R.layout.activity_main);

        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return;
        }
        File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new File(sdPath.getAbsolutePath() + "/sensors_test");
        sdPath.mkdirs();
        sdFilePrisedAccel = new File(sdPath, "Приседания_accelerometer");
        sdFilePrisedLinearAccel = new File(sdPath, "Приседания_linear_accelerometer");
        sdFilePrisedGyroscope = new File(sdPath, "Приседания_gyroscope");
        sdFilePrisedProximity = new File(sdPath, "Приседания_proximity");
        sdFilePrisedMagneticField = new File(sdPath, "Приседания_magnetic_field");
        sdFilePrisedGravity = new File(sdPath, "Приседания_gravity");
        sdFilePrisedGameRotationVector = new File(sdPath, "Приседания_game_rotation_vector");
        sdFilePrisedLowLatency = new File(sdPath, "Приседания_low_latency_offbody_detect");
        sdFilePrisedMotion = new File(sdPath, "Приседания_motion_detect");
        sdFilePrisedRotationVector = new File(sdPath, "Приседания_rotation_vector");
        sdFilePrisedSignMotion = new File(sdPath, "Приседания_significant_motion");
        sdFilePrisedStepCounter = new File(sdPath, "Приседания_step_counter");
        sdFilePrisedStepDetect = new File(sdPath, "Приседания_step_detector");

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action1) {
                    btn1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action1 = false;
                } else {
                    btn1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action1 = true;
                }
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedLinearAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedGyroscope, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedProximity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedMagneticField, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_GRAVITY) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedGravity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedGameRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedLowLatency, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_MOTION_DETECT) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_SIGNIFICANT_MOTION) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedSignMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedStepCounter, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            if (action1) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePrisedStepDetect, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
