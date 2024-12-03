package org.apache.commons.validator;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

public class FormSetFactory extends AbstractObjectCreationFactory {
    private transient Log log = LogFactory.getLog(FormSetFactory.class);

    private FormSet createFormSet(ValidatorResources validatorResources, String str, String str2, String str3) throws Exception {
        FormSet formSet = validatorResources.getFormSet(str, str2, str3);
        if (formSet != null) {
            if (getLog().isDebugEnabled()) {
                Log log2 = getLog();
                log2.debug("FormSet[" + formSet.displayKey() + "] found - merging.");
            }
            return formSet;
        }
        FormSet formSet2 = new FormSet();
        formSet2.setLanguage(str);
        formSet2.setCountry(str2);
        formSet2.setVariant(str3);
        validatorResources.addFormSet(formSet2);
        if (getLog().isDebugEnabled()) {
            Log log3 = getLog();
            log3.debug("FormSet[" + formSet2.displayKey() + "] created.");
        }
        return formSet2;
    }

    private Log getLog() {
        if (this.log == null) {
            this.log = LogFactory.getLog(FormSetFactory.class);
        }
        return this.log;
    }

    public Object createObject(Attributes attributes) throws Exception {
        return createFormSet((ValidatorResources) this.digester.peek(0), attributes.getValue("language"), attributes.getValue("country"), attributes.getValue("variant"));
    }
}
