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

package com.amazonaws.services.iot.model.transform;

import com.amazonaws.services.iot.model.*;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

/**
 * JSON unmarshaller for POJO TopicRuleListItem
 */
class TopicRuleListItemJsonUnmarshaller implements
        Unmarshaller<TopicRuleListItem, JsonUnmarshallerContext> {

    public TopicRuleListItem unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        TopicRuleListItem topicRuleListItem = new TopicRuleListItem();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("ruleArn")) {
                topicRuleListItem.setRuleArn(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("ruleName")) {
                topicRuleListItem.setRuleName(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("topicPattern")) {
                topicRuleListItem.setTopicPattern(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("createdAt")) {
                topicRuleListItem.setCreatedAt(DateJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("ruleDisabled")) {
                topicRuleListItem.setRuleDisabled(BooleanJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return topicRuleListItem;
    }

    private static TopicRuleListItemJsonUnmarshaller instance;

    public static TopicRuleListItemJsonUnmarshaller getInstance() {
        if (instance == null)
            instance = new TopicRuleListItemJsonUnmarshaller();
        return instance;
    }
}
