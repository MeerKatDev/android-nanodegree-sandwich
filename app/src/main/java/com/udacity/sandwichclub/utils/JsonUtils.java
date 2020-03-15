package com.udacity.sandwichclub.utils;

import android.util.Log;

import java.util.ArrayList;
import com.udacity.sandwichclub.model.Sandwich;
import org.json.*;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            Log.d("TAG", json);
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");
            String mainName = nameObject.getString("mainName");
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");

            return new Sandwich(
                    mainName,
                    arrayToList(alsoKnownAs),
                    placeOfOrigin,
                    description,
                    image,
                    arrayToList(ingredients)
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<String> arrayToList(JSONArray a) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i < a.length(); i++) {
            try {
                list.add( a.getString(i) );
            } catch (JSONException e) {
                e.printStackTrace();
                return list;
            }
        }
        return list;
    }
}
