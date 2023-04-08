package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    //Vars
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }



    public Television(String make, String model, boolean smart, int screenSize, int resolution){
       if(make == null||make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720){
           throw new IllegalArgumentException("Invalid parameter in constructor");
       }
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        this.fourK = this.resolution == 2160;
    }

    public Television(String model, boolean smart, int screenSize, int resolution, String make){
        this (make, model, smart,screenSize,resolution);
    }

    @Override
    public String toString() {
        String Smarties = "";
        if (smart)
            Smarties = "smart ";
        String rez = Integer.toString(getResolution());
        if (this.getResolution() == 2160)
            rez = "4K";

        return
                make + '-' +
                model + ", " +
                screenSize +" inch "+ Smarties+ "tv with " +
                rez + " resolution";


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(fourK) + make.hashCode() + model.hashCode() + resolution + Boolean.hashCode(smart);
    }

    @Override
    public int compareTo(Television another) {
        if(another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        if(this.make.compareTo(another.make) == 0){
            if(this.model.compareTo(another.model)==0){
               return this.getScreenSize()-another.getScreenSize();
            }
            else{return this.model.compareTo(another.model);}
        }
        return this.make.compareTo(another.make);}
    }
