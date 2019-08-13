package com.example.touch;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

//import com.example.touch.R;
//import android.os.ServiceManager;
//import android.os.Bundle;
//import android.os.ITouchService;
public class MainActivity extends Activity implements OnClickListener {
    private final static String LOG_TAG = "touch";

    //private ITouchService touchService = null;

    private EditText valueText = null;
    private Button readButton = null;
    private Button writeButton = null;
    private Button clearButton = null;
    private Button moveButton = null;
    private Button quitButton = null;
    private Button switchButton = null;
    private String num;


    public MainActivity() {
        num = new String("Please input a value...");
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //touchService = ITouchService.Stub.asInterface(
        //        ServiceManager.getService("touch"));
        //View view = View.inflate( this, R.layout.activity_main, null);
        valueText = findViewById(R.id.edit_value);
        readButton = findViewById(R.id.button_read);
        writeButton = findViewById(R.id.button_write);
        clearButton = findViewById(R.id.button_clear);
        switchButton = findViewById(R.id.switchbutton);
        moveButton = findViewById(R.id.movebutton);
        quitButton = findViewById(R.id.quitbutton);

        readButton.setOnClickListener(this);
        writeButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        moveButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
        switchButton.setOnClickListener(this);
        Log.i(LOG_TAG, "Touch Activity Created");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(readButton)) {
            //try {
                //int val = touchService.getVal();
                String val = this.num;
                String text = String.valueOf(val);
                valueText.setText(text);
            Toast.makeText(this, "读取成功", Toast.LENGTH_LONG).show();
            //} catch (RemoteException e) {
                //Log.e(LOG_TAG, "Remote Exception while reading value from device.");
            //}
        }
        else if(v.equals(writeButton)) {
            //try {
//            String text;
//            text = valueText.getText().toString();
            //int val = Integer.parseInt(text);
            //touchService.setVal(val);
            this.num = valueText.getText().toString();
            Toast.makeText(this, "写入成功", Toast.LENGTH_LONG).show();
            //} catch (RemoteException e) {
            // Log.e(LOG_TAG, "Remote Exception while writing value to device.");
            //}



        }
        else if(v.equals(clearButton)) {
            String text = "";
            valueText.setText(text);
            final Intent it = new Intent(MainActivity.this,AdActivity.class);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        //sleep(10);
                        startActivity(it);
                    } catch (/*InterruptedException*/Throwable e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
        else if(v.equals(moveButton)) {
            final Intent it = new Intent(MainActivity.this,MoveActivity.class);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(100);

                        startActivity(it);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Toast.makeText(this, "正在登陆", Toast.LENGTH_LONG).show();
            thread.start();
        }
        else if(v.equals(quitButton)) {
            final Intent it = new Intent(MainActivity.this,grid.class);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(10);

                        startActivity(it);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Toast.makeText(this, "正在切换", Toast.LENGTH_LONG).show();
            thread.start();
        }
        else if(v.equals(switchButton)) {
            final Intent it = new Intent(MainActivity.this,SwitchToggleButton.class);
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(10);

                        startActivity(it);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Toast.makeText(this, "正在切换", Toast.LENGTH_LONG).show();
            thread.start();
        }
    }
}