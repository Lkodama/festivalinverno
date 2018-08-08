package com.kodamalabs.festivalinverno.mappers;

import android.app.Activity;

import com.kodamalabs.festivalinverno.models.LineUp;
import com.kodamalabs.festivalinverno.utils.JsonConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LineupMapper {

    private static List<LineUp> lineUpList;

    public static List<LineUp> getLineUpList(Activity activity, String filename) throws JSONException {

        lineUpList = new ArrayList<>();
        String json = JsonConverter.loadJSONFromAsset(activity, filename);
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            lineUpList.add(new LineUp(jsonObject.getInt("id"),jsonObject.getString("time"),jsonObject.getString("band"),jsonObject.getString("description"), jsonObject.getString("imgUrl")));
        }

        return lineUpList;
    }
}
