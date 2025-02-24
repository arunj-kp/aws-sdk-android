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

package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Updates the Secure Sockets Layer (SSL) certificate for the custom domain for
 * your user pool.
 * </p>
 * <p>
 * You can use this operation to provide the Amazon Resource Name (ARN) of a new
 * certificate to Amazon Cognito. You can't use it to change the domain for a
 * user pool.
 * </p>
 * <p>
 * A custom domain is used to host the Amazon Cognito hosted UI, which provides
 * sign-up and sign-in pages for your application. When you set up a custom
 * domain, you provide a certificate that you manage with Certificate Manager
 * (ACM). When necessary, you can use this operation to change the certificate
 * that you applied to your custom domain.
 * </p>
 * <p>
 * Usually, this is unnecessary following routine certificate renewal with ACM.
 * When you renew your existing certificate in ACM, the ARN for your certificate
 * remains the same, and your custom domain uses the new certificate
 * automatically.
 * </p>
 * <p>
 * However, if you replace your existing certificate with a new one, ACM gives
 * the new certificate a new ARN. To apply the new certificate to your custom
 * domain, you must provide this ARN to Amazon Cognito.
 * </p>
 * <p>
 * When you add your new certificate in ACM, you must choose US East (N.
 * Virginia) as the Amazon Web Services Region.
 * </p>
 * <p>
 * After you submit your request, Amazon Cognito requires up to 1 hour to
 * distribute your new certificate to your custom domain.
 * </p>
 * <p>
 * For more information about adding a custom domain to your user pool, see <a
 * href=
 * "https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-user-pools-add-custom-domain.html"
 * >Using Your Own Domain for the Hosted UI</a>.
 * </p>
 */
