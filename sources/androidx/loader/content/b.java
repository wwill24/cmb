package androidx.loader.content;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b<D> {

    /* renamed from: a  reason: collision with root package name */
    int f6117a;

    /* renamed from: b  reason: collision with root package name */
    C0068b<D> f6118b;

    /* renamed from: c  reason: collision with root package name */
    a<D> f6119c;

    /* renamed from: d  reason: collision with root package name */
    Context f6120d;

    /* renamed from: e  reason: collision with root package name */
    boolean f6121e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f6122f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f6123g = true;

    /* renamed from: h  reason: collision with root package name */
    boolean f6124h = false;

    /* renamed from: i  reason: collision with root package name */
    boolean f6125i = false;

    public interface a<D> {
        void a(@NonNull b<D> bVar);
    }

    /* renamed from: androidx.loader.content.b$b  reason: collision with other inner class name */
    public interface C0068b<D> {
        void a(@NonNull b<D> bVar, D d10);
    }

    public b(@NonNull Context context) {
        this.f6120d = context.getApplicationContext();
    }

    public void a() {
        this.f6122f = true;
        k();
    }

    public boolean b() {
        return l();
    }

    public void c() {
        this.f6125i = false;
    }

    @NonNull
    public String d(D d10) {
        StringBuilder sb2 = new StringBuilder(64);
        androidx.core.util.b.a(d10, sb2);
        sb2.append("}");
        return sb2.toString();
    }

    public void e() {
        a<D> aVar = this.f6119c;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void f(D d10) {
        C0068b<D> bVar = this.f6118b;
        if (bVar != null) {
            bVar.a(this, d10);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f6117a);
        printWriter.print(" mListener=");
        printWriter.println(this.f6118b);
        if (this.f6121e || this.f6124h || this.f6125i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f6121e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f6124h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f6125i);
        }
        if (this.f6122f || this.f6123g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f6122f);
            printWriter.print(" mReset=");
            printWriter.println(this.f6123g);
        }
    }

    public void h() {
        n();
    }

    @NonNull
    public Context i() {
        return this.f6120d;
    }

    public boolean j() {
        return this.f6122f;
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        throw null;
    }

    public void m() {
        if (this.f6121e) {
            h();
        } else {
            this.f6124h = true;
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* access modifiers changed from: protected */
    public void p() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void q() {
    }

    public void r(int i10, @NonNull C0068b<D> bVar) {
        if (this.f6118b == null) {
            this.f6118b = bVar;
            this.f6117a = i10;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void s() {
        o();
        this.f6123g = true;
        this.f6121e = false;
        this.f6122f = false;
        this.f6124h = false;
        this.f6125i = false;
    }

    public void t() {
        if (this.f6125i) {
            m();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        androidx.core.util.b.a(this, sb2);
        sb2.append(" id=");
        sb2.append(this.f6117a);
        sb2.append("}");
        return sb2.toString();
    }

    public final void u() {
        this.f6121e = true;
        this.f6123g = false;
        this.f6122f = false;
        p();
    }

    public void v() {
        this.f6121e = false;
        q();
    }

    public void w(@NonNull C0068b<D> bVar) {
        C0068b<D> bVar2 = this.f6118b;
        if (bVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (bVar2 == bVar) {
            this.f6118b = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }
}
