package com.example.asynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView1);

        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        // Save the state of the TextView
        String content = mTextView.getText().toString();

        outState.putString(TEXT_STATE,
                mTextView.getText().toString());


    }

    public class SimpleAsyncTask extends AsyncTask<Void, Void, String>{

        private WeakReference<TextView> mTextView;

        public SimpleAsyncTask(TextView textView) {
            this.mTextView = new WeakReference<>(textView);
        }

        @Override
        protected String doInBackground(Void... voids) {
            Random r = new Random();
            int n = r.nextInt(11);

            int s = n * 200;

            try {
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Return a String result
            return "Awake at last after sleeping for " + s + " milliseconds!";
        }

        @Override
        protected void onPostExecute(String result) {
            mTextView.get().setText(result);
        }
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        new SimpleAsyncTask(mTextView).execute();
    }
}
