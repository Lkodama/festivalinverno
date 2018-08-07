package com.kodamalabs.festivalinverno.mappers;

import android.app.Activity;

import com.kodamalabs.festivalinverno.models.FoodTruck;
import com.kodamalabs.festivalinverno.models.Services;
import com.kodamalabs.festivalinverno.models.Sightseeing;
import com.kodamalabs.festivalinverno.utils.JsonConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SightseeingMapper {

    private static List<Sightseeing> sightseeingList;

    public static List<Sightseeing> getSightseeingList(Activity activity) throws JSONException {
        sightseeingList = new ArrayList<>();
        String json = JsonConverter.loadJSONFromAsset(activity, "turismo.json");
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            List<String> listImagesUrl = new ArrayList<>();
            JSONArray imagesUrl = jsonObject.getJSONArray("listImagesUrl");
            for(int j = 0; j< imagesUrl.length(); j++){
                listImagesUrl.add(imagesUrl.getString(j));
            }
            sightseeingList.add(new Sightseeing(jsonObject.getString("name"),jsonObject.getString("description"),
                    jsonObject.getString("latitude"),jsonObject.getString("longitude"), listImagesUrl));
        }

        return sightseeingList;
    }
}
