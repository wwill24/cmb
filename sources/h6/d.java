package h6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.DateUtils;
import f6.a2;
import java.util.ArrayList;
import java.util.List;

public class d implements a<RisingGiveTake> {

    /* renamed from: a  reason: collision with root package name */
    private RisingGiveTake f15405a;

    public static class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        private RisingGiveTake c() {
            RisingGiveTake risingGiveTake = new RisingGiveTake();
            risingGiveTake.setAction(getInt(getColumnIndex("rising_give_take_action")));
            risingGiveTake.setEndDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("rising_give_take_end_date")), DateUtils.DATE_WITH_TIME_PATTERN));
            risingGiveTake.setStartDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("rising_give_take_start_date")), DateUtils.DATE_WITH_TIME_PATTERN));
            risingGiveTake.setId(getString(getColumnIndex("rising_give_take_id")));
            risingGiveTake.setProfileId(getString(getColumnIndex(Extra.PROFILE_ID)));
            risingGiveTake.setShown(a2.h(getInt(getColumnIndex("rising_give_take_shown"))));
            risingGiveTake.setGiven(a2.h(getInt(getColumnIndex("rising_give_take_given"))));
            risingGiveTake.setPairBagelType(getInt(getColumnIndex("rising_give_take_pair_bagel_type")));
            risingGiveTake.setPairLikeComment(getString(getColumnIndex("pair_like_comment")));
            return risingGiveTake;
        }

        public RisingGiveTake a() {
            return c();
        }

        /* access modifiers changed from: package-private */
        public List<RisingGiveTake> b() {
            ArrayList arrayList = new ArrayList();
            if (moveToFirst()) {
                do {
                    arrayList.add(c());
                } while (moveToNext());
            }
            return arrayList;
        }
    }

    public static d c(RisingGiveTake risingGiveTake) {
        d dVar = new d();
        if (risingGiveTake != null) {
            dVar.f15405a = risingGiveTake;
        }
        return dVar;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("rising_give_take_action", Integer.valueOf(this.f15405a.getAction()));
        contentValues.put("rising_give_take_end_date", DateUtils.getMillisFromUtc(this.f15405a.getEndDate()));
        contentValues.put("rising_give_take_start_date", DateUtils.getMillisFromUtc(this.f15405a.getStartDate()));
        contentValues.put("rising_give_take_id", this.f15405a.getId());
        contentValues.put(Extra.PROFILE_ID, this.f15405a.getProfileId());
        contentValues.put("rising_give_take_shown", Integer.valueOf(a2.n(this.f15405a.isShown())));
        contentValues.put("rising_give_take_given", Integer.valueOf(a2.n(this.f15405a.isGiven())));
        contentValues.put("rising_give_take_pair_bagel_type", Integer.valueOf(this.f15405a.getPairBagelType()));
        contentValues.put("pair_like_comment", this.f15405a.getPairLikeComment());
        return contentValues;
    }

    public List<RisingGiveTake> b(Cursor cursor) {
        return new a(cursor).b();
    }
}
