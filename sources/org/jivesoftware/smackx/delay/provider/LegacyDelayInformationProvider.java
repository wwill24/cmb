package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;

public class LegacyDelayInformationProvider extends AbstractDelayInformationProvider {
    /* access modifiers changed from: protected */
    public Date parseDate(String str) throws SmackParsingException.SmackTextParseException {
        return ParserUtils.getDateFromString(str);
    }
}
