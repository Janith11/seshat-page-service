package com.seshat.pageservice.service;

import com.seshat.pageservice.model.Page;
import com.seshat.pageservice.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Override
    public List<Page> getAllPages() {
        return this.pageRepository.findAll();
    }

    @Override
    public Optional<Page> getPageById(String id) {
        return this.pageRepository.findById(id);
    }

    @Override
    public Page addPage(Page page) {
        return this.pageRepository.save(page);
    }

    @Override
    public Page updatePage(String id, Page page) {
        if (this.pageRepository.existsById(id)) {
            page.setId(id);
            return this.pageRepository.save(page);
        } else {
            return null; // or throw exception
        }
    }

    @Override
    public void deletePage(String id) {
        this.pageRepository.deleteById(id);
    }
}
