/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package kr.co.willsoft.webTest;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.cordova.CordovaActivity;
import org.apache.cordova.engine.SystemWebViewEngine;

public class MainActivity extends CordovaActivity{
    private static final String TAG = "MainActivity";

    private String phoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        super.init();


        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getBoolean("cdvStartInBackground", false)){
            moveTaskToBack(true);
        }

        AppInit();

        Log.d(TAG, "onCreate");
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }

    //App 시작 시 공통 init
    public void AppInit(){
        //외부링크 클릭 시 외부 브라우저 호출
        setWebViewClient();
        //App 실행자의 휴대폰번호
        getTelephoneNumber();
    }

    public void getTelephoneNumber(){
        TelephonyManager telephony = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        phoneNumber = telephony.getLine1Number();
    }

    public void setWebViewClient(){
        SystemWebViewEngine systemWebViewEngine = (SystemWebViewEngine)this.appView.getEngine();
        WebViewClient myWebViewClient = new MyWebViewClient(systemWebViewEngine);

        WebView webView = (WebView)systemWebViewEngine.getView();
        webView.setWebViewClient(myWebViewClient);
    }

    @Override
    public void onRestart(){
        Log.i(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    public void onStart(){
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume(){
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause(){
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop(){
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }
}
