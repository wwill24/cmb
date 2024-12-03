package androidx.activity;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f335a;

    public /* synthetic */ b(ComponentActivity componentActivity) {
        this.f335a = componentActivity;
    }

    public final void run() {
        this.f335a.invalidateMenu();
    }
}
