package net.bytebuddy.matcher;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.beanutils.PropertyUtils;

@HashCodeAndEqualsPlugin.Enhance
public class StringMatcher extends ElementMatcher.Junction.ForNonNullValues<String> {
    private final Mode mode;
    private final String value;

    public enum Mode {
        EQUALS_FULLY("equals") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.equals(str);
            }
        },
        EQUALS_FULLY_IGNORE_CASE("equalsIgnoreCase") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.equalsIgnoreCase(str);
            }
        },
        STARTS_WITH("startsWith") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.startsWith(str);
            }
        },
        STARTS_WITH_IGNORE_CASE("startsWithIgnoreCase") {
            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale.", value = {"DM_CONVERT_CASE"})
            public boolean matches(String str, String str2) {
                return str2.toLowerCase().startsWith(str.toLowerCase());
            }
        },
        ENDS_WITH("endsWith") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.endsWith(str);
            }
        },
        ENDS_WITH_IGNORE_CASE("endsWithIgnoreCase") {
            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale.", value = {"DM_CONVERT_CASE"})
            public boolean matches(String str, String str2) {
                return str2.toLowerCase().endsWith(str.toLowerCase());
            }
        },
        CONTAINS("contains") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.contains(str);
            }
        },
        CONTAINS_IGNORE_CASE("containsIgnoreCase") {
            /* access modifiers changed from: protected */
            @SuppressFBWarnings(justification = "Both strings are transformed by the default locale.", value = {"DM_CONVERT_CASE"})
            public boolean matches(String str, String str2) {
                return str2.toLowerCase().contains(str.toLowerCase());
            }
        },
        MATCHES("matches") {
            /* access modifiers changed from: protected */
            public boolean matches(String str, String str2) {
                return str2.matches(str);
            }
        };
        
        private final String description;

        /* access modifiers changed from: protected */
        public String getDescription() {
            return this.description;
        }

        /* access modifiers changed from: protected */
        public abstract boolean matches(String str, String str2);

        private Mode(String str) {
            this.description = str;
        }
    }

    public StringMatcher(String str, Mode mode2) {
        this.value = str;
        this.mode = mode2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StringMatcher stringMatcher = (StringMatcher) obj;
        return this.mode.equals(stringMatcher.mode) && this.value.equals(stringMatcher.value);
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.value.hashCode()) * 31) + this.mode.hashCode();
    }

    public String toString() {
        return this.mode.getDescription() + PropertyUtils.MAPPED_DELIM + this.value + PropertyUtils.MAPPED_DELIM2;
    }

    /* access modifiers changed from: protected */
    public boolean doMatch(String str) {
        return this.mode.matches(this.value, str);
    }
}
