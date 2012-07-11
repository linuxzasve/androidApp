package com.linuxzasve.mobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class Clanak extends Activity {
	
	public static String naslov_clanka = "com.example.myapp.MESSAGE";

	public final static String link = "com.example.myapp.MESSAGE";
	
	public void sendMessage(View view) {
	    Intent intent = new Intent(this, komentar_activity.class);
	    
	    intent.putExtra(link, naslov_clanka);
	    startActivity(intent);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clanak_activity);
        
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.link);
        
        RssFeed lzs_feed = new RssFeed("http://feeds.feedburner.com/linuxzasve");
        String sadrzaj = lzs_feed.getContentByTitle(message);
        
        String komentari_url = lzs_feed.getCommentsByTitle(message);
        
        naslov_clanka = komentari_url;
        
        WebView clanak = (WebView) findViewById(R.id.sadrzaj_clanka);
        
        WebSettings settings = clanak.getSettings();
      	settings.setDefaultTextEncodingName("utf-8");
      	clanak.getSettings().setJavaScriptEnabled(true);
      	clanak.getSettings().setBuiltInZoomControls(true);
      	
            // displaying selected product name
      	clanak.loadData(sadrzaj, "text/html", null);

        
    }
}
