package com.ushwamala.resources;

import org.apache.wicket.request.resource.PackageResourceReference;

public class DefaultTheme extends PackageResourceReference {
    private static final DefaultTheme INSTANCE = new DefaultTheme();

    public DefaultTheme() {
        super(DefaultTheme.class, "com.ushwamala.resources/sg-default.css");
    }

    public static DefaultTheme get() {
        return INSTANCE;
    }

}
