package org.apache.commons.validator;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.AppsFlyerKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.util.ValidatorUtils;

public class ValidatorAction implements Serializable {
    private static final long serialVersionUID = 1339713700053204597L;
    private String classname = null;
    private final List<String> dependencyList = Collections.synchronizedList(new ArrayList());
    private String depends = null;
    private Object instance = null;
    private String javascript = null;
    private String jsFunction = null;
    private String jsFunctionName = null;
    private transient Log log = LogFactory.getLog(ValidatorAction.class);
    private String method = null;
    private final List<String> methodParameterList = new ArrayList();
    private String methodParams = "java.lang.Object,org.apache.commons.validator.ValidatorAction,org.apache.commons.validator.Field";
    private String msg = null;
    private String name = null;
    private Class<?>[] parameterClasses = null;
    private Class<?> validationClass = null;
    private Method validationMethod = null;

    private String formatJavascriptFileName() {
        String substring = this.jsFunction.substring(1);
        if (this.jsFunction.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return substring;
        }
        return this.jsFunction.replace('.', '/') + ".js";
    }

    private String generateJsFunction() {
        StringBuilder sb2 = new StringBuilder("org.apache.commons.validator.javascript");
        sb2.append(".validate");
        sb2.append(this.name.substring(0, 1).toUpperCase());
        String str = this.name;
        sb2.append(str.substring(1, str.length()));
        return sb2.toString();
    }

    private ClassLoader getClassLoader(Map<String, Object> map) {
        return ((Validator) map.get(Validator.VALIDATOR_PARAM)).getClassLoader();
    }

    private Log getLog() {
        if (this.log == null) {
            this.log = LogFactory.getLog(ValidatorAction.class);
        }
        return this.log;
    }

    private Object[] getParameterValues(Map<String, ? super Object> map) {
        Object[] objArr = new Object[this.methodParameterList.size()];
        for (int i10 = 0; i10 < this.methodParameterList.size(); i10++) {
            objArr[i10] = map.get(this.methodParameterList.get(i10));
        }
        return objArr;
    }

    private Object getValidationClassInstance() throws ValidatorException {
        if (Modifier.isStatic(this.validationMethod.getModifiers())) {
            this.instance = null;
        } else if (this.instance == null) {
            try {
                this.instance = this.validationClass.newInstance();
            } catch (InstantiationException e10) {
                throw new ValidatorException("Couldn't create instance of " + this.classname + ".  " + e10.getMessage());
            } catch (IllegalAccessException e11) {
                throw new ValidatorException("Couldn't create instance of " + this.classname + ".  " + e11.getMessage());
            }
        }
        return this.instance;
    }

    private void handleIndexedField(Field field, int i10, Object[] objArr) throws ValidatorException {
        int indexOf = this.methodParameterList.indexOf(Validator.BEAN_PARAM);
        int indexOf2 = this.methodParameterList.indexOf(Validator.FIELD_PARAM);
        objArr[indexOf] = field.getIndexedProperty(objArr[indexOf])[i10];
        Field field2 = (Field) field.clone();
        String key = field2.getKey();
        field2.setKey(ValidatorUtils.replace(key, Field.TOKEN_INDEXED, "[" + i10 + "]"));
        objArr[indexOf2] = field2;
    }

