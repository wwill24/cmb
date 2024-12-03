package org.jivesoftware.smackx.disco.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lm.c;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

public class DiscoverInfo extends IQ implements DiscoverInfoView {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/disco#info";
    private boolean containsDuplicateFeatures;
    private final List<Feature> features;
    private final Set<Feature> featuresSet;
    private final List<Identity> identities;
    private final Set<String> identitiesSet;
    private String node;

    public static final class Identity implements Comparable<Identity> {
        private final String category;
        private final HashCode.Cache hashCodeCache;
        private final String key;
        private final String lang;
        private final String name;
        private final String type;

        public Identity(String str, String str2) {
            this(str, str2, (String) null, (String) null);
        }

        /* access modifiers changed from: private */
        public String getKey() {
            return this.key;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, Identity identity) {
            builder.append(this.key, identity.key).append(this.lang, identity.lang).append(this.name, identity.name);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$hashCode$1(HashCode.Builder builder) {
            builder.append((Object) this.key).append((Object) this.lang).append((Object) this.name);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new c(this));
        }

        public String getCategory() {
            return this.category;
        }

        public String getLanguage() {
            return this.lang;
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new b(this));
        }

        public boolean isOfCategoryAndType(String str, String str2) {
            return this.category.equals(str) && this.type.equals(str2);
        }

        public String toString() {
            return toXML().toString();
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("identity");
            xmlStringBuilder.xmllangAttribute(this.lang);
            xmlStringBuilder.attribute("category", this.category);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute("type", this.type);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Identity(String str, String str2, String str3) {
            this(str, str3, str2, (String) null);
        }

        public int compareTo(Identity identity) {
            String str = identity.lang;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String str3 = this.lang;
            if (str3 == null) {
                str3 = str2;
            }
            String str4 = identity.type;
            if (str4 == null) {
                str4 = str2;
            }
            String str5 = this.type;
            if (str5 != null) {
                str2 = str5;
            }
            if (!this.category.equals(identity.category)) {
                return this.category.compareTo(identity.category);
            }
            if (!str2.equals(str4)) {
                return str2.compareTo(str4);
            }
            if (str3.equals(str)) {
                return 0;
            }
            return str3.compareTo(str);
        }

        public Identity(String str, String str2, String str3, String str4) {
            this.hashCodeCache = new HashCode.Cache();
            this.category = (String) StringUtils.requireNotNullNorEmpty(str, "category cannot be null");
            this.type = (String) StringUtils.requireNotNullNorEmpty(str2, "type cannot be null");
            this.key = c.d(str, str2);
            this.name = str3;
            this.lang = str4;
        }
    }

    DiscoverInfo(DiscoverInfoBuilder discoverInfoBuilder, boolean z10) {
        super(discoverInfoBuilder, "query", NAMESPACE);
        ArrayList<Feature> arrayList = new ArrayList<>();
        this.features = arrayList;
        this.featuresSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        this.identities = arrayList2;
        this.identitiesSet = new HashSet();
        arrayList.addAll(discoverInfoBuilder.getFeatures());
        arrayList2.addAll(discoverInfoBuilder.getIdentities());
        this.node = discoverInfoBuilder.getNode();
        for (Feature add : arrayList) {
            if (!this.featuresSet.add(add)) {
                this.containsDuplicateFeatures = true;
            }
        }
        for (Identity access$000 : this.identities) {
            this.identitiesSet.add(access$000.getKey());
        }
        if (z10 && this.containsDuplicateFeatures) {
            throw new IllegalArgumentException("The disco#info request contains duplicate features.");
        }
    }

    public static DiscoverInfoBuilder builder(XMPPConnection xMPPConnection) {
        return new DiscoverInfoBuilder(xMPPConnection);
    }

    public static boolean nullSafeContainsFeature(DiscoverInfo discoverInfo, CharSequence charSequence) {
        if (discoverInfo == null) {
            return false;
        }
        return discoverInfo.containsFeature(charSequence);
    }

    @Deprecated
    public boolean addFeature(String str) {
        return addFeature(new Feature(str));
    }

    @Deprecated
    public void addFeatures(Collection<String> collection) {
        if (collection != null) {
            for (String addFeature : collection) {
                addFeature(addFeature);
            }
        }
    }

