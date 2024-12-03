package androidx.room;

import java.util.List;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f6967a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6968b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f6969c;

    public /* synthetic */ y(a0 a0Var, String str, List list) {
        this.f6967a = a0Var;
        this.f6968b = str;
        this.f6969c = list;
    }

    public final void run() {
        a0.x(this.f6967a, this.f6968b, this.f6969c);
    }
}
