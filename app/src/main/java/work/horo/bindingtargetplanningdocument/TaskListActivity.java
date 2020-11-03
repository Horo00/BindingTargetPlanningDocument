package work.horo.bindingtargetplanningdocument;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskListActivity extends AppCompatActivity {

    List<Map<String, String>> parentList;
//    List<Map<String, String>> parentDataList;
//    Map<String, String> parentData;
    List<List<Map<String, String>>> childList;
    List<Map<String, String>> childDataList;
    Map<String, String> childData;

    final String PARENT_KEY = "parentKey";
    final String CHILD_KEY ="childKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        parentList = new ArrayList<>();
        childList = new ArrayList<>();

        Task sampleTask1 = new Task("sample1");
        sampleTask1.setChildTask("子sample1","子のサンプル１です");
//        sampleTask1.setChildTaskDescriptions("子のサンプル１です");

        Task sampleTask2 = new Task("sample2");
        sampleTask2.setChildTask("子sampleA","子sampleAです");
//        sampleTask2.setChildTaskDescriptions("子sampleAです");
        sampleTask2.setChildTask("子sampleB","子サンプルBです");
//        sampleTask2.setChildTaskDescriptions(("子サンプルBです"));


        //親リストに表示する内容を生成
        setParentList("parentKey", sampleTask1.getParentTask());
        setParentList("parentKey", sampleTask2.getParentTask());

        //子リストに表示する内容を生成
        String firstItemName1[] = {"子1", "子2"};
        String secondItemName1[] = {"子1段目", "子2段目"};
        setChildDataList("childKey1",sampleTask1);

        String firstItemName2[] = {"子A", "子B", "子C"};
        String secondItemName2[] = {"子A段目", "子B段目", "子C段目"};
        setChildDataList("childKey1", sampleTask2);

        //アダプタ作成
        SimpleExpandableListAdapter adapter =
                new SimpleExpandableListAdapter(
                        this,
                        parentList,
                        android.R.layout.simple_expandable_list_item_1,
                        new String[]{"parentKey"},
                        new int[]{android.R.id.text1},
                        childList,
                        android.R.layout.simple_expandable_list_item_2,
                        new String[]{"childKey1", "childKey2"},
                        new int[]{android.R.id.text1, android.R.id.text2}
                );

        ExpandableListView elv = findViewById(R.id.listView);
        elv.setAdapter(adapter);

    }

    /**
     * 親リストに表示する内容を生成する処理
     * @param parentKey
     * @param value
     * @return　parentList
     */
    private List<Map<String, String>> setParentList(String parentKey, String value) {
        Map<String, String> parentData = new HashMap<String, String>();
        parentData.put(parentKey, value);
        parentList.add(parentData);
        return parentList;
    }

    /**
     * 子リストに表示する内容を生成する処理
     * @param childKey1
     * @param firstItemName
     * @param childKey2
     * @param secondItemName
     * @return childDataList
     */
    private List<Map<String, String>> setChildData(String childKey1, String firstItemName, String childKey2, String secondItemName) {
        childData = new HashMap<String, String>();
        childData.put(childKey1, firstItemName);
        childData.put(childKey2, secondItemName);
        childDataList.add(childData);
        return childDataList;
    }
//
//    /**
//     * 子リストを表示数分作成する処理
//     * @param childKey1
//     * @param firstItemName
//     * @param childKey2
//     * @param secondItemName
//     * @return childList
//     */
//    private List<List<Map<String, String>>> setChildDataList(String childKey1, String firstItemName[], String childKey2, String secondItemName[]) {
//        childDataList = new ArrayList<>();
//        //作成する項目数の回数繰り返す
//        for (int i = 0; i < firstItemName.length; i++) {
//            setChildData(childKey1, firstItemName[i], childKey2, secondItemName[i]);
//        }
//        childList.add(childDataList);
//        return childList;
//    }
    private List<List<Map<String, String>>> setChildDataList(String childKey1,Task sampleTask) {
        childDataList = new ArrayList<>();
        //作成する項目数の回数繰り返す
        String childKey2 = "childKey2";
        for (int i = 0; i < sampleTask.getChildList().size(); i++) {
            setChildData(childKey1, sampleTask.getChildList().get(i), childKey2, sampleTask.getChildTaskDescriptions().get(i));
        }
        childList.add(childDataList);
        return childList;
    }
}