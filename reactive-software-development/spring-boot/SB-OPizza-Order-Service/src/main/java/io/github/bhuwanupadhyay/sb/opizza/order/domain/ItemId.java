package io.github.bhuwanupadhyay.sb.opizza.order.domain;

import io.github.bhuwanupadhyay.sb.opizza.shared.Asserts;
import io.github.bhuwanupadhyay.sb.opizza.shared.Identifier;

public class ItemId implements Identifier<String> {

    private static final String MISSING_ITEM_ID = "missing item id";

    private final String id;

    public ItemId(String id) {
        Asserts.notEmpty(id, MISSING_ITEM_ID);
        this.id = id;
    }

    @Override
    public String value() {
        return id;
    }
}
