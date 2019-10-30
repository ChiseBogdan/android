package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private EditText mReplyTextView;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReplyTextView = (EditText) findViewById(R.id.editText_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On Create");
    }

    public void replyToMainActivity(View view) {
        String replyMessage = mReplyTextView.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, replyMessage);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On ReStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "-------------");
        Log.d(LOG_TAG, "On Destroy");
    }
}
