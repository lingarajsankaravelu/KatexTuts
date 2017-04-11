package katex.hourglass.in.katextuts.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import katex.hourglass.in.katextuts.R;

/**
 * Created by lingaraj on 4/4/17.
 */

public class MathviewInLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathview_in_layout);
        setInitialViews();
    }

    private void setInitialViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Katex MathView In Layout Demo");

    }
}
