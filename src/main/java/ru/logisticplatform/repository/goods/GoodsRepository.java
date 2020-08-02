package ru.logisticplatform.repository.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.logisticplatform.model.goods.Goods;

/**
 * Repository interface that extends {@link JpaRepository} for class {@link Goods}.
 *
 * @author Sergei Perminov
 * @version 1.0
 */

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
