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

package com.amazonaws.services.chimesdkmessaging.model;

import java.io.Serializable;

public class DescribeChannelMembershipResult implements Serializable {
    /**
     * <p>
     * The details of the membership.
     * </p>
     */
    private ChannelMembership channelMembership;

    /**
     * <p>
     * The details of the membership.
     * </p>
     *
     * @return <p>
     *         The details of the membership.
     *         </p>
     */
    public ChannelMembership getChannelMembership() {
        return channelMembership;
    }

    /**
     * <p>
     * The details of the membership.
     * </p>
     *
     * @param channelMembership <p>
     *            The details of the membership.
     *            </p>
     */
    public void setChannelMembership(ChannelMembership channelMembership) {
        this.channelMembership = channelMembership;
    }

    /**
     * <p>
     * The details of the membership.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param channelMembership <p>
     *            The details of the membership.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public DescribeChannelMembershipResult withChannelMembership(ChannelMembership channelMembership) {
        this.channelMembership = channelMembership;
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
        if (getChannelMembership() != null)
            sb.append("ChannelMembership: " + getChannelMembership());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getChannelMembership() == null) ? 0 : getChannelMembership().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeChannelMembershipResult == false)
            return false;
        DescribeChannelMembershipResult other = (DescribeChannelMembershipResult) obj;

        if (other.getChannelMembership() == null ^ this.getChannelMembership() == null)
            return false;
        if (other.getChannelMembership() != null
                && other.getChannelMembership().equals(this.getChannelMembership()) == false)
            return false;
        return true;
    }
}
