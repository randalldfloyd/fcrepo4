/*
 * Licensed to DuraSpace under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * DuraSpace licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.kernel.api.services.functions;

import static java.util.UUID.randomUUID;

import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Unique value minter that creates hierarchical IDs from a UUID
 *
 * @author awoods
 * @author acoburn
 */
public interface HierarchicalIdentifierSupplier extends UniqueValueSupplier {

    /**
     * Mint a unique non-hierarchical identifier by default
     *
     * @return uuid
     */
    @Override
    default public String get() {

        final String s = randomUUID().toString();
        return s;
    }

    /**
     * Mint a hierarchical identifier with parameters to control length and count of the pairtree. A count of ZERO
     * will return a non-hierarchical identifier.
     *
     * @param length the desired length of pairtree parts
     * @param count the desired number of pairtree parts
     * @return uuid
     */
    default public String get(final int length, final int count) {
        final String s = randomUUID().toString();
        final String id;

        if (count > 0) {
            final StringJoiner joiner = new StringJoiner("/", "", "/" + s);

            IntStream.rangeClosed(0, count - 1)
            .forEach(x -> joiner.add(s.substring(x * length, (x + 1) * length)));
            id = joiner.toString();
        } else {
            id = s;
        }
        return id;
    }
}
