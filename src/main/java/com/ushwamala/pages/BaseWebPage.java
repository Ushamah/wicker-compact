package com.ushwamala.pages;

import com.ushwamala.enums.Tenant;
import com.ushwamala.panels.FooterPanel;
import com.ushwamala.panels.HeaderPanel;
import com.ushwamala.resources.BootstrapCssResourceReference;
import com.ushwamala.resources.CafeoneTheme;
import com.ushwamala.resources.DefaultTheme;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BaseWebPage extends WebPage {

    private Tenant tenant;

    public BaseWebPage(PageParameters parameters) {
        super(parameters);
        add(new HeaderPanel("headerPanel").setRenderBodyOnly(true));
        add(new FooterPanel("footerPanel").setRenderBodyOnly(true));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
       tenant = Tenant.get();
    }

    @Override
    public void renderHead(IHeaderResponse response){
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(BootstrapCssResourceReference.get()));
       if(tenant.equals(Tenant.DEFAULT)){
           response.render(CssHeaderItem.forReference(DefaultTheme.get()));
       } else {
           response.render(CssHeaderItem.forReference(CafeoneTheme.get()));
       }
    }
}
