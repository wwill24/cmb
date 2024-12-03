package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import p1.a;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001BÏ\u0001\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020\"\u0012\b\u0010+\u001a\u0004\u0018\u00010(\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000100\u0012\b\u00105\u001a\u0004\u0018\u00010\n\u0012\b\u00109\u001a\u0004\u0018\u000106\u0012\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016\u0012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020A0\u0016¢\u0006\u0004\bH\u0010IJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0006X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8\u0006X\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b,\u0010\u001cR\u0014\u0010/\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001cR\u001c\u00103\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001008\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b4\u0010\fR\u0016\u00109\u001a\u0004\u0018\u0001068\u0006X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010>\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:8\u0006X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\u00168\u0006X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0019R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020A0\u00168\u0006X\u0004¢\u0006\u0006\n\u0004\bB\u0010\u0019R\u0014\u0010E\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\bD\u0010\u001c¨\u0006J"}, d2 = {"Landroidx/room/e;", "", "", "fromVersion", "toVersion", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "name", "Lt1/j$c;", "c", "Lt1/j$c;", "sqliteOpenHelperFactory", "Landroidx/room/RoomDatabase$d;", "d", "Landroidx/room/RoomDatabase$d;", "migrationContainer", "", "Landroidx/room/RoomDatabase$b;", "e", "Ljava/util/List;", "callbacks", "f", "Z", "allowMainThreadQueries", "Landroidx/room/RoomDatabase$JournalMode;", "g", "Landroidx/room/RoomDatabase$JournalMode;", "journalMode", "Ljava/util/concurrent/Executor;", "h", "Ljava/util/concurrent/Executor;", "queryExecutor", "i", "transactionExecutor", "Landroid/content/Intent;", "j", "Landroid/content/Intent;", "multiInstanceInvalidationServiceIntent", "k", "requireMigration", "l", "allowDestructiveMigrationOnDowngrade", "", "m", "Ljava/util/Set;", "migrationNotRequiredFrom", "n", "copyFromAssetPath", "Ljava/io/File;", "o", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "p", "Ljava/util/concurrent/Callable;", "copyFromInputStream", "q", "typeConverters", "Lp1/a;", "r", "autoMigrationSpecs", "s", "multiInstanceInvalidation", "Landroidx/room/RoomDatabase$e;", "prepackagedDatabaseCallback", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lt1/j$c;Landroidx/room/RoomDatabase$d;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$e;Ljava/util/List;Ljava/util/List;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6829a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6830b;

    /* renamed from: c  reason: collision with root package name */
    public final j.c f6831c;

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase.d f6832d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RoomDatabase.b> f6833e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f6834f;

    /* renamed from: g  reason: collision with root package name */
    public final RoomDatabase.JournalMode f6835g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f6836h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f6837i;

    /* renamed from: j  reason: collision with root package name */
    public final Intent f6838j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6839k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f6840l;

    /* renamed from: m  reason: collision with root package name */
    private final Set<Integer> f6841m;

    /* renamed from: n  reason: collision with root package name */
    public final String f6842n;

    /* renamed from: o  reason: collision with root package name */
    public final File f6843o;

    /* renamed from: p  reason: collision with root package name */
    public final Callable<InputStream> f6844p;

    /* renamed from: q  reason: collision with root package name */
    public final List<Object> f6845q;

    /* renamed from: r  reason: collision with root package name */
    public final List<a> f6846r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f6847s;

    @SuppressLint({"LambdaLast"})
    public e(Context context, String str, j.c cVar, RoomDatabase.d dVar, List<? extends RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.e eVar, List<? extends Object> list2, List<? extends a> list3) {
        RoomDatabase.JournalMode journalMode2 = journalMode;
        Executor executor3 = executor;
        Executor executor4 = executor2;
        Intent intent2 = intent;
        List<? extends Object> list4 = list2;
        List<? extends a> list5 = list3;
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(cVar, "sqliteOpenHelperFactory");
        kotlin.jvm.internal.j.g(dVar, "migrationContainer");
        kotlin.jvm.internal.j.g(journalMode2, "journalMode");
        kotlin.jvm.internal.j.g(executor3, "queryExecutor");
        kotlin.jvm.internal.j.g(executor4, "transactionExecutor");
        kotlin.jvm.internal.j.g(list4, "typeConverters");
        kotlin.jvm.internal.j.g(list5, "autoMigrationSpecs");
        this.f6829a = context;
        this.f6830b = str;
        this.f6831c = cVar;
        this.f6832d = dVar;
        this.f6833e = list;
        this.f6834f = z10;
        this.f6835g = journalMode2;
        this.f6836h = executor3;
        this.f6837i = executor4;
        this.f6838j = intent2;
        this.f6839k = z11;
        this.f6840l = z12;
        this.f6841m = set;
        this.f6842n = str2;
        this.f6843o = file;
        this.f6844p = callable;
        this.f6845q = list4;
        this.f6846r = list5;
        this.f6847s = intent2 != null;
    }

    public boolean a(int i10, int i11) {
        boolean z10;
        Set<Integer> set;
        if (i10 > i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && this.f6840l) {
            return false;
        }
        if (!this.f6839k || ((set = this.f6841m) != null && set.contains(Integer.valueOf(i10)))) {
            return false;
        }
        return true;
    }
}
