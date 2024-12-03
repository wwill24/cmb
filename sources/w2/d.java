package w2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class d {

    /* renamed from: c  reason: collision with root package name */
    public static final d f18178c = new d("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f18179a;

    /* renamed from: b  reason: collision with root package name */
    private e f18180b;

    public d(String... strArr) {
        this.f18179a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f18179a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public d a(String str) {
        d dVar = new d(this);
        dVar.f18179a.add(str);
        return dVar;
    }

    public boolean c(String str, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (i10 >= this.f18179a.size()) {
            return false;
        }
        if (i10 == this.f18179a.size() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = this.f18179a.get(i10);
        if (!str2.equals("**")) {
            if (str2.equals(str) || str2.equals("*")) {
                z12 = true;
            } else {
                z12 = false;
            }
            if ((z10 || (i10 == this.f18179a.size() - 2 && b())) && z12) {
                return true;
            }
            return false;
        }
        if (z10 || !this.f18179a.get(i10 + 1).equals(str)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (i10 == this.f18179a.size() - 2 || (i10 == this.f18179a.size() - 3 && b())) {
                return true;
            }
            return false;
        } else if (z10) {
            return true;
        } else {
            int i11 = i10 + 1;
            if (i11 < this.f18179a.size() - 1) {
                return false;
            }
            return this.f18179a.get(i11).equals(str);
        }
    }

    public e d() {
        return this.f18180b;
    }

    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (!this.f18179a.get(i10).equals("**")) {
            return 1;
        }
        if (i10 != this.f18179a.size() - 1 && this.f18179a.get(i10 + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f18179a.equals(dVar.f18179a)) {
            return false;
        }
        e eVar = this.f18180b;
        e eVar2 = dVar.f18180b;
        if (eVar != null) {
            return eVar.equals(eVar2);
        }
        if (eVar2 == null) {
            return true;
        }
        return false;
    }

    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f18179a.size()) {
            return false;
        }
        if (this.f18179a.get(i10).equals(str) || this.f18179a.get(i10).equals("**") || this.f18179a.get(i10).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean h(String str, int i10) {
        if (!"__container".equals(str) && i10 >= this.f18179a.size() - 1 && !this.f18179a.get(i10).equals("**")) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f18179a.hashCode() * 31;
        e eVar = this.f18180b;
        if (eVar != null) {
            i10 = eVar.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public d i(e eVar) {
        d dVar = new d(this);
        dVar.f18180b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("KeyPath{keys=");
        sb2.append(this.f18179a);
        sb2.append(",resolved=");
        sb2.append(this.f18180b != null);
        sb2.append('}');
        return sb2.toString();
    }

    private d(d dVar) {
        this.f18179a = new ArrayList(dVar.f18179a);
        this.f18180b = dVar.f18180b;
    }
}
