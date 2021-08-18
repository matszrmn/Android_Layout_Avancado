package br.com.moduloavancado.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class Travel {
    private UUID id;
    private String title;
    private String imgSrc;
    private BigInteger days;
    private BigDecimal value;

    public Travel(String title, BigInteger days, BigDecimal value, String imgSrc) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.days = days;
        this.value = value;
        this.imgSrc = imgSrc;
    }

    public UUID getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getDays() {
        return days;
    }

    @SuppressWarnings("unused")
    public void setDays(BigInteger days) {
        this.days = days;
    }

    public BigDecimal getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    @SuppressWarnings("unused")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
