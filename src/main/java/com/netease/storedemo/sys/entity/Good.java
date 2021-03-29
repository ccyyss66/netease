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
@EqualsAndHashCode()
@Accessors(chain = true)
public class Good  {

    private static final long serialVersionUID = 1L;

    private String goodname;

    private Float price;

    private String description;

    private String abstracts;

    private String pic;

    private Integer isSold;


}
