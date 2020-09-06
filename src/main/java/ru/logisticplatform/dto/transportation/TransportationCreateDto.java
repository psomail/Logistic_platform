package ru.logisticplatform.dto.transportation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.logisticplatform.model.transportation.TransportationStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransportationCreateDto {

    TransportTypeCreateTransportationDto transportType;
    String model;
}