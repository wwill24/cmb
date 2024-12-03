package org.commonmark.internal;

import am.o;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;
import zl.c;
import zl.d;

public class LinkReferenceDefinitionParser {

    /* renamed from: a  reason: collision with root package name */
    private State f24077a = State.START_DEFINITION;

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f24078b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    private final List<o> f24079c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private StringBuilder f24080d;

    /* renamed from: e  reason: collision with root package name */
    private String f24081e;

    /* renamed from: f  reason: collision with root package name */
    private String f24082f;

    /* renamed from: g  reason: collision with root package name */
    private char f24083g;

    /* renamed from: h  reason: collision with root package name */
    private StringBuilder f24084h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24085i = false;

    enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24093a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.commonmark.internal.LinkReferenceDefinitionParser$State[] r0 = org.commonmark.internal.LinkReferenceDefinitionParser.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24093a = r0
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.PARAGRAPH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24093a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_DEFINITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24093a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.LABEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24093a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.DESTINATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24093a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.START_TITLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24093a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.commonmark.internal.LinkReferenceDefinitionParser$State r1 = org.commonmark.internal.LinkReferenceDefinitionParser.State.TITLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.LinkReferenceDefinitionParser.a.<clinit>():void");
        }
    }

    private int a(CharSequence charSequence, int i10) {
        String str;
        int m10 = d.m(charSequence, i10, charSequence.length());
        int a10 = c.a(charSequence, m10);
        if (a10 == -1) {
            return -1;
        }
        if (charSequence.charAt(m10) == '<') {
            str = charSequence.subSequence(m10 + 1, a10 - 1).toString();
        } else {
            str = charSequence.subSequence(m10, a10).toString();
        }
        this.f24082f = str;
        int m11 = d.m(charSequence, a10, charSequence.length());
        if (m11 >= charSequence.length()) {
            this.f24085i = true;
            this.f24078b.setLength(0);
        } else if (m11 == a10) {
            return -1;
        }
        this.f24077a = State.START_TITLE;
        return m11;
    }

    private void b() {
        String str;
        if (this.f24085i) {
            String e10 = zl.a.e(this.f24082f);
            StringBuilder sb2 = this.f24084h;
            if (sb2 != null) {
                str = zl.a.e(sb2.toString());
            } else {
                str = null;
            }
            this.f24079c.add(new o(this.f24081e, e10, str));
            this.f24080d = null;
            this.f24085i = false;
            this.f24081e = null;
            this.f24082f = null;
            this.f24084h = null;
        }
    }

    private int e(CharSequence charSequence, int i10) {
        int i11;
        int c10 = c.c(charSequence, i10);
        if (c10 == -1) {
            return -1;
        }
        this.f24080d.append(charSequence, i10, c10);
        if (c10 >= charSequence.length()) {
            this.f24080d.append(10);
            return c10;
        } else if (charSequence.charAt(c10) != ']' || (i11 = c10 + 1) >= charSequence.length() || charSequence.charAt(i11) != ':' || this.f24080d.length() > 999) {
            return -1;
        } else {
            String b10 = zl.a.b(this.f24080d.toString());
            if (b10.isEmpty()) {
                return -1;
            }
            this.f24081e = b10;
            this.f24077a = State.DESTINATION;
            return d.m(charSequence, i11 + 1, charSequence.length());
        }
    }

    private int g(CharSequence charSequence, int i10) {
        int m10 = d.m(charSequence, i10, charSequence.length());
        if (m10 >= charSequence.length() || charSequence.charAt(m10) != '[') {
            return -1;
        }
        this.f24077a = State.LABEL;
        this.f24080d = new StringBuilder();
        int i11 = m10 + 1;
        if (i11 >= charSequence.length()) {
            this.f24080d.append(10);
        }
        return i11;
    }

    private int h(CharSequence charSequence, int i10) {
        int m10 = d.m(charSequence, i10, charSequence.length());
        if (m10 >= charSequence.length()) {
            this.f24077a = State.START_DEFINITION;
            return m10;
        }
        this.f24083g = 0;
        char charAt = charSequence.charAt(m10);
        if (charAt == '\"' || charAt == '\'') {
            this.f24083g = charAt;
        } else if (charAt == '(') {
            this.f24083g = PropertyUtils.MAPPED_DELIM2;
        }
        if (this.f24083g != 0) {
            this.f24077a = State.TITLE;
            this.f24084h = new StringBuilder();
            m10++;
            if (m10 == charSequence.length()) {
                this.f24084h.append(10);
            }
        } else {
            b();
            this.f24077a = State.START_DEFINITION;
        }
        return m10;
    }

    private int i(CharSequence charSequence, int i10) {
        int e10 = c.e(charSequence, i10, this.f24083g);
        if (e10 == -1) {
            return -1;
        }
        this.f24084h.append(charSequence.subSequence(i10, e10));
        if (e10 >= charSequence.length()) {
            this.f24084h.append(10);
            return e10;
        }
        int m10 = d.m(charSequence, e10 + 1, charSequence.length());
        if (m10 != charSequence.length()) {
            return -1;
        }
        this.f24085i = true;
        b();
        this.f24078b.setLength(0);
        this.f24077a = State.START_DEFINITION;
        return m10;
    }

    /* access modifiers changed from: package-private */
    public List<o> c() {
        b();
        return this.f24079c;
    }

    /* access modifiers changed from: package-private */
    public CharSequence d() {
        return this.f24078b;
    }

    public void f(CharSequence charSequence) {
        if (this.f24078b.length() != 0) {
            this.f24078b.append(10);
        }
        this.f24078b.append(charSequence);
        int i10 = 0;
        while (i10 < charSequence.length()) {
            switch (a.f24093a[this.f24077a.ordinal()]) {
                case 1:
                    return;
                case 2:
                    i10 = g(charSequence, i10);
                    break;
                case 3:
                    i10 = e(charSequence, i10);
                    break;
                case 4:
                    i10 = a(charSequence, i10);
                    break;
                case 5:
                    i10 = h(charSequence, i10);
                    break;
                case 6:
                    i10 = i(charSequence, i10);
                    break;
            }
            if (i10 == -1) {
                this.f24077a = State.PARAGRAPH;
                return;
            }
        }
    }
}
