package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f4639a;

    l(Object obj) {
        this.f4639a = (LocaleList) obj;
    }

    public String a() {
        return this.f4639a.toLanguageTags();
    }

    public Object b() {
        return this.f4639a;
    }

    public boolean equals(Object obj) {
        return this.f4639a.equals(((k) obj).b());
    }

    public Locale get(int i10) {
        return this.f4639a.get(i10);
    }

    public int hashCode() {
        return this.f4639a.hashCode();
    }

    public boolean isEmpty() {
        return this.f4639a.isEmpty();
    }

    public int size() {
        return this.f4639a.size();
    }

    public String toString() {
        return this.f4639a.toString();
    }
}
