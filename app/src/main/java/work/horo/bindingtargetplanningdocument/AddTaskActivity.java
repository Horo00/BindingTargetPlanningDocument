package work.horo.bindingtargetplanningdocument;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private String unit = "なし"; //単位変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    @Override
    public void onClick(View v) {
        //edittextを保存


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        unit = ((TextView)view).getText().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Override必須のため入力しない
    }
}