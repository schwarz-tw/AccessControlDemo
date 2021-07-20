package com.example.demo.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cardid;
    private String type;
    private String data;

    public Card() {
    }

    public Card(long id, String cardid, String type, String data) {
        this.id = id;
        this.cardid = cardid;
        this.type = type;
        this.data = data;
    }

    public String getCardid() {
        return cardid;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardid, card.cardid) && Objects.equals(type, card.type) && Objects.equals(data, card.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardid, type, data);
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardid='" + cardid + '\'' +
                ", type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
