package fr.tabbya.instantvisio;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Copyright (c) 2019 - Stéphane Luçon 20/03/2020
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class Disclaimer extends Activity {


    private Context mContext;
    private static final String TAG = "DisclaimerFragment";
    private Button validation;
    private Button refusal;
    private TextView disclaimer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "****** ON VIEW CREATED ");



        setContentView(R.layout.disclaimer);

        disclaimer = (TextView) findViewById(R.id.disclaimerText);
        disclaimer.setMovementMethod(new ScrollingMovementMethod());

        validation = (Button) findViewById(R.id.acceptPolicy);
        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferencesManager.setDisclaimerDone(true);
                Intent newActivity = new Intent(Disclaimer.this, MainActivity.class);
                newActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                newActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newActivity);

            }
        });


        refusal = (Button) findViewById(R.id.refusePolicy);
        refusal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferencesManager.setDisclaimerDone(false);

                /** let's close it all */
                finish();
                finishAffinity();


            }

        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
    finish();
    finishAffinity();
    }
    }

