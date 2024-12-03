package org.apache.commons.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections.FastHashMap;

public class Form implements Serializable {
    private static final long serialVersionUID = 6445211789563796371L;
    protected FastHashMap hFields = new FastHashMap();
    protected String inherit = null;
    protected List<Field> lFields = new ArrayList();
    protected String name = null;
    private boolean processed = false;

    public void addField(Field field) {
        this.lFields.add(field);
        getFieldMap().put(field.getKey(), field);
    }

    public boolean containsField(String str) {
        return getFieldMap().containsKey(str);
    }

    public String getExtends() {
        return this.inherit;
    }

    public Field getField(String str) {
        return getFieldMap().get(str);
    }

    /* access modifiers changed from: protected */
    public Map<String, Field> getFieldMap() {
        return this.hFields;
    }

    public List<Field> getFields() {
        return Collections.unmodifiableList(this.lFields);
    }

    public String getName() {
        return this.name;
    }

    public boolean isExtending() {
        return this.inherit != null;
    }

    public boolean isProcessed() {
        return this.processed;
    }

    /* access modifiers changed from: protected */
    public void merge(Form form) {
        ArrayList arrayList = new ArrayList();
        FastHashMap fastHashMap = new FastHashMap();
        for (Field next : form.getFields()) {
            if (next != null) {
                String key = next.getKey();
                if (!containsField(key)) {
                    arrayList.add(next);
                    fastHashMap.put(key, next);
                } else {
                    Field field = getField(key);
                    getFieldMap().remove(key);
                    this.lFields.remove(field);
                    arrayList.add(field);
                    fastHashMap.put(key, field);
                }
            }
        }
        this.lFields.addAll(0, arrayList);
        getFieldMap().putAll(fastHashMap);
    }

    /* access modifiers changed from: protected */
    public void process(Map<String, String> map, Map<String, String> map2, Map<String, Form> map3) {
        Form form;
        if (!isProcessed()) {
            int i10 = 0;
            if (isExtending() && (form = map3.get(this.inherit)) != null) {
                if (!form.isProcessed()) {
                    form.process(map2, map, map3);
                }
                for (Field next : form.getFields()) {
                    if (getFieldMap().get(next.getKey()) == null) {
                        this.lFields.add(i10, next);
                        getFieldMap().put(next.getKey(), next);
                        i10++;
                    }
                }
            }
            this.hFields.setFast(true);
            ListIterator<Field> listIterator = this.lFields.listIterator(i10);
            while (listIterator.hasNext()) {
                listIterator.next().process(map, map2);
            }
            this.processed = true;
        }
    }

    public void setExtends(String str) {
        this.inherit = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Form: ");
        sb2.append(this.name);
        sb2.append("\n");
        for (Field append : this.lFields) {
            sb2.append("\tField: \n");
            sb2.append(append);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public ValidatorResults validate(Map<String, Object> map, Map<String, ValidatorAction> map2, int i10) throws ValidatorException {
        return validate(map, map2, i10, (String) null);
    }

    /* access modifiers changed from: package-private */
    public ValidatorResults validate(Map<String, Object> map, Map<String, ValidatorAction> map2, int i10, String str) throws ValidatorException {
        ValidatorResults validatorResults = new ValidatorResults();
        map.put(Validator.VALIDATOR_RESULTS_PARAM, validatorResults);
        if (str != null) {
            Field field = getFieldMap().get(str);
            if (field != null) {
                map.put(Validator.FIELD_PARAM, field);
                if (field.getPage() <= i10) {
                    validatorResults.merge(field.validate(map, map2));
                }
            } else {
                throw new ValidatorException("Unknown field " + str + " in form " + getName());
            }
        } else {
            for (Field next : this.lFields) {
                map.put(Validator.FIELD_PARAM, next);
                if (next.getPage() <= i10) {
                    validatorResults.merge(next.validate(map, map2));
                }
            }
        }
        return validatorResults;
    }
}
