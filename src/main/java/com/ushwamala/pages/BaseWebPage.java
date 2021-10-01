package com.ushwamala.pages;

import com.ushwamala.panels.FooterPanel;
import com.ushwamala.panels.HeaderPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class BaseWebPage extends WebPage {
    public BaseWebPage(PageParameters parameters) {
        super(parameters);
        add(new HeaderPanel("headerPanel"));
        add(new FooterPanel("footerPanel"));
    }
}
