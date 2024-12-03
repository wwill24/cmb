package org.jivesoftware.smackx.pubsub.form;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ChildrenAssociationPolicy;
import org.jivesoftware.smackx.pubsub.ConfigureNodeFields;
import org.jivesoftware.smackx.pubsub.ItemReply;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.NotificationType;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.TextMultiFormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public class FillableConfigureForm extends FillableForm implements ConfigureFormReader {
    FillableConfigureForm(DataForm dataForm) {
        super(dataForm);
    }

    public void setAccessModel(AccessModel accessModel) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.access_model.getFieldName()).setValue((Enum<?>) accessModel)).build());
    }

    public void setBodyXSLT(String str) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.body_xslt.getFieldName()).setValue((CharSequence) str)).build());
    }

    public void setChildren(List<String> list) {
        write(((TextMultiFormField.Builder) FormField.textMultiBuilder(ConfigureNodeFields.children.getFieldName()).addValues(list)).build());
    }

    public void setChildrenAssociationPolicy(ChildrenAssociationPolicy childrenAssociationPolicy) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.children_association_policy.getFieldName()).setValue((Enum<?>) childrenAssociationPolicy)).build());
    }

    public void setChildrenAssociationWhitelist(List<? extends Jid> list) {
        write(FormField.jidMultiBuilder(ConfigureNodeFields.children_association_whitelist.getFieldName()).addValues(list).build());
    }

    public void setChildrenMax(int i10) {
        write(((TextSingleFormField.Builder) FormField.textSingleBuilder(ConfigureNodeFields.children_max.getFieldName()).setValue(i10)).build());
    }

    public void setCollection(String str) {
        setCollections(Collections.singletonList(str));
    }

    public void setCollections(Collection<String> collection) {
        write(((TextMultiFormField.Builder) FormField.textMultiBuilder(ConfigureNodeFields.collection.getFieldName()).addValues(collection)).build());
    }

    public void setDataType(CharSequence charSequence) {
        writeTextSingle(ConfigureNodeFields.type.getFieldName(), charSequence);
    }

    public void setDataformXSLT(URL url) {
        write(((TextSingleFormField.Builder) FormField.textSingleBuilder(ConfigureNodeFields.dataform_xslt.getFieldName()).setValue(url)).build());
    }

    public void setDeliverPayloads(boolean z10) {
        writeBoolean(ConfigureNodeFields.deliver_payloads.getFieldName(), z10);
    }

    public void setItemReply(ItemReply itemReply) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.itemreply.getFieldName()).setValue((Enum<?>) itemReply)).build());
    }

    public void setMaxItems(int i10) {
        write(((TextSingleFormField.Builder) FormField.textSingleBuilder(ConfigureNodeFields.max_items.getFieldName()).setValue(i10)).build());
    }

    public void setMaxPayloadSize(int i10) {
        write(((TextSingleFormField.Builder) FormField.textSingleBuilder(ConfigureNodeFields.max_payload_size.getFieldName()).setValue(i10)).build());
    }

    public void setNodeType(NodeType nodeType) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.node_type.getFieldName()).setValue((Enum<?>) nodeType)).build());
    }

    public void setNotificationType(NotificationType notificationType) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.notification_type.getFieldName()).setValue((Enum<?>) notificationType)).build());
    }

    public void setNotifyConfig(boolean z10) {
        writeBoolean(ConfigureNodeFields.notify_config.getFieldName(), z10);
    }

    public void setNotifyDelete(boolean z10) {
        writeBoolean(ConfigureNodeFields.notify_delete.getFieldName(), z10);
    }

    public void setNotifyRetract(boolean z10) {
        writeBoolean(ConfigureNodeFields.notify_retract.getFieldName(), z10);
    }

    public void setPersistentItems(boolean z10) {
        writeBoolean(ConfigureNodeFields.persist_items.getFieldName(), z10);
    }

    public void setPresenceBasedDelivery(boolean z10) {
        writeBoolean(ConfigureNodeFields.presence_based_delivery.getFieldName(), z10);
    }

    public void setPublishModel(PublishModel publishModel) {
        write(((ListSingleFormField.Builder) FormField.listSingleBuilder(ConfigureNodeFields.publish_model.getFieldName()).setValue((Enum<?>) publishModel)).build());
    }

    public void setRosterGroupsAllowed(List<? extends CharSequence> list) {
        writeListMulti(ConfigureNodeFields.roster_groups_allowed.getFieldName(), list);
    }

    public void setSubscribe(boolean z10) {
        writeBoolean(ConfigureNodeFields.subscribe.getFieldName(), z10);
    }

    public void setTitle(CharSequence charSequence) {
        writeTextSingle(ConfigureNodeFields.title.getFieldName(), charSequence);
    }
}