    private boolean isValid(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private boolean javascriptAlreadyLoaded() {
        return this.javascript != null;
    }

    private void loadParameterClasses(ClassLoader classLoader) throws ValidatorException {
        if (this.parameterClasses == null) {
            Class<?>[] clsArr = new Class[this.methodParameterList.size()];
            int i10 = 0;
            while (i10 < this.methodParameterList.size()) {
                try {
                    clsArr[i10] = classLoader.loadClass(this.methodParameterList.get(i10));
                    i10++;
                } catch (ClassNotFoundException e10) {
                    throw new ValidatorException(e10.getMessage());
                }
            }
            this.parameterClasses = clsArr;
        }
    }

    private void loadValidationClass(ClassLoader classLoader) throws ValidatorException {
        if (this.validationClass == null) {
            try {
                this.validationClass = classLoader.loadClass(this.classname);
            } catch (ClassNotFoundException e10) {
                throw new ValidatorException(e10.toString());
            }
        }
    }

    private void loadValidationMethod() throws ValidatorException {
        if (this.validationMethod == null) {
            try {
                this.validationMethod = this.validationClass.getMethod(this.method, this.parameterClasses);
            } catch (NoSuchMethodException e10) {
                throw new ValidatorException("No such validation method: " + e10.getMessage());
            }
        }
    }

    private boolean onlyReturnErrors(Map<String, Object> map) {
        return ((Validator) map.get(Validator.VALIDATOR_PARAM)).getOnlyReturnErrors();
    }

    private String readJavascriptFile(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = getClass().getClassLoader();
        }
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream(str);
        if (resourceAsStream == null) {
            resourceAsStream = getClass().getResourceAsStream(str);
        }
        if (resourceAsStream == null) {
            Log log2 = getLog();
            log2.debug("  Unable to read javascript name " + str);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append("\n");
                } else {
                    try {
                        break;
                    } catch (IOException e10) {
                        getLog().error("Error closing stream to javascript file.", e10);
                    }
                }
            } catch (IOException e11) {
                getLog().error("Error reading javascript file.", e11);
                bufferedReader.close();
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (IOException e12) {
                    getLog().error("Error closing stream to javascript file.", e12);
                }
                throw th2;
            }
        }
        bufferedReader.close();
        String sb3 = sb2.toString();
        if (sb3.equals("")) {
            return null;
        }
        return sb3;
    }

    /* access modifiers changed from: package-private */
    public boolean executeValidationMethod(Field field, Map<String, Object> map, ValidatorResults validatorResults, int i10) throws ValidatorException {
        Object obj;
        map.put(Validator.VALIDATOR_ACTION_PARAM, this);
        try {
            if (this.validationMethod == null) {
                synchronized (this) {
                    ClassLoader classLoader = getClassLoader(map);
                    loadValidationClass(classLoader);
                    loadParameterClasses(classLoader);
                    loadValidationMethod();
                }
            }
            Object[] parameterValues = getParameterValues(map);
            if (field.isIndexed()) {
                handleIndexedField(field, i10, parameterValues);
            }
            obj = null;
            obj = this.validationMethod.invoke(getValidationClassInstance(), parameterValues);
        } catch (IllegalArgumentException e10) {
            throw new ValidatorException(e10.getMessage());
        } catch (IllegalAccessException e11) {
            throw new ValidatorException(e11.getMessage());
        } catch (InvocationTargetException e12) {
            if (e12.getTargetException() instanceof Exception) {
                throw ((Exception) e12.getTargetException());
            } else if (e12.getTargetException() instanceof Error) {
                throw ((Error) e12.getTargetException());
            }
        } catch (Exception e13) {
            if (!(e13 instanceof ValidatorException)) {
                Log log2 = getLog();
                log2.error("Unhandled exception thrown during validation: " + e13.getMessage(), e13);
                validatorResults.add(field, this.name, false);
                return false;
            }
            throw ((ValidatorException) e13);
        }
        boolean isValid = isValid(obj);
        if (!isValid || (isValid && !onlyReturnErrors(map))) {
            validatorResults.add(field, this.name, isValid, obj);
        }
        if (!isValid) {
            return false;
        }
        return true;
    }

    public String getClassname() {
        return this.classname;
    }

    public List<String> getDependencyList() {
        return Collections.unmodifiableList(this.dependencyList);
    }

    public String getDepends() {
        return this.depends;
    }

    public String getJavascript() {
        return this.javascript;
    }

    public String getJsFunctionName() {
        return this.jsFunctionName;
    }

    public String getMethod() {
        return this.method;
    }

    public String getMethodParams() {
        return this.methodParams;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public void init() {
        loadJavascriptFunction();
    }

    public boolean isDependency(String str) {
        return this.dependencyList.contains(str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadJavascriptFunction() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.javascriptAlreadyLoaded()     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            org.apache.commons.logging.Log r0 = r4.getLog()     // Catch:{ all -> 0x006c }
            boolean r0 = r0.isTraceEnabled()     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x001c
            org.apache.commons.logging.Log r0 = r4.getLog()     // Catch:{ all -> 0x006c }
            java.lang.String r1 = "  Loading function begun"
            r0.trace(r1)     // Catch:{ all -> 0x006c }
        L_0x001c:
            java.lang.String r0 = r4.jsFunction     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = r4.generateJsFunction()     // Catch:{ all -> 0x006c }
            r4.jsFunction = r0     // Catch:{ all -> 0x006c }
        L_0x0026:
            java.lang.String r0 = r4.formatJavascriptFileName()     // Catch:{ all -> 0x006c }
            org.apache.commons.logging.Log r1 = r4.getLog()     // Catch:{ all -> 0x006c }
            boolean r1 = r1.isTraceEnabled()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0051
            org.apache.commons.logging.Log r1 = r4.getLog()     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "  Loading js function '"
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r0)     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006c }
            r1.trace(r2)     // Catch:{ all -> 0x006c }
        L_0x0051:
            java.lang.String r0 = r4.readJavascriptFile(r0)     // Catch:{ all -> 0x006c }
            r4.javascript = r0     // Catch:{ all -> 0x006c }
            org.apache.commons.logging.Log r0 = r4.getLog()     // Catch:{ all -> 0x006c }
            boolean r0 = r0.isTraceEnabled()     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x006a
            org.apache.commons.logging.Log r0 = r4.getLog()     // Catch:{ all -> 0x006c }
            java.lang.String r1 = "  Loading javascript function completed"
            r0.trace(r1)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r4)
            return
        L_0x006c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.validator.ValidatorAction.loadJavascriptFunction():void");
    }

    public void setClassname(String str) {
        this.classname = str;
    }

    public void setDepends(String str) {
        this.depends = str;
        this.dependencyList.clear();
        StringTokenizer stringTokenizer = new StringTokenizer(str, AppsFlyerKit.COMMA);
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && trim.length() > 0) {
                this.dependencyList.add(trim);
            }
        }
    }

    public void setJavascript(String str) {
        if (this.jsFunction == null) {
            this.javascript = str;
            return;
        }
        throw new IllegalStateException("Cannot call setJavascript() after calling setJsFunction()");
    }

    public void setJsFunction(String str) {
        if (this.javascript == null) {
            this.jsFunction = str;
            return;
        }
        throw new IllegalStateException("Cannot call setJsFunction() after calling setJavascript()");
    }

    public void setJsFunctionName(String str) {
        this.jsFunctionName = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setMethodParams(String str) {
        this.methodParams = str;
        this.methodParameterList.clear();
        StringTokenizer stringTokenizer = new StringTokenizer(str, AppsFlyerKit.COMMA);
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && trim.length() > 0) {
                this.methodParameterList.add(trim);
            }
        }
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ValidatorAction: " + this.name + "\n";
    }
}
