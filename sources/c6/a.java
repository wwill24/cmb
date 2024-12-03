package c6;

import android.content.Intent;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f7967a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7968b;

    /* renamed from: c  reason: collision with root package name */
    private final Intent f7969c;

    public a(int i10, int i11, Intent intent) {
        this.f7967a = i10;
        this.f7968b = i11;
        this.f7969c = intent;
    }

    public Intent a() {
        return this.f7969c;
    }

    public int b() {
        return this.f7967a;
    }

    public int c() {
        return this.f7968b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f7967a == aVar.f7967a && this.f7968b == aVar.f7968b) {
            Intent intent = this.f7969c;
            if (intent != null) {
                if (intent.equals(aVar.f7969c)) {
                    return true;
                }
            } else if (aVar.f7969c == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11 = ((this.f7967a * 31) + this.f7968b) * 31;
        Intent intent = this.f7969c;
        if (intent != null) {
            i10 = intent.hashCode();
        } else {
            i10 = 0;
        }
        return i11 + i10;
    }
}
