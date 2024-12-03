package oa;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;

public final class j extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f41321e;

    public interface a {
        void F0();

        void l();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        kotlin.jvm.internal.j.g(viewGroup, "view");
        kotlin.jvm.internal.j.g(aVar, "listener");
        this.f41321e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void l(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f41321e.F0();
    }

    /* access modifiers changed from: private */
    public static final void m(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f41321e.l();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_photos_button).setOnClickListener(new h(this));
        ((ViewGroup) this.f7869c).findViewById(R.id.photos_back_button).setOnClickListener(new i(this));
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message_primary)).setText(t9.a.onboardingPhotos);
    }
}
