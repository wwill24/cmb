package org.apache.commons.validator;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.kits.AppsFlyerKit;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ValidatorResources implements Serializable {
    private static final String ARGS_PATTERN = "form-validation/formset/form/field/arg";
    private static final String[] REGISTRATIONS = {"-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.0//EN", "/org/apache/commons/validator/resources/validator_1_0.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.0.1//EN", "/org/apache/commons/validator/resources/validator_1_0_1.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.1//EN", "/org/apache/commons/validator/resources/validator_1_1.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.1.3//EN", "/org/apache/commons/validator/resources/validator_1_1_3.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.2.0//EN", "/org/apache/commons/validator/resources/validator_1_2_0.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.3.0//EN", "/org/apache/commons/validator/resources/validator_1_3_0.dtd", "-//Apache Software Foundation//DTD Commons Validator Rules Configuration 1.4.0//EN", "/org/apache/commons/validator/resources/validator_1_4_0.dtd"};
    private static final String VALIDATOR_RULES = "digester-rules.xml";
    protected static Locale defaultLocale = Locale.getDefault();
    private static final long serialVersionUID = -8203745881446239554L;
    protected FormSet defaultFormSet;
    protected FastHashMap hActions;
    protected FastHashMap hConstants;
    protected FastHashMap hFormSets;
    private transient Log log;

    public ValidatorResources() {
        this.log = LogFactory.getLog(ValidatorResources.class);
        this.hFormSets = new FastHashMap();
        this.hConstants = new FastHashMap();
        this.hActions = new FastHashMap();
    }

    private void addOldArgRules(Digester digester) {
        AnonymousClass1 r02 = new Rule() {
            public void begin(String str, String str2, Attributes attributes) throws Exception {
                Arg arg = new Arg();
                arg.setKey(attributes.getValue(SDKConstants.PARAM_KEY));
                arg.setName(attributes.getValue("name"));
                if ("false".equalsIgnoreCase(attributes.getValue("resource"))) {
                    arg.setResource(false);
                }
                try {
                    arg.setPosition(Integer.parseInt(str2.substring(3)));
                } catch (Exception e10) {
                    Log access$000 = ValidatorResources.this.getLog();
                    access$000.error("Error parsing Arg position: " + str2 + " " + arg + " " + e10);
                }
                ((Field) getDigester().peek(0)).addArg(arg);
            }
        };
        digester.addRule("form-validation/formset/form/field/arg0", r02);
        digester.addRule("form-validation/formset/form/field/arg1", r02);
        digester.addRule("form-validation/formset/form/field/arg2", r02);
        digester.addRule("form-validation/formset/form/field/arg3", r02);
    }

    private String buildLocale(String str, String str2, String str3) {
        String str4;
        String str5 = "";
        if (str == null || str.length() <= 0) {
            str = str5;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (str2 == null || str2.length() <= 0) {
            str4 = str5;
        } else {
            str4 = JavaConstant.Dynamic.DEFAULT_NAME + str2;
        }
        sb2.append(str4);
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb3);
        if (str3 != null && str3.length() > 0) {
            str5 = JavaConstant.Dynamic.DEFAULT_NAME + str3;
        }
        sb4.append(str5);
        return sb4.toString();
    }

    /* access modifiers changed from: private */
    public Log getLog() {
        if (this.log == null) {
            this.log = LogFactory.getLog(ValidatorResources.class);
        }
        return this.log;
    }

    private FormSet getParent(FormSet formSet) {
        if (formSet.getType() == 2) {
            return this.defaultFormSet;
        }
        if (formSet.getType() == 3) {
            FormSet formSet2 = getFormSets().get(buildLocale(formSet.getLanguage(), (String) null, (String) null));
            if (formSet2 == null) {
                return this.defaultFormSet;
            }
            return formSet2;
        } else if (formSet.getType() != 4) {
            return null;
        } else {
            FormSet formSet3 = getFormSets().get(buildLocale(formSet.getLanguage(), formSet.getCountry(), (String) null));
            if (formSet3 != null) {
                return formSet3;
            }
            FormSet formSet4 = getFormSets().get(buildLocale(formSet.getLanguage(), (String) null, (String) null));
            if (formSet4 == null) {
                return this.defaultFormSet;
            }
            return formSet4;
        }
    }

    private Digester initDigester() {
        URL resource = getClass().getResource(VALIDATOR_RULES);
        if (resource == null) {
            resource = ValidatorResources.class.getResource(VALIDATOR_RULES);
        }
        if (getLog().isDebugEnabled()) {
            Log log2 = getLog();
            log2.debug("Loading rules from '" + resource + "'");
        }
        Digester createDigester = DigesterLoader.createDigester(resource);
        createDigester.setNamespaceAware(true);
        createDigester.setValidating(true);
        createDigester.setUseContextClassLoader(true);
        addOldArgRules(createDigester);
        int i10 = 0;
        while (true) {
            String[] strArr = REGISTRATIONS;
            if (i10 >= strArr.length) {
                return createDigester;
            }
            URL resource2 = getClass().getResource(strArr[i10 + 1]);
            if (resource2 != null) {
                createDigester.register(strArr[i10], resource2.toString());
            }
            i10 += 2;
        }
    }

    private void processForms() {
        if (this.defaultFormSet == null) {
            this.defaultFormSet = new FormSet();
        }
        this.defaultFormSet.process(getConstants());
        for (String str : getFormSets().keySet()) {
            FormSet formSet = getFormSets().get(str);
            formSet.merge(getParent(formSet));
        }
        for (FormSet next : getFormSets().values()) {
            if (!next.isProcessed()) {
                next.process(getConstants());
            }
        }
    }

    public void addConstant(String str, String str2) {
        if (getLog().isDebugEnabled()) {
            Log log2 = getLog();
            log2.debug("Adding Global Constant: " + str + AppsFlyerKit.COMMA + str2);
        }
        this.hConstants.put(str, str2);
    }

    public void addFormSet(FormSet formSet) {
        String buildKey = buildKey(formSet);
        if (buildKey.length() == 0) {
            if (getLog().isWarnEnabled() && this.defaultFormSet != null) {
                getLog().warn("Overriding default FormSet definition.");
            }
            this.defaultFormSet = formSet;
            return;
        }
        if (getFormSets().get(buildKey) == null) {
            if (getLog().isDebugEnabled()) {
                Log log2 = getLog();
                log2.debug("Adding FormSet '" + formSet.toString() + "'.");
            }
        } else if (getLog().isWarnEnabled()) {
            Log log3 = getLog();
            log3.warn("Overriding FormSet definition. Duplicate for locale: " + buildKey);
        }
        getFormSets().put(buildKey, formSet);
    }

    public void addValidatorAction(ValidatorAction validatorAction) {
        validatorAction.init();
        getActions().put(validatorAction.getName(), validatorAction);
        if (getLog().isDebugEnabled()) {
            Log log2 = getLog();
            log2.debug("Add ValidatorAction: " + validatorAction.getName() + AppsFlyerKit.COMMA + validatorAction.getClassname());
        }
    }

    /* access modifiers changed from: protected */
    public String buildKey(FormSet formSet) {
        return buildLocale(formSet.getLanguage(), formSet.getCountry(), formSet.getVariant());
    }

    /* access modifiers changed from: protected */
    public Map<String, ValidatorAction> getActions() {
        return this.hActions;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getConstants() {
        return this.hConstants;
    }

    public Form getForm(Locale locale, String str) {
        return getForm(locale.getLanguage(), locale.getCountry(), locale.getVariant(), str);
    }

    /* access modifiers changed from: package-private */
    public FormSet getFormSet(String str, String str2, String str3) {
        String buildLocale = buildLocale(str, str2, str3);
        if (buildLocale.length() == 0) {
            return this.defaultFormSet;
        }
        return getFormSets().get(buildLocale);
    }

    /* access modifiers changed from: protected */
    public Map<String, FormSet> getFormSets() {
        return this.hFormSets;
    }

    public ValidatorAction getValidatorAction(String str) {
        return getActions().get(str);
    }

    public Map<String, ValidatorAction> getValidatorActions() {
        return Collections.unmodifiableMap(getActions());
    }

    public void process() {
        this.hFormSets.setFast(true);
        this.hConstants.setFast(true);
        this.hActions.setFast(true);
        processForms();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = getFormSets().get(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.validator.Form getForm(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            java.lang.String r7 = r4.buildLocale(r5, r6, r7)
            int r0 = r7.length()
            r1 = 0
            if (r0 <= 0) goto L_0x001c
            java.util.Map r0 = r4.getFormSets()
            java.lang.Object r0 = r0.get(r7)
            org.apache.commons.validator.FormSet r0 = (org.apache.commons.validator.FormSet) r0
            if (r0 == 0) goto L_0x001c
            org.apache.commons.validator.Form r0 = r0.getForm(r8)
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 != 0) goto L_0x003a
            java.lang.String r6 = r4.buildLocale(r5, r6, r1)
            int r2 = r6.length()
            if (r2 <= 0) goto L_0x003b
            java.util.Map r2 = r4.getFormSets()
            java.lang.Object r2 = r2.get(r6)
            org.apache.commons.validator.FormSet r2 = (org.apache.commons.validator.FormSet) r2
            if (r2 == 0) goto L_0x003b
            org.apache.commons.validator.Form r0 = r2.getForm(r8)
            goto L_0x003b
        L_0x003a:
            r6 = r7
        L_0x003b:
            if (r0 != 0) goto L_0x0057
            java.lang.String r6 = r4.buildLocale(r5, r1, r1)
            int r5 = r6.length()
            if (r5 <= 0) goto L_0x0057
            java.util.Map r5 = r4.getFormSets()
            java.lang.Object r5 = r5.get(r6)
            org.apache.commons.validator.FormSet r5 = (org.apache.commons.validator.FormSet) r5
            if (r5 == 0) goto L_0x0057
            org.apache.commons.validator.Form r0 = r5.getForm(r8)
        L_0x0057:
            if (r0 != 0) goto L_0x0061
            org.apache.commons.validator.FormSet r5 = r4.defaultFormSet
            org.apache.commons.validator.Form r0 = r5.getForm(r8)
            java.lang.String r6 = "default"
        L_0x0061:
            java.lang.String r5 = "'"
            java.lang.String r1 = "Form '"
            if (r0 != 0) goto L_0x0093
            org.apache.commons.logging.Log r6 = r4.getLog()
            boolean r6 = r6.isWarnEnabled()
            if (r6 == 0) goto L_0x00c6
            org.apache.commons.logging.Log r6 = r4.getLog()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r8)
            java.lang.String r8 = "' not found for locale '"
            r2.append(r8)
            r2.append(r7)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r6.warn(r5)
            goto L_0x00c6
        L_0x0093:
            org.apache.commons.logging.Log r2 = r4.getLog()
            boolean r2 = r2.isDebugEnabled()
            if (r2 == 0) goto L_0x00c6
            org.apache.commons.logging.Log r2 = r4.getLog()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r8)
            java.lang.String r8 = "' found in formset '"
            r3.append(r8)
            r3.append(r6)
            java.lang.String r6 = "' for locale '"
            r3.append(r6)
            r3.append(r7)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r2.debug(r5)
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.ValidatorResources.getForm(java.lang.String, java.lang.String, java.lang.String, java.lang.String):org.apache.commons.validator.Form");
    }

    public ValidatorResources(InputStream inputStream) throws IOException, SAXException {
        this(new InputStream[]{inputStream});
    }

    public ValidatorResources(InputStream[] inputStreamArr) throws IOException, SAXException {
        this.log = LogFactory.getLog(ValidatorResources.class);
        this.hFormSets = new FastHashMap();
        this.hConstants = new FastHashMap();
        this.hActions = new FastHashMap();
        Digester initDigester = initDigester();
        int i10 = 0;
        while (i10 < inputStreamArr.length) {
            if (inputStreamArr[i10] != null) {
                initDigester.push(this);
                initDigester.parse(inputStreamArr[i10]);
                i10++;
            } else {
                throw new IllegalArgumentException("Stream[" + i10 + "] is null");
            }
        }
        process();
    }

    public ValidatorResources(String str) throws IOException, SAXException {
        this(new String[]{str});
    }

    public ValidatorResources(String[] strArr) throws IOException, SAXException {
        this.log = LogFactory.getLog(ValidatorResources.class);
        this.hFormSets = new FastHashMap();
        this.hConstants = new FastHashMap();
        this.hActions = new FastHashMap();
        Digester initDigester = initDigester();
        for (String parse : strArr) {
            initDigester.push(this);
            initDigester.parse(parse);
        }
        process();
    }

    public ValidatorResources(URL url) throws IOException, SAXException {
        this(new URL[]{url});
    }

    public ValidatorResources(URL[] urlArr) throws IOException, SAXException {
        this.log = LogFactory.getLog(ValidatorResources.class);
        this.hFormSets = new FastHashMap();
        this.hConstants = new FastHashMap();
        this.hActions = new FastHashMap();
        Digester initDigester = initDigester();
        for (URL parse : urlArr) {
            initDigester.push(this);
            initDigester.parse(parse);
        }
        process();
    }
}
