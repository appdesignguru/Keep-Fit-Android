package com.kratos.keepfit.core;

import android.graphics.drawable.Drawable;

public class Exercise {

    private final int exerciseId;
    private final String name;
    private final String details;
    private final Drawable drawableResource;

    public Exercise(int exerciseId, String name, String details, Drawable drawableResource) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.details = details;
        this.drawableResource = drawableResource;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Drawable getDrawableResource() {
        return drawableResource;
    }
}