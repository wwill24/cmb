package org.apache.commons.validator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Validator implements Serializable {
    public static final String BEAN_PARAM = "java.lang.Object";
    public static final String FIELD_PARAM = "org.apache.commons.validator.Field";
    public static final String FORM_PARAM = "org.apache.commons.validator.Form";
    public static final String LOCALE_PARAM = "java.util.Locale";
    public static final String VALIDATOR_ACTION_PARAM = "org.apache.commons.validator.ValidatorAction";
    public static final String VALIDATOR_PARAM = "org.apache.commons.validator.Validator";
    public static final String VALIDATOR_RESULTS_PARAM = "org.apache.commons.validator.ValidatorResults";
    private static final long serialVersionUID = -7119418755208731611L;
    protected transient ClassLoader classLoader;
    protected String fieldName;
    protected String formName;
    protected boolean onlyReturnErrors;
    protected int page;
    protected Map<String, Object> parameters;
    protected ValidatorResources resources;
    protected boolean useContextClassLoader;

    public Validator(ValidatorResources validatorResources) {
        this(validatorResources, (String) null);
    }

    public void clear() {
        this.formName = null;
        this.fieldName = null;
        this.parameters = new HashMap();
        this.page = 0;
    }

    public ClassLoader getClassLoader() {
        ClassLoader contextClassLoader;
        ClassLoader classLoader2 = this.classLoader;
        if (classLoader2 != null) {
            return classLoader2;
        }
        if (!this.useContextClassLoader || (contextClassLoader = Thread.currentThread().getContextClassLoader()) == null) {
            return getClass().getClassLoader();
        }
        return contextClassLoader;
    }

    public String getFormName() {
        return this.formName;
    }

    public boolean getOnlyReturnErrors() {
        return this.onlyReturnErrors;
    }

    public int getPage() {
        return this.page;
    }

    public Object getParameterValue(String str) {
        return this.parameters.get(str);
    }

    public boolean getUseContextClassLoader() {
        return this.useContextClassLoader;
    }

    public void setClassLoader(ClassLoader classLoader2) {
        this.classLoader = classLoader2;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setFormName(String str) {
        this.formName = str;
    }

    public void setOnlyReturnErrors(boolean z10) {
        this.onlyReturnErrors = z10;
    }

    public void setPage(int i10) {
        this.page = i10;
    }

    public void setParameter(String str, Object obj) {
        this.parameters.put(str, obj);
    }

    public void setUseContextClassLoader(boolean z10) {
        this.useContextClassLoader = z10;
    }

    public ValidatorResults validate() throws ValidatorException {
        Locale locale = (Locale) getParameterValue(LOCALE_PARAM);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        setParameter(VALIDATOR_PARAM, this);
        Form form = this.resources.getForm(locale, this.formName);
        if (form == null) {
            return new ValidatorResults();
        }
        setParameter(FORM_PARAM, form);
        return form.validate(this.parameters, this.resources.getValidatorActions(), this.page, this.fieldName);
    }

    public Validator(ValidatorResources validatorResources, String str) {
        this.resources = null;
        this.formName = null;
        this.fieldName = null;
        this.parameters = new HashMap();
        this.page = 0;
        this.classLoader = null;
        this.useContextClassLoader = false;
        this.onlyReturnErrors = false;
        if (validatorResources != null) {
            this.resources = validatorResources;
            this.formName = str;
            return;
        }
        throw new IllegalArgumentException("Resources cannot be null.");
    }

    public Validator(ValidatorResources validatorResources, String str, String str2) {
        this.resources = null;
        this.formName = null;
        this.fieldName = null;
        this.parameters = new HashMap();
        this.page = 0;
        this.classLoader = null;
        this.useContextClassLoader = false;
        this.onlyReturnErrors = false;
        if (validatorResources != null) {
            this.resources = validatorResources;
            this.formName = str;
            this.fieldName = str2;
            return;
        }
        throw new IllegalArgumentException("Resources cannot be null.");
    }
}
