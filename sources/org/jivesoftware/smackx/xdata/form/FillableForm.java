package org.jivesoftware.smackx.xdata.form;

import im.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.xdata.AbstractMultiFormField;
import org.jivesoftware.smackx.xdata.AbstractSingleStringValueFormField;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.ListMultiFormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.XmppDateTime;

public class FillableForm extends FilledForm {
    private final Map<String, FormField> filledFields = new HashMap();
    private final Set<String> filledRequiredFields = new HashSet();
    private final Set<String> missingRequiredFields = new HashSet();
    private final Set<String> requiredFields;

    /* renamed from: org.jivesoftware.smackx.xdata.form.FillableForm$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smackx.xdata.FormField$Type[] r0 = org.jivesoftware.smackx.xdata.FormField.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type = r0
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.list_multi     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.text_multi     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.jid_multi     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.fixed     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.list_single     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.text_private     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.text_single     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.hidden     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.bool     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.jivesoftware.smackx.xdata.FormField$Type r1 = org.jivesoftware.smackx.xdata.FormField.Type.jid_single     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.xdata.form.FillableForm.AnonymousClass1.<clinit>():void");
        }
    }

    public FillableForm(DataForm dataForm) {
        super(dataForm);
        if (dataForm.getType() == DataForm.Type.form) {
            HashSet hashSet = new HashSet();
            for (FormField next : dataForm.getFields()) {
                if (next.isRequired()) {
                    String fieldName = next.getFieldName();
                    hashSet.add(fieldName);
                    if (next.hasValueSet()) {
                        write(next);
                    } else {
                        this.missingRequiredFields.add(fieldName);
                    }
                }
            }
            this.requiredFields = Collections.unmodifiableSet(hashSet);
            return;
        }
        throw new IllegalArgumentException();
    }

    private static AbstractMultiFormField.Builder<?, ?> createMultiKindFieldbuilder(String str, FormField.Type type) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i10 == 1) {
            return FormField.listMultiBuilder(str);
        }
        if (i10 == 2) {
            return FormField.textMultiBuilder(str);
        }
        throw new IllegalArgumentException();
    }

    private static AbstractSingleStringValueFormField.Builder<?, ?> createSingleKindFieldBuilder(String str, FormField.Type type) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i10 == 5) {
            return FormField.listSingleBuilder(str);
        }
        if (i10 == 6) {
            return FormField.textPrivateBuilder(str);
        }
        if (i10 == 7) {
            return FormField.textSingleBuilder(str);
        }
        if (i10 == 8) {
            return FormField.hiddenBuilder(str);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    public DataForm getDataFormToSubmit() {
        if (this.missingRequiredFields.isEmpty()) {
            DataForm.Builder builder = DataForm.builder();
            TextSingleFormField textSingleFormField = this.formTypeFormField;
            if (textSingleFormField != null) {
                builder.addField(textSingleFormField);
            }
            builder.addFields(this.filledFields.values());
            return builder.build();
        }
        throw new IllegalStateException("Not all required fields filled. Missing: " + this.missingRequiredFields);
    }

    public FormField getField(String str) {
        FormField formField = this.filledFields.get(str);
        if (formField != null) {
            return formField;
        }
        return super.getField(str);
    }

    public void setAnswer(String str, Collection<? extends CharSequence> collection) {
        FormField formField;
        FormField.Type type = getFieldOrThrow(str).getType();
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            formField = createMultiKindFieldbuilder(str, type).addValues(collection).build();
        } else if (i10 == 3) {
            ArrayList arrayList = new ArrayList(collection.size());
            ArrayList arrayList2 = new ArrayList();
            a.e(collection, arrayList, arrayList2);
            if (arrayList2.isEmpty()) {
                formField = FormField.jidMultiBuilder(str).addValues(arrayList).build();
            } else {
                throw new IllegalArgumentException((Throwable) arrayList2.get(0));
            }
        } else {
            throw new IllegalArgumentException("");
        }
        write(formField);
    }

    /* access modifiers changed from: protected */
    public void write(String str, int i10) {
        writeTextSingle(str, Integer.toString(i10));
    }

    /* access modifiers changed from: protected */
    public void writeBoolean(String str, boolean z10) {
        write(FormField.booleanBuilder(str).setValue(z10).build());
    }

    /* access modifiers changed from: protected */
    public void writeListMulti(String str, List<? extends CharSequence> list) {
        write(((ListMultiFormField.Builder) FormField.listMultiBuilder(str).addValues(list)).build());
    }

    /* access modifiers changed from: protected */
    public void writeTextSingle(String str, CharSequence charSequence) {
        write(((TextSingleFormField.Builder) FormField.textSingleBuilder(str).setValue(charSequence)).build());
    }

    /* access modifiers changed from: protected */
    public void write(String str, Date date) {
        writeTextSingle(str, XmppDateTime.i(date));
    }

    public final void write(FormField formField) {
        if (formField.getType() == FormField.Type.fixed) {
            throw new IllegalArgumentException();
        } else if (formField.hasValueSet()) {
            String fieldName = formField.getFieldName();
            if (getDataForm().hasField(fieldName)) {
                for (FormFieldChildElement validate : getDataForm().getField(fieldName).getFormFieldChildElements()) {
                    validate.validate(formField);
                }
                this.filledFields.put(fieldName, formField);
                if (this.requiredFields.contains(fieldName)) {
                    this.filledRequiredFields.add(fieldName);
                    this.missingRequiredFields.remove(fieldName);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setAnswer(String str, int i10) {
        setAnswer(str, (CharSequence) Integer.toString(i10));
    }

    public void setAnswer(String str, CharSequence charSequence) {
        FormField formField;
        FormField.Type type = getFieldOrThrow(str).getType();
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$xdata$FormField$Type[type.ordinal()]) {
            case 1:
            case 3:
                throw new IllegalArgumentException("Can not answer fields of type '" + type + "' with a CharSequence");
            case 2:
                formField = createMultiKindFieldbuilder(str, type).addValue(charSequence).build();
                break;
            case 4:
                throw new IllegalArgumentException("Fields of type 'fixed' are not answerable");
            case 5:
            case 6:
            case 7:
            case 8:
                formField = createSingleKindFieldBuilder(str, type).setValue(charSequence).build();
                break;
            case 9:
                formField = FormField.booleanBuilder(str).setValue(charSequence).build();
                break;
            case 10:
                try {
                    formField = FormField.jidSingleBuilder(str).setValue(org.jxmpp.jid.impl.a.n(charSequence)).build();
                    break;
                } catch (XmppStringprepException e10) {
                    throw new IllegalArgumentException(e10);
                }
            default:
                throw new AssertionError();
        }
        write(formField);
    }

    public void setAnswer(String str, boolean z10) {
        if (getFieldOrThrow(str).getType() == FormField.Type.bool) {
            write(FormField.booleanBuilder(str).setValue(z10).build());
            return;
        }
        throw new IllegalArgumentException();
    }
}
