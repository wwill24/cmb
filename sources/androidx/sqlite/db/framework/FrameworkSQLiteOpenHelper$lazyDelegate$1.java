package androidx.sqlite.db.framework;

import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import t1.b;
import t1.d;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "a", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;"}, k = 3, mv = {1, 7, 1})
final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends Lambda implements Function0<FrameworkSQLiteOpenHelper.OpenHelper> {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    /* renamed from: a */
    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (this.this$0.f7013b == null || !this.this$0.f7015d) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f7012a, this.this$0.f7013b, new FrameworkSQLiteOpenHelper.b((FrameworkSQLiteDatabase) null), this.this$0.f7014c, this.this$0.f7016e);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f7012a, new File(d.a(this.this$0.f7012a), this.this$0.f7013b).getAbsolutePath(), new FrameworkSQLiteOpenHelper.b((FrameworkSQLiteDatabase) null), this.this$0.f7014c, this.this$0.f7016e);
        }
        b.d(openHelper, this.this$0.f7018g);
        return openHelper;
    }
}
