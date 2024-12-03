package org.jivesoftware.smackx.ox;

import cn.k;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpContentElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

public class OpenPgpMessage {
    private final String element;
    private final k metadata;
    private OpenPgpContentElement openPgpContentElement;
    private final State state;

    public enum State {
        signcrypt,
        sign,
        crypt
    }

    public OpenPgpMessage(String str, State state2, k kVar) {
        this.metadata = (k) Objects.requireNonNull(kVar);
        this.state = (State) Objects.requireNonNull(state2);
        this.element = (String) Objects.requireNonNull(str);
    }

    private void ensureOpenPgpContentElementSet() throws XmlPullParserException, IOException {
        if (this.openPgpContentElement == null) {
            OpenPgpContentElement parseOpenPgpContentElement = OpenPgpContentElementProvider.parseOpenPgpContentElement(this.element);
            this.openPgpContentElement = parseOpenPgpContentElement;
            if (parseOpenPgpContentElement != null) {
                if (parseOpenPgpContentElement instanceof SigncryptElement) {
                    if (this.state != State.signcrypt) {
                        throw new IllegalStateException("OpenPgpContentElement was signed and encrypted, but is not a SigncryptElement.");
                    }
                } else if (parseOpenPgpContentElement instanceof SignElement) {
                    if (this.state != State.sign) {
                        throw new IllegalStateException("OpenPgpContentElement was signed and unencrypted, but is not a SignElement.");
                    }
                } else if ((parseOpenPgpContentElement instanceof CryptElement) && this.state != State.crypt) {
                    throw new IllegalStateException("OpenPgpContentElement was unsigned and encrypted, but is not a CryptElement.");
                }
            }
        }
    }

    public k getMetadata() {
        return this.metadata;
    }

    public OpenPgpContentElement getOpenPgpContentElement() throws XmlPullParserException, IOException {
        ensureOpenPgpContentElementSet();
        return this.openPgpContentElement;
    }

    public State getState() throws IOException, XmlPullParserException {
        ensureOpenPgpContentElementSet();
        return this.state;
    }

    public OpenPgpMessage(byte[] bArr, State state2, k kVar) {
        this(new String((byte[]) Objects.requireNonNull(bArr), Charset.forName("UTF-8")), state2, kVar);
    }
}
