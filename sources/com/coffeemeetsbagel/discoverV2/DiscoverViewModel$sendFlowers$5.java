package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.R;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverViewModel$sendFlowers$5 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ int $expectedPrice;
    final /* synthetic */ long $startTime;
    final /* synthetic */ DiscoverViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiscoverViewModel$sendFlowers$5(long j10, DiscoverViewModel discoverViewModel, int i10) {
        super(1);
        this.$startTime = j10;
        this.this$0 = discoverViewModel;
        this.$expectedPrice = i10;
    }

    public final void a(Throwable th2) {
        long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
        this.this$0.J0(R.string.send_flowers_error_message);
        a.C0491a aVar = a.f40771d;
        String m10 = this.this$0.f12227s;
        j.d(th2);
        aVar.c(m10, "Unable to purchase flowers", th2);
        this.this$0.N0(String.valueOf(this.$expectedPrice), false, currentTimeMillis);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
