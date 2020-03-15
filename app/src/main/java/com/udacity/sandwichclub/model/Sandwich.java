package com.udacity.sandwichclub.model;

import java.util.List;

public class Sandwich {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {

    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getIngredientsAsString() { return joinArrayList(this.ingredients); }
    public String getAlsoKnownAsAsString() { return joinArrayList(this.alsoKnownAs); }

    private String joinArrayList(List<String> al) {
        if(al.size()>0) {
            StringBuilder sb = new StringBuilder();
            for (String s : al) {
                sb.append(s);
                sb.append(", ");
            }
            sb.substring(0, sb.length() - 1);
            return sb.toString();
        } else return "";
    }
}
