package com.seshat.pageservice.service;

import com.seshat.pageservice.model.Page;

import java.util.List;
import java.util.Optional;

public interface PageService {
    List<Page> getAllPages();

    Optional<Page> getPageById(String id);

    Page addPage(Page page);

    Page updatePage(String id, Page page);

    void deletePage(String id);
}
