package com.example.lpoon2.browsertutorial;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by lpoon2 on 12/29/2015.
 */
public class webViewClient2 extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url){

        if(Uri.parse(url).getHost().endsWith(".com")) return false;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

}
