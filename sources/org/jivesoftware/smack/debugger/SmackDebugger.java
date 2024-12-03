package org.jivesoftware.smack.debugger;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.xml.splitter.e;
import org.jxmpp.xml.splitter.h;

public abstract class SmackDebugger {
    protected final XMPPConnection connection;
    private h incomingStreamSplitterForPrettyPrinting;
    private h outgoingStreamSplitterForPrettyPrinting;

    protected SmackDebugger(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newConnectionReader$1(String str) {
        try {
            this.incomingStreamSplitterForPrettyPrinting.append(str);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newConnectionWriter$3(String str) {
        try {
            this.outgoingStreamSplitterForPrettyPrinting.append(str);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: incomingStreamSink */
    public abstract void lambda$newConnectionReader$0(CharSequence charSequence);

    public final Reader newConnectionReader(Reader reader) {
        this.incomingStreamSplitterForPrettyPrinting = new h(e.f().h(new a(this)).g());
        ObservableReader observableReader = new ObservableReader(reader);
        observableReader.addReaderListener(new b(this));
        return observableReader;
    }

    public final Writer newConnectionWriter(Writer writer) {
        this.outgoingStreamSplitterForPrettyPrinting = new h(e.f().h(new c(this)).g());
        ObservableWriter observableWriter = new ObservableWriter(writer);
        observableWriter.addWriterListener(new d(this));
        return observableWriter;
    }

    public void onIncomingElementCompleted() {
    }

    public abstract void onIncomingStreamElement(TopLevelStreamElement topLevelStreamElement);

    public void onOutgoingElementCompleted() {
    }

    public abstract void onOutgoingStreamElement(TopLevelStreamElement topLevelStreamElement);

    /* renamed from: outgoingStreamSink */
    public abstract void lambda$newConnectionWriter$2(CharSequence charSequence);

    public abstract void userHasLogged(EntityFullJid entityFullJid);
}
