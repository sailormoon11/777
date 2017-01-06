
package com.julia_sk.favorite;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import java.util.ArrayList;
        import android.app.Activity;
        import android.widget.ListView;

public class Main2Activity extends Activity {

    private ListView lessonListView;
    private LessonListAdapter appListAdapter;
    public static ArrayList<Lesson> lessonsList;
    public static void setLessonsList(ArrayList<Lesson> lessonsList1) {
        lessonsList = lessonsList1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        lessonListView = (ListView) findViewById(R.id.lessonList);

       // lessonsList = new ArrayList<Lesson>();


//        for (int i = 1; i < 11; i++) {
//            lessonsList.add(new Lesson("Урок " + i, "Текст урока номер " + i+ ". В этом уроке мы научимся ..."));
//        }

        appListAdapter = new LessonListAdapter(this, lessonsList);
        lessonListView.setAdapter(appListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(appListAdapter!=null){
            appListAdapter.notifyDataSetChanged();
        }
    }

}
