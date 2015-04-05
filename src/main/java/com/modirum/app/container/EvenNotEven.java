package com.modirum.app.container;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mf
 * Date: 05.04.15
 * Time: 18:53
 */
public class EvenNotEven {

    private List<BigDecimal> even = new LinkedList<>();

    private List<BigDecimal> notEven = new LinkedList<>();

    public List<BigDecimal> getEven() {
        return even;
    }

    public void setEven(BigDecimal even) {
        this.even.add(even);
    }

    public List<BigDecimal> getNotEven() {
        return notEven;
    }

    public void setNotEven(BigDecimal notEven) {
        this.notEven.add(notEven);
    }
}
