package l8;

import androidx.annotation.NonNull;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import lc.t;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.sasl.provided.SASLPlainMechanism;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileManager f16076a;

    public e(ProfileManager profileManager) {
        this.f16076a = profileManager;
    }

    private void g() {
        for (String blacklistSASLMechanism : SASLAuthentication.getRegisterdSASLMechanisms().values()) {
            SASLAuthentication.blacklistSASLMechanism(blacklistSASLMechanism);
        }
        SASLAuthentication.unBlacklistSASLMechanism("PLAIN");
        SASLAuthentication.registerSASLMechanism(new SASLPlainMechanism());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public XMPPTCPConnection a() throws UnknownHostException {
        DomainBareJid domainBareJid;
        InetAddress inetAddress = null;
        try {
            domainBareJid = a.e(c());
        } catch (XmppStringprepException e10) {
            fa.a.i(e10);
            domainBareJid = null;
        }
        InetAddress[] allByName = InetAddress.getAllByName(c());
        if (allByName.length > 0) {
            int length = allByName.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                InetAddress inetAddress2 = allByName[i10];
                if (inetAddress2 instanceof Inet4Address) {
                    inetAddress = inetAddress2;
                    break;
                }
                i10++;
            }
        }
        Long valueOf = Long.valueOf(TimeUnit.MINUTES.toMillis(3));
        XMPPTCPConnectionConfiguration.Builder builder = (XMPPTCPConnectionConfiguration.Builder) ((XMPPTCPConnectionConfiguration.Builder) ((XMPPTCPConnectionConfiguration.Builder) ((XMPPTCPConnectionConfiguration.Builder) ((XMPPTCPConnectionConfiguration.Builder) XMPPTCPConnectionConfiguration.builder().setPort(5222)).setXmppDomain(domainBareJid)).setSendPresence(true)).setResource(f())).setConnectTimeout(valueOf.intValue()).setSecurityMode(ConnectionConfiguration.SecurityMode.required);
        if (inetAddress != null) {
            builder.setHostAddress(inetAddress);
        } else {
            builder.setHost((CharSequence) c());
        }
        XMPPTCPConnection xMPPTCPConnection = new XMPPTCPConnection(builder.build());
        xMPPTCPConnection.setFromMode(XMPPConnection.FromMode.UNCHANGED);
        xMPPTCPConnection.setReplyTimeout(valueOf.longValue());
        ReconnectionManager.getInstanceFor(xMPPTCPConnection).setReconnectionPolicy(ReconnectionManager.ReconnectionPolicy.RANDOM_INCREASING_DELAY);
        g();
        Roster.getInstanceFor(xMPPTCPConnection).setRosterLoadedAtLogin(false);
        return xMPPTCPConnection;
    }

    /* access modifiers changed from: package-private */
    public Jid b() {
        try {
            return a.o(c());
        } catch (XmppStringprepException e10) {
            fa.a.i(e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return t.i();
    }

    /* access modifiers changed from: package-private */
    public String d() {
        NetworkProfile j10 = this.f16076a.j();
        if (j10 == null) {
            return null;
        }
        return j10.getId() + "@" + t.i();
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return t.n();
    }

    /* access modifiers changed from: package-private */
    public Resourcepart f() {
        try {
            return Resourcepart.b(e());
        } catch (XmppStringprepException e10) {
            fa.a.i(e10);
            return null;
        }
    }
}
