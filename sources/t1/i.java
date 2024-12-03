package t1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0010H&J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H'JE\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u001d\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J)\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001bH&¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010%R(\u0010/\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020,\u0018\u00010+8fX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u00060À\u0006\u0001"}, d2 = {"Lt1/i;", "Ljava/io/Closeable;", "", "sql", "Lt1/m;", "T0", "", "beginTransaction", "b0", "endTransaction", "setTransactionSuccessful", "", "E1", "query", "Landroid/database/Cursor;", "q1", "Lt1/l;", "Z0", "Landroid/os/CancellationSignal;", "cancellationSignal", "t1", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "whereClause", "", "", "whereArgs", "k1", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "D", "bindArgs", "a0", "(Ljava/lang/String;[Ljava/lang/Object;)V", "isOpen", "()Z", "getPath", "()Ljava/lang/String;", "path", "O1", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "A", "()Ljava/util/List;", "attachedDbs", "sqlite_release"}, k = 1, mv = {1, 7, 1})
public interface i extends Closeable {
    List<Pair<String, String>> A();

    void D(String str) throws SQLException;

    boolean E1();

    boolean O1();

    m T0(String str);

    Cursor Z0(l lVar);

    void a0(String str, Object[] objArr) throws SQLException;

    void b0();

    void beginTransaction();

    void endTransaction();

    String getPath();

    boolean isOpen();

    int k1(String str, int i10, ContentValues contentValues, String str2, Object[] objArr);

    Cursor q1(String str);

    void setTransactionSuccessful();

    Cursor t1(l lVar, CancellationSignal cancellationSignal);
}
