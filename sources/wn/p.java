package wn;

import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private final String f42503a;

    /* renamed from: b  reason: collision with root package name */
    private final char f42504b;

    /* renamed from: c  reason: collision with root package name */
    private final q f42505c;

    public p(String str, char c10, q qVar) {
        j.g(str, "text");
        j.g(qVar, JingleS5BTransport.ATTR_MODE);
        this.f42503a = str;
        this.f42504b = c10;
        this.f42505c = qVar;
    }

    public final char a() {
        return this.f42504b;
    }

    public final q b() {
        return this.f42505c;
    }

    public final String c() {
        return this.f42503a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return j.b(this.f42503a, pVar.f42503a) && this.f42504b == pVar.f42504b && j.b(this.f42505c, pVar.f42505c);
    }

    public int hashCode() {
        return (((this.f42503a.hashCode() * 31) + Character.hashCode(this.f42504b)) * 31) + this.f42505c.hashCode();
    }

    public String toString() {
        String str = this.f42503a;
        char c10 = this.f42504b;
        q qVar = this.f42505c;
        return "TrimArguments(text=" + str + ", char=" + c10 + ", mode=" + qVar + ")";
    }
}
