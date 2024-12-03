package h6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import f6.a2;
import java.util.ArrayList;
import java.util.List;

public class b implements a<Bagel> {

    /* renamed from: a  reason: collision with root package name */
    public Bagel f15403a;

    public static class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        private void c(Bagel bagel) {
            bagel.setAction(getInt(getColumnIndex("action")));
            bagel.setBagelType(getInt(getColumnIndex("bagel_type")));
            bagel.setCoupleId(getString(getColumnIndex("couple_id")));
            bagel.setCreatedAt(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("created_at")), DateUtils.DATE_WITH_TIME_PATTERN));
            bagel.setDecouplingDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("decoupling_date")), DateUtils.DATE_WITH_TIME_PATTERN));
            bagel.setEndDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex(FirebaseAnalytics.Param.END_DATE)), DateUtils.DATE_WITH_TIME_PATTERN));
            bagel.setGivenByFirstName(getString(getColumnIndex("given_by_first_name")));
            bagel.setId(getString(getColumnIndex(Extra.BAGEL_ID)));
            bagel.setIsRematched(a2.h(getInt(getColumnIndex("is_rematched"))));
            bagel.setIsBlocked(a2.h(getInt(getColumnIndex("is_blocked"))));
            bagel.setIsPairBlocked(a2.h(getInt(getColumnIndex("is_pair_blocked"))));
            bagel.setLastUpdated(DateUtils.getFormattedUtcDate(getLong(getColumnIndex("last_updated")), DateUtils.DATE_WITH_TIME_PATTERN));
            bagel.setNumMutualFriends(getInt(getColumnIndex("num_mutual_friends")));
            bagel.setPairAction(getInt(getColumnIndex("pair_action")));
            bagel.setPairBagelType(getInt(getColumnIndex("pair_bagel_type")));
            bagel.setProfileId(getString(getColumnIndex(Extra.PROFILE_ID)));
            bagel.setStartDate(DateUtils.getFormattedUtcDate(getLong(getColumnIndex(FirebaseAnalytics.Param.START_DATE)), DateUtils.DATE_WITH_TIME_PATTERN));
            bagel.setHasRevealPurchased(a2.h(getInt(getColumnIndex("reveal_purchased"))));
            bagel.setMeetupPromptAnswer(getInt(getColumnIndex("meetup_prompt_answer")));
            bagel.setMeetupFollowUpAnswer(getInt(getColumnIndex("meetup_follow_up_answer")));
            bagel.setTotalWoos(getInt(getColumnIndex("bagel_total_woos")));
            bagel.setPairTotalWoos(getInt(getColumnIndex("bagel_pair_total_woos")));
            bagel.setTotalWoosSeen(getInt(getColumnIndex("bagel_total_woos_seen")));
            bagel.setLikeComment(getString(getColumnIndex("like_comment")));
            bagel.setPairLikeComment(getString(getColumnIndex("pair_like_comment")));
            bagel.setPurchaseAttributionValue(Integer.valueOf(getInt(getColumnIndex("purchase_attribution"))));
            bagel.setChatRemoved(a2.h(getInt(getColumnIndex("chat_removed"))));
            bagel.setPairChatRemoved(a2.h(getInt(getColumnIndex("pair_chat_removed"))));
            int columnIndex = getColumnIndex("show_order");
            if (isNull(columnIndex)) {
                bagel.setShowOrder((Integer) null);
            } else {
                bagel.setShowOrder(Integer.valueOf(getInt(columnIndex)));
            }
            int columnIndex2 = getColumnIndex("rising_bagel_count");
            if (isNull(columnIndex2)) {
                bagel.setRisingBagelCount(0);
            } else {
                bagel.setRisingBagelCount(getInt(columnIndex2));
            }
        }

        public Bagel a() {
            Bagel bagel = new Bagel();
            c(bagel);
            return bagel;
        }

        /* access modifiers changed from: package-private */
        public List<Bagel> b() {
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
                sb2.append("Could not successfully extract Bagel model from cursor: ");
                sb2.append(e10.getMessage());
            } catch (Throwable th2) {
                close();
                throw th2;
            }
            close();
            return arrayList;
        }
    }

    public static a<Bagel> c() {
        return new b();
    }

    public static a<Bagel> d(Bagel bagel) {
        b bVar = new b();
        bVar.f15403a = bagel;
        return bVar;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("action", Integer.valueOf(this.f15403a.getAction()));
        contentValues.put("couple_id", this.f15403a.getCoupleId());
        contentValues.put("created_at", DateUtils.getMillisFromUtc(this.f15403a.getCreatedAt()));
        contentValues.put("decoupling_date", DateUtils.getMillisFromUtc(this.f15403a.getDecouplingDate()));
        contentValues.put(FirebaseAnalytics.Param.END_DATE, DateUtils.getMillisFromUtc(this.f15403a.getEndDate()));
        contentValues.put("given_by_first_name", this.f15403a.getGivenByFirstName());
        contentValues.put(Extra.BAGEL_ID, this.f15403a.getId());
        contentValues.put("is_rematched", Integer.valueOf(a2.n(this.f15403a.isRematched())));
        contentValues.put("is_blocked", Integer.valueOf(a2.n(this.f15403a.isBlocked())));
        contentValues.put("is_pair_blocked", Integer.valueOf(a2.n(this.f15403a.isPairBlocked())));
        contentValues.put("last_updated", DateUtils.getMillisFromUtc(this.f15403a.getLastUpdated()));
        contentValues.put("num_mutual_friends", Integer.valueOf(this.f15403a.getNumMutualFriends()));
        contentValues.put("pair_action", Integer.valueOf(this.f15403a.getPairAction()));
        contentValues.put("pair_bagel_type", Integer.valueOf(this.f15403a.getPairBagelType()));
        contentValues.put(Extra.PROFILE_ID, this.f15403a.getProfileId());
        contentValues.put("reveal_purchased", Integer.valueOf(a2.n(this.f15403a.hasRevealPurchased())));
        contentValues.put(FirebaseAnalytics.Param.START_DATE, DateUtils.getMillisFromUtc(this.f15403a.getStartDate()));
        contentValues.put("bagel_type", Integer.valueOf(this.f15403a.getBagelType()));
        contentValues.put("meetup_prompt_answer", Integer.valueOf(this.f15403a.getMeetupPromptAnswer()));
        contentValues.put("meetup_follow_up_answer", Integer.valueOf(this.f15403a.getMeetupFollowUpAnswer()));
        contentValues.put("bagel_total_woos", Integer.valueOf(this.f15403a.getTotalWoos()));
        contentValues.put("bagel_pair_total_woos", Integer.valueOf(this.f15403a.getPairTotalWoos()));
        contentValues.put("bagel_total_woos_seen", Integer.valueOf(this.f15403a.getTotalWoosSeen()));
        contentValues.put("chat_removed", Integer.valueOf(a2.n(this.f15403a.isChatRemoved())));
        contentValues.put("pair_chat_removed", Integer.valueOf(a2.n(this.f15403a.isPairChatRemoved())));
        contentValues.put("show_order", this.f15403a.getShowOrder());
        contentValues.put("rising_bagel_count", Integer.valueOf(this.f15403a.getRisingBagelCount()));
        contentValues.put("like_comment", this.f15403a.getLikeComment());
        contentValues.put("pair_like_comment", this.f15403a.getPairLikeComment());
        if (this.f15403a.getPurchaseAttributionValue() != null) {
            contentValues.put("purchase_attribution", this.f15403a.getPurchaseAttributionValue());
        }
        return contentValues;
    }

    public List<Bagel> b(Cursor cursor) {
        return new a(cursor).b();
    }
}
