package work.horo.bindingtargetplanningdocument;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


class Task{
    private String parentTask; //大タスク
    private int targetGrowthRate; //目標達成率
    private List<String> childList = new ArrayList<>(); //小タスクのタイトル
    private List<String> childTaskDescriptions = new ArrayList<>(); //小タスクの説明文
    private int id;
    static final String FILE = "taskData.txt"; //タスクを保存するファイル

    /**
     * 達成率引数なしのコンストラクタ
     */
     Task(String parentTask){
         this.parentTask=parentTask;
         targetGrowthRate = 0;
     }

    /**
     * 達成率引数ありのコンストラクタ
     */
     Task(String parentTask,int targetGrowthRate){
         this.parentTask=parentTask;
         this.targetGrowthRate = targetGrowthRate;
     }


     void setChildTask(String childTask,String description){
         childList.add(childTask);
         childTaskDescriptions.add(description);
     }


     void setChildTaskDescriptions(String description){
         childTaskDescriptions.add(description);
     }

     String getParentTask(){
         return parentTask;
     }

     List<String> getChildList(){
         return childList;
     }

     List<String> getChildTaskDescriptions(){
         return childTaskDescriptions;
     }

}
