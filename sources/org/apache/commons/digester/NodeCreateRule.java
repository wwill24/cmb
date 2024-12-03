package org.apache.commons.digester;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NodeCreateRule extends Rule {
    private DocumentBuilder documentBuilder;
    private int nodeType;

    private class NodeBuilder extends DefaultHandler {
        protected int depth = 0;
        protected Document doc = null;
        protected ContentHandler oldContentHandler = null;
        protected Node root = null;
        protected Node top = null;
        protected StringBuffer topText = new StringBuffer();

        public NodeBuilder(Document document, Node node) throws ParserConfigurationException, SAXException {
            this.doc = document;
            this.root = node;
            this.top = node;
            this.oldContentHandler = NodeCreateRule.this.digester.getCustomContentHandler();
        }

        private void addTextIfPresent() throws SAXException {
            if (this.topText.length() > 0) {
                String stringBuffer = this.topText.toString();
                this.topText.setLength(0);
                if (stringBuffer.trim().length() > 0) {
                    try {
                        this.top.appendChild(this.doc.createTextNode(stringBuffer));
                    } catch (DOMException e10) {
                        throw new SAXException(e10.getMessage());
                    }
                }
            }
        }

        public void characters(char[] cArr, int i10, int i11) throws SAXException {
            this.topText.append(cArr, i10, i11);
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            addTextIfPresent();
            try {
                if (this.depth == 0) {
                    NodeCreateRule.this.getDigester().setCustomContentHandler(this.oldContentHandler);
                    NodeCreateRule.this.getDigester().push(this.root);
                    NodeCreateRule.this.getDigester().endElement(str, str2, str3);
                }
                this.top = this.top.getParentNode();
                this.depth--;
            } catch (DOMException e10) {
                throw new SAXException(e10.getMessage());
            }
        }

        public void processingInstruction(String str, String str2) throws SAXException {
            try {
                this.top.appendChild(this.doc.createProcessingInstruction(str, str2));
            } catch (DOMException e10) {
                throw new SAXException(e10.getMessage());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[Catch:{ DOMException -> 0x007b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void startElement(java.lang.String r3, java.lang.String r4, java.lang.String r5, org.xml.sax.Attributes r6) throws org.xml.sax.SAXException {
            /*
                r2 = this;
                r2.addTextIfPresent()
                org.w3c.dom.Node r0 = r2.top     // Catch:{ DOMException -> 0x007b }
                if (r4 == 0) goto L_0x0017
                int r1 = r4.length()     // Catch:{ DOMException -> 0x007b }
                if (r1 != 0) goto L_0x000e
                goto L_0x0017
            L_0x000e:
                org.w3c.dom.Document r5 = r2.doc     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Element r3 = r5.createElementNS(r3, r4)     // Catch:{ DOMException -> 0x007b }
                r2.top = r3     // Catch:{ DOMException -> 0x007b }
                goto L_0x001f
            L_0x0017:
                org.w3c.dom.Document r3 = r2.doc     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Element r3 = r3.createElement(r5)     // Catch:{ DOMException -> 0x007b }
                r2.top = r3     // Catch:{ DOMException -> 0x007b }
            L_0x001f:
                r3 = 0
            L_0x0020:
                int r4 = r6.getLength()     // Catch:{ DOMException -> 0x007b }
                if (r3 >= r4) goto L_0x006f
                java.lang.String r4 = r6.getLocalName(r3)     // Catch:{ DOMException -> 0x007b }
                if (r4 == 0) goto L_0x0054
                java.lang.String r4 = r6.getLocalName(r3)     // Catch:{ DOMException -> 0x007b }
                int r4 = r4.length()     // Catch:{ DOMException -> 0x007b }
                if (r4 != 0) goto L_0x0037
                goto L_0x0054
            L_0x0037:
                org.w3c.dom.Document r4 = r2.doc     // Catch:{ DOMException -> 0x007b }
                java.lang.String r5 = r6.getURI(r3)     // Catch:{ DOMException -> 0x007b }
                java.lang.String r1 = r6.getLocalName(r3)     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Attr r4 = r4.createAttributeNS(r5, r1)     // Catch:{ DOMException -> 0x007b }
                java.lang.String r5 = r6.getValue(r3)     // Catch:{ DOMException -> 0x007b }
                r4.setNodeValue(r5)     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Node r5 = r2.top     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Element r5 = (org.w3c.dom.Element) r5     // Catch:{ DOMException -> 0x007b }
                r5.setAttributeNodeNS(r4)     // Catch:{ DOMException -> 0x007b }
                goto L_0x006c
            L_0x0054:
                org.w3c.dom.Document r4 = r2.doc     // Catch:{ DOMException -> 0x007b }
                java.lang.String r5 = r6.getQName(r3)     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Attr r4 = r4.createAttribute(r5)     // Catch:{ DOMException -> 0x007b }
                java.lang.String r5 = r6.getValue(r3)     // Catch:{ DOMException -> 0x007b }
                r4.setNodeValue(r5)     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Node r5 = r2.top     // Catch:{ DOMException -> 0x007b }
                org.w3c.dom.Element r5 = (org.w3c.dom.Element) r5     // Catch:{ DOMException -> 0x007b }
                r5.setAttributeNode(r4)     // Catch:{ DOMException -> 0x007b }
            L_0x006c:
                int r3 = r3 + 1
                goto L_0x0020
            L_0x006f:
                org.w3c.dom.Node r3 = r2.top     // Catch:{ DOMException -> 0x007b }
                r0.appendChild(r3)     // Catch:{ DOMException -> 0x007b }
                int r3 = r2.depth     // Catch:{ DOMException -> 0x007b }
                int r3 = r3 + 1
                r2.depth = r3     // Catch:{ DOMException -> 0x007b }
                return
            L_0x007b:
                r3 = move-exception
                org.xml.sax.SAXException r4 = new org.xml.sax.SAXException
                java.lang.String r3 = r3.getMessage()
                r4.<init>(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.digester.NodeCreateRule.NodeBuilder.startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
        }
    }

    public NodeCreateRule() throws ParserConfigurationException {
        this(1);
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        NodeBuilder nodeBuilder;
        Element element;
        Document newDocument = this.documentBuilder.newDocument();
        if (this.nodeType == 1) {
            int i10 = 0;
            if (getDigester().getNamespaceAware()) {
                element = newDocument.createElementNS(str, str2);
                while (i10 < attributes.getLength()) {
                    element.setAttributeNS(attributes.getURI(i10), attributes.getQName(i10), attributes.getValue(i10));
                    i10++;
                }
            } else {
                element = newDocument.createElement(str2);
                while (i10 < attributes.getLength()) {
                    element.setAttribute(attributes.getQName(i10), attributes.getValue(i10));
                    i10++;
                }
            }
            nodeBuilder = new NodeBuilder(newDocument, element);
        } else {
            nodeBuilder = new NodeBuilder(newDocument, newDocument.createDocumentFragment());
        }
        getDigester().setCustomContentHandler(nodeBuilder);
    }

    public void end() throws Exception {
        this.digester.pop();
    }

    public NodeCreateRule(DocumentBuilder documentBuilder2) {
        this(1, documentBuilder2);
    }

    public NodeCreateRule(int i10) throws ParserConfigurationException {
        this(i10, DocumentBuilderFactory.newInstance().newDocumentBuilder());
    }

    public NodeCreateRule(int i10, DocumentBuilder documentBuilder2) {
        this.documentBuilder = null;
        this.nodeType = 1;
        if (i10 == 11 || i10 == 1) {
            this.nodeType = i10;
            this.documentBuilder = documentBuilder2;
            return;
        }
        throw new IllegalArgumentException("Can only create nodes of type DocumentFragment and Element");
    }
}
