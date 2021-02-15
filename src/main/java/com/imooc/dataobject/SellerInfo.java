package com.imooc.dataobject;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class SellerInfo {

    @Id
    private  String sellerId;

    private  String username;

    private  String password;

    private  String openid;

}
