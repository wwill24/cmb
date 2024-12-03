package org.jivesoftware.smackx.softwareinfo.form;

import java.util.List;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.mediaelement.element.MediaElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.form.FilledForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public final class SoftwareInfoForm extends FilledForm {
    public static final String FORM_TYPE = "urn:xmpp:dataforms:softwareinfo";
    public static final String ICON = "icon";
    public static final String OS = "os";
    public static final String OS_VERSION = "os_version";
    public static final String SOFTWARE = "software";
    public static final String SOFTWARE_VERSION = "software_version";

    public static final class Builder {
        DataForm.Builder dataFormBuilder;

        public SoftwareInfoForm build() {
            return new SoftwareInfoForm(this.dataFormBuilder.build());
        }

        public Builder setDataForm(DataForm dataForm) {
            if (dataForm.getTitle() != null || !dataForm.getItems().isEmpty() || dataForm.getReportedData() != null || !dataForm.getInstructions().isEmpty()) {
                throw new IllegalArgumentException("Illegal Arguements for SoftwareInformation");
            }
            String formType = dataForm.getFormType();
            if (formType == null) {
                throw new IllegalArgumentException("FORM_TYPE Formfield missing");
            } else if (formType.equals(SoftwareInfoForm.FORM_TYPE)) {
                this.dataFormBuilder = dataForm.asBuilder();
                return this;
            } else {
                throw new IllegalArgumentException("Malformed FORM_TYPE Formfield encountered");
            }
        }

        public Builder setIcon(int i10, int i11, List<MediaElement.Uri> list) {
            MediaElement.Builder builder = MediaElement.builder();
            for (MediaElement.Uri addUri : list) {
                builder.addUri(addUri);
            }
            return setIcon(builder.setHeightAndWidth(i10, i11).build());
        }

        public Builder setOS(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.OS);
            builder.setValue((CharSequence) str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setOSVersion(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.OS_VERSION);
            builder.setValue((CharSequence) str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setSoftware(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.SOFTWARE);
            builder.setValue((CharSequence) str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        public Builder setSoftwareVersion(String str) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.SOFTWARE_VERSION);
            builder.setValue((CharSequence) str);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }

        private Builder() {
            this.dataFormBuilder = DataForm.builder(DataForm.Type.result);
            this.dataFormBuilder.addField(FormField.buildHiddenFormType(SoftwareInfoForm.FORM_TYPE));
        }

        public Builder setIcon(MediaElement mediaElement) {
            TextSingleFormField.Builder builder = FormField.builder(SoftwareInfoForm.ICON);
            builder.addFormFieldChildElement(mediaElement);
            this.dataFormBuilder.addField(builder.build());
            return this;
        }
    }

    static {
        FormFieldRegistry.register(FORM_TYPE, FormField.Type.text_single, OS, OS_VERSION, SOFTWARE, SOFTWARE_VERSION);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, SoftwareInfoForm softwareInfoForm) {
        builder.append(getDataForm().getType(), softwareInfoForm.getDataForm().getType()).append(getDataForm().getTitle(), softwareInfoForm.getDataForm().getTitle()).append(getDataForm().getReportedData(), softwareInfoForm.getDataForm().getReportedData()).append(getDataForm().getItems(), softwareInfoForm.getDataForm().getItems()).append(getDataForm().getFields(), softwareInfoForm.getDataForm().getFields()).append(getDataForm().getExtensionElements(), softwareInfoForm.getDataForm().getExtensionElements());
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public MediaElement getIcon() {
        FormFieldChildElement formFieldChildElement;
        FormField field = getField(ICON);
        if (field == null || (formFieldChildElement = field.getFormFieldChildElement(MediaElement.QNAME)) == null) {
            return null;
        }
        return (MediaElement) formFieldChildElement;
    }

    public String getOS() {
        return readFirstValue(OS);
    }

    public String getOSVersion() {
        return readFirstValue(OS_VERSION);
    }

    public String getSoftwareName() {
        return readFirstValue(SOFTWARE);
    }

    public String getSoftwareVersion() {
        return readFirstValue(SOFTWARE_VERSION);
    }

    public int hashCode() {
        HashCode.Builder builder = HashCode.builder();
        builder.append((Object) getDataForm().getFields());
        builder.append((Object) getDataForm().getItems());
        builder.append((Object) getDataForm().getExtensionElements());
        return builder.build();
    }

    private SoftwareInfoForm(DataForm dataForm) {
        super(dataForm);
    }
}
