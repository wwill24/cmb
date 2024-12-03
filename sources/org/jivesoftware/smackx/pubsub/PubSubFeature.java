package org.jivesoftware.smackx.pubsub;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smackx.disco.Feature;

public enum PubSubFeature implements CharSequence {
    access_authorize(r1),
    access_open(r1),
    access_presence(r1),
    access_roster(r1),
    access_whitelist(r1),
    auto_create(r1),
    auto_subscribe(r14),
    collections(r1),
    config_node(r14),
    create_and_configure(r14),
    create_nodes(r14),
    delete_items(r14),
    delete_nodes(r14),
    get_pending(r1),
    item_ids(r14),
    last_published(r14),
    leased_subscription(r1),
    manage_subscriptions(r1),
    member_affiliation(r14),
    meta_data(r14),
    modify_affiliations(r1),
    multi_collection(r1),
    multi_subscribe(r1),
    outcast_affiliation(r14),
    persistent_items(r14),
    presence_notifications(r1),
    presence_subscribe(r14),
    publish(r7),
    publish_options(r1),
    publish_only_affiliation(r1),
    publisher_affiliation(r14),
    purge_nodes(r1),
    retract_items(r1),
    retrieve_affiliations(r14),
    retrieve_default(r14),
    retrieve_default_sub(r1),
    retrieve_items(r14),
    retrieve_subscriptions(r14),
    subscribe(r7),
    subscription_options(r1),
    subscriptions_notifications(r1),
    instant_nodes(r14),
    filtered_notifications(r14);
    
    private final String feature;
    private final String qualifiedFeature;
    private final Feature.Support support;

    private PubSubFeature(Feature.Support support2) {
        String replace = name().replace('_', SignatureVisitor.SUPER);
        this.feature = replace;
        this.qualifiedFeature = "http://jabber.org/protocol/pubsub#" + replace;
        this.support = support2;
    }

    public char charAt(int i10) {
        return this.qualifiedFeature.charAt(i10);
    }

    public String getFeatureName() {
        return this.feature;
    }

    public int length() {
        return this.qualifiedFeature.length();
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.qualifiedFeature.subSequence(i10, i11);
    }

    public Feature.Support support() {
        return this.support;
    }

    public String toString() {
        return this.qualifiedFeature;
    }
}
