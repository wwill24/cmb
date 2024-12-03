package com.coffeemeetsbagel.whatsnew;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coffeemeetsbagel.whatsnew.WhatsNewViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ActivityWhatsNew$observePages$1 extends Lambda implements Function1<List<? extends WhatsNewViewModel.a>, Unit> {
    final /* synthetic */ ActivityWhatsNew this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityWhatsNew$observePages$1(ActivityWhatsNew activityWhatsNew) {
        super(1);
        this.this$0 = activityWhatsNew;
    }

    public final void a(List<WhatsNewViewModel.a> list) {
        ViewPager2 C0 = this.this$0.f37611c;
        if (C0 == null) {
            j.y("viewPager");
            C0 = null;
        }
        RecyclerView.Adapter adapter = C0.getAdapter();
        j.e(adapter, "null cannot be cast to non-null type com.coffeemeetsbagel.whatsnew.WhatsNewContentAdapter");
        j.f(list, "pages");
        ((b) adapter).K(list);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
