package com.luisjrz96.personalblog.core;

import com.luisjrz96.personalblog.core.api.exceptions.InternalServerServiceException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Utils {

    public static String getGenericTypeName(ParameterizedType parameterizedType, int typeIndex) {
        if (parameterizedType != null && typeIndex >= 0) {
            Type[] types = parameterizedType.getActualTypeArguments();
            if ( types != null && types.length >= typeIndex) {
                String[]typeInfo  = types[typeIndex].getTypeName().split("[.]");
                return typeInfo[typeInfo.length-1];
            }
        }
        throw new InternalServerServiceException(new RuntimeException("Unable to obtain information"));
    }
}
