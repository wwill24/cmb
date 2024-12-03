package androidx.room;

import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import t1.i;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lt1/i;", "db", "", "a", "(Lt1/i;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1})
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1 extends Lambda implements Function1<i, Object> {
    final /* synthetic */ String $sql;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(String str) {
        super(1);
        this.$sql = str;
    }

    /* renamed from: a */
    public final Object invoke(i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        iVar.D(this.$sql);
        return null;
    }
}
