package com.kodamalabs.festivalinverno.utils;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

public class JsonConverter {

    public static String loadJSONFromAsset(Activity activity,String file) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
