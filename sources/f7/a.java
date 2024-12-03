package f7;

import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.RosterElement;
import h6.b;
import h6.e;
import java.util.ArrayList;
import java.util.List;

public class a implements d {
    private static Bagel d(Cursor cursor, boolean z10) {
        Bagel a10 = new b.a(cursor).a();
        if (z10) {
            try {
                RosterElement a11 = new e.a(cursor).a();
                if (a11 != null && !TextUtils.isEmpty(a11.getGroupName())) {
                    a10.setRosterGroup(a11.getGroupName());
                }
            } catch (Exception unused) {
            }
        }
        return a10;
    }

    public Integer a(Cursor cursor) throws SQLException {
        if (cursor == null || cursor.isClosed() || !cursor.moveToFirst()) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(cursor.getColumnIndex("show_order")));
    }

    public List<Bagel> b(Cursor cursor, boolean z10) {
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(d(cursor, z10));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public Bagel c(Cursor cursor, boolean z10) {
        return d(cursor, z10);
    }
}
