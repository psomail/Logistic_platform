package ru.logisticplatform.dto.transportation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.logisticplatform.dto.goods.GoodsTypeDto;
import ru.logisticplatform.dto.goods.GoodsTypeForCreateGoodsDto;
import ru.logisticplatform.model.transportation.TransportType;
import ru.logisticplatform.model.transportation.TransportationStatus;
import ru.logisticplatform.model.user.User;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportationDto {

    Long id;
    TransportTypeDto transportType;
    String model;
    List<GoodsTypeDto> goodsType;
    TransportationStatus transportationStatus;
}
