package m5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.coffeemeetsbagel.feature.chatlist.ConnectionHolder;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.enums.MatchType;
import f6.f2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import u6.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final f7.a f16335a;

    /* renamed from: b  reason: collision with root package name */
    private final h f16336b;

    public a(f7.a aVar, h hVar) {
        j.g(aVar, "bagelCursorUtils");
        j.g(hVar, "pendingMessagesDao");
        this.f16335a = aVar;
        this.f16336b = hVar;
    }

    public final List<ConnectionHolder> a() {
        ArrayList arrayList = new ArrayList();
        c cVar = c.f16339a;
        SQLiteDatabase readableDatabase = f2.f().getReadableDatabase();
        j.f(readableDatabase, "getDatabaseOpenHelper().readableDatabase");
        Cursor a10 = cVar.a(readableDatabase);
        if (a10.moveToFirst()) {
            do {
                Bagel c10 = this.f16335a.c(a10, true);
                MatchContract match = c10.toMatch(MatchType.CONNECTED);
                h hVar = this.f16336b;
                String id2 = c10.getId();
                j.f(id2, "bagel.id");
                arrayList.add(new ConnectionHolder(match, (ConnectionDetails) null, hVar.a(id2).size(), (String) null, (String) null, (Integer) null, ConnectionHolder.ConnectionHolderType.ACTIVE, 58, (DefaultConstructorMarker) null));
            } while (a10.moveToNext());
        } else {
            fa.a.f40771d.a("GetBagelConnectionUseCase", "No active connections in  SQLite database");
        }
        if (!a10.isClosed()) {
            a10.close();
        }
        if (arrayList.size() > 100) {
            String str = "Too many active connections - we are sending " + arrayList.size() + " queries to Room for Pending Messages";
            fa.a.f40771d.c("GetBagelConnectionUseCase", str, new IllegalStateException(str));
        }
        return arrayList;
    }

    public final List<ConnectionHolder> b() {
        ArrayList arrayList = new ArrayList();
        c cVar = c.f16339a;
        SQLiteDatabase readableDatabase = f2.f().getReadableDatabase();
        j.f(readableDatabase, "getDatabaseOpenHelper().readableDatabase");
        Cursor c10 = cVar.c(readableDatabase);
        if (c10.getCount() <= 0 || !c10.moveToFirst()) {
            fa.a.f40771d.a("GetBagelConnectionUseCase", "No expired connections in  SQLite database");
        } else {
            do {
                arrayList.add(new ConnectionHolder(this.f16335a.c(c10, true).toMatch(MatchType.CONNECTED), (ConnectionDetails) null, 0, (String) null, (String) null, (Integer) null, ConnectionHolder.ConnectionHolderType.INACTIVE, 58, (DefaultConstructorMarker) null));
            } while (c10.moveToNext());
        }
        if (!c10.isClosed()) {
            c10.close();
        }
        return arrayList;
    }
}
