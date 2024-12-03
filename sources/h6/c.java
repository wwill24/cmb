package h6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.DateUtils;
import f6.a2;
import java.util.ArrayList;
import java.util.List;

public class c implements a<GiveTake> {

    /* renamed from: a  reason: collision with root package name */
    private GiveTake f15404a;

    public static class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        private void c(GiveTake giveTake) {
            giveTake.setStartDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("give_ten_start_date")), DateUtils.DATE_WITH_TIME_PATTERN));
            giveTake.setEndDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("give_ten_end_date")), DateUtils.DATE_WITH_TIME_PATTERN));
            giveTake.setLastUpdated(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("give_ten_last_updated")), DateUtils.DATE_WITH_TIME_PATTERN));
            giveTake.setDateShown(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("give_ten_date_shown")), DateUtils.DATE_WITH_TIME_PATTERN));
            giveTake.setIsShown(a2.h(getInt(getColumnIndex("give_ten_is_shown"))));
            giveTake.setIsTaken(a2.h(getInt(getColumnIndex("give_ten_is_taken"))));
            giveTake.setIsGiven(a2.h(getInt(getColumnIndex("give_ten_is_given"))));
            giveTake.setProfileId(getString(getColumnIndex(Extra.PROFILE_ID)));
            giveTake.setId(getString(getColumnIndex("give_ten_id")));
        }

        public GiveTake a() {
            GiveTake giveTake = new GiveTake();
            c(giveTake);
            return giveTake;
        }

        /* access modifiers changed from: package-private */
        public List<GiveTake> b() {
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
                sb2.append("Could not successfully extract GiveTake model from cursor");
                sb2.append(e10.getMessage());
            } catch (Throwable th2) {
                close();
                throw th2;
            }
            close();
            return arrayList;
        }
    }

    public static c c() {
        return new c();
    }

    public static c d(GiveTake giveTake) {
        c cVar = new c();
        cVar.f15404a = giveTake;
        return cVar;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("give_ten_date_shown", DateUtils.getMillisFromUtc(this.f15404a.getDateShown()));
        contentValues.put("give_ten_end_date", DateUtils.getMillisFromUtc(this.f15404a.getEndDate()));
        contentValues.put("give_ten_start_date", DateUtils.getMillisFromUtc(this.f15404a.getStartDate()));
        contentValues.put("give_ten_last_updated", DateUtils.getMillisFromUtc(this.f15404a.getLastUpdated()));
        contentValues.put("give_ten_id", this.f15404a.getId());
        contentValues.put(Extra.PROFILE_ID, this.f15404a.getProfileId());
        contentValues.put("give_ten_is_given", Integer.valueOf(a2.n(this.f15404a.isGiven())));
        contentValues.put("give_ten_is_taken", Integer.valueOf(a2.n(this.f15404a.isLiked())));
        contentValues.put("give_ten_is_shown", Integer.valueOf(a2.n(this.f15404a.isShown())));
        return contentValues;
    }

    public List<GiveTake> b(Cursor cursor) {
        return new a(cursor).b();
    }
}
