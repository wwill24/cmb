package h6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.constants.Extra;
import java.util.ArrayList;
import java.util.List;

public class e implements a<RosterElement> {

    /* renamed from: a  reason: collision with root package name */
    private RosterElement f15406a;

    public static class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        private void c(RosterElement rosterElement) {
            rosterElement.setProfileId(getString(getColumnIndex(Extra.PROFILE_ID)));
            if (3 == getType(getColumnIndex("jid"))) {
                rosterElement.setJid(getString(getColumnIndex("jid")));
            }
            if (3 == getType(getColumnIndex("group_name"))) {
                rosterElement.setGroupName(getString(getColumnIndex("group_name")));
            }
        }

        public RosterElement a() {
            RosterElement rosterElement = new RosterElement();
            c(rosterElement);
            return rosterElement;
        }

        /* access modifiers changed from: package-private */
        public List<RosterElement> b() {
            ArrayList arrayList = new ArrayList();
            try {
                if (moveToFirst()) {
                    while (!isAfterLast()) {
                        arrayList.add(a());
                        moveToNext();
                    }
                }
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not successfully extract roster element model from cursor: ");
                sb2.append(e10.getMessage());
            } catch (Throwable th2) {
                close();
                throw th2;
            }
            close();
            return arrayList;
        }
    }

    public static a c(RosterElement rosterElement) {
        e eVar = new e();
        eVar.f15406a = rosterElement;
        return eVar;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Extra.PROFILE_ID, this.f15406a.getProfileId());
        contentValues.put("jid", this.f15406a.getJid());
        contentValues.put("group_name", this.f15406a.getGroupName());
        return contentValues;
    }

    public List<RosterElement> b(Cursor cursor) {
        return new a(cursor).b();
    }
}
