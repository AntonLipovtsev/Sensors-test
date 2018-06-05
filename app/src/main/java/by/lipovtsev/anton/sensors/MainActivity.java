package by.lipovtsev.anton.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private boolean action1;
    private boolean action2;
    private boolean action3;
    private boolean action4;
    private boolean action5;

    private String name;

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

    private File sdFilePlankaAccel;
    private File sdFilePlankaLinearAccel;
    private File sdFilePlankaGyroscope;
    private File sdFilePlankaProximity;
    private File sdFilePlankaMagneticField;
    private File sdFilePlankaGravity;
    private File sdFilePlankaGameRotationVector;
    private File sdFilePlankaLowLatency;
    private File sdFilePlankaMotion;
    private File sdFilePlankaRotationVector;
    private File sdFilePlankaSignMotion;
    private File sdFilePlankaStepCounter;
    private File sdFilePlankaStepDetect;

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

        EditText edtName = findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = String.valueOf(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return;
        }
        File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new File(sdPath.getAbsolutePath() + "/sensors_test");
        sdPath.mkdirs();

        btn1 = findViewById(R.id.btn1);
        final File finalSdPath = sdPath;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action1) {
                    btn1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action1 = false;
                } else {
                    sdFilePrisedAccel = new File(finalSdPath, "Приседания_accelerometer_" + name);
                    sdFilePrisedLinearAccel = new File(finalSdPath, "Приседания_linear_accelerometer_" + name);
                    sdFilePrisedGyroscope = new File(finalSdPath, "Приседания_gyroscope_" + name);
                    sdFilePrisedProximity = new File(finalSdPath, "Приседания_proximity_" + name);
                    sdFilePrisedMagneticField = new File(finalSdPath, "Приседания_magnetic_field_" + name);
                    sdFilePrisedGravity = new File(finalSdPath, "Приседания_gravity_" + name);
                    sdFilePrisedGameRotationVector = new File(finalSdPath, "Приседания_game_rotation_vector_" + name);
                    sdFilePrisedLowLatency = new File(finalSdPath, "Приседания_low_latency_offbody_detect_" + name);
                    sdFilePrisedMotion = new File(finalSdPath, "Приседания_motion_detect_" + name);
                    sdFilePrisedRotationVector = new File(finalSdPath, "Приседания_rotation_vector_" + name);
                    sdFilePrisedSignMotion = new File(finalSdPath, "Приседания_significant_motion_" + name);
                    sdFilePrisedStepCounter = new File(finalSdPath, "Приседания_step_counter_" + name);
                    sdFilePrisedStepDetect = new File(finalSdPath, "Приседания_step_detector_" + name);

                    btn1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action1 = true;
                }
            }
        });

        btn2 = findViewById(R.id.btn2);
        final File finalSdPath1 = sdPath;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action2) {
                    btn2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action2 = false;
                } else {
                    sdFileOtAccel = new File(finalSdPath1, "Отжимания_accelerometer_" + name);
                    sdFileOtLinearAccel = new File(finalSdPath1, "Отжимания_linear_accelerometer_" + name);
                    sdFileOtGyroscope = new File(finalSdPath1, "Отжимания_gyroscope_" + name);
                    sdFileOtProximity = new File(finalSdPath1, "Отжимания_proximity_" + name);
                    sdFileOtMagneticField = new File(finalSdPath1, "Отжимания_magnetic_field_" + name);
                    sdFileOtGravity = new File(finalSdPath1, "Отжимания_gravity_" + name);
                    sdFileOtGameRotationVector = new File(finalSdPath1, "Отжимания_game_rotation_vector_" + name);
                    sdFileOtLowLatency = new File(finalSdPath1, "Отжимания_low_latency_offbody_detect_" + name);
                    sdFileOtMotion = new File(finalSdPath1, "Отжимания_motion_detect_" + name);
                    sdFileOtRotationVector = new File(finalSdPath1, "Отжимания_rotation_vector_" + name);
                    sdFileOtSignMotion = new File(finalSdPath1, "Отжимания_significant_motion_" + name);
                    sdFileOtStepCounter = new File(finalSdPath1, "Отжимания_step_counter_" + name);
                    sdFileOtStepDetect = new File(finalSdPath1, "Отжимания_step_detector_" + name);

                    btn2.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action2 = true;
                }
            }
        });

        btn3 = findViewById(R.id.btn3);
        final File finalSdPath2 = sdPath;
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action3) {
                    btn3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action3 = false;
                } else {
                    sdFileTwAccel = new File(finalSdPath2, "Скручивания_accelerometer_" + name);
                    sdFileTwLinearAccel = new File(finalSdPath2, "Скручивания_linear_accelerometer_" + name);
                    sdFileTwGyroscope = new File(finalSdPath2, "Скручивания_gyroscope_" + name);
                    sdFileTwProximity = new File(finalSdPath2, "Скручивания_proximity_" + name);
                    sdFileTwMagneticField = new File(finalSdPath2, "Скручивания_magnetic_field_" + name);
                    sdFileTwGravity = new File(finalSdPath2, "Скручивания_gravity_" + name);
                    sdFileTwGameRotationVector = new File(finalSdPath2, "Скручивания_game_rotation_vector_" + name);
                    sdFileTwLowLatency = new File(finalSdPath2, "Скручивания_low_latency_offbody_detect_" + name);
                    sdFileTwMotion = new File(finalSdPath2, "Скручивания_motion_detect_" + name);
                    sdFileTwRotationVector = new File(finalSdPath2, "Скручивания_rotation_vector_" + name);
                    sdFileTwSignMotion = new File(finalSdPath2, "Скручивания_significant_motion_" + name);
                    sdFileTwStepCounter = new File(finalSdPath2, "Скручивания_step_counter_" + name);
                    sdFileTwStepDetect = new File(finalSdPath2, "Скручивания_step_detector_" + name);

                    btn3.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action3 = true;
                }
            }
        });

        btn4 = findViewById(R.id.btn4);
        final File finalSdPath3 = sdPath;
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action4) {
                    btn4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action4 = false;
                } else {
                    sdFileWalkAccel = new File(finalSdPath3, "Ходьба_accelerometer_" + name);
                    sdFileWalkLinearAccel = new File(finalSdPath3, "Ходьба_linear_accelerometer_" + name);
                    sdFileWalkGyroscope = new File(finalSdPath3, "Ходьба_gyroscope_" + name);
                    sdFileWalkProximity = new File(finalSdPath3, "Ходьба_proximity_" + name);
                    sdFileWalkMagneticField = new File(finalSdPath3, "Ходьба_magnetic_field_" + name);
                    sdFileWalkGravity = new File(finalSdPath3, "Ходьба_gravity_" + name);
                    sdFileWalkGameRotationVector = new File(finalSdPath3, "Ходьба_game_rotation_vector_" + name);
                    sdFileWalkLowLatency = new File(finalSdPath3, "Ходьба_low_latency_offbody_detect_" + name);
                    sdFileWalkMotion = new File(finalSdPath3, "Ходьба_motion_detect_" + name);
                    sdFileWalkRotationVector = new File(finalSdPath3, "Ходьба_rotation_vector_" + name);
                    sdFileWalkSignMotion = new File(finalSdPath3, "Ходьба_significant_motion_" + name);
                    sdFileWalkStepCounter = new File(finalSdPath3, "Ходьба_step_counter_" + name);
                    sdFileWalkStepDetect = new File(finalSdPath3, "Ходьба_step_detector_" + name);

                    btn4.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action4 = true;
                }
            }
        });

        btn5 = findViewById(R.id.btn5);
        final File finalSdPath4 = sdPath;
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action5) {
                    btn5.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_green_dark));
                    action5 = false;
                } else {
                    sdFilePlankaAccel = new File(finalSdPath4, "Планка_accelerometer_" + name);
                    sdFilePlankaLinearAccel = new File(finalSdPath4, "Планка_linear_accelerometer_" + name);
                    sdFilePlankaGyroscope = new File(finalSdPath4, "Планка_gyroscope_" + name);
                    sdFilePlankaProximity = new File(finalSdPath4, "Планка_proximity_" + name);
                    sdFilePlankaMagneticField = new File(finalSdPath4, "Планка_magnetic_field_" + name);
                    sdFilePlankaGravity = new File(finalSdPath4, "Планка_gravity_" + name);
                    sdFilePlankaGameRotationVector = new File(finalSdPath4, "Планка_game_rotation_vector_" + name);
                    sdFilePlankaLowLatency = new File(finalSdPath4, "Планка_low_latency_offbody_detect_" + name);
                    sdFilePlankaMotion = new File(finalSdPath4, "Планка_motion_detect_" + name);
                    sdFilePlankaRotationVector = new File(finalSdPath4, "Планка_rotation_vector_" + name);
                    sdFilePlankaSignMotion = new File(finalSdPath4, "Планка_significant_motion_" + name);
                    sdFilePlankaStepCounter = new File(finalSdPath4, "Планка_step_counter_" + name);
                    sdFilePlankaStepDetect = new File(finalSdPath4, "Планка_step_detector_" + name);

                    btn5.setBackgroundColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_red_dark));
                    action5 = true;
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtLinearAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwLinearAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkLinearAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaLinearAccel, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGyroscope, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGyroscope, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGyroscope, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaGyroscope, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtProximity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwProximity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkProximity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaProximity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtMagneticField, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwMagneticField, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkMagneticField, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaMagneticField, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGravity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGravity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGravity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaGravity, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtGameRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwGameRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkGameRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaGameRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtLowLatency, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwLowLatency, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkLowLatency, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaLowLatency, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaRotationVector, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtSignMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwSignMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkSignMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaSignMotion, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtStepCounter, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwStepCounter, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkStepCounter, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaStepCounter, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action2) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileOtStepDetect, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action3) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileTwStepDetect, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action4) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFileWalkStepDetect, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (action5) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(sdFilePlankaStepDetect, true));
                    String values = Arrays.toString(sensorEvent.values);
                    values = values.replaceAll("[\\[\\]\"]", "");
                    values += ", " + System.currentTimeMillis() + "\n";
                    bw.write(values);
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
