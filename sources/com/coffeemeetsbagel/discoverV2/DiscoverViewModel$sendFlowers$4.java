package com.coffeemeetsbagel.discoverV2;

import androidx.lifecycle.g0;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.discoverV2.DiscoverViewModel;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

final class DiscoverViewModel$sendFlowers$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ int $expectedPrice;
    final /* synthetic */ boolean $fromProfileDetailView;
    final /* synthetic */ GiveTake $giveTake;
    final /* synthetic */ long $startTime;
    final /* synthetic */ DiscoverViewModel this$0;

    @d(c = "com.coffeemeetsbagel.discoverV2.DiscoverViewModel$sendFlowers$4$1", f = "DiscoverViewModel.kt", l = {464}, m = "invokeSuspend")
    /* renamed from: com.coffeemeetsbagel.discoverV2.DiscoverViewModel$sendFlowers$4$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
        int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(discoverViewModel2, giveTake, cVar);
        }

        public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                CoroutineDispatcher b10 = x0.b();
                final DiscoverViewModel discoverViewModel = discoverViewModel2;
                final GiveTake giveTake = giveTake;
                AnonymousClass1 r12 = new Function2<k0, c<? super Unit>, Object>((c<? super AnonymousClass1>) null) {
                    int label;

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        DiscoverViewModel$sendFlowers$4(long j10, boolean z10, DiscoverViewModel discoverViewModel, GiveTake giveTake, int i10) {
                            super(1);
                            this.$startTime = j10;
                            this.$fromProfileDetailView = z10;
                            this.this$0 = discoverViewModel;
                            this.$giveTake = giveTake;
                            this.$expectedPrice = i10;
                        }

                        public final void a(Boolean bool) {
                            String str;
                            long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
                            if (this.$fromProfileDetailView) {
                                str = "discover_profile_detail";
                            } else if (this.this$0.P().m(this.$giveTake)) {
                                str = "discover_infinite_scroll";
                            } else if (this.this$0.P().l(this.$giveTake)) {
                                str = "discover_search_item";
                            } else {
                                str = ModelDeeplinkData.VALUE_PAGE_DISCOVER;
                            }
                            String str2 = str;
                            DiscoverViewModel discoverViewModel = this.this$0;
                            String profileId = this.$giveTake.getProfileId();
                            j.f(profileId, "giveTake.profileId");
                            discoverViewModel.Q0(str2, "paidlike", "not connected", profileId, "none");
                            this.$giveTake.setIsTaken(true);
                            this.this$0.P().q();
                            k0 a10 = g0.a(this.this$0);
                            final DiscoverViewModel discoverViewModel2 = this.this$0;
                            final GiveTake giveTake = this.$giveTake;
                            s1 unused = j.d(a10, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
                            this.this$0.H0(DiscoverViewModel.ProgressDialogViewState.GONE);
                            DiscoverViewModel.y0(this.this$0, DiscoverViewModel.ActionState.FLOWER_SENT, this.$giveTake, (PurchaseType) null, 4, (Object) null);
                            this.this$0.J0(R.string.send_flowers_success_message);
                            this.this$0.N0(String.valueOf(this.$expectedPrice), true, currentTimeMillis);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            a((Boolean) obj);
                            return Unit.f32013a;
                        }
                    }
