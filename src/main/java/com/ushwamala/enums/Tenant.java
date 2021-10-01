package com.ushwamala.enums;

public enum Tenant {
    DEFAULT, CAFE_MUC;

    public static Tenant get(){
        final String tenant = System.getProperty("tenant");
        if(tenant == null){
            return DEFAULT;
        }
        return Tenant.valueOf(tenant.toUpperCase());
    }
}
