package com.coffeemeetsbagel.database;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.h0;
import com.coffeemeetsbagel.database.daos.ActionCardRoomDao;
import com.coffeemeetsbagel.database.daos.ActiveSubscriptionRoomDao;
import com.coffeemeetsbagel.database.daos.CapabilityRoomDao;
import com.coffeemeetsbagel.database.daos.ConnectionDetailsRoomDao;
import com.coffeemeetsbagel.database.daos.MatchContextRoomDao;
import com.coffeemeetsbagel.database.daos.PendingMessageRoomDao;
import com.coffeemeetsbagel.database.daos.ProfileRoomDao;
import com.coffeemeetsbagel.database.daos.ResourceRoomDao;
import com.coffeemeetsbagel.database.daos.StickerRoomDao;
import com.coffeemeetsbagel.database.daos.SubscriptionBundleRoomDao;
import com.coffeemeetsbagel.database.daos.a1;
import com.coffeemeetsbagel.database.daos.b0;
import com.coffeemeetsbagel.database.daos.c1;
import com.coffeemeetsbagel.database.daos.d0;
import com.coffeemeetsbagel.database.daos.e1;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.database.daos.k0;
import com.coffeemeetsbagel.database.daos.n;
import com.coffeemeetsbagel.database.daos.o0;
import com.coffeemeetsbagel.database.daos.v;
import com.coffeemeetsbagel.likes_you.LikesYouGroupRoomDao;
import com.coffeemeetsbagel.likes_you.d;
import com.coffeemeetsbagel.likes_you.o;
import com.coffeemeetsbagel.likes_you.q;
import com.coffeemeetsbagel.qna.QuestionDaoV2Impl;
import com.mparticle.identity.IdentityHttpResponse;
import f6.w1;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import p1.b;

public abstract class CmbDatabase extends RoomDatabase {

    /* renamed from: p  reason: collision with root package name */
    public static final a f11593p = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CmbDatabase b(a aVar, Context context, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = "cmb-room.db";
            }
            return aVar.a(context, str);
        }

        private final RoomDatabase.a<CmbDatabase> c(Context context, String str) {
            RoomDatabase.a<CmbDatabase> a10 = h0.a(context, CmbDatabase.class, str);
            b[] a11 = w1.f14850a.a();
            return a10.b((b[]) Arrays.copyOf(a11, a11.length));
        }

        public final CmbDatabase a(Context context, String str) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(str, "name");
            return c(context, str).d();
        }
    }

    public abstract ActionCardRoomDao E();

    public abstract ActiveSubscriptionRoomDao F();

    public abstract h G();

    public abstract com.coffeemeetsbagel.database.daos.j H();

    public abstract n I();

    public abstract CapabilityRoomDao J();

    public abstract ConnectionDetailsRoomDao K();

    public abstract d L();

    public abstract q M();

    public abstract LikesYouGroupRoomDao N();

    public abstract o O();

    public abstract MatchContextRoomDao P();

    public abstract v Q();

    public abstract PendingMessageRoomDao R();

    public abstract b0 S();

    public abstract d0 T();

    public abstract ProfileRoomDao U();

    public abstract QuestionDaoV2Impl V();

    public abstract k0 W();

    public abstract ResourceRoomDao X();

    public abstract o0 Y();

    public abstract eb.b Z();

    public abstract StickerRoomDao a0();

    public abstract SubscriptionBundleRoomDao b0();

    public abstract a1 c0();

    public abstract c1 d0();

    public abstract e1 e0();
}
