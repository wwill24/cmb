package androidx.lifecycle;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f6068a;

    public /* synthetic */ w(ProcessLifecycleOwner processLifecycleOwner) {
        this.f6068a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.i(this.f6068a);
    }
}
