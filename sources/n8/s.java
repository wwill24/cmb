package n8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import com.coffeemeetsbagel.feature.mongoose.enums.RosterGroup;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.facebook.appevents.AppEventsConstants;
import com.jakewharton.rxrelay2.b;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import d7.l;
import d7.m;
import h6.e;
import h6.f;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smackx.chatstates.ChatState;
import qj.w;
import u6.e;
import u6.h;

public class s implements m {

    /* renamed from: m  reason: collision with root package name */
    static final String f16663m = "s";

    /* renamed from: a  reason: collision with root package name */
    private final t7.a f16664a;

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, b<List<SavedMessage>>> f16665b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, PublishSubject<String>> f16666c;

    /* renamed from: d  reason: collision with root package name */
    private final LruCache<String, b<ChatState>> f16667d;

    /* renamed from: e  reason: collision with root package name */
    private final LruCache<String, b<ConnectionDetails>> f16668e;

    /* renamed from: f  reason: collision with root package name */
    private final b<Integer> f16669f;

    /* renamed from: g  reason: collision with root package name */
    private final a f16670g;

    /* renamed from: h  reason: collision with root package name */
    private final l f16671h;

    /* renamed from: i  reason: collision with root package name */
    private final h f16672i;

    /* renamed from: j  reason: collision with root package name */
    private final b<x> f16673j;

    /* renamed from: k  reason: collision with root package name */
    private final tj.a f16674k = new tj.a();

