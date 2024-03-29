package ru.logisticplatform.service.transportation;

import ru.logisticplatform.model.transportation.TransportType;
import ru.logisticplatform.model.transportation.Transportation;
import ru.logisticplatform.model.transportation.TransportationStatus;
import ru.logisticplatform.model.user.User;

import java.util.List;

public interface TransportationService {

    Transportation findById(Long id);

    List<Transportation> findAll();

    List<Transportation> findAllByUser(User user);

    List<Transportation>  findAllByTransportationStatus(TransportationStatus status);

    List<Transportation> findAllByUserAndStatus(User user, TransportationStatus status);

    List<Transportation> findAllByUserAndStatusNotLike(User user, TransportationStatus status);

    Transportation findByTransportTypeAndModelAndUserAndTransportationStatusNotLike(TransportType transportType
                                                                                    ,String model
                                                                                    ,User user
                                                                                    ,TransportationStatus transportationStatus);

    Transportation createTransportation(Transportation transportation);

    Transportation updateTransportation(Transportation transportation);

    void delete(Long id);
}
