package org.apache.commons.validator;

import com.mparticle.kits.AppsFlyerKit;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.validator.util.ValidatorUtils;

public class Field implements Cloneable, Serializable {
    private static final String DEFAULT_ARG = "org.apache.commons.validator.Field.DEFAULT";
    protected static final String TOKEN_END = "}";
    public static final String TOKEN_INDEXED = "[]";
    protected static final String TOKEN_START = "${";
    protected static final String TOKEN_VAR = "var:";
    private static final long serialVersionUID = -8502647722530192185L;
    protected Map<String, Arg>[] args = new Map[0];
    protected boolean clientValidation = true;
    private final List<String> dependencyList = Collections.synchronizedList(new ArrayList());
    protected String depends = null;
    protected int fieldOrder = 0;
    protected FastHashMap hMsgs = new FastHashMap();
    protected FastHashMap hVars = new FastHashMap();
    protected String indexedListProperty = null;
    protected String indexedProperty = null;
    protected String key = null;
    protected int page = 0;
    protected String property = null;

    private void determineArgPosition(Arg arg) {
        if (arg.getPosition() < 0) {
            Map<String, Arg>[] mapArr = this.args;
            int i10 = 0;
            if (mapArr == null || mapArr.length == 0) {
                arg.setPosition(0);
                return;
            }
            String name = arg.getName() == null ? DEFAULT_ARG : arg.getName();
            int i11 = -1;
            int i12 = -1;
            while (true) {
                Map<String, Arg>[] mapArr2 = this.args;
                if (i10 >= mapArr2.length) {
                    break;
                }
                Map<String, Arg> map = mapArr2[i10];
                if (map != null && map.containsKey(name)) {
                    i11 = i10;
                }
                Map<String, Arg> map2 = this.args[i10];
                if (map2 != null && map2.containsKey(DEFAULT_ARG)) {
                    i12 = i10;
                }
                i10++;
            }
            if (i11 < 0) {
                i11 = i12;
            }
            arg.setPosition(i11 + 1);
        }
    }

    private void ensureArgsCapacity(Arg arg) {
        if (arg.getPosition() >= this.args.length) {
            Map<String, Arg>[] mapArr = new Map[(arg.getPosition() + 1)];
            Map<String, Arg>[] mapArr2 = this.args;
            System.arraycopy(mapArr2, 0, mapArr, 0, mapArr2.length);
            this.args = mapArr;
        }
    }

    private int getIndexedPropertySize(Object obj) throws ValidatorException {
        try {
            Object property2 = PropertyUtils.getProperty(obj, getIndexedListProperty());
            if (property2 == null) {
                return 0;
            }
            if (property2 instanceof Collection) {
                return ((Collection) property2).size();
            }
            if (property2.getClass().isArray()) {
                return ((Object[]) property2).length;
            }
            throw new ValidatorException(getKey() + " is not indexed");
        } catch (IllegalAccessException e10) {
            throw new ValidatorException(e10.getMessage());
        } catch (InvocationTargetException e11) {
            throw new ValidatorException(e11.getMessage());
        } catch (NoSuchMethodException e12) {
            throw new ValidatorException(e12.getMessage());
        }
    }

    private void handleMissingAction(String str) throws ValidatorException {
        throw new ValidatorException("No ValidatorAction named " + str + " found for field " + getProperty());
    }

