package androidx.room;

import androidx.room.AutoClosingRoomOpenHelper;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import t1.i;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lt1/i;", "db", "a", "(Lt1/i;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1})
final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1 extends Lambda implements Function1<i, T> {
    final /* synthetic */ Function1<m, T> $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function1<? super m, ? extends T> function1) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = function1;
    }

    /* renamed from: a */
    public final T invoke(i iVar) {
        j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        m T0 = iVar.T0(this.this$0.f6739a);
        this.this$0.c(T0);
        return this.$block.invoke(T0);
    }
}
