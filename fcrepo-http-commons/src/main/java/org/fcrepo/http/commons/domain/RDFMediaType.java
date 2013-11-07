/**
 * Copyright 2013 DuraSpace, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fcrepo.http.commons.domain;

import static javax.ws.rs.core.Variant.mediaTypes;
import static org.apache.jena.riot.WebContent.contentTypeN3;
import static org.apache.jena.riot.WebContent.contentTypeN3Alt1;
import static org.apache.jena.riot.WebContent.contentTypeN3Alt2;
import static org.apache.jena.riot.WebContent.contentTypeNQuads;
import static org.apache.jena.riot.WebContent.contentTypeNTriples;
import static org.apache.jena.riot.WebContent.contentTypeRDFJSON;
import static org.apache.jena.riot.WebContent.contentTypeRDFXML;
import static org.apache.jena.riot.WebContent.contentTypeTriG;
import static org.apache.jena.riot.WebContent.contentTypeTurtle;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Variant;

/**
 * This is a convenience class carrying the various RDF content-type values as
 * Strings and MediaTypes, after the fashion of the constants available on
 * javax.ws.rs.core.MediaType
 *
 * @author ba2213
 */
public abstract class RDFMediaType extends MediaType {

    public static final String N3_TEXT_RDF = contentTypeN3;

    public static final MediaType N3_TEXT_RDF_TYPE = typeFromString(N3_TEXT_RDF);

    public static final String N3_APPLICATION = contentTypeN3Alt1;

    public static final MediaType N3_APPLICATION_TYPE = typeFromString(N3_APPLICATION);

    public static final String N3_TEXT = contentTypeN3Alt2;

    public static final MediaType N3_TEXT_TYPE = typeFromString(N3_TEXT);

    public static final String TURTLE = contentTypeTurtle;

    public static final MediaType TURTLE_TYPE = typeFromString(TURTLE);

    public static final String RDF_XML = contentTypeRDFXML;

    public static final MediaType RDF_XML_TYPE = typeFromString(RDF_XML);

    public static final String RDF_JSON = contentTypeRDFJSON;

    public static final MediaType RDF_JSON_TYPE = typeFromString(RDF_JSON);

    public static final String NTRIPLES = contentTypeNTriples;

    public static final MediaType NTRIPLES_TYPE = typeFromString(NTRIPLES);

    public static final String TRI_G = contentTypeTriG;

    public static final MediaType TRI_G_TYPE = typeFromString(TRI_G);

    public static final String NQUADS = contentTypeNQuads;

    public static final MediaType NQUADS_TYPE = typeFromString(NQUADS);

    public static final List<Variant> POSSIBLE_RDF_VARIANTS = mediaTypes(
            TURTLE_TYPE, RDF_XML_TYPE, NTRIPLES_TYPE, RDF_JSON_TYPE, N3_TEXT_RDF_TYPE,
            N3_APPLICATION_TYPE, N3_TEXT_TYPE, TRI_G_TYPE, NQUADS_TYPE).add().build();

    public static final List<Variant> ALL_VARIANTS = mediaTypes(
            TURTLE_TYPE, RDF_XML_TYPE, NTRIPLES_TYPE, RDF_JSON_TYPE, N3_TEXT_RDF_TYPE,
            N3_APPLICATION_TYPE, N3_TEXT_TYPE, TRI_G_TYPE, NQUADS_TYPE, MediaType.TEXT_HTML_TYPE).add().build();

    private static MediaType typeFromString(final String type) {
        return new MediaType(type.split("/")[0], type.split("/")[1]);
    }

}
