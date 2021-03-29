package com.netease.storedemo.sys.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Orders {

    private static final long serialVersionUID = 1L;

    @TableField("goodId")
    private Integer goodId;

    private LocalDate time;

    private Integer number;

    @TableField("boughtPrice")
    private Float boughtPrice;


}
