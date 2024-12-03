package androidx.room;

import androidx.room.p;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f6953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f6954b;

    public /* synthetic */ q(p pVar, String[] strArr) {
        this.f6953a = pVar;
        this.f6954b = strArr;
    }

    public final void run() {
        p.b.g(this.f6953a, this.f6954b);
    }
}
