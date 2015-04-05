package com.modirum.app.container;

import java.math.BigDecimal;
import java.util.Collections;
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

    private List<BigDecimal> uneven = new LinkedList<>();

    public List<BigDecimal> getEven() {
        return even;
    }

    public void setEven(BigDecimal even) {
        this.even.add(even);
    }

    public List<BigDecimal> getUneven() {
        return uneven;
    }

    public void setUneven(BigDecimal uneven) {
        this.uneven.add(uneven);
    }

    /**
     * Sort all collections
     */
    public void sortAll() {
        Collections.sort(even);
        Collections.sort(uneven);
    }

    public BigDecimal getEvenSum() {
        return getSum(even);
    }

    public BigDecimal getUnevenSum() {
        return getSum(uneven);
    }

    private BigDecimal getSum(List<BigDecimal> values) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal value : values) {
            sum = sum.add(value);
        }
        return sum;
    }
}
