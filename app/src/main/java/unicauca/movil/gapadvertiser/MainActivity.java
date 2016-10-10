package unicauca.movil.gapadvertiser;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  static final ParcelUuid SERVICE_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");
  static final ParcelUuid DATA_UUID = ParcelUuid.fromString("0000b81d-0000-1000-8000-00805f9b34fb");

  BluetoothAdapter adapter;

  EditText info;
  Button btnAd, btnCancel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    info = (EditText) findViewById(R.id.info);
    btnAd = (Button) findViewById(R.id.btnAd);
    btnCancel = (Button) findViewById(R.id.btnCancel);

    btnAd.setOnClickListener(this);
    btnCancel.setOnClickListener(this);

    BluetoothManager manager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
    adapter = manager.getAdapter();
  }


  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btnAd:
        stateAd(true);
        startAd();
        break;
      case R.id.btnCancel:
        stateAd(false);
        cancelAd();
        break;
    }
  }

  private void stateAd(boolean state){
    btnAd.setEnabled(!state);
    btnCancel.setEnabled(state);
  }

  private void startAd() {

  }

  private void cancelAd() {

  }


}
