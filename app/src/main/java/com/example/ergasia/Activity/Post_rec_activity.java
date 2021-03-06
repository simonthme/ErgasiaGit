package com.example.ergasia.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ergasia.R;
import com.example.ergasia.Helper.SQLiteHandler;
import com.example.ergasia.Helper.SessionManager;

public class Post_rec_activity extends Activity {

    Button jepostButton;
    Button jerecButton;
    private SessionManager session;
    private SQLiteHandler db;
    private static Boolean isPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_rec_activity);

        // SQlite database handler
        db = new SQLiteHandler(getApplicationContext());
        // Session manager
        session = new SessionManager(getApplicationContext());


        //check if user is already logged in
        if (session.isLoggedIn()) {
            if (session.isCandidate()) {
                //User is already logged in. Take him to Post/Rec activity
                Intent i = new Intent(Post_rec_activity.this, MainTabbedActivityPost.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(Post_rec_activity.this, MainTabbedActivityRec.class);
                startActivity(i);
                finish();
            }
            // A FAIRE: différencier Postulant Recruteur
        }

        addListenerOnButton();

    }

    private void addListenerOnButton() {

        //final Context context = this;

        jepostButton = (Button) findViewById(R.id.postButton);
        jerecButton = (Button) findViewById(R.id.recButton);

        jepostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                isPost = true;
                Intent i = new Intent(Post_rec_activity.this, LoginActivity.class);
                startActivity(i);

            }
        });

        jerecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                isPost = false;
                Intent i = new Intent(Post_rec_activity.this, LoginActivity.class);
                startActivity(i);

            }
        });
    }


    public static boolean getIsPost() {
        return isPost;
    }

}
