package net.bytebuddy.description.type;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

public interface RecordComponentList<T extends RecordComponentDescription> extends FilterableList<T, RecordComponentList<T>> {

    public static abstract class AbstractBase<S extends RecordComponentDescription> extends FilterableList.AbstractBase<S, RecordComponentList<S>> implements RecordComponentList<S> {
        public RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((RecordComponentDescription) it.next()).asDefined());
            }
            return new Explicit(arrayList);
        }

        public ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((RecordComponentDescription) it.next()).asToken(elementMatcher));
            }
            return new ByteCodeElement.Token.TokenList<>(arrayList);
        }

        public TypeList.Generic asTypeList() {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(((RecordComponentDescription) it.next()).getType());
            }
            return new TypeList.Generic.Explicit((List<? extends TypeDefinition>) arrayList);
        }

        /* access modifiers changed from: protected */
        public RecordComponentList<S> wrap(List<S> list) {
            return new Explicit(list);
        }
    }

    public static class Empty<S extends RecordComponentDescription> extends FilterableList.Empty<S, RecordComponentList<S>> implements RecordComponentList<S> {
        public RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined() {
            return new Empty();
        }

        public ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new ByteCodeElement.Token.TokenList<>((S[]) new RecordComponentDescription.Token[0]);
        }

        public TypeList.Generic asTypeList() {
            return new TypeList.Generic.Empty();
        }
    }

    public static class Explicit<S extends RecordComponentDescription> extends AbstractBase<S> {
        private final List<? extends S> recordComponents;

        public Explicit(S... sArr) {
            this(Arrays.asList(sArr));
        }

        public int size() {
            return this.recordComponents.size();
        }

        public Explicit(List<? extends S> list) {
            this.recordComponents = list;
        }

        public S get(int i10) {
            return (RecordComponentDescription) this.recordComponents.get(i10);
        }
    }

    public static class ForLoadedRecordComponents extends AbstractBase<RecordComponentDescription.InDefinedShape> {
        private final List<?> recordComponents;

        protected ForLoadedRecordComponents(Object... objArr) {
            this((List<?>) Arrays.asList(objArr));
        }

        public int size() {
            return this.recordComponents.size();
        }

        protected ForLoadedRecordComponents(List<?> list) {
            this.recordComponents = list;
        }

        public RecordComponentDescription.InDefinedShape get(int i10) {
            return new RecordComponentDescription.ForLoadedRecordComponent((AnnotatedElement) this.recordComponents.get(i10));
        }
    }

    public static class ForTokens extends AbstractBase<RecordComponentDescription.InDefinedShape> {
        private final List<? extends RecordComponentDescription.Token> tokens;
        private final TypeDescription typeDescription;

        public ForTokens(TypeDescription typeDescription2, RecordComponentDescription.Token... tokenArr) {
            this(typeDescription2, (List<? extends RecordComponentDescription.Token>) Arrays.asList(tokenArr));
        }

        public int size() {
            return this.tokens.size();
        }

        public ForTokens(TypeDescription typeDescription2, List<? extends RecordComponentDescription.Token> list) {
            this.typeDescription = typeDescription2;
            this.tokens = list;
        }

        public RecordComponentDescription.InDefinedShape get(int i10) {
            return new RecordComponentDescription.Latent(this.typeDescription, (RecordComponentDescription.Token) this.tokens.get(i10));
        }
    }

    public static class TypeSubstituting extends AbstractBase<RecordComponentDescription.InGenericShape> {
        private final TypeDescription.Generic declaringType;
        private final List<? extends RecordComponentDescription> recordComponentDescriptions;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, List<? extends RecordComponentDescription> list, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.recordComponentDescriptions = list;
            this.visitor = visitor2;
        }

        public int size() {
            return this.recordComponentDescriptions.size();
        }

        public RecordComponentDescription.InGenericShape get(int i10) {
            return new RecordComponentDescription.TypeSubstituting(this.declaringType, (RecordComponentDescription) this.recordComponentDescriptions.get(i10), this.visitor);
        }
    }

    RecordComponentList<RecordComponentDescription.InDefinedShape> asDefined();

    ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);

    TypeList.Generic asTypeList();
}
