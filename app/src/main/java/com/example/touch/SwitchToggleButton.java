package com.example.touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SwitchToggleButton extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton tbtn_open;
    private Switch swh_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        tbtn_open = (ToggleButton) findViewById(R.id.tbtn_open);
        swh_status =  (Switch) findViewById(R.id.swh_status);
        tbtn_open.setOnCheckedChangeListener(this);
        swh_status.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.tbtn_open:
                if(compoundButton.isChecked()) Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"打开声音",Toast.LENGTH_SHORT).show();
                break;
            case R.id.swh_status:
                if(compoundButton.isChecked()) Toast.makeText(this,"开关:ON",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"开关:OFF",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