    private void processArg(String str, String str2) {
        int i10 = 0;
        while (true) {
            Map<String, Arg>[] mapArr = this.args;
            if (i10 < mapArr.length) {
                Map<String, Arg> map = mapArr[i10];
                if (map != null) {
                    for (Arg next : map.values()) {
                        if (next != null) {
                            next.setKey(ValidatorUtils.replace(next.getKey(), str, str2));
                        }
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    private void processMessageComponents(String str, String str2) {
        if (str != null && !str.startsWith("${var:")) {
            for (Msg next : getMsgMap().values()) {
                next.setKey(ValidatorUtils.replace(next.getKey(), str, str2));
            }
        }
        processArg(str, str2);
    }

    private void processVars(String str, String str2) {
        for (String var : getVarMap().keySet()) {
            Var var2 = getVar(var);
            var2.setValue(ValidatorUtils.replace(var2.getValue(), str, str2));
        }
    }

    private boolean runDependentValidators(ValidatorAction validatorAction, ValidatorResults validatorResults, Map<String, ValidatorAction> map, Map<String, Object> map2, int i10) throws ValidatorException {
        List<String> dependencyList2 = validatorAction.getDependencyList();
        if (dependencyList2.isEmpty()) {
            return true;
        }
        for (String next : dependencyList2) {
            ValidatorAction validatorAction2 = map.get(next);
            if (validatorAction2 == null) {
                handleMissingAction(next);
            }
            if (!validateForRule(validatorAction2, validatorResults, map, map2, i10)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateForRule(ValidatorAction validatorAction, ValidatorResults validatorResults, Map<String, ValidatorAction> map, Map<String, Object> map2, int i10) throws ValidatorException {
        ValidatorResult validatorResult = validatorResults.getValidatorResult(getKey());
        if (validatorResult != null && validatorResult.containsAction(validatorAction.getName())) {
            return validatorResult.isValid(validatorAction.getName());
        }
        if (!runDependentValidators(validatorAction, validatorResults, map, map2, i10)) {
            return false;
        }
        return validatorAction.executeValidationMethod(this, map2, validatorResults, i10);
    }

    public void addArg(Arg arg) {
        if (arg != null && arg.getKey() != null && arg.getKey().length() != 0) {
            determineArgPosition(arg);
            ensureArgsCapacity(arg);
            Map<String, Arg> map = this.args[arg.getPosition()];
            if (map == null) {
                map = new HashMap<>();
                this.args[arg.getPosition()] = map;
            }
            if (arg.getName() == null) {
                map.put(DEFAULT_ARG, arg);
            } else {
                map.put(arg.getName(), arg);
            }
        }
    }

    public void addMsg(Msg msg) {
        getMsgMap().put(msg.getName(), msg);
    }

    public void addVar(Var var) {
        getVarMap().put(var.getName(), var);
    }

    public Object clone() {
        try {
            Field field = (Field) super.clone();
            field.args = new Map[this.args.length];
            int i10 = 0;
            while (true) {
                Map<String, Arg>[] mapArr = this.args;
                if (i10 < mapArr.length) {
                    if (mapArr[i10] != null) {
                        HashMap hashMap = new HashMap(this.args[i10]);
                        for (Map.Entry entry : hashMap.entrySet()) {
                            hashMap.put((String) entry.getKey(), (Arg) ((Arg) entry.getValue()).clone());
                        }
                        field.args[i10] = hashMap;
                    }
                    i10++;
                } else {
                    field.hVars = ValidatorUtils.copyFastHashMap(this.hVars);
                    field.hMsgs = ValidatorUtils.copyFastHashMap(this.hMsgs);
                    return field;
                }
            }
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10.toString());
        }
    }

    public void generateKey() {
        if (isIndexed()) {
            this.key = this.indexedListProperty + TOKEN_INDEXED + "." + this.property;
            return;
        }
        this.key = this.property;
    }

    public Arg getArg(int i10) {
        return getArg(DEFAULT_ARG, i10);
    }

    public Arg[] getArgs(String str) {
        Arg[] argArr = new Arg[this.args.length];
        for (int i10 = 0; i10 < this.args.length; i10++) {
            argArr[i10] = getArg(str, i10);
        }
        return argArr;
    }

    public List<String> getDependencyList() {
        return Collections.unmodifiableList(this.dependencyList);
    }

    public String getDepends() {
        return this.depends;
    }

    public int getFieldOrder() {
        return this.fieldOrder;
    }

    public String getIndexedListProperty() {
        return this.indexedListProperty;
    }

    public String getIndexedProperty() {
        return this.indexedProperty;
    }

    public String getKey() {
        if (this.key == null) {
            generateKey();
        }
        return this.key;
    }

    public Msg getMessage(String str) {
        return getMsgMap().get(str);
    }

    public Map<String, Msg> getMessages() {
        return Collections.unmodifiableMap(getMsgMap());
    }

    public String getMsg(String str) {
        Msg message = getMessage(str);
        if (message == null) {
            return null;
        }
        return message.getKey();
    }

    /* access modifiers changed from: protected */
    public Map<String, Msg> getMsgMap() {
        return this.hMsgs;
    }

    public int getPage() {
        return this.page;
    }

    public String getProperty() {
        return this.property;
    }

    public Var getVar(String str) {
        return getVarMap().get(str);
    }

    /* access modifiers changed from: protected */
    public Map<String, Var> getVarMap() {
        return this.hVars;
    }

    public String getVarValue(String str) {
        Var var = getVarMap().get(str);
        if (var == null || !(var instanceof Var)) {
            return null;
        }
        return var.getValue();
    }

    public Map<String, Var> getVars() {
        return Collections.unmodifiableMap(getVarMap());
    }

    public boolean isClientValidation() {
        return this.clientValidation;
    }

    public boolean isDependency(String str) {
        return this.dependencyList.contains(str);
    }

    public boolean isIndexed() {
        String str = this.indexedListProperty;
        return str != null && str.length() > 0;
    }

    /* access modifiers changed from: package-private */
    public void process(Map<String, String> map, Map<String, String> map2) {
        this.hMsgs.setFast(false);
        this.hVars.setFast(true);
        generateKey();
        for (Map.Entry next : map2.entrySet()) {
            String str = TOKEN_START + ((String) next.getKey()) + TOKEN_END;
            String str2 = (String) next.getValue();
            this.property = ValidatorUtils.replace(this.property, str, str2);
            processVars(str, str2);
            processMessageComponents(str, str2);
        }
        for (Map.Entry next2 : map.entrySet()) {
            String str3 = TOKEN_START + ((String) next2.getKey()) + TOKEN_END;
            String str4 = (String) next2.getValue();
            this.property = ValidatorUtils.replace(this.property, str3, str4);
            processVars(str3, str4);
            processMessageComponents(str3, str4);
        }
        for (String next3 : getVarMap().keySet()) {
            processMessageComponents("${var:" + next3 + TOKEN_END, getVar(next3).getValue());
        }
        this.hMsgs.setFast(true);
    }

    public void setClientValidation(boolean z10) {
        this.clientValidation = z10;
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

    public void setFieldOrder(int i10) {
        this.fieldOrder = i10;
    }

    public void setIndexedListProperty(String str) {
        this.indexedListProperty = str;
    }

    public void setIndexedProperty(String str) {
        this.indexedProperty = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPage(int i10) {
        this.page = i10;
    }

    public void setProperty(String str) {
        this.property = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t\tkey = " + this.key + "\n");
        sb2.append("\t\tproperty = " + this.property + "\n");
        sb2.append("\t\tindexedProperty = " + this.indexedProperty + "\n");
        sb2.append("\t\tindexedListProperty = " + this.indexedListProperty + "\n");
        sb2.append("\t\tdepends = " + this.depends + "\n");
        sb2.append("\t\tpage = " + this.page + "\n");
        sb2.append("\t\tfieldOrder = " + this.fieldOrder + "\n");
        if (this.hVars != null) {
            sb2.append("\t\tVars:\n");
            for (String next : getVarMap().keySet()) {
                sb2.append("\t\t\t");
                sb2.append(next);
                sb2.append("=");
                sb2.append(getVarMap().get(next));
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public ValidatorResults validate(Map<String, Object> map, Map<String, ValidatorAction> map2) throws ValidatorException {
        int i10;
        if (getDepends() == null) {
            return new ValidatorResults();
        }
        ValidatorResults validatorResults = new ValidatorResults();
        Object obj = map.get(Validator.BEAN_PARAM);
        if (isIndexed()) {
            i10 = getIndexedPropertySize(obj);
        } else {
            i10 = 1;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            ValidatorResults validatorResults2 = new ValidatorResults();
            for (String next : this.dependencyList) {
                ValidatorAction validatorAction = map2.get(next);
                if (validatorAction == null) {
                    handleMissingAction(next);
                }
                if (!validateForRule(validatorAction, validatorResults2, map2, map, i11)) {
                    validatorResults.merge(validatorResults2);
                    return validatorResults;
                }
            }
            validatorResults.merge(validatorResults2);
        }
        return validatorResults;
    }

    public void addVar(String str, String str2, String str3) {
        addVar(new Var(str, str2, str3));
    }

    public Arg getArg(String str, int i10) {
        Map<String, Arg> map;
        Map<String, Arg>[] mapArr = this.args;
        if (i10 >= mapArr.length || (map = mapArr[i10]) == null) {
            return null;
        }
        Arg arg = map.get(str);
        if (arg != null || !str.equals(DEFAULT_ARG)) {
            return arg == null ? getArg(i10) : arg;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Object[] getIndexedProperty(Object obj) throws ValidatorException {
        try {
            Object property2 = PropertyUtils.getProperty(obj, getIndexedListProperty());
            if (property2 instanceof Collection) {
                return ((Collection) property2).toArray();
            }
            if (property2.getClass().isArray()) {
                return (Object[]) property2;
            }
            throw new ValidatorException(getKey() + " is not indexed");
        } catch (IllegalAccessException e10) {
            throw new ValidatorException(e10.getMessage());
        } catch (InvocationTargetException e11) {
            throw new ValidatorException(e11.getMessage());
        } catch (NoSuchMethodException e12) {
            throw new ValidatorException(e12.getMessage());
        }
    }
}
