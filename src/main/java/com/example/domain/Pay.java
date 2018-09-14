package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: ld
 * @Date: 2018/9/14 14:40
 * @Description:
 */
@Entity
public class Pay {
    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal amt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }
}
