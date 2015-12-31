package com.example.lpoon2.browsertutorial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private WebView myWebView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
       // myWebView.loadUrl("http://html5test.com");
        String something = "<html><body>Type something <b>above</b></body></html>";
        myWebView.loadData(something, "text/html", "utf-8");
        myWebView.setWebViewClient(new webViewClient2());

        editText = (EditText)findViewById(R.id.text) ;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    if(!editText.getText().toString().contains("http://")){
                        myWebView.loadUrl("http://" + editText.getText().toString());
                        editText.setText("http://" + editText.getText().toString());

                    }
                     else {
                        myWebView.loadUrl(editText.getText().toString());
                        editText.setText(editText.getText().toString());
                    }
                        //myWebView.setWebViewClient(new webViewClient2());
                        handled = true;
                }
                return handled;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        if( myWebView.canGoBack()) myWebView.goBack();
        else super.onBackPressed();


    }
}
