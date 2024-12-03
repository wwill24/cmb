package md;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import md.m0;

public final /* synthetic */ class w implements m0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f41253a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f41254b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f41255c;

    public /* synthetic */ w(String str, LogEventDropped.Reason reason, long j10) {
        this.f41253a = str;
        this.f41254b = reason;
        this.f41255c = j10;
    }

    public final Object apply(Object obj) {
        return m0.A1(this.f41253a, this.f41254b, this.f41255c, (SQLiteDatabase) obj);
    }
}
