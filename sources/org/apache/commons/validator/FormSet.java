package org.apache.commons.validator;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FormSet implements Serializable {
    protected static final int COUNTRY_FORMSET = 3;
    protected static final int GLOBAL_FORMSET = 1;
    protected static final int LANGUAGE_FORMSET = 2;
    protected static final int VARIANT_FORMSET = 4;
    private static final long serialVersionUID = -8936513232763306055L;
    private final Map<String, String> constants = new HashMap();
    private String country = null;
    private final Map<String, Form> forms = new HashMap();
    private String language = null;
    private transient Log log = LogFactory.getLog(FormSet.class);
    private boolean merged;
    private boolean processed = false;
    private String variant = null;

    private Log getLog() {
        if (this.log == null) {
            this.log = LogFactory.getLog(FormSet.class);
        }
        return this.log;
    }

    public void addConstant(String str, String str2) {
        if (this.constants.containsKey(str)) {
            Log log2 = getLog();
            log2.error("Constant '" + str + "' already exists in FormSet[" + displayKey() + "] - ignoring.");
            return;
        }
        this.constants.put(str, str2);
    }

    public void addForm(Form form) {
        String name = form.getName();
        if (this.forms.containsKey(name)) {
            Log log2 = getLog();
            log2.error("Form '" + name + "' already exists in FormSet[" + displayKey() + "] - ignoring.");
            return;
        }
        this.forms.put(form.getName(), form);
    }

    public String displayKey() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.language;
        if (str != null && str.length() > 0) {
            sb2.append("language=");
            sb2.append(this.language);
        }
        String str2 = this.country;
        if (str2 != null && str2.length() > 0) {
            if (sb2.length() > 0) {
                sb2.append(", ");
            }
            sb2.append("country=");
            sb2.append(this.country);
        }
        String str3 = this.variant;
        if (str3 != null && str3.length() > 0) {
            if (sb2.length() > 0) {
                sb2.append(", ");
            }
            sb2.append("variant=");
            sb2.append(this.variant);
        }
        if (sb2.length() == 0) {
            sb2.append("default");
        }
        return sb2.toString();
    }

    public String getCountry() {
        return this.country;
    }

    public Form getForm(String str) {
        return this.forms.get(str);
    }

    public Map<String, Form> getForms() {
        return Collections.unmodifiableMap(this.forms);
    }

    public String getLanguage() {
        return this.language;
    }

    /* access modifiers changed from: protected */
    public int getType() {
        if (getVariant() != null) {
            if (getLanguage() != null && getCountry() != null) {
                return 4;
            }
            throw new NullPointerException("When variant is specified, country and language must be specified.");
        } else if (getCountry() != null) {
            if (getLanguage() != null) {
                return 3;
            }
            throw new NullPointerException("When country is specified, language must be specified.");
        } else if (getLanguage() != null) {
            return 2;
        } else {
            return 1;
        }
    }

    public String getVariant() {
        return this.variant;
    }

    /* access modifiers changed from: protected */
    public boolean isMerged() {
        return this.merged;
    }

    public boolean isProcessed() {
        return this.processed;
    }

    /* access modifiers changed from: protected */
    public void merge(FormSet formSet) {
        if (formSet != null) {
            Map<String, Form> forms2 = getForms();
            for (Map.Entry next : formSet.getForms().entrySet()) {
                Form form = forms2.get((String) next.getKey());
                if (form != null) {
                    form.merge((Form) next.getValue());
                } else {
                    addForm((Form) next.getValue());
                }
            }
        }
        this.merged = true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void process(Map<String, String> map) {
        for (Form process : this.forms.values()) {
            process.process(map, this.constants, this.forms);
        }
        this.processed = true;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setVariant(String str) {
        this.variant = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FormSet: language=");
        sb2.append(this.language);
        sb2.append("  country=");
        sb2.append(this.country);
        sb2.append("  variant=");
        sb2.append(this.variant);
        sb2.append("\n");
        for (Form append : getForms().values()) {
            sb2.append("   ");
            sb2.append(append);
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
