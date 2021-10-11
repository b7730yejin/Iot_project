package com.test.baeyejin.iot_project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class TempActivity extends AppCompatActivity {


    EditText editTemp; //사용자 입력값
    TextView ME_text; //적정 여부 출력
    TextView temp; //현재 온도 뷰
    float senser_data = 0; //온도 센서 값


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        editTemp = (EditText)findViewById(R.id.user_temp);
        String Utemp = editTemp.getText().toString();
        String Stemp = String.format("%.2f", senser_data);

        temp.setText(Stemp);

        float Utemp_data = Float.parseFloat(Utemp);
        float ME = Utemp_data - senser_data; //Margin of error(오차범위)

        ME_text = (TextView)findViewById(R.id.temp_color);

        if(ME == Math.abs(2.0)){
            ME_text.setText("적정 온도");
            ME_text.setTextColor(Color.parseColor("#228B22"));
        }
        else{
            ME_text.setText("부적정 온도 - 히터가동");
            ME_text.setTextColor(Color.parseColor("#8B0000"));

            if(Utemp_data > senser_data){
                //히터 동작
            }
        }



    }
}
