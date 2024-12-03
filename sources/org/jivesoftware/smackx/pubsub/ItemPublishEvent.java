package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.pubsub.Item;

public class ItemPublishEvent<T extends Item> extends SubscriptionEvent {
    private List<T> items;
    private Date originalDate;

    public ItemPublishEvent(String str, List<T> list) {
        super(str);
        this.items = list;
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public Date getPublishedDate() {
        return this.originalDate;
    }

    public boolean isDelayed() {
        return this.originalDate != null;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append("  [subscriptions: ");
        sb2.append(getSubscriptions());
        sb2.append("], [Delayed: ");
        if (isDelayed()) {
            str = this.originalDate.toString();
        } else {
            str = "false";
        }
        sb2.append(str);
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public ItemPublishEvent(String str, List<T> list, List<String> list2) {
        super(str, list2);
        this.items = list;
    }

    public ItemPublishEvent(String str, List<T> list, List<String> list2, Date date) {
        super(str, list2);
        this.items = list;
        if (date != null) {
            this.originalDate = date;
        }
    }
}
