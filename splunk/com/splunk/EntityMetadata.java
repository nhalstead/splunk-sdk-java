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

import java.util.Map;

// A class that provides access to an entities metadata. Instances of this
// class are obtained via Entity.getMetadata.
public class EntityMetadata {
    private Entity entity;

    EntityMetadata(Entity entity) {
        this.entity = entity;
    }

    // Answers if the corresponding entity's permissions can be changed.
    public boolean canChangePermissions() {
        return getEaiAcl().getBoolean("can_change_perms", false);
    }

    // Indicates that the resource can be share via an app.
    public boolean canShareApp() {
        return getEaiAcl().getBoolean("can_share_app", false);
    }

    // Indicates that the resource can be shared globally.
    public boolean canShareGlobal() {
        return getEaiAcl().getBoolean("can_share_global", false);
    }

    // Indicates that the resource can be shared to a specific user.
    public boolean canShareUser() {
        return getEaiAcl().getBoolean("can_share_user", false);
    }

    // Answers if the corresponding entity can be modified.
    public boolean canWrite() {
        return getEaiAcl().getBoolean("can_write", false);
    }

    // Returns the app context of this resource.
    public String getApp() {
        return getEaiAcl().getString("app", "system");
    }

    Record getEaiAcl() {
        return (Record)entity.validate().get("eai:acl");
    }

    // Returns the username of the owner of this resource.
    public String getOwner() {
        return getEaiAcl().getString("owner");
    }

    // Returns the entity's permissions. The permissions are represented as
    // a Map that maps action to a list of roles that can perform the action.
    public Record getPermissions() {
        return getEaiAcl().<Record>getValue("perms", null);
    }

    // Returns a value indicating how the resources is shared, legal values
    // are: app, global and user.
    public String getSharing() {
        return getEaiAcl().getString("sharing");
    }

    // Answers if the metadata of this entity can be changed.
    public boolean isModifiable() {
        return getEaiAcl().getBoolean("modifiable", false);
    }
}
