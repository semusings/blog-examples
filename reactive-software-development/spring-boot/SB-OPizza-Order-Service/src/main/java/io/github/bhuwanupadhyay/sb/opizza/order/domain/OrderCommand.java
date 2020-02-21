package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface OrderCommand {

    String getName();

    @RequiredArgsConstructor
    @Getter
    class ItemAddCommand {

        private final String itemId;

        private final Integer quantity;

    }

    @RequiredArgsConstructor
    @Getter
    class OrderPlaceCommand implements OrderCommand {

        private final String name;

    }
}
