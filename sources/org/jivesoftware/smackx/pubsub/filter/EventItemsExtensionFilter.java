package org.jivesoftware.smackx.pubsub.filter;

import org.jivesoftware.smack.filter.ExtensionElementFilter;
import org.jivesoftware.smackx.pubsub.EventElement;
import org.jivesoftware.smackx.pubsub.EventElementType;

public final class EventItemsExtensionFilter extends ExtensionElementFilter<EventElement> {
    public static final EventItemsExtensionFilter INSTANCE = new EventItemsExtensionFilter();

    private EventItemsExtensionFilter() {
        super(EventElement.class);
    }

    public boolean accept(EventElement eventElement) {
        return eventElement.getEventType() == EventElementType.items;
    }
}
