package jpawebpratice.jpapratice.domain;

import jpawebpratice.jpapratice.domain.Exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.Embeddable;

import static jpawebpratice.jpapratice.domain.comm.commFunction.isStringEmpty;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    protected Address() {

    }
}
