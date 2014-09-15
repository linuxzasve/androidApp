package com.linuxzasve.mobile.googl;

import android.content.Context;

import com.google.gson.Gson;
import com.linuxzasve.mobile.googl.model.GooGlRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;

/**
 * Class is used to shorten URL via goo.gl service.
 *
 * @author dejan
 */
public class GoogleUrlShortener {

    private static final String POST_URL = "https://www.googleapis.com/urlshortener/v1/url";
    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Method shortens url
     *
     * @param context android context
     * @param longUrl long url to be shortened
     * @param handler response handler
     */
    public static void ShortenUrl(final Context context, final String longUrl, final AsyncHttpResponseHandler handler) {

        GooGlRequest r = new GooGlRequest();
        r.setLongUrl(longUrl);

        Gson gson = new Gson();

        StringEntity entity = null;

        Header[] headers = new Header[1];
        headers[0] = new BasicHeader("Content-Type", "application/json");

        try {
            entity = new StringEntity(gson.toJson(r));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        post(context, POST_URL, headers, entity, handler);

    }

    /**
     * Method makes POST request to given url, with given entity as body. Response is handeled
     * in responseHandler.
     *
     * @param context         android context
     * @param url             url to POST to
     * @param entity          request body
     * @param responseHandler response handler
     */
    private static void post(final Context context, final String url, final Header[] headers, final HttpEntity entity, final AsyncHttpResponseHandler responseHandler) {
        client.post(context, url, headers, entity, "application/json", responseHandler);
    }
}
