package com.demo.beans;

import com.demo.common.ValidatorGroup1;
import com.demo.common.ValidatorGroup2;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductInfo {

    private Integer prdId;
    @NotBlank(message = "请输入商品名称")
    private String prdName;
    private Integer typeId;
    private String  desc;
    @NotNull(message = "请输入商品价格")
    private Float price;



    @NotNull(groups = ValidatorGroup2.class)
    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    @NotBlank(message = "请输入商品名",groups = {ValidatorGroup1.class,ValidatorGroup2.class})
    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @NotEmpty
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
