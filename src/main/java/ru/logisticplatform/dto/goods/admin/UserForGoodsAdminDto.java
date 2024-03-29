package ru.logisticplatform.dto.goods.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.logisticplatform.dto.user.UserDto;
import ru.logisticplatform.model.user.UserStatus;


//@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserForGoodsAdminDto {
    Long id;
    String username;
}
