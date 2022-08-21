package com.example.manytomanyrelation.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
@Embeddable
@Getter
@Setter
public class Phone {
    private String number;
    private String areaCode;
    private String countryCode;
}
