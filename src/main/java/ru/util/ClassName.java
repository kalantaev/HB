package ru.util;

/**
 * Created by ������������� on 27.03.2016.
 */
public class ClassName {
    private ClassName(){}
    public static String getClassName(){
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }
}
