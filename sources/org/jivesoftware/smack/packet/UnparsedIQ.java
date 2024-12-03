package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ;

public class UnparsedIQ extends IQ {
    private final CharSequence content;

    public UnparsedIQ(String str, String str2, CharSequence charSequence) {
        super(str, str2);
        this.content = charSequence;
    }

    public CharSequence getContent() {
        return this.content;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.escape(this.content);
        return iQChildElementXmlStringBuilder;
    }
}
