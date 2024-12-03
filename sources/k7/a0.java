package k7;

import com.coffeemeetsbagel.models.CmbMessage;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import l8.h;
import n8.s;
import tj.a;

public class a0 implements d {

    /* renamed from: h  reason: collision with root package name */
    private static final String f15887h = "a0";

    /* renamed from: a  reason: collision with root package name */
    private String f15888a;

    /* renamed from: b  reason: collision with root package name */
    private String f15889b;

    /* renamed from: c  reason: collision with root package name */
    private g f15890c;

    /* renamed from: d  reason: collision with root package name */
    private h f15891d;

    /* renamed from: e  reason: collision with root package name */
    private s f15892e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15893f;

    /* renamed from: g  reason: collision with root package name */
    private a f15894g = new a();

    public a0(g gVar, h hVar, s sVar, String str, String str2) {
        this.f15890c = gVar;
        this.f15891d = hVar;
        this.f15892e = sVar;
        this.f15889b = str;
        this.f15888a = str2;
    }

    private List<CmbMessage> Y(List<SavedMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (SavedMessage next : list) {
            if (next.getProfileId().equals(this.f15888a)) {
                arrayList.add(new CmbMessage(next, this.f15889b));
            }
        }
        Collections.sort(arrayList, new z());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int Z(CmbMessage cmbMessage, CmbMessage cmbMessage2) {
        if (DateUtils.getDate(cmbMessage.getDateSent()).getTime() - DateUtils.getDate(cmbMessage2.getDateSent()).getTime() < 0) {
            return -1;
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a0(List list) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(List list) throws Exception {
        this.f15893f = false;
    }

    private CmbMessage e0(List<CmbMessage> list, ConnectionDetails connectionDetails) {
        if (connectionDetails.getPairReadReceiptDate() != null) {
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                CmbMessage cmbMessage = list.get(size);
                Date localDate = DateUtils.getLocalDate(cmbMessage.getDateSent(), DateUtils.DATE_WITH_TIME_PATTERN);
                Date localDate2 = DateUtils.getLocalDate(connectionDetails.getPairReadReceiptDate(), DateUtils.DATE_WITH_TIME_PATTERN_MS);
                if (localDate == null || localDate2 == null) {
                    fa.a.f(f15887h, "Malformed Read Receipt Dates");
                    fa.a.i(new Exception("Malformed Read Receipt Dates"));
                } else if (cmbMessage.isFromMe(this.f15889b) && localDate.compareTo(localDate2) <= 0) {
                    return cmbMessage;
                } else {
                    size--;
                }
            }
        }
        return null;
    }

    public void g(List<PendingMessage> list) {
        ArrayList arrayList = new ArrayList();
        for (PendingMessage cmbMessage : list) {
            CmbMessage cmbMessage2 = new CmbMessage(cmbMessage);
            cmbMessage2.setSenderID(Long.valueOf(this.f15889b).longValue());
            arrayList.add(cmbMessage2);
        }
        this.f15890c.l0(arrayList);
    }

    public void m() {
        this.f15894g.a(this.f15891d.n(this.f15888a).a0(sj.a.a()).b(new v(), new w()));
    }

    public void n() {
        if (!this.f15893f) {
            this.f15893f = true;
            this.f15894g.a(this.f15891d.f(this.f15888a).a0(sj.a.a()).b(new x(this), new y()));
        }
    }

    public void s(List<SavedMessage> list, ConnectionDetails connectionDetails) {
        List<CmbMessage> Y = Y(list);
        this.f15890c.J(Y, e0(Y, connectionDetails));
        this.f15892e.X(this.f15888a);
    }

    public void start() {
    }

    public void stop() {
        this.f15894g.dispose();
    }
}
