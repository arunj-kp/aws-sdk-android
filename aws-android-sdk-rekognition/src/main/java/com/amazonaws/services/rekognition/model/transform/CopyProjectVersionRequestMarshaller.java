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

package com.amazonaws.services.rekognition.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

import android.text.TextUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;

/**
 * JSON request marshaller for CopyProjectVersionRequest
 */
public class CopyProjectVersionRequestMarshaller implements
        Marshaller<Request<CopyProjectVersionRequest>, CopyProjectVersionRequest> {

    public Request<CopyProjectVersionRequest> marshall(
            CopyProjectVersionRequest copyProjectVersionRequest) {
        if (copyProjectVersionRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(CopyProjectVersionRequest)");
        }

        Request<CopyProjectVersionRequest> request = new DefaultRequest<CopyProjectVersionRequest>(
                copyProjectVersionRequest, "AmazonRekognition");
        String target = "RekognitionService.CopyProjectVersion";
        request.addHeader("X-Amz-Target", target);
        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/";
        request.setResourcePath(uriResourcePath);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();

            if (copyProjectVersionRequest.getSourceProjectArn() != null) {
                String sourceProjectArn = copyProjectVersionRequest.getSourceProjectArn();
                jsonWriter.name("SourceProjectArn");
                jsonWriter.value(sourceProjectArn);
            }
            if (copyProjectVersionRequest.getSourceProjectVersionArn() != null) {
                String sourceProjectVersionArn = copyProjectVersionRequest
                        .getSourceProjectVersionArn();
                jsonWriter.name("SourceProjectVersionArn");
                jsonWriter.value(sourceProjectVersionArn);
            }
            if (copyProjectVersionRequest.getDestinationProjectArn() != null) {
                String destinationProjectArn = copyProjectVersionRequest.getDestinationProjectArn();
                jsonWriter.name("DestinationProjectArn");
                jsonWriter.value(destinationProjectArn);
            }
            if (copyProjectVersionRequest.getVersionName() != null) {
                String versionName = copyProjectVersionRequest.getVersionName();
                jsonWriter.name("VersionName");
                jsonWriter.value(versionName);
            }
            if (copyProjectVersionRequest.getOutputConfig() != null) {
                OutputConfig outputConfig = copyProjectVersionRequest.getOutputConfig();
                jsonWriter.name("OutputConfig");
                OutputConfigJsonMarshaller.getInstance().marshall(outputConfig, jsonWriter);
            }
            if (copyProjectVersionRequest.getTags() != null) {
                java.util.Map<String, String> tags = copyProjectVersionRequest.getTags();
                jsonWriter.name("Tags");
                jsonWriter.beginObject();
                for (java.util.Map.Entry<String, String> tagsEntry : tags.entrySet()) {
                    String tagsValue = tagsEntry.getValue();
                    if (tagsValue != null) {
                        jsonWriter.name(tagsEntry.getKey());
                        jsonWriter.value(tagsValue);
                    }
                }
                jsonWriter.endObject();
            }
            if (copyProjectVersionRequest.getKmsKeyId() != null) {
                String kmsKeyId = copyProjectVersionRequest.getKmsKeyId();
                jsonWriter.name("KmsKeyId");
                jsonWriter.value(kmsKeyId);
            }

            jsonWriter.endObject();
            jsonWriter.close();
            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", "application/x-amz-json-1.1");
        }

        return request;
    }
}
