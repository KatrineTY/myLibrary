package com.library.dao.objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "readers")
public class Reader {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reader_name")
    @NotNull(message = "Непустое поле!")
    @Size(min = 4, max = 16, message = "Длина логина должна быть от 4 до 16 символов")
    private String readerName;
    @Column(name = "phone")
    @NotNull(message = "Непустое поле!")
    @Size(min = 6, max = 16, message = "Длина пароля должна быть от 6 до 16 символов")
    private String password;

    public Reader() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
