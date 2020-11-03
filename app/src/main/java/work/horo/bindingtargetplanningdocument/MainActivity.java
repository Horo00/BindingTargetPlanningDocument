package work.horo.bindingtargetplanningdocument;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //表示用サンプルデータの作成
        String[] dimensions ={"A","B","C","D"};//分割円の名称
        float[] values ={1f,2f,3f,4f};//分割円の大きさ

        //Entryにデータ格納
        List<PieEntry> entryList = new ArrayList<>();
        for(int i=0;i<dimensions.length;i++){
            entryList.add(new PieEntry(values[i], dimensions[i]));
        }

        //PieDataSetにデータ格納
        PieDataSet pieDataSet = new PieDataSet(entryList,"candle");
        //DataSetのフォーマット指定
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        //PieDataにPieDataSetを格納
        PieData pieData=new PieData(pieDataSet);

        //PieChartにPieData格納
        PieChart pieChart =(PieChart)findViewById(R.id.pieChartExample);
        pieChart.setData(pieData);

        //Chartのフォーマット指定
        //特になし

        //画面に描画
        pieChart.invalidate();

        Button btnTask = findViewById(R.id.btnTask);
        btnTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,TaskListActivity.class);
        startActivity(intent);
    }
}