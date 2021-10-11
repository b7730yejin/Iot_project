package com.test.baeyejin.iot_project;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MedicActivity extends AppCompatActivity {

    Switch agreement;
    TextView water_quality;
    float senser_data; //센서 데이터


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        senser_data = 11;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic);
        agreement = (Switch)findViewById(R.id.sw_button);
        water_quality = (TextView)findViewById(R.id.water_Q);

        agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agreement.isChecked()){
                    Toast.makeText(getApplicationContext(), "긴급처방 기능 활성", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "긴급처방 기능 비활성", Toast.LENGTH_LONG).show();
                }
            }
        });

        if(senser_data > 10){
            water_quality.setText("나쁨");
            water_quality.setTextColor(Color.parseColor("#8B0000"));
            //약 처방
        }
        else if(senser_data <=2){
            water_quality.setText("좋음");
            water_quality.setTextColor(Color.parseColor("#228B22"));
        }

    }
    /*
    void show(){
        AlertDialog.Builder agreement = new AlertDialog.Builder(MedicActivity.this);
        agreement.setTitle("사용자 동의 필요");
        agreement.setMessage("긴급처방 기능을 이용하겠습니까?");
        agreement.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "긴급처방 기능 활성", Toast.LENGTH_LONG).show();
            }
        });
        agreement.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "긴급처방 기능 비활성", Toast.LENGTH_LONG).show();
            }
        });
        agreement.show();

    }
    */

}
