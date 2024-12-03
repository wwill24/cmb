package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.beanutils.PropertyUtils;

public class ToStringUtil {

    public static final class Builder {

        /* renamed from: sb  reason: collision with root package name */
        private final StringBuilder f24167sb;

        public <V> Builder add(String str, Collection<? extends V> collection, Function<?, V> function) {
            if (collection.isEmpty()) {
                return this;
            }
            StringBuilder sb2 = this.f24167sb;
            sb2.append(' ');
            sb2.append(str);
            sb2.append('[');
            ArrayList arrayList = new ArrayList(collection.size());
            for (Object apply : collection) {
                arrayList.add(function.apply(apply).toString());
            }
            StringUtils.appendTo((Collection<? extends Object>) arrayList, ", ", this.f24167sb);
            this.f24167sb.append(PropertyUtils.INDEXED_DELIM2);
            return this;
        }

        public Builder addValue(String str, Object obj) {
            if (obj == null) {
                return this;
            }
            StringBuilder sb2 = this.f24167sb;
            if (sb2.charAt(sb2.length() - 1) != '(') {
                this.f24167sb.append(' ');
            }
            StringBuilder sb3 = this.f24167sb;
            sb3.append(str);
            sb3.append("='");
            sb3.append(obj);
            sb3.append('\'');
            return this;
        }

        public String build() {
            this.f24167sb.append(PropertyUtils.MAPPED_DELIM2);
            return this.f24167sb.toString();
        }

        private Builder(StringBuilder sb2) {
            this.f24167sb = sb2;
        }
    }

    public static Builder builderFor(Class<?> cls) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getSimpleName());
        sb2.append(PropertyUtils.MAPPED_DELIM);
        return new Builder(sb2);
    }
}
