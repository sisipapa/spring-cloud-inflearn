package com.sisipapa.catalogservice.service;

import com.sisipapa.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
