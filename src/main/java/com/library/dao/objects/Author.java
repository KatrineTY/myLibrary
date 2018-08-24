package com.library.dao.objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Author {
    private int id;

    @NotNull(message = "Непустое поле!")
    @Pattern(regexp = "[a-zA-Z]+[\\s[a-zA-Z]+]*" , message = "Должны быть только буквы")
    private String authorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
