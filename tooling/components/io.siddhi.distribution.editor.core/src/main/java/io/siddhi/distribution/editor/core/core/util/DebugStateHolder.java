/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.siddhi.distribution.editor.core.core.util;

import java.util.Map;

/**
 * For storing meta data for a debugger states (query state and debug event state).
 * Used in JSON responses
 */
public class DebugStateHolder {
    private Map<String, Map<String, Object>> queryState;
    private DebugCallbackEvent eventState;

    private DebugStateHolder() {
    }

    public DebugStateHolder(DebugCallbackEvent eventState, Map<String, Map<String, Object>> queryState) {
        this.eventState = eventState;
        this.queryState = queryState;
    }

    public Map<String, Map<String, Object>> getQueryState() {
        return queryState;
    }

    public DebugCallbackEvent getEventState() {
        return eventState;
    }
}
