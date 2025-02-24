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

package com.amazonaws.services.sns.model;

import java.io.Serializable;

/**
 * <p>
 * Response for Publish action.
 * </p>
 */
public class PublishResult implements Serializable {
    /**
     * <p>
     * Unique identifier assigned to the published message.
     * </p>
     * <p>
     * Length Constraint: Maximum 100 characters
     * </p>
     */
    private String messageId;

    /**
     * <p>
     * This response element applies only to FIFO (first-in-first-out) topics.
     * </p>
     * <p>
     * The sequence number is a large, non-consecutive number that Amazon SNS
     * assigns to each message. The length of <code>SequenceNumber</code> is 128
     * bits. <code>SequenceNumber</code> continues to increase for each
     * <code>MessageGroupId</code>.
     * </p>
     */
    private String sequenceNumber;

    /**
     * <p>
     * Unique identifier assigned to the published message.
     * </p>
     * <p>
     * Length Constraint: Maximum 100 characters
     * </p>
     *
     * @return <p>
     *         Unique identifier assigned to the published message.
     *         </p>
     *         <p>
     *         Length Constraint: Maximum 100 characters
     *         </p>
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * <p>
     * Unique identifier assigned to the published message.
     * </p>
     * <p>
     * Length Constraint: Maximum 100 characters
     * </p>
     *
     * @param messageId <p>
     *            Unique identifier assigned to the published message.
     *            </p>
     *            <p>
     *            Length Constraint: Maximum 100 characters
     *            </p>
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * <p>
     * Unique identifier assigned to the published message.
     * </p>
     * <p>
     * Length Constraint: Maximum 100 characters
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param messageId <p>
     *            Unique identifier assigned to the published message.
     *            </p>
     *            <p>
     *            Length Constraint: Maximum 100 characters
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public PublishResult withMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    /**
     * <p>
     * This response element applies only to FIFO (first-in-first-out) topics.
     * </p>
     * <p>
     * The sequence number is a large, non-consecutive number that Amazon SNS
     * assigns to each message. The length of <code>SequenceNumber</code> is 128
     * bits. <code>SequenceNumber</code> continues to increase for each
     * <code>MessageGroupId</code>.
     * </p>
     *
     * @return <p>
     *         This response element applies only to FIFO (first-in-first-out)
     *         topics.
     *         </p>
     *         <p>
     *         The sequence number is a large, non-consecutive number that
     *         Amazon SNS assigns to each message. The length of
     *         <code>SequenceNumber</code> is 128 bits.
     *         <code>SequenceNumber</code> continues to increase for each
     *         <code>MessageGroupId</code>.
     *         </p>
     */
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * <p>
     * This response element applies only to FIFO (first-in-first-out) topics.
     * </p>
     * <p>
     * The sequence number is a large, non-consecutive number that Amazon SNS
     * assigns to each message. The length of <code>SequenceNumber</code> is 128
     * bits. <code>SequenceNumber</code> continues to increase for each
     * <code>MessageGroupId</code>.
     * </p>
     *
     * @param sequenceNumber <p>
     *            This response element applies only to FIFO
     *            (first-in-first-out) topics.
     *            </p>
     *            <p>
     *            The sequence number is a large, non-consecutive number that
     *            Amazon SNS assigns to each message. The length of
     *            <code>SequenceNumber</code> is 128 bits.
     *            <code>SequenceNumber</code> continues to increase for each
     *            <code>MessageGroupId</code>.
     *            </p>
     */
    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * <p>
     * This response element applies only to FIFO (first-in-first-out) topics.
     * </p>
     * <p>
     * The sequence number is a large, non-consecutive number that Amazon SNS
     * assigns to each message. The length of <code>SequenceNumber</code> is 128
     * bits. <code>SequenceNumber</code> continues to increase for each
     * <code>MessageGroupId</code>.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     *
     * @param sequenceNumber <p>
     *            This response element applies only to FIFO
     *            (first-in-first-out) topics.
     *            </p>
     *            <p>
     *            The sequence number is a large, non-consecutive number that
     *            Amazon SNS assigns to each message. The length of
     *            <code>SequenceNumber</code> is 128 bits.
     *            <code>SequenceNumber</code> continues to increase for each
     *            <code>MessageGroupId</code>.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public PublishResult withSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
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
        if (getMessageId() != null)
            sb.append("MessageId: " + getMessageId() + ",");
        if (getSequenceNumber() != null)
            sb.append("SequenceNumber: " + getSequenceNumber());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        hashCode = prime * hashCode
                + ((getSequenceNumber() == null) ? 0 : getSequenceNumber().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof PublishResult == false)
            return false;
        PublishResult other = (PublishResult) obj;

        if (other.getMessageId() == null ^ this.getMessageId() == null)
            return false;
        if (other.getMessageId() != null
                && other.getMessageId().equals(this.getMessageId()) == false)
            return false;
        if (other.getSequenceNumber() == null ^ this.getSequenceNumber() == null)
            return false;
        if (other.getSequenceNumber() != null
                && other.getSequenceNumber().equals(this.getSequenceNumber()) == false)
            return false;
        return true;
    }
}
