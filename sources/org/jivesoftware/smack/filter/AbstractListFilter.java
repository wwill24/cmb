package org.jivesoftware.smack.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;

public abstract class AbstractListFilter implements StanzaFilter {
    protected final List<StanzaFilter> filters;

    protected AbstractListFilter() {
        this.filters = new ArrayList();
    }

    public void addFilter(StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaFilter, "Parameter must not be null.");
        this.filters.add(stanzaFilter);
    }

    public final String toString() {
        return getClass().getSimpleName() + ": (" + StringUtils.toStringBuilder(this.filters, ", ") + PropertyUtils.MAPPED_DELIM2;
    }

    protected AbstractListFilter(StanzaFilter... stanzaFilterArr) {
        this((List<StanzaFilter>) new ArrayList(Arrays.asList(stanzaFilterArr)));
    }

    protected AbstractListFilter(List<StanzaFilter> list) {
        Objects.requireNonNull(list, "Parameter must not be null.");
        for (StanzaFilter requireNonNull : list) {
            Objects.requireNonNull(requireNonNull, "Parameter must not be null.");
        }
        this.filters = list;
    }
}
