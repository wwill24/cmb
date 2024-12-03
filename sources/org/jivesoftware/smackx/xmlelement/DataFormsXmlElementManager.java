package org.jivesoftware.smackx.xmlelement;

import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProviderManager;
import org.jivesoftware.smackx.xmlelement.provider.DataFormsXmlElementProvider;

public class DataFormsXmlElementManager {
    static {
        FormFieldChildElementProviderManager.addFormFieldChildElementProvider(new DataFormsXmlElementProvider());
    }
}
