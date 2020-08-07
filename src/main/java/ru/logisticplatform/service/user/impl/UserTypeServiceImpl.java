package ru.logisticplatform.service.user.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.logisticplatform.model.user.UserType;
import ru.logisticplatform.repository.user.UserTypeRepository;
import ru.logisticplatform.service.user.UserTypeService;

/**
 * Implementation of {@link UserTypeService} interface.
 * Wrapper for {@link UserTypeRepository} + business logic.
 *
 * @author Sergei Perminov
 * @version 1.0
 */


@Service
@Slf4j
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserType findByUserTypeName(String userTypeName) {
        UserType userType = userTypeRepository.findByName(userTypeName);
        log.info("IN RoleServiceImpl findByRoleName - userType: {} found by userTypeName: {}", userType, userTypeName);
        return userType;
    }
}