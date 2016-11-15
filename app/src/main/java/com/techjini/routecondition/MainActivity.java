package com.techjini.routecondition;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.tbouron.shakedetector.library.ShakeDetector;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity implements ShakeDetector.OnShakeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String STATUS = "status";
    private static final float SENSIBILITY = 1.0f;
    private static final int SHAKE_NUMBER = 1;

    @InjectView(R.id.status)
    protected TextView mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        if (savedInstanceState != null && savedInstanceState.containsKey(STATUS)) {
            mStatus.setText(savedInstanceState.getString(STATUS));
        }

        // We create and start the shake detector here.
        if (ShakeDetector.create(this, this)) {
            addStatusMessage(getString(R.string.shake_detector_created));
            ShakeDetector.updateConfiguration(SENSIBILITY, SHAKE_NUMBER);
        } else {
            addStatusMessage(getString(R.string.shake_detector_error));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // We restart shake detector if the activity was in background.
        if (ShakeDetector.start()) {
            addStatusMessage(getString(R.string.shake_detector_restarted));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        // We stop shake detector when the activity goes to the background.
        ShakeDetector.stop();
        addStatusMessage(getString(R.string.shake_detector_stopped));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // We destroy shake detector when the activity finishes to release the resources.
        ShakeDetector.destroy();
        addStatusMessage(getString(R.string.shake_detector_destroyed));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATUS, mStatus.getText().toString());
    }

    @Override
    public void OnShake() {
        // This callback is triggered by the ShakeDetector. In a real implementation, you should
        // do here a real action.
        addStatusMessage(getString(R.string.shake_detected));
        Toast.makeText(this, getString(R.string.device_shaken), Toast.LENGTH_SHORT).show();
    }

    private void addStatusMessage(String message) {
        String date = new SimpleDateFormat("HH:mm:ss-SSS").format(new Date());
        String status = String.format("\n[%s] %s", date, message);

        mStatus.append(status);
        Log.d(TAG, status);
    }
}
