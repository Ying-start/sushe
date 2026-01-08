package com.sushe.po.export;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AdminExport {
    private  Integer a_id;
    private  String  a_username;

    @JsonIgnore
    private  String  a_password;

    private  String  a_name;
    private  Integer a_phone;

    @JsonIgnore
    private  Integer a_power;

    private  String  a_describe;

}
