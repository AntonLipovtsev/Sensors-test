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
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private boolean action1;
    private boolean action2;
    private boolean action3;
    private boolean action4;

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

    private File sdFileOtAccel;
    private File sdFileOtLinearAccel;
    private File sdFileOtGyroscope;
    private File sdFileOtProximity;
    private File sdFileOtMagneticField;
    private File sdFileOtGravity;
    private File sdFileOtGameRotationVector;
    private File sdFileOtLowLatency;
    private File sdFileOtMotion;
    private File sdFileOtRotationVector;
    private File sdFileOtSignMotion;
    private File sdFileOtStepCounter;
    private File sdFileOtStepDetect;

    private File sdFileTwAccel;
    private File sdFileTwLinearAccel;
    private File sdFileTwGyroscope;
    private File sdFileTwProximity;
    private File sdFileTwMagneticField;
    private File sdFileTwGravity;
    private File sdFileTwGameRotationVector;
    private File sdFileTwLowLatency;
    private File sdFileTwMotion;
    private File sdFileTwRotationVector;
    private File sdFileTwSignMotion;
    private File sdFileTwStepCounter;
    private File sdFileTwStepDetect;

    private File sdFileWalkAccel;
    private File sdFileWalkLinearAccel;
    private File sdFileWalkGyroscope;
    private File sdFileWalkProximity;
    private File sdFileWalkMagneticField;
    private File sdFileWalkGravity;
    private File sdFileWalkGameRotationVector;
    private File sdFileWalkLowLatency;
    private File sdFileWalkMotion;
    private File sdFileWalkRotationVector;
    private File sdFileWalkSignMotion;
    private File sdFileWalkStepCounter;
    private File sdFileWalkStepDetect;

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

        sdFileOtAccel = new File(sdPath, "Отжимания_accelerometer");
        sdFileOtLinearAccel = new File(sdPath, "Отжимания_linear_accelerometer");
        sdFileOtGyroscope = new File(sdPath, "Отжимания_gyroscope");
        sdFileOtProximity = new File(sdPath, "Отжимания_proximity");
        sdFileOtMagneticField = new File(sdPath, "Отжимания_magnetic_field");
        sdFileOtGravity = new File(sdPath, "Отжимания_gravity");
        sdFileOtGameRotationVector = new File(sdPath, "Отжимания_game_rotation_vector");
        sdFileOtLowLatency = new File(sdPath, "Отжимания_low_latency_offbody_detect");
        sdFileOtMotion = new File(sdPath, "Отжимания_motion_detect");
        sdFileOtRotationVector = new File(sdPath, "Отжимания_rotation_vector");
        sdFileOtSignMotion = new File(sdPath, "Отжимания_significant_motion");
        sdFileOtStepCounter = new File(sdPath, "Отжимания_step_counter");
        sdFileOtStepDetect = new File(sdPath, "Отжимания_step_detector");

        sdFileTwAccel = new File(sdPath, "Скручивания_accelerometer");
        sdFileTwLinearAccel = new File(sdPath, "Скручивания_linear_accelerometer");
        sdFileTwGyroscope = new File(sdPath, "Скручивания_gyroscope");
        sdFileTwProximity = new File(sdPath, "Скручивания_proximity");
        sdFileTwMagneticField = new File(sdPath, "Скручивания_magnetic_field");
        sdFileTwGravity = new File(sdPath, "Скручивания_gravity");
        sdFileTwGameRotationVector = new File(sdPath, "Скручивания_game_rotation_vector");
        sdFileTwLowLatency = new File(sdPath, "Скручивания_low_latency_offbody_detect");
        sdFileTwMotion = new File(sdPath, "Скручивания_motion_detect");
        sdFileTwRotationVector = new File(sdPath, "Скручивания_rotation_vector");
        sdFileTwSignMotion = new File(sdPath, "Скручивания_significant_motion");
        sdFileTwStepCounter = new File(sdPath, "Скручивания_step_counter");
        sdFileTwStepDetect = new File(sdPath, "Скручивания_step_detector");

        sdFileWalkAccel = new File(sdPath, "Ходьба_accelerometer");
        sdFileWalkLinearAccel = new File(sdPath, "Ходьба_linear_accelerometer");
        sdFileWalkGyroscope = new File(sdPath, "Ходьба_gyroscope");
        sdFileWalkProximity = new File(sdPath, "Ходьба_proximity");
        sdFileWalkMagneticField = new File(sdPath, "Ходьба_magnetic_field");
        sdFileWalkGravity = new File(sdPath, "Ходьба_gravity");
        sdFileWalkGameRotationVector = new File(sdPath, "Ходьба_game_rotation_vector");
        sdFileWalkLowLatency = new File(sdPath, "Ходьба_low_latency_offbody_detect");
        sdFileWalkMotion = new File(sdPath, "Ходьба_motion_detect");
        sdFileWalkRotationVector = new File(sdPath, "Ходьба_rotation_vector");
        sdFileWalkSignMotion = new File(sdPath, "Ходьба_significant_motion");
        sdFileWalkStepCounter = new File(sdPath, "Ходьба_step_counter");
        sdFileWalkStepDetect = new File(sdPath, "Ходьба_step_detector");

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

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action2) {
                    btn2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action2 = false;
                } else {
                    btn2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action2 = true;
                }
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action3) {
                    btn3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action3 = false;
                } else {
                    btn3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action3 = true;
                }
            }
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action4) {
                    btn4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action4 = false;
                } else {
                    btn4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action4 = true;
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkAccel, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtLinearAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwLinearAccel, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkLinearAccel, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGyroscope, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGyroscope, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGyroscope, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtProximity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwProximity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkProximity, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtMagneticField, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwMagneticField, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkMagneticField, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGravity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGravity, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGravity, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGameRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGameRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGameRotationVector, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtLowLatency, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwLowLatency, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkLowLatency, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkMotion, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwRotationVector, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkRotationVector, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtSignMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwSignMotion, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkSignMotion, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtStepCounter, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwStepCounter, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkStepCounter, true));
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

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtStepDetect, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwStepDetect, true));
                    bw.write(Arrays.toString(sensorEvent.values));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkStepDetect, true));
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
