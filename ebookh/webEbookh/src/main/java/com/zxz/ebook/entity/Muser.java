package com.zxz.ebook.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class Muser {

    @Id
    public String id;
    public String username;
    public String nickname;

    public Muser() {}

    public Muser(String username, String nickname) {
        this.username=username;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return String.format(
                "Muser[id=%s, username='%s', nickname='%s']",
                id, username, nickname);
    }

}
