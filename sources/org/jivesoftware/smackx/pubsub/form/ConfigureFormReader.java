package org.jivesoftware.smackx.pubsub.form;

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
import org.jivesoftware.smackx.xdata.JidMultiFormField;
import org.jivesoftware.smackx.xdata.form.FormReader;
import org.jxmpp.jid.Jid;

public interface ConfigureFormReader extends FormReader {
    public static final String FORM_TYPE = "http://jabber.org/protocol/pubsub#node_config";

    AccessModel getAccessModel() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.access_model.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return AccessModel.valueOf(readFirstValue);
    }

    String getBodyXSLT() {
        return readFirstValue(ConfigureNodeFields.body_xslt.getFieldName());
    }

    List<String> getChildren() {
        return readStringValues(ConfigureNodeFields.children.getFieldName());
    }

    ChildrenAssociationPolicy getChildrenAssociationPolicy() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.children_association_policy.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return ChildrenAssociationPolicy.valueOf(readFirstValue);
    }

    List<Jid> getChildrenAssociationWhitelist() {
        FormField field = getField(ConfigureNodeFields.children_association_whitelist.getFieldName());
        if (field == null) {
            Collections.emptyList();
        }
        return ((JidMultiFormField) field.ifPossibleAs(JidMultiFormField.class)).getValues();
    }

    Integer getChildrenMax() {
        return readInteger(ConfigureNodeFields.children_max.getFieldName());
    }

    List<? extends CharSequence> getCollection() {
        return readValues(ConfigureNodeFields.collection.getFieldName());
    }

    String getDataType() {
        return readFirstValue(ConfigureNodeFields.type.getFieldName());
    }

    String getDataformXSLT() {
        return readFirstValue(ConfigureNodeFields.dataform_xslt.getFieldName());
    }

    ItemReply getItemReply() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.itemreply.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return ItemReply.valueOf(readFirstValue);
    }

    Integer getMaxItems() {
        return readInteger(ConfigureNodeFields.max_items.getFieldName());
    }

    Integer getMaxPayloadSize() {
        return readInteger(ConfigureNodeFields.max_payload_size.getFieldName());
    }

    NodeType getNodeType() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.node_type.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return NodeType.valueOf(readFirstValue);
    }

    NotificationType getNotificationType() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.notification_type.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return NotificationType.valueOf(readFirstValue);
    }

    PublishModel getPublishModel() {
        String readFirstValue = readFirstValue(ConfigureNodeFields.publish_model.getFieldName());
        if (readFirstValue == null) {
            return null;
        }
        return PublishModel.valueOf(readFirstValue);
    }

    List<String> getRosterGroupsAllowed() {
        return readStringValues(ConfigureNodeFields.roster_groups_allowed.getFieldName());
    }

    String getTitle() {
        return readFirstValue(ConfigureNodeFields.title.getFieldName());
    }

    Boolean isDeliverPayloads() {
        return readBoolean(ConfigureNodeFields.deliver_payloads.getFieldName());
    }

    Boolean isNotifyConfig() {
        return readBoolean(ConfigureNodeFields.notify_config.getFieldName());
    }

    Boolean isNotifyDelete() {
        return readBoolean(ConfigureNodeFields.notify_delete.getFieldName());
    }

    Boolean isNotifyRetract() {
        return readBoolean(ConfigureNodeFields.notify_retract.getFieldName());
    }

    boolean isPersistItems() {
        return readBoolean(ConfigureNodeFields.persist_items.getFieldName()).booleanValue();
    }

    boolean isPresenceBasedDelivery() {
        return readBoolean(ConfigureNodeFields.presence_based_delivery.getFieldName()).booleanValue();
    }

    boolean isSubscribe() {
        return readBoolean(ConfigureNodeFields.subscribe.getFieldName()).booleanValue();
    }
}
