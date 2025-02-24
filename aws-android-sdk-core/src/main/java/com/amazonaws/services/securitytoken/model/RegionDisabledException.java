/*
 * Copyright 2010-2022 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

/**
 * <p>
 * STS is not activated in the requested region for the account that is being
 * asked to generate credentials. The account administrator must use the IAM
 * console to activate STS in that region. For more information, see <a href=
 * "https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_temp_enable-regions.html"
 * >Activating and Deactivating Amazon Web Services STS in an Amazon Web
 * Services Region</a> in the <i>IAM User Guide</i>.
 * </p>
 */
public class RegionDisabledException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new RegionDisabledException with the specified error
     * message.
     *
     * @param message Describes the error encountered.
     */
    public RegionDisabledException(String message) {
        super(message);
    }
}