public class UpdateUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * The domain name for the custom domain that hosts the sign-up and sign-in
     * pages for your application. One example might be
     * <code>auth.example.com</code>.
     * </p>
     * <p>
     * This string can include only lowercase letters, numbers, and hyphens.
     * Don't use a hyphen for the first or last character. Use periods to
     * separate subdomain names.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 63<br/>
     * <b>Pattern: </b>^[a-z0-9](?:[a-z0-9\-]{0,61}[a-z0-9])?$<br/>
     */
    private String domain;

    /**
     * <p>
     * The ID of the user pool that is associated with the custom domain whose
     * certificate you're updating.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 55<br/>
     * <b>Pattern: </b>[\w-]+_[0-9a-zA-Z]+<br/>
     */
    private String userPoolId;

    /**
     * <p>
     * The configuration for a custom domain that hosts the sign-up and sign-in
     * pages for your application. Use this object to specify an SSL certificate
     * that is managed by ACM.
     * </p>
     */
    private CustomDomainConfigType customDomainConfig;

    /**
     * <p>
     * The domain name for the custom domain that hosts the sign-up and sign-in
     * pages for your application. One example might be
     * <code>auth.example.com</code>.
     * </p>
     * <p>
     * This string can include only lowercase letters, numbers, and hyphens.
     * Don't use a hyphen for the first or last character. Use periods to
     * separate subdomain names.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 63<br/>
     * <b>Pattern: </b>^[a-z0-9](?:[a-z0-9\-]{0,61}[a-z0-9])?$<br/>
     *
     * @return <p>
     *         The domain name for the custom domain that hosts the sign-up and
     *         sign-in pages for your application. One example might be
     *         <code>auth.example.com</code>.
     *         </p>
     *         <p>
     *         This string can include only lowercase letters, numbers, and
     *         hyphens. Don't use a hyphen for the first or last character. Use
     *         periods to separate subdomain names.
     *         </p>
     */
    public String getDomain() {
        return domain;
    }

    /**
     * <p>
     * The domain name for the custom domain that hosts the sign-up and sign-in
     * pages for your application. One example might be
     * <code>auth.example.com</code>.
     * </p>
     * <p>
     * This string can include only lowercase letters, numbers, and hyphens.
     * Don't use a hyphen for the first or last character. Use periods to
     * separate subdomain names.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 63<br/>
     * <b>Pattern: </b>^[a-z0-9](?:[a-z0-9\-]{0,61}[a-z0-9])?$<br/>
     *
     * @param domain <p>
     *            The domain name for the custom domain that hosts the sign-up
     *            and sign-in pages for your application. One example might be
     *            <code>auth.example.com</code>.
     *            </p>
     *            <p>
     *            This string can include only lowercase letters, numbers, and
     *            hyphens. Don't use a hyphen for the first or last character.
     *            Use periods to separate subdomain names.
     *            </p>
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * <p>
     * The domain name for the custom domain that hosts the sign-up and sign-in
     * pages for your application. One example might be
     * <code>auth.example.com</code>.
     * </p>
     * <p>
     * This string can include only lowercase letters, numbers, and hyphens.
     * Don't use a hyphen for the first or last character. Use periods to
     * separate subdomain names.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 63<br/>
     * <b>Pattern: </b>^[a-z0-9](?:[a-z0-9\-]{0,61}[a-z0-9])?$<br/>
     *
     * @param domain <p>
     *            The domain name for the custom domain that hosts the sign-up
     *            and sign-in pages for your application. One example might be
     *            <code>auth.example.com</code>.
     *            </p>
     *            <p>
     *            This string can include only lowercase letters, numbers, and
     *            hyphens. Don't use a hyphen for the first or last character.
     *            Use periods to separate subdomain names.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateUserPoolDomainRequest withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * <p>
     * The ID of the user pool that is associated with the custom domain whose
     * certificate you're updating.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 55<br/>
     * <b>Pattern: </b>[\w-]+_[0-9a-zA-Z]+<br/>
     *
     * @return <p>
     *         The ID of the user pool that is associated with the custom domain
     *         whose certificate you're updating.
     *         </p>
     */
    public String getUserPoolId() {
        return userPoolId;
    }

    /**
     * <p>
     * The ID of the user pool that is associated with the custom domain whose
     * certificate you're updating.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 55<br/>
     * <b>Pattern: </b>[\w-]+_[0-9a-zA-Z]+<br/>
     *
     * @param userPoolId <p>
     *            The ID of the user pool that is associated with the custom
     *            domain whose certificate you're updating.
     *            </p>
     */
    public void setUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
    }

    /**
     * <p>
     * The ID of the user pool that is associated with the custom domain whose
     * certificate you're updating.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 55<br/>
     * <b>Pattern: </b>[\w-]+_[0-9a-zA-Z]+<br/>
     *
     * @param userPoolId <p>
     *            The ID of the user pool that is associated with the custom
     *            domain whose certificate you're updating.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateUserPoolDomainRequest withUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
        return this;
    }

    /**
     * <p>
     * The configuration for a custom domain that hosts the sign-up and sign-in
     * pages for your application. Use this object to specify an SSL certificate
     * that is managed by ACM.
     * </p>
     *
     * @return <p>
     *         The configuration for a custom domain that hosts the sign-up and
     *         sign-in pages for your application. Use this object to specify an
     *         SSL certificate that is managed by ACM.
     *         </p>
     */
    public CustomDomainConfigType getCustomDomainConfig() {
        return customDomainConfig;
    }

    /**
     * <p>
     * The configuration for a custom domain that hosts the sign-up and sign-in
     * pages for your application. Use this object to specify an SSL certificate
     * that is managed by ACM.
     * </p>
     *
     * @param customDomainConfig <p>
     *            The configuration for a custom domain that hosts the sign-up
     *            and sign-in pages for your application. Use this object to
     *            specify an SSL certificate that is managed by ACM.
     *            </p>
     */
    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfig) {
        this.customDomainConfig = customDomainConfig;
    }

    /**
     * <p>
     * The configuration for a custom domain that hosts the sign-up and sign-in
     * pages for your application. Use this object to specify an SSL certificate
     * that is managed by ACM.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param customDomainConfig <p>
     *            The configuration for a custom domain that hosts the sign-up
     *            and sign-in pages for your application. Use this object to
     *            specify an SSL certificate that is managed by ACM.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public UpdateUserPoolDomainRequest withCustomDomainConfig(
            CustomDomainConfigType customDomainConfig) {
        this.customDomainConfig = customDomainConfig;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null)
            sb.append("Domain: " + getDomain() + ",");
        if (getUserPoolId() != null)
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        if (getCustomDomainConfig() != null)
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getDomain() == null) ? 0 : getDomain().hashCode());
        hashCode = prime * hashCode + ((getUserPoolId() == null) ? 0 : getUserPoolId().hashCode());
        hashCode = prime * hashCode
                + ((getCustomDomainConfig() == null) ? 0 : getCustomDomainConfig().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UpdateUserPoolDomainRequest == false)
            return false;
        UpdateUserPoolDomainRequest other = (UpdateUserPoolDomainRequest) obj;

        if (other.getDomain() == null ^ this.getDomain() == null)
            return false;
        if (other.getDomain() != null && other.getDomain().equals(this.getDomain()) == false)
            return false;
        if (other.getUserPoolId() == null ^ this.getUserPoolId() == null)
            return false;
        if (other.getUserPoolId() != null
                && other.getUserPoolId().equals(this.getUserPoolId()) == false)
            return false;
        if (other.getCustomDomainConfig() == null ^ this.getCustomDomainConfig() == null)
            return false;
        if (other.getCustomDomainConfig() != null
                && other.getCustomDomainConfig().equals(this.getCustomDomainConfig()) == false)
            return false;
        return true;
    }
}
