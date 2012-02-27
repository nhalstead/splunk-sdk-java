/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

import java.util.Date;

/**
 * Representation of a Splunk application, commonly referred to as an 'app'.
 */
public class Upload extends Entity {

    /**
     * Class constructor.
     *
     * @param service The connected service instance.
     * @param path The application endpoint.
     */
    Upload(Service service, String path) {
        super(service, path);
    }

    /**
     * Returns the number of bytes currently indexed.
     *
     * @return The number of bytes currently indexed.
     */
    public int getBytesIndexed() {
        return getInteger("Bytes Indexed");
    }

    /**
     * Returns the current offset.
     *
     * @return The current offset.
     */
    public int getOffset() {
        return getInteger("Offset");
    }

    /**
     * Returns the current size.
     *
     * @return The current size.
     */
    public int getSize() {
        return getInteger("Size");
    }

    /**
     * Returns the number of sources indexed.
     *
     * @return The number of sources indexed.
     */
    public int getSourcesIndexed() {
        return getInteger("Sources Indexed");
    }

    /**
     * Returns the start time of the upload being indexed.
     *
     * @return The start time of the upload being indexed.
     */
    public Date getSpoolTime() {
        return getDate("Spool Time", null);
    }
}

