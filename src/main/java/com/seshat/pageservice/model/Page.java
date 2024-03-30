package com.seshat.pageservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pages")
public class Page {
    @Id
    private String id;
    private String userId;
    private String userName;
    private int pageCount;

}
