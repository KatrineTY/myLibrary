package com.library.dao.objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Genre {
    private int id;

    @NotNull(message = "Непустое поле!")
    @Pattern(regexp = "[a-zA-Z]+[\\s[a-zA-Z]+]*" , message = "Должны быть только буквы")
    private String genreName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
