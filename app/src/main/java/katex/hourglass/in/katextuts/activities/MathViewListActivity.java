package katex.hourglass.in.katextuts.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import katex.hourglass.in.katextuts.R;
import katex.hourglass.in.katextuts.adapters.MathListAdapter;

/**
 * Created by lingaraj on 4/4/17.
 */

public class MathViewListActivity extends AppCompatActivity {

    private List<String> formulas = new ArrayList<>();
    private String TAG = "MATHVIEWINLIST";
    private RecyclerView mRecyclerview;
    private MathListAdapter math_list_adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathview_list);
        retriveFormulas();
        setInitialViews();

    }

    private void setInitialViews() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setHasFixedSize(false);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        math_list_adapter = new MathListAdapter(MathViewListActivity.this,new CardClick(),formulas);
        mRecyclerview.setAdapter(math_list_adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Katex MathView In List Demo");

        Log.d(TAG,"Layout Views Initialized");


    }

    private void retriveFormulas() {
        formulas = Arrays.asList(getResources().getStringArray(R.array.formulas));
        Log.d(TAG,"Formulas loaded from String array");

    }

    public class CardClick implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
            int position = mRecyclerview.getChildAdapterPosition(view);
            math_list_adapter.toggleMarked(position);
            Log.d(TAG,"Card Click Position:"+position);

        }
    }
}
