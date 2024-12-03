package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;

public class DelayInformationProvider extends AbstractDelayInformationProvider {
    public static final DelayInformationProvider INSTANCE = new DelayInformationProvider();

    /* access modifiers changed from: protected */
    public Date parseDate(String str) throws SmackParsingException.SmackTextParseException {
        return ParserUtils.getDateFromXep82String(str);
    }
}
