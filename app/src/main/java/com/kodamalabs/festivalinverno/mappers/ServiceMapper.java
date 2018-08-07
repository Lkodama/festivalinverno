package com.kodamalabs.festivalinverno.mappers;

import android.app.Activity;

import com.kodamalabs.festivalinverno.models.FoodTruck;
import com.kodamalabs.festivalinverno.models.Services;
import com.kodamalabs.festivalinverno.utils.JsonConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServiceMapper {

    public static List<Services> services;

    public static List<Services> getServicesList(Activity activity, String category) throws JSONException {
        services = new ArrayList<>();
        String json = JsonConverter.loadJSONFromAsset(activity, getFileName(category));
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++){
            JSONObject jsonObject = array.getJSONObject(i);
            services.add(new Services(jsonObject.getString("name"),jsonObject.getString("description"),jsonObject.getString("address"),
                    jsonObject.getString("latitude"),jsonObject.getString("longitude"),jsonObject.getString("imageUrl")));
        }

        return services;
    }

    private static String getFileName(String category){
        switch (category){
            case "COMPRAS" :
             return "compras.json";

            case "RESTAURANTE" :
                return "restaurante.json";

            case "POUSADA":
                return "pousada.json";

            case "SAUDE" :
                return "saude.json";

            case "SERVICO" :
                return "servico.json";

                default: return "compras.json";
        }

    }
}
