package kr.co.willsoft.webTest;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import org.apache.cordova.engine.SystemWebViewClient;
import org.apache.cordova.engine.SystemWebViewEngine;

/**
 * Created by rudalee on 2017. 6. 14..
 */

public class MyWebViewClient extends SystemWebViewClient{
    private static final String TAG = "MyWebViewClient";

    public MyWebViewClient(SystemWebViewEngine parentEngine){
        super(parentEngine);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
        Log.i(TAG, "shouldOverrideUrlLoading");
        Uri uri = request.getUrl();

        if(uri.getScheme().equals("http") || uri.getScheme().equals("https")){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            view.getContext().startActivity(intent);
            return true;
        }else{
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
