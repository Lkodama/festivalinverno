package com.kodamalabs.festivalinverno.mappers;

import android.app.Activity;

import com.kodamalabs.festivalinverno.models.FoodTruck;
import com.kodamalabs.festivalinverno.utils.JsonConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FoodTruckMapper {

    private static List<FoodTruck> foodTruckList;

    public static List<FoodTruck> getFoodTruckList(Activity activity) throws JSONException {
        foodTruckList = new ArrayList<>();
        String json = JsonConverter.loadJSONFromAsset(activity, "foodtruck.json");
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            foodTruckList.add(new FoodTruck(jsonObject.getString("name"),jsonObject.getString("description"),jsonObject.getString("imageUrl")));
        }

        return foodTruckList;
    }
}
