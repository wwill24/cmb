package h6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.constants.Extra;
import com.google.firebase.messaging.Constants;
import f6.a2;
import java.util.ArrayList;
import java.util.List;

public class f implements a<SavedMessage> {

    /* renamed from: a  reason: collision with root package name */
    private SavedMessage f15407a;

    public static class a extends CursorWrapper {
        public a(Cursor cursor) {
            super(cursor);
        }

        private void c(SavedMessage savedMessage) {
            savedMessage.setProfileId(getString(getColumnIndex(Extra.PROFILE_ID)));
            savedMessage.setMessage(getString(getColumnIndex("message")));
            savedMessage.setTimestamp(getString(getColumnIndex("timestamp")));
            savedMessage.setMessageId(getString(getColumnIndex(Constants.MessagePayloadKeys.MSGID_SERVER)));
            savedMessage.setCategory(getString(getColumnIndex("category")));
            savedMessage.setUrl(getString(getColumnIndex("url")));
            savedMessage.setDisplayedMessageId(getString(getColumnIndex("displayed_message_id")));
            savedMessage.setToMe(a2.h(getInt(getColumnIndex("to_me"))));
        }

        public SavedMessage a() {
            SavedMessage savedMessage = new SavedMessage();
            c(savedMessage);
            return savedMessage;
        }

        /* access modifiers changed from: package-private */
        public List<SavedMessage> b() {
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
                sb2.append("Could not successfully extract SavedMessage model from cursor: ");
                sb2.append(e10.getMessage());
            } catch (Throwable th2) {
                close();
                throw th2;
            }
            close();
            return arrayList;
        }
    }

    public static a c(SavedMessage savedMessage) {
        f fVar = new f();
        fVar.f15407a = savedMessage;
        return fVar;
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Extra.PROFILE_ID, this.f15407a.getProfileId());
        contentValues.put("message", this.f15407a.getMessage());
        contentValues.put("timestamp", this.f15407a.getTimestamp());
        contentValues.put(Constants.MessagePayloadKeys.MSGID_SERVER, this.f15407a.getMessageId());
        contentValues.put("category", this.f15407a.getCategory());
        contentValues.put("url", this.f15407a.getUrl());
        contentValues.put("displayed_message_id", this.f15407a.getDisplayedMessageId());
        contentValues.put("to_me", Boolean.valueOf(this.f15407a.isToMe()));
        return contentValues;
    }

    public List<SavedMessage> b(Cursor cursor) {
        return new a(cursor).b();
    }
}
