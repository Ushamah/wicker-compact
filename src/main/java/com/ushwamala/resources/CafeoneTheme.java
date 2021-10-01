package com.ushwamala.resources;

import org.apache.wicket.request.resource.PackageResourceReference;

public class CafeoneTheme extends PackageResourceReference {
    private static final CafeoneTheme INSTANCE = new CafeoneTheme();

    public CafeoneTheme() {
        super(CafeoneTheme.class, "com.ushwamala.resources/cafeone.css");
    }

    public static CafeoneTheme get() {
        return INSTANCE;
    }

}
