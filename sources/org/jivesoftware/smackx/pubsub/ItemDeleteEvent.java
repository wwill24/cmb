package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

public class ItemDeleteEvent extends SubscriptionEvent {
    private List<String> itemIds = Collections.emptyList();

    public ItemDeleteEvent(String str, List<String> list, List<String> list2) {
        super(str, list2);
        if (list != null) {
            this.itemIds = list;
            return;
        }
        throw new IllegalArgumentException("deletedItemIds cannot be null");
    }

    public List<String> getItemIds() {
        return Collections.unmodifiableList(this.itemIds);
    }

    public String toString() {
        return getClass().getName() + "  [subscriptions: " + getSubscriptions() + "], [Deleted Items: " + this.itemIds + PropertyUtils.INDEXED_DELIM2;
    }
}
