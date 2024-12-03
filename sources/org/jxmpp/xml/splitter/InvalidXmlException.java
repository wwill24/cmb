package org.jxmpp.xml.splitter;

import java.io.IOException;

public abstract class InvalidXmlException extends IOException {
    private static final long serialVersionUID = 1;
    private final char unexpectedChar;
    private final String xml;

    public static final class InvalidAttributeDeclarationException extends InvalidXmlException {
        private static final long serialVersionUID = 1;

        private InvalidAttributeDeclarationException(CharSequence charSequence, char c10, CharSequence charSequence2) {
            super(charSequence, c10, charSequence2);
        }

        public static InvalidAttributeDeclarationException a(char c10, CharSequence charSequence) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid attribute declaration, expected ''' or '\"', but got '");
            sb2.append(c10);
            sb2.append("'. Parsed xml so far: ");
            sb2.append(charSequence);
            return new InvalidAttributeDeclarationException(sb2, c10, charSequence);
        }
    }

    public static final class InvalidEmptyTagException extends InvalidXmlException {
        private static final long serialVersionUID = 1;

        private InvalidEmptyTagException(CharSequence charSequence, char c10, CharSequence charSequence2) {
            super(charSequence, c10, charSequence2);
        }

        public static InvalidEmptyTagException a(char c10, CharSequence charSequence) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid empty tag, expected '>', but got '");
            sb2.append(c10);
            sb2.append("'. Parsed xml so far: ");
            sb2.append(charSequence);
            return new InvalidEmptyTagException(sb2, c10, charSequence);
        }
    }

    protected InvalidXmlException(CharSequence charSequence, char c10, CharSequence charSequence2) {
        super(charSequence.toString());
        this.unexpectedChar = c10;
        this.xml = charSequence2.toString();
    }
}
