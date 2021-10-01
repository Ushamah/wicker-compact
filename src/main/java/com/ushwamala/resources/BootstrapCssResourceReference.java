package com.ushwamala.resources;

import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.PackageResourceReference;

public class BootstrapCssResourceReference extends PackageResourceReference {
    private static final BootstrapCssResourceReference INSTANCE = new BootstrapCssResourceReference();
    public BootstrapCssResourceReference() {
        super(BootstrapCssResourceReference.class, "com.ushwamala.resources/bootstrap.css");
    }

    public static BootstrapCssResourceReference get() {
        return INSTANCE;
    }

    //Adding the bootstrap.js dependency to bootstrap.css
    @Override
    public List<HeaderItem> getDependencies() {
        final List<HeaderItem> dependencies = super.getDependencies();
        dependencies.add(JavaScriptHeaderItem.forReference(BootstrapJsResourceReference.get()));
        return dependencies;
    }
}