    @Deprecated
    public void addIdentities(Collection<Identity> collection) {
        if (collection != null) {
            for (Identity addIdentity : collection) {
                addIdentity(addIdentity);
            }
        }
    }

    @Deprecated
    public void addIdentity(Identity identity) {
        this.identities.add(identity);
        this.identitiesSet.add(identity.getKey());
    }

    public DiscoverInfoBuilder asBuilder(String str) {
        return new DiscoverInfoBuilder(this, str);
    }

    public boolean containsDuplicateFeatures() {
        return this.containsDuplicateFeatures;
    }

    public boolean containsDuplicateIdentities() {
        LinkedList<Identity> linkedList = new LinkedList<>();
        for (Identity next : this.identities) {
            for (Identity equals : linkedList) {
                if (next.equals(equals)) {
                    return true;
                }
            }
            linkedList.add(next);
        }
        return false;
    }

    public boolean containsFeature(CharSequence charSequence) {
        return this.features.contains(new Feature(charSequence));
    }

    public List<Feature> getFeatures() {
        return Collections.unmodifiableList(this.features);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, getNode());
        iQChildElementXmlStringBuilder.rightAngleBracket();
        for (Identity xml : this.identities) {
            iQChildElementXmlStringBuilder.append(xml.toXML());
        }
        for (Feature xml2 : this.features) {
            iQChildElementXmlStringBuilder.append(xml2.toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Identity> getIdentities() {
        return Collections.unmodifiableList(this.identities);
    }

    public String getNode() {
        return this.node;
    }

    public boolean hasIdentity(String str, String str2) {
        return this.identitiesSet.contains(c.d(str, str2));
    }

    @Deprecated
    public void setNode(String str) {
        this.node = (String) StringUtils.requireNullOrNotEmpty(str, "The node can not be the empty string");
    }

    public static final class Feature {
        private final String variable;

        public Feature(Feature feature) {
            this.variable = feature.variable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, Feature feature) {
            builder.append(this.variable, feature.variable);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new a(this));
        }

        public String getVar() {
            return this.variable;
        }

        public int hashCode() {
            return this.variable.hashCode();
        }

        public String toString() {
            return toXML().toString();
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("feature");
            xmlStringBuilder.attribute("var", this.variable);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Feature(CharSequence charSequence) {
            this(charSequence.toString());
        }

        public Feature(String str) {
            this.variable = (String) StringUtils.requireNotNullNorEmpty(str, "variable cannot be null");
        }
    }

    public static DiscoverInfoBuilder builder(IqData iqData) {
        return new DiscoverInfoBuilder(iqData);
    }

    @Deprecated
    public boolean addFeature(Feature feature) {
        this.features.add(feature);
        boolean add = this.featuresSet.add(feature);
        if (!add) {
            this.containsDuplicateFeatures = true;
        }
        return add;
    }

    @Deprecated
    public DiscoverInfo clone() {
        return new DiscoverInfo(this);
    }

    public List<Identity> getIdentities(String str, String str2) {
        ArrayList arrayList = new ArrayList(this.identities.size());
        for (Identity next : this.identities) {
            if (next.getCategory().equals(str) && next.getType().equals(str2)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static DiscoverInfoBuilder builder(String str) {
        return new DiscoverInfoBuilder(str);
    }

    @Deprecated
    public DiscoverInfo() {
        super("query", NAMESPACE);
        this.features = new ArrayList();
        this.featuresSet = new HashSet();
        this.identities = new ArrayList();
        this.identitiesSet = new HashSet();
    }

    public DiscoverInfo(DiscoverInfo discoverInfo) {
        super(discoverInfo);
        ArrayList arrayList = new ArrayList();
        this.features = arrayList;
        HashSet hashSet = new HashSet();
        this.featuresSet = hashSet;
        ArrayList arrayList2 = new ArrayList();
        this.identities = arrayList2;
        HashSet hashSet2 = new HashSet();
        this.identitiesSet = hashSet2;
        this.node = discoverInfo.getNode();
        arrayList.addAll(discoverInfo.features);
        hashSet.addAll(discoverInfo.featuresSet);
        arrayList2.addAll(discoverInfo.identities);
        hashSet2.addAll(discoverInfo.identitiesSet);
    }
}
