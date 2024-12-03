package l8;

import android.content.Context;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import java.util.Collection;
import java.util.Iterator;
import lc.t;
import n8.s;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.RosterListener;
import org.jxmpp.jid.Jid;
import uj.a;

public class n1 implements RosterListener {

    /* renamed from: a  reason: collision with root package name */
    private final s f16166a;

    /* renamed from: b  reason: collision with root package name */
    private final h1 f16167b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16168c;

    n1(s sVar, h1 h1Var, Context context) {
        this.f16166a = sVar;
        this.f16167b = h1Var;
        this.f16168c = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean b(Collection collection) throws Exception {
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f16166a.u(t.j((Jid) it.next()));
                this.f16167b.A1();
            }
            return Boolean.TRUE;
        } catch (Exception e10) {
            throw a.a(new Throwable("Failed to delete roster entries" + e10.getMessage()));
        }
    }

    public void entriesAdded(Collection<Jid> collection) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("entries added ");
        sb2.append(collection.size());
        MongooseSyncJobService.D(this.f16168c, collection);
    }

    public void entriesDeleted(Collection<Jid> collection) {
        this.f16167b.H1(new m1(this, collection), true);
    }

    public void entriesUpdated(Collection<Jid> collection) {
        MongooseSyncJobService.D(this.f16168c, collection);
    }

    public void presenceChanged(Presence presence) {
    }
}
