package o5;

import android.os.Bundle;
import androidx.fragment.app.h;
import b6.a;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import kotlin.jvm.internal.j;
import o5.a;

public final class d extends a<a, ChatActivity> {
    /* access modifiers changed from: protected */
    /* renamed from: D0 */
    public a z0(ChatActivity chatActivity) {
        j.g(chatActivity, "componentActivity");
        a a10 = g.a().b(new a.C0182a(chatActivity)).c(Bakery.j()).a();
        j.f(a10, "builder()\n              …\n                .build()");
        return a10;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.chat.details.ChatActivity");
        ChatActivity chatActivity = (ChatActivity) activity;
        if (this.f7846a == null) {
            this.f7846a = z0(chatActivity);
        }
        C c10 = this.f7846a;
        j.d(c10);
        ((a) c10).I(chatActivity);
        C c11 = this.f7846a;
        j.d(c11);
        ((a) c11).R(this);
        chatActivity.F1();
    }
}
