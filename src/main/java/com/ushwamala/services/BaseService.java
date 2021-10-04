package com.ushwamala.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ushwamala.entities.BaseEntity;

public abstract class BaseService<T extends BaseEntity> {

    private static long ENTITY_ID_COUNTER = 0;

    private final Map<Long, T> entities = new HashMap<>();

    public T save(T entity) {
        if (entity.getId() == null) {
            return insert(entity);
        }
        return updateEntity(entity);
    }

    private T insert(T entity) {
        entity.setId(++ENTITY_ID_COUNTER);
        entities.put(entity.getId(), entity);
        return entity;
    }

    private T updateEntity(T entity) {
        entities.put(entity.getId(), entity);
        return entity;
    }

    public T get(Long id) {
        return entities.get(id);
    }

    public Collection<T> listAll() {

        return entities.values();
    }

}
