package ru.logisticplatform.service.goods;

import ru.logisticplatform.model.goods.Goods;

import java.util.List;

public interface GoodsService {

    Goods findById(Long id);

    List<Goods> findAll();
}
