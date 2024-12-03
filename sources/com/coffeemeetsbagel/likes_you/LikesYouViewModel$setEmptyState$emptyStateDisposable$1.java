package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.likes_you.LikesYouViewModel;
import com.coffeemeetsbagel.likes_you.presentation.EmptyStateAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LikesYouViewModel$setEmptyState$emptyStateDisposable$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ int $selectedTab;
    final /* synthetic */ LikesYouViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LikesYouViewModel$setEmptyState$emptyStateDisposable$1(LikesYouViewModel likesYouViewModel, int i10) {
        super(1);
        this.this$0 = likesYouViewModel;
        this.$selectedTab = i10;
    }

    public final void a(Boolean bool) {
        j.f(bool, "hasMoreLikes");
        if (bool.booleanValue()) {
            this.this$0.f34135p.o(new LikesYouViewModel.b.a(new g(EmptyStateAction.UPSELL.b(), this.this$0.f34126g.a(t0.likes_you_go_premium, new Object[0]), this.this$0.f34126g.a(t0.likes_you_empty_unsubscribed_hidden_likes_text, new Object[0]), (String) null, this.this$0.f34126g.a(t0.likes_you_empty_unsubscribed_hidden_likes_title, new Object[0]), 8, (DefaultConstructorMarker) null), q0.ic_likes_you_heart_non_subs_empty, this.$selectedTab));
        } else {
            this.this$0.f34135p.o(new LikesYouViewModel.b.a(new g(EmptyStateAction.UPSELL.b(), this.this$0.f34126g.a(t0.likes_you_empty_unsubscribed_cta, new Object[0]), this.this$0.f34126g.a(t0.likes_you_empty_non_subscribed_description, new Object[0]), (String) null, this.this$0.f34126g.a(t0.likes_you_empty_non_subscribed_title, new Object[0]), 8, (DefaultConstructorMarker) null), q0.ic_likes_you_heart_non_subs_empty, this.$selectedTab));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Boolean) obj);
        return Unit.f32013a;
    }
}
