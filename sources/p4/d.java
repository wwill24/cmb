package p4;

import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import i4.h;
import i4.x;
import java.util.HashSet;
import java.util.Iterator;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final HashSet<String> f17003a;

    private d(String[] strArr) {
        this.f17003a = new HashSet<>();
        e(strArr);
    }

    static d b(String str) {
        return new d(str.split(AppsFlyerKit.COMMA));
    }

    static d c(String[] strArr) {
        return new d(strArr);
    }

    static d d() {
        return new d(h.f15490c);
    }

    private void e(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (x.b(h.f15491d, str)) {
                    this.f17003a.add(x.e(str));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        return x.b(this.f17003a, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f17003a.equals(((d) obj).f17003a);
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !this.f17003a.isEmpty();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f17003a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (h.f15491d.contains(next)) {
                sb2.append(next);
                if (it.hasNext()) {
                    str = AppsFlyerKit.COMMA;
                } else {
                    str = "";
                }
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    private d(HashSet<String> hashSet) {
        HashSet<String> hashSet2 = new HashSet<>();
        this.f17003a = hashSet2;
        hashSet2.addAll(hashSet);
    }
}
