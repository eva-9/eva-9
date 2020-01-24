package com.eva9.common.util.model;

import lombok.Data;

/**
 * @author Steve Jin
 * @description
 * @date 2020-01-12 13:20
 **/
@Data
public class CommandResult {

    public static final int EXIT_VALUE_TIMEOUT=-1;
    private int exitValue;
    private String output;
    private String error;

}
