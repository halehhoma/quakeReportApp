package com.example.android.Earthquake;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Loader;
import android.os.AsyncTask;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private static final String LOG_TAG=EarthquakeLoader.class.getName();
    private String mUrl;



    public EarthquakeLoader(Context context, String Url) {
        super(context);
        mUrl=Url;
    }

    private void OnStartLoading(){forceLoad();}

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {

    }

    public List<Earthquake> loadInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
//        mUrl= Urls[0]
        if (earthquakes != null && !earthquakes.isEmpty()) {
                return null;
            }

            List<Earthquake> earthquakes = QuaryUtils.fetchEarthquakeData(urls[0]);
            return earthquakes;
        }

        List<Earthquake> earthquakes = QuaryUtils.fetchEarthquakeData(mUrl);

    @Override
    public List<Earthquake> loadInBackground() {
        return null;
    }


        return earthquakes;
    }

}
