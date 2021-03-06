/*
 * Copyright (c)  2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package io.siddhi.distribution.event.simulator.core.exception;

/**
 * customized exception class for copying and deleting files.
 */
public class FileOperationsException extends Exception {
    /**
     * Throws customizes exception copying and deleting files.
     *
     * @param message Error Message
     */
    public FileOperationsException(String message) {
        super(message);
    }

    /**
     * Throws customizes exception copying and deleting files.
     *
     * @param message Error Message
     * @param cause   Throwable which caused the file deployment exception
     */
    public FileOperationsException(String message, Throwable cause) {
        super(message, cause);
    }
}
