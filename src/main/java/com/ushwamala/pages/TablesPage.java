package com.ushwamala.pages;

import java.util.ArrayList;
import java.util.Collection;

import com.ushwamala.entities.Table;
import com.ushwamala.services.ServiceRegistry;
import com.ushwamala.services.TableService;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class TablesPage extends BaseEntitiesPage {
    private final DataView<Table> tables;

    public TablesPage(PageParameters parameters) {
        super(parameters);

        TableService tablesService = ServiceRegistry.get(TableService.class);
        Collection<Table> tenantTables = tablesService.listAll();

        IDataProvider<Table> tablesDataProvider = new ListDataProvider<>(new ArrayList<>(tenantTables));
        this.tables = new DataView<>("tables", tablesDataProvider) {
            @Override
            protected void populateItem(Item<Table> item) {
                Table table = item.getModelObject();
                item.add(new Label("name", table.getName()));
                item.add(new Label("seatCount", table.getSeatCount()));
                item.add(new Label("orderableElectronically", table.getOrderableElectronically()));
            }
        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        tables.setItemsPerPage(3);
        add(this.tables);
    }

    @Override
    protected IPageable getPageable() {
        return this.tables;
    }
}
