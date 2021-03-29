package com.netease.storedemo.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
@Data
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Integer type;


}
