package j$.time.format;

import java.text.ParsePosition;
import java.util.HashSet;
import java.util.Iterator;

class o {

    /* renamed from: a  reason: collision with root package name */
    protected String f42651a;

    /* renamed from: b  reason: collision with root package name */
    protected String f42652b;

    /* renamed from: c  reason: collision with root package name */
    protected char f42653c;

    /* renamed from: d  reason: collision with root package name */
    protected o f42654d;

    /* renamed from: e  reason: collision with root package name */
    protected o f42655e;

    private o(String str, String str2, o oVar) {
        this.f42651a = str;
        this.f42652b = str2;
        this.f42654d = oVar;
        this.f42653c = str.length() == 0 ? 65535 : this.f42651a.charAt(0);
    }

    /* synthetic */ o(String str, String str2, o oVar, int i10) {
        this(str, str2, oVar);
    }

    private boolean b(String str, String str2) {
        int i10 = 0;
        while (i10 < str.length() && i10 < this.f42651a.length() && c(str.charAt(i10), this.f42651a.charAt(i10))) {
            i10++;
        }
        if (i10 != this.f42651a.length()) {
            o e10 = e(this.f42651a.substring(i10), this.f42652b, this.f42654d);
            this.f42651a = str.substring(0, i10);
            this.f42654d = e10;
            if (i10 < str.length()) {
                this.f42654d.f42655e = e(str.substring(i10), str2, (o) null);
                this.f42652b = null;
            } else {
                this.f42652b = str2;
            }
            return true;
        } else if (i10 < str.length()) {
            String substring = str.substring(i10);
            for (o oVar = this.f42654d; oVar != null; oVar = oVar.f42655e) {
                if (c(oVar.f42653c, substring.charAt(0))) {
                    return oVar.b(substring, str2);
                }
            }
            o e11 = e(substring, str2, (o) null);
            e11.f42655e = this.f42654d;
            this.f42654d = e11;
            return true;
        } else {
            this.f42652b = str2;
            return true;
        }
    }

    public static o f(x xVar) {
        return xVar.k() ? new o("", (String) null, (o) null) : new n();
    }

    public static o g(HashSet hashSet, x xVar) {
        o f10 = f(xVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            f10.b(str, str);
        }
        return f10;
    }

    public final void a(String str, String str2) {
        b(str, str2);
    }

    /* access modifiers changed from: protected */
    public boolean c(char c10, char c11) {
        return c10 == c11;
    }

    public final String d(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (!h(charSequence, index, length)) {
            return null;
        }
        int length2 = this.f42651a.length() + index;
        o oVar = this.f42654d;
        if (oVar != null && length2 != length) {
            while (true) {
                if (!c(oVar.f42653c, charSequence.charAt(length2))) {
                    oVar = oVar.f42655e;
                    if (oVar == null) {
                        break;
                    }
                } else {
                    parsePosition.setIndex(length2);
                    String d10 = oVar.d(charSequence, parsePosition);
                    if (d10 != null) {
                        return d10;
                    }
                }
            }
        }
        parsePosition.setIndex(length2);
        return this.f42652b;
    }

    /* access modifiers changed from: protected */
    public o e(String str, String str2, o oVar) {
        return new o(str, str2, oVar);
    }

    /* access modifiers changed from: protected */
    public boolean h(CharSequence charSequence, int i10, int i11) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f42651a, i10);
        }
        int length = this.f42651a.length();
        if (length > i11 - i10) {
            return false;
        }
        int i12 = 0;
        while (true) {
            int i13 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i14 = i12 + 1;
            int i15 = i10 + 1;
            if (!c(this.f42651a.charAt(i12), charSequence.charAt(i10))) {
                return false;
            }
            i10 = i15;
            length = i13;
            i12 = i14;
        }
    }
}
