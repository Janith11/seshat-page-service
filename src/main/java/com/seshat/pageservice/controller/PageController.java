package com.seshat.pageservice.controller;

import com.seshat.pageservice.model.Page;
import com.seshat.pageservice.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pages")
public class PageController {

    private final PageService pageService;

    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        List<Page> pages = this.pageService.getAllPages();
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable String id) {
        Optional<Page> page = this.pageService.getPageById(id);
        return page.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Page> addPage(@RequestBody Page page) {
        Page newPage = this.pageService.addPage(page);
        return new ResponseEntity<>(newPage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Page> updatePage(@PathVariable String id, @RequestBody Page page) {
        Page updatedPage = this.pageService.updatePage(id, page);
        if (updatedPage != null) {
            return new ResponseEntity<>(updatedPage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable String id) {
        this.pageService.deletePage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
