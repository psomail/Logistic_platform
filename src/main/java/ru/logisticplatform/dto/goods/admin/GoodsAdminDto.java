package ru.logisticplatform.dto.goods.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.logisticplatform.dto.goods.GoodsTypeDto;
import ru.logisticplatform.dto.goods.GoodsTypeUserDto;
import ru.logisticplatform.dto.user.AdminUserDto;
import ru.logisticplatform.model.goods.Goods;
import ru.logisticplatform.model.goods.GoodsPrivate;
import ru.logisticplatform.model.goods.GoodsType;

import java.util.Date;

/**
 * DTO class for user requests by {@link Goods}
 *
 * @author Sergei Perminov
 * @version 1.0
 */


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsAdminDto {

    Long id;
    GoodsTypeAdminDto goodsType;
    String name;
    Double lenght;
    Double width;
    Double height;
    Double volume;
    Double carrying;
    GoodsPrivate goodsPrivate;
    AdminUserDto user;
    Date created;
    Date updated;

}