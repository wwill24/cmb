package org.jivesoftware.smack.debugger;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.logging.Logger;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.ReconnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.WriterListener;
import org.jxmpp.jid.EntityFullJid;

public abstract class AbstractDebugger extends SmackDebugger {
    private static final Logger LOGGER = Logger.getLogger(AbstractDebugger.class.getName());
    public static boolean printInterpreted = false;
    private final ConnectionListener connListener;
    private ObservableReader reader = new ObservableReader(this.reader);
    private final ReaderListener readerListener;
    private final ReconnectionListener reconnectionListener;
    private ObservableWriter writer;
    private final WriterListener writerListener;

    public AbstractDebugger(final XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        AnonymousClass1 r02 = new ReaderListener() {
            public void read(String str) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("RECV (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.readerListener = r02;
        this.reader.addReaderListener(r02);
        this.writer = new ObservableWriter(this.writer);
        AnonymousClass2 r03 = new WriterListener() {
            public void write(String str) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("SENT (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.writerListener = r03;
        this.writer.addWriterListener(r03);
        this.connListener = new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                String str = "XMPPConnection authenticated (" + xMPPConnection + ")";
                if (z10) {
                    str = str + " and resumed";
                }
                AbstractDebugger.this.log(str);
            }

            public void connected(XMPPConnection xMPPConnection) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("XMPPConnection connected (" + xMPPConnection + ")");
            }

            public void connectionClosed() {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("XMPPConnection closed (" + xMPPConnection + ")");
            }

            public void connectionClosedOnError(Exception exc) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("XMPPConnection closed due to an exception (" + xMPPConnection + ")", exc);
            }
        };
        AnonymousClass4 r04 = new ReconnectionListener() {
            public void reconnectingIn(int i10) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("XMPPConnection (" + xMPPConnection + ") will reconnect in " + i10);
            }

            public void reconnectionFailed(Exception exc) {
                AbstractDebugger abstractDebugger = AbstractDebugger.this;
                abstractDebugger.log("Reconnection failed due to an exception (" + xMPPConnection + ")", exc);
            }
        };
        this.reconnectionListener = r04;
        if (xMPPConnection instanceof AbstractXMPPConnection) {
            ReconnectionManager.getInstanceFor((AbstractXMPPConnection) xMPPConnection).addReconnectionListener(r04);
            return;
        }
        Logger logger = LOGGER;
        logger.info("The connection instance " + xMPPConnection + " is not an instance of AbstractXMPPConnection, thus we can not install the ReconnectionListener");
    }

    public final void incomingStreamSink(CharSequence charSequence) {
        log("RECV (" + this.connection.getConnectionCounter() + "): " + charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void log(String str);

    /* access modifiers changed from: protected */
    public abstract void log(String str, Throwable th2);

    public void onIncomingStreamElement(TopLevelStreamElement topLevelStreamElement) {
        if (printInterpreted) {
            log("RCV PKT (" + this.connection.getConnectionCounter() + "): " + topLevelStreamElement.toXML());
        }
    }

    public void onOutgoingStreamElement(TopLevelStreamElement topLevelStreamElement) {
    }

    public final void outgoingStreamSink(CharSequence charSequence) {
        log("SENT (" + this.connection.getConnectionCounter() + "): " + charSequence);
    }

    public void userHasLogged(EntityFullJid entityFullJid) {
        String part = entityFullJid.c1().toString();
        boolean equals = "".equals(part);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("User logged (");
        sb2.append(this.connection.getConnectionCounter());
        sb2.append("): ");
        if (equals) {
            part = "";
        }
        sb2.append(part);
        sb2.append("@");
        sb2.append(this.connection.getXMPPServiceDomain());
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(this.connection.getPort());
        String sb3 = sb2.toString();
        log(sb3 + RemoteSettings.FORWARD_SLASH_STRING + entityFullJid.q0());
        this.connection.addConnectionListener(this.connListener);
    }
}
