package com.coffeemeetsbagel.suggested_history.suggested_history_list;

import android.widget.FrameLayout;
import com.coffeemeetsbagel.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SuggestedHistoryListRouter$bannerContainer$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ SuggestedHistoryListRouter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedHistoryListRouter$bannerContainer$2(SuggestedHistoryListRouter suggestedHistoryListRouter) {
        super(0);
        this.this$0 = suggestedHistoryListRouter;
    }

    /* renamed from: a */
    public final FrameLayout invoke() {
        return (FrameLayout) this.this$0.l().findViewById(R.id.banner_container);
    }
}
