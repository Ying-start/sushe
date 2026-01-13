package com.sushe.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Admin extends BasePageRequest {
    private  Integer a_id;
    private  String  a_username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String  a_password;
    private  String  a_name;
    private  Integer a_phone;
    private  Integer a_power;
    private  String  a_describe;

}
