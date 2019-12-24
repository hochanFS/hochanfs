package com.financescript.springapp.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article extends BaseEntity {
    @ManyToOne
    private User author;

    private String title;

    @Lob
    private String contents;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Article(Long id, User author, String title, String contents, List<Comment> comments) {
        super(id);
        this.author = author;
        this.title = title;
        this.contents = contents;
        if (comments != null)
            this.comments = comments;
    }
}
