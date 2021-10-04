package com.ushwamala.services;

import com.ushwamala.entities.Table;

public class TableService extends BaseService<Table> {

    public TableService() {
        final Table costaRica = new Table("Costa Rica", 4);
        final Table panama = new Table("Panama", 4);
        final Table honduras = new Table("Honduras", 6);
        final Table mexico = new Table("Mexico", 12);
        final Table cuba = new Table("Cuba", 8);

        save(costaRica);
        save(panama);
        save(honduras);
        save(mexico);
        save(cuba);
    }
}
