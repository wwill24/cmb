package org.jivesoftware.smackx.xdata.form;

import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public abstract class FilledForm implements FormReader {
    private final DataForm dataForm;
    protected final TextSingleFormField formTypeFormField;

    public FilledForm(DataForm dataForm2) {
        this.dataForm = (DataForm) Objects.requireNonNull(dataForm2);
        if (dataForm2.getType() != DataForm.Type.cancel) {
            this.formTypeFormField = dataForm2.getHiddenFormTypeField();
            return;
        }
        throw new IllegalArgumentException("Forms of type 'cancel' are not filled nor fillable");
    }

    protected static void ensureFormType(DataForm dataForm2, String str) {
        String formType = dataForm2.getFormType();
        if (!str.equals(formType)) {
            throw new IllegalArgumentException("The provided data form must be of type '" + str + "', this one was of type '" + formType + '\'');
        }
    }

    public DataForm getDataForm() {
        return this.dataForm;
    }

    public FormField getField(String str) {
        return this.dataForm.getField(str);
    }

    /* access modifiers changed from: protected */
    public FormField getFieldOrThrow(String str) {
        FormField field = getField(str);
        if (field != null) {
            return field;
        }
        throw new IllegalArgumentException("No field named " + str);
    }

    public String getFormType() {
        TextSingleFormField textSingleFormField = this.formTypeFormField;
        if (textSingleFormField == null) {
            return null;
        }
        return textSingleFormField.getValue();
    }

    public StringBuilder getInstructions() {
        StringBuilder sb2 = new StringBuilder();
        for (String append : this.dataForm.getInstructions()) {
            sb2.append(append);
            sb2.append(10);
        }
        return sb2;
    }

    public String getTitle() {
        return this.dataForm.getTitle();
    }

    public boolean hasField(String str) {
        return this.dataForm.hasField(str);
    }
}