    /* renamed from: l  reason: collision with root package name */
    private final e f16675l;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16676a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.MessageStatus[] r0 = com.coffeemeetsbagel.models.enums.MessageStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16676a = r0
                com.coffeemeetsbagel.models.enums.MessageStatus r1 = com.coffeemeetsbagel.models.enums.MessageStatus.NOT_SENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16676a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.MessageStatus r1 = com.coffeemeetsbagel.models.enums.MessageStatus.SENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n8.s.a.<clinit>():void");
        }
    }

    public s(t7.a aVar, l lVar, h hVar, e eVar) {
        this.f16664a = aVar;
        this.f16665b = new LruCache<>(20);
        this.f16666c = new HashMap<>();
        this.f16667d = new LruCache<>(20);
        this.f16668e = new LruCache<>(20);
        this.f16671h = lVar;
        this.f16669f = b.C0();
        this.f16670g = new a();
        this.f16672i = hVar;
        this.f16673j = b.C0();
        this.f16675l = eVar;
        lVar.b(this);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void E(String str, ChatState chatState) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Updated chat state: ");
        sb2.append(chatState);
        sb2.append(" for ");
        sb2.append(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void G(String str, List list) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Relay for ");
        sb2.append(str);
        sb2.append(" received ");
        sb2.append(list.size());
        sb2.append(" saved messages");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.f16673j.accept(x.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.f16673j.accept(x.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(String str, String str2) throws Exception {
        this.f16675l.i(str, str2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void N(String str, Throwable th2) throws Exception {
        String str2 = f16663m;
        fa.a.f(str2, "Couldn't reset count for " + str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O(String str) throws Exception {
        return this.f16665b.get(str) != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.f16673j.accept(x.a());
    }

    private void T(String str, ConnectionDetails connectionDetails) {
        b bVar = this.f16668e.get(str);
        if (bVar != null) {
            ConnectionDetails connectionDetails2 = (ConnectionDetails) bVar.E0();
            if (connectionDetails2 == null || connectionDetails2.getPairReadReceiptDate() == null || !connectionDetails2.getPairReadReceiptDate().equals(connectionDetails.getPairReadReceiptDate())) {
                bVar.accept(connectionDetails);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void P(String str, List<SavedMessage> list) {
        b bVar = this.f16665b.get(str);
        if (bVar != null) {
            List list2 = (List) bVar.E0();
            if (list2 == null || !list2.equals(list)) {
                bVar.accept(list);
            }
        }
    }

    private void V(List<SavedMessage> list) {
        HashSet hashSet = new HashSet();
        for (SavedMessage next : list) {
            String profileId = next.getProfileId();
            if (!hashSet.contains(profileId)) {
                e0(profileId);
                hashSet.add(next.getProfileId());
            }
        }
    }

    /* access modifiers changed from: private */
    public void Z() {
        this.f16674k.a(w.A(new q(this)).K(dk.a.c()).E(sj.a.a()).c(this.f16669f));
    }

    private void e0(String str) {
        PublishSubject publishSubject = this.f16666c.get(str);
        if (publishSubject == null) {
            publishSubject = PublishSubject.C0();
            this.f16674k.a(publishSubject.q(50, TimeUnit.MILLISECONDS).B(new d(this)).K(new e(this)).b(new f(this, str), new g()));
            this.f16666c.put(str, publishSubject);
        }
        publishSubject.d(str);
    }

    /* access modifiers changed from: private */
    public w<List<SavedMessage>> f0(String str) {
        return w.C(Y(str)).K(dk.a.c()).E(sj.a.a());
    }

    private void m0(SavedMessage savedMessage) {
        ConnectionDetails x10 = K(savedMessage.getProfileId());
        this.f16670g.b(x10, savedMessage);
        if (savedMessage.isDisplayedMessage() && savedMessage.isToMe()) {
            T(savedMessage.getProfileId(), x10);
        }
        this.f16675l.g(x10);
        this.f16673j.accept(x.a());
        Z();
    }

    private void n0(List<SavedMessage> list, String str) {
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (SavedMessage next : list) {
            String profileId = next.getProfileId();
            ConnectionDetails connectionDetails = (ConnectionDetails) hashMap.get(profileId);
            if (connectionDetails == null) {
                connectionDetails = K(next.getProfileId());
            }
            this.f16670g.b(connectionDetails, next);
            if (next.isDisplayedMessage() && next.isToMe()) {
                hashSet.add(next.getProfileId());
            }
            hashMap.put(profileId, connectionDetails);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            T(str2, (ConnectionDetails) hashMap.get(str2));
        }
        if (((ConnectionDetails) hashMap.get(str)) == null) {
            hashMap.put(str, K(str));
        }
        this.f16675l.a(new ArrayList(hashMap.values()));
        this.f16673j.accept(x.a());
        Z();
    }

    private b<List<SavedMessage>> t(String str) {
        b<List<SavedMessage>> C0 = b.C0();
        this.f16665b.put(str, C0);
        this.f16674k.a(C0.b(new r(str), new c()));
        return C0;
    }

    private Cursor v(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.query("roster_element", (String[]) null, "group_name == ?", new String[]{RosterGroup.ACTIVE.a()}, (String) null, (String) null, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public ConnectionDetails K(String str) {
        ConnectionDetails c10 = this.f16675l.c(str);
        if (c10 == null) {
            return new ConnectionDetails();
        }
        return c10;
    }

    public int A() {
        e.a aVar = new e.a(v(this.f16664a.b().getReadableDatabase()));
        int i10 = 0;
        while (aVar.moveToNext()) {
            try {
                RosterElement a10 = aVar.a();
                if (a10 != null) {
                    ConnectionDetails c10 = this.f16675l.c(a10.getProfileId());
                    if (c10 != null && c10.getUnreadMessageCount() > 0) {
                        i10++;
                    }
                }
            } catch (Exception e10) {
                fa.a.g(f16663m, "Failed to calculate the unread message count.", e10);
            } catch (Throwable th2) {
                aVar.close();
                throw th2;
            }
        }
        aVar.close();
        return i10;
    }

    public boolean B(List<RosterElement> list) {
        boolean e10 = this.f16664a.e("roster_element", list);
        new Handler(Looper.getMainLooper()).post(new k(this));
        return e10;
    }

    public boolean C(SavedMessage savedMessage) {
        boolean i10 = this.f16664a.i("saved_message", savedMessage);
        if (!savedMessage.isDisplayedMessage()) {
            e0(savedMessage.getProfileId());
        }
        m0(savedMessage);
        return i10;
    }

    public boolean D(List<SavedMessage> list, String str) {
        boolean e10 = this.f16664a.e("saved_message", list);
        V(list);
        n0(list, str);
        return e10;
    }

    public b<x> S() {
        return this.f16673j;
    }

    public b<ConnectionDetails> W(String str) {
        b<ConnectionDetails> bVar = this.f16668e.get(str);
        if (bVar == null) {
            bVar = b.C0();
            this.f16668e.put(str, bVar);
        }
        ((t) w.A(new o(this, str)).K(dk.a.c()).g(com.uber.autodispose.a.a(this.f16671h))).b(bVar, new p());
        return bVar;
    }

    public void X(String str) {
        ((com.uber.autodispose.m) qj.a.w(new l(this, str, lc.t.e())).F(dk.a.c()).j(com.uber.autodispose.a.a(this.f16671h))).f(new m(this), new n(str));
    }

    public List<SavedMessage> Y(String str) {
        Cursor query = this.f16664a.b().getReadableDatabase().query("saved_message", (String[]) null, "profile_id == ?", new String[]{str}, (String) null, (String) null, "timestamp asc");
        ArrayList arrayList = new ArrayList();
        if (query.moveToFirst()) {
            do {
                SavedMessage a10 = new f.a(query).a();
                if (!TextUtils.isEmpty(a10.getMessage()) || !TextUtils.isEmpty(a10.getUrl())) {
                    arrayList.add(a10);
                }
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    public void a() {
        this.f16674k.e();
        this.f16665b.evictAll();
        this.f16667d.evictAll();
        this.f16668e.evictAll();
        this.f16666c.clear();
    }

    public Bagel a0(String str) {
        List<T> F = this.f16664a.b().F(Extra.BAGEL, h6.b.c(), Extra.PROFILE_ID, str);
        if (CollectionUtils.isEmpty((List) F)) {
            return null;
        }
        return (Bagel) F.get(0);
    }

    public SavedMessage b0(String str) {
        SavedMessage savedMessage;
        Cursor query = this.f16664a.b().getReadableDatabase().query("saved_message", (String[]) null, "profile_id == ? AND displayed_message_id IS NOT NULL AND to_me == 0", new String[]{str}, (String) null, (String) null, "timestamp desc", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (query.moveToFirst()) {
            savedMessage = new f.a(query).a();
        } else {
            savedMessage = null;
        }
        query.close();
        return savedMessage;
    }

    public SavedMessage c0(String str) {
        SavedMessage savedMessage = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor query = this.f16664a.b().getReadableDatabase().query("saved_message", (String[]) null, "profile_id == ? AND message IS NOT NULL", new String[]{str}, (String) null, (String) null, "timestamp desc", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (query.moveToFirst()) {
            savedMessage = new f.a(query).a();
        }
        query.close();
        return savedMessage;
    }

    public SavedMessage d0(String str) {
        SavedMessage savedMessage;
        Cursor query = this.f16664a.b().getReadableDatabase().query("saved_message", (String[]) null, "profile_id == ? AND to_me == 1", new String[]{str}, (String) null, (String) null, "timestamp desc", "10");
        if (query.moveToFirst()) {
            while (true) {
                savedMessage = new f.a(query).a();
                if (TextUtils.isEmpty(savedMessage.getMessage()) && TextUtils.isEmpty(savedMessage.getUrl())) {
                    if (!query.moveToNext()) {
                        break;
                    }
                } else {
                    break;
                }
            }
            savedMessage = null;
        } else {
            savedMessage = null;
        }
        query.close();
        return savedMessage;
    }

    public w<Long> g0(PendingMessageEntity pendingMessageEntity) {
        return this.f16672i.c(pendingMessageEntity);
    }

    public b<List<SavedMessage>> h0(String str) {
        b<List<SavedMessage>> bVar = this.f16665b.get(str);
        if (bVar != null) {
            return bVar;
        }
        b<List<SavedMessage>> t10 = t(str);
        e0(str);
        return t10;
    }

    public b<Integer> i0() {
        return this.f16669f;
    }

    public w<Integer> j0(MessageStatus messageStatus, long j10) {
        int i10 = a.f16676a[messageStatus.ordinal()];
        if (i10 == 1) {
            return this.f16672i.f(j10, messageStatus);
        }
        if (i10 != 2) {
            return w.C(0);
        }
        return this.f16672i.g(j10);
    }

    public Integer k0(Long l10, String str) {
        return Integer.valueOf(this.f16672i.j(l10.longValue(), str));
    }

    public boolean l0(String str, String str2) {
        this.f16664a.c("roster_element", "group_name", str2, Extra.PROFILE_ID, str);
        new Handler(Looper.getMainLooper()).post(new i(this));
        return true;
    }

    public void r() {
    }

    public b<ChatState> s(String str) {
        b<ChatState> bVar = this.f16667d.get(str);
        if (bVar != null) {
            return bVar;
        }
        b<ChatState> C0 = b.C0();
        this.f16667d.put(str, C0);
        ((p) C0.g(com.uber.autodispose.a.a(this.f16671h))).b(new b(str), new j());
        return C0;
    }

    public boolean u(String str) {
        boolean z10 = true;
        if (this.f16664a.j("roster_element", "profile_id=?", new String[]{str}) <= 0) {
            z10 = false;
        }
        new Handler(Looper.getMainLooper()).post(new h(this));
        return z10;
    }

    public List<RosterElement> w() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = v(this.f16664a.b().getReadableDatabase());
            while (cursor != null && cursor.moveToNext()) {
                arrayList.add(new e.a(cursor).a());
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public w<List<PendingMessage>> y(String str) {
        return this.f16672i.n(str);
    }

    public Integer z() {
        return Integer.valueOf(this.f16672i.i().size());
    }
}
