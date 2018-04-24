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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <p>
 * HierarchicalIdentifierSupplierTest class.
 * </p>
 *
 * @author rdfloyd
 */
public class HierarchicalIdentifierSupplierTest {

    private static class DefaultPathMinter implements HierarchicalIdentifierSupplier {
    }

    protected HierarchicalIdentifierSupplier defaultPidMinter = new DefaultPathMinter();

    @Test
    public void testGet() {
        final String id = defaultPidMinter.get();
        // Without params check to see that id contains 1 part and no slashes
        final int parts = (id.split("/").length);
        assertEquals(1, parts);
    }

    @Test
    public void testGetIdNoPairtree() {
        final String id = defaultPidMinter.get(0, 0);
        // With params but with (count=0), check to see that id contains 1 part and no slashes
        final int parts = (id.split("/").length);
        assertEquals(1, parts);
    }

    @Test
    public void testGetIdPairtreeParams() {
        final String id = defaultPidMinter.get(2, 4);
        // With params and (count > 0) check to see that id contains (count + 1) parts delimited by slashes
        final int parts = (id.split("/").length);
        assertEquals(5, parts);
    }

}