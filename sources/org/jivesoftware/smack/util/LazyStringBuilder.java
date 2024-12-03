package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LazyStringBuilder implements Appendable, CharSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String cache;
    private final List<CharSequence> list = new ArrayList(20);

    static {
        Class<LazyStringBuilder> cls = LazyStringBuilder.class;
    }

    private void invalidateCache() {
        this.cache = null;
    }

    public char charAt(int i10) {
        String str = this.cache;
        if (str != null) {
            return str.charAt(i10);
        }
        for (CharSequence next : this.list) {
            if (i10 < next.length()) {
                return next.charAt(i10);
            }
            i10 -= next.length();
        }
        throw new IndexOutOfBoundsException();
    }

    public List<CharSequence> getAsList() {
        String str = this.cache;
        if (str != null) {
            return Collections.singletonList(str);
        }
        return Collections.unmodifiableList(this.list);
    }

    public int length() {
        String str = this.cache;
        if (str != null) {
            return str.length();
        }
        int i10 = 0;
        try {
            for (CharSequence length : this.list) {
                i10 += length.length();
            }
            return i10;
        } catch (NullPointerException e10) {
            StringBuilder safeToStringBuilder = safeToStringBuilder();
            throw new RuntimeException("The following LazyStringBuilder threw a NullPointerException:  " + safeToStringBuilder, e10);
        }
    }

    public StringBuilder safeToStringBuilder() {
        StringBuilder sb2 = new StringBuilder();
        for (CharSequence append : this.list) {
            sb2.append(append);
        }
        return sb2;
    }

    public CharSequence subSequence(int i10, int i11) {
        return toString().subSequence(i10, i11);
    }

    public String toString() {
        if (this.cache == null) {
            StringBuilder sb2 = new StringBuilder(length());
            for (CharSequence append : this.list) {
                sb2.append(append);
            }
            this.cache = sb2.toString();
        }
        return this.cache;
    }

    public LazyStringBuilder append(LazyStringBuilder lazyStringBuilder) {
        this.list.addAll(lazyStringBuilder.list);
        invalidateCache();
        return this;
    }

    public LazyStringBuilder append(CharSequence charSequence) {
        this.list.add(charSequence);
        invalidateCache();
        return this;
    }

    public LazyStringBuilder append(CharSequence charSequence, int i10, int i11) {
        this.list.add(charSequence.subSequence(i10, i11));
        invalidateCache();
        return this;
    }

    public LazyStringBuilder append(char c10) {
        this.list.add(Character.toString(c10));
        invalidateCache();
        return this;
    }
}
