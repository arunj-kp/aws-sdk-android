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

package com.amazonaws.services.connect;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import com.amazonaws.services.connect.model.*;

/**
 * Interface for accessing Amazon Connect asynchronously.
 * <p>
 * Amazon Connect is a cloud-based contact center solution that you use to set
 * up and manage a customer contact center and provide reliable customer
 * engagement at any scale.
 * </p>
 * <p>
 * Amazon Connect provides metrics and real-time reporting that enable you to
 * optimize contact routing. You can also resolve customer issues more
 * efficiently by getting customers in touch with the appropriate agents.
 * </p>
 * <p>
 * There are limits to the number of Amazon Connect resources that you can
 * create. There are also limits to the number of requests that you can make per
 * second. For more information, see <a href=
 * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html"
 * >Amazon Connect Service Quotas</a> in the <i>Amazon Connect Administrator
 * Guide</i>.
 * </p>
 * <p>
 * You can connect programmatically to an Amazon Web Services service by using
 * an endpoint. For a list of Amazon Connect endpoints, see <a
 * href="https://docs.aws.amazon.com/general/latest/gr/connect_region.html"
 * >Amazon Connect Endpoints</a>.
 * </p>
 * <note>
 * <p>
 * Working with flows? Check out the <a href=
 * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
 * >Amazon Connect Flow language</a>.
 * </p>
 * </note>
 **/
public class AmazonConnectAsyncClient extends AmazonConnectClient implements AmazonConnectAsync {

    /**
     * Executor service for executing asynchronous requests.
     */
    private ExecutorService executorService;

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect. A credentials provider chain will be used that searches for
     * credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AmazonConnectAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect. A credentials provider chain will be used that searches for
     * credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling
     *            how this client connects to Amazon Connect (ex: proxy
     *            settings, retry counts, etc.).
     * @see DefaultAWSCredentialsProviderChain
     */
    @Deprecated
    public AmazonConnectAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors
                .newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials. Default client
     * settings will be used, and a fixed size thread pool will be created for
     * executing the asynchronous tasks.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key)
     *            to use when authenticating with AWS services.
     */
    public AmazonConnectAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials and executor service.
     * Default client settings will be used.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key)
     *            to use when authenticating with AWS services.
     * @param executorService The executor service by which all asynchronous
     *            requests will be executed.
     */
    public AmazonConnectAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
        super(awsCredentials);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials, executor service,
     * and client configuration options.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key)
     *            to use when authenticating with AWS services.
     * @param clientConfiguration Client configuration options (ex: max retry
     *            limit, proxy settings, etc).
     * @param executorService The executor service by which all asynchronous
     *            requests will be executed.
     */
    public AmazonConnectAsyncClient(AWSCredentials awsCredentials,
            ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials provider. Default
     * client settings will be used, and a fixed size thread pool will be
     * created for executing the asynchronous tasks.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     */
    public AmazonConnectAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials provider and executor
     * service. Default client settings will be used.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param executorService The executor service by which all asynchronous
     *            requests will be executed.
     */
    public AmazonConnectAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
            ExecutorService executorService) {
        this(awsCredentialsProvider, new ClientConfiguration(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials provider and client
     * configuration options.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param clientConfiguration Client configuration options (ex: max retry
     *            limit, proxy settings, etc).
     */
    public AmazonConnectAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, Executors
                .newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * Connect using the specified AWS account credentials provider, executor
     * service, and client configuration options.
     * <p>
     * All calls made using this new client object are non-blocking, and will
     * immediately return a Java Future object that the caller can later check
     * to see if the service call has actually completed.
     *
     * @param awsCredentialsProvider The AWS credentials provider which will
     *            provide credentials to authenticate requests with AWS
     *            services.
     * @param clientConfiguration Client configuration options (ex: max retry
     *            limit, proxy settings, etc).
     * @param executorService The executor service by which all asynchronous
     *            requests will be executed.
     */
    public AmazonConnectAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Returns the executor service used by this async client to execute
     * requests.
     *
     * @return The executor service used by this async client to execute
     *         requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call getExecutorService().shutdown() followed by
     * getExecutorService().awaitTermination() prior to calling this method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates an approved origin to an Amazon Connect instance.
     * </p>
     * 
     * @param associateApprovedOriginRequest
     * @return A Java Future object containing the response from the
     *         AssociateApprovedOrigin service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateApprovedOriginAsync(
            final AssociateApprovedOriginRequest associateApprovedOriginRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateApprovedOrigin(associateApprovedOriginRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates an approved origin to an Amazon Connect instance.
     * </p>
     * 
     * @param associateApprovedOriginRequest
     * @return A Java Future object containing the response from the
     *         AssociateApprovedOrigin service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateApprovedOriginAsync(
            final AssociateApprovedOriginRequest associateApprovedOriginRequest,
            final AsyncHandler<AssociateApprovedOriginRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateApprovedOrigin(associateApprovedOriginRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateApprovedOriginRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Amazon Lex or Amazon Lex V2 bot.
     * </p>
     * 
     * @param associateBotRequest
     * @return A Java Future object containing the response from the
     *         AssociateBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateBotAsync(final AssociateBotRequest associateBotRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateBot(associateBotRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Amazon Lex or Amazon Lex V2 bot.
     * </p>
     * 
     * @param associateBotRequest
     * @return A Java Future object containing the response from the
     *         AssociateBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws LimitExceededException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateBotAsync(final AssociateBotRequest associateBotRequest,
            final AsyncHandler<AssociateBotRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateBot(associateBotRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateBotRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Associates an existing vocabulary as the default. Contact Lens for Amazon
     * Connect uses the vocabulary in post-call and real-time analysis sessions
     * for the given language.
     * </p>
     * 
     * @param associateDefaultVocabularyRequest
     * @return A Java Future object containing the response from the
     *         AssociateDefaultVocabulary service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateDefaultVocabularyResult> associateDefaultVocabularyAsync(
            final AssociateDefaultVocabularyRequest associateDefaultVocabularyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateDefaultVocabularyResult>() {
            public AssociateDefaultVocabularyResult call() throws Exception {
                return associateDefaultVocabulary(associateDefaultVocabularyRequest);
            }
        });
    }

    /**
     * <p>
     * Associates an existing vocabulary as the default. Contact Lens for Amazon
     * Connect uses the vocabulary in post-call and real-time analysis sessions
     * for the given language.
     * </p>
     * 
     * @param associateDefaultVocabularyRequest
     * @return A Java Future object containing the response from the
     *         AssociateDefaultVocabulary service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateDefaultVocabularyResult> associateDefaultVocabularyAsync(
            final AssociateDefaultVocabularyRequest associateDefaultVocabularyRequest,
            final AsyncHandler<AssociateDefaultVocabularyRequest, AssociateDefaultVocabularyResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateDefaultVocabularyResult>() {
            public AssociateDefaultVocabularyResult call() throws Exception {
                AssociateDefaultVocabularyResult result = null;
                try {
                    result = associateDefaultVocabulary(associateDefaultVocabularyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateDefaultVocabularyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a storage resource type for the first time. You can only
     * associate one type of storage configuration in a single call. This means,
     * for example, that you can't define an instance with multiple S3 buckets
     * for storing chat transcripts.
     * </p>
     * <p>
     * This API does not create a resource that doesn't exist. It only
     * associates it to the instance. Ensure that the resource being specified
     * in the storage configuration, like an S3 bucket, exists when being used
     * for association.
     * </p>
     * 
     * @param associateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         AssociateInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateInstanceStorageConfigResult> associateInstanceStorageConfigAsync(
            final AssociateInstanceStorageConfigRequest associateInstanceStorageConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateInstanceStorageConfigResult>() {
            public AssociateInstanceStorageConfigResult call() throws Exception {
                return associateInstanceStorageConfig(associateInstanceStorageConfigRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a storage resource type for the first time. You can only
     * associate one type of storage configuration in a single call. This means,
     * for example, that you can't define an instance with multiple S3 buckets
     * for storing chat transcripts.
     * </p>
     * <p>
     * This API does not create a resource that doesn't exist. It only
     * associates it to the instance. Ensure that the resource being specified
     * in the storage configuration, like an S3 bucket, exists when being used
     * for association.
     * </p>
     * 
     * @param associateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         AssociateInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateInstanceStorageConfigResult> associateInstanceStorageConfigAsync(
            final AssociateInstanceStorageConfigRequest associateInstanceStorageConfigRequest,
            final AsyncHandler<AssociateInstanceStorageConfigRequest, AssociateInstanceStorageConfigResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateInstanceStorageConfigResult>() {
            public AssociateInstanceStorageConfigResult call() throws Exception {
                AssociateInstanceStorageConfigResult result = null;
                try {
                    result = associateInstanceStorageConfig(associateInstanceStorageConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateInstanceStorageConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Lambda function.
     * </p>
     * 
     * @param associateLambdaFunctionRequest
     * @return A Java Future object containing the response from the
     *         AssociateLambdaFunction service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateLambdaFunctionAsync(
            final AssociateLambdaFunctionRequest associateLambdaFunctionRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateLambdaFunction(associateLambdaFunctionRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Lambda function.
     * </p>
     * 
     * @param associateLambdaFunctionRequest
     * @return A Java Future object containing the response from the
     *         AssociateLambdaFunction service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateLambdaFunctionAsync(
            final AssociateLambdaFunctionRequest associateLambdaFunctionRequest,
            final AsyncHandler<AssociateLambdaFunctionRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateLambdaFunction(associateLambdaFunctionRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateLambdaFunctionRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Amazon Lex bot.
     * </p>
     * 
     * @param associateLexBotRequest
     * @return A Java Future object containing the response from the
     *         AssociateLexBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateLexBotAsync(final AssociateLexBotRequest associateLexBotRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateLexBot(associateLexBotRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Allows the specified Amazon Connect instance to access the specified
     * Amazon Lex bot.
     * </p>
     * 
     * @param associateLexBotRequest
     * @return A Java Future object containing the response from the
     *         AssociateLexBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateLexBotAsync(final AssociateLexBotRequest associateLexBotRequest,
            final AsyncHandler<AssociateLexBotRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateLexBot(associateLexBotRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateLexBotRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Associates a flow with a phone number claimed to your Amazon Connect
     * instance.
     * </p>
     * 
     * @param associatePhoneNumberContactFlowRequest
     * @return A Java Future object containing the response from the
     *         AssociatePhoneNumberContactFlow service method, as returned by
     *         Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associatePhoneNumberContactFlowAsync(
            final AssociatePhoneNumberContactFlowRequest associatePhoneNumberContactFlowRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associatePhoneNumberContactFlow(associatePhoneNumberContactFlowRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Associates a flow with a phone number claimed to your Amazon Connect
     * instance.
     * </p>
     * 
     * @param associatePhoneNumberContactFlowRequest
     * @return A Java Future object containing the response from the
     *         AssociatePhoneNumberContactFlow service method, as returned by
     *         Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associatePhoneNumberContactFlowAsync(
            final AssociatePhoneNumberContactFlowRequest associatePhoneNumberContactFlowRequest,
            final AsyncHandler<AssociatePhoneNumberContactFlowRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associatePhoneNumberContactFlow(associatePhoneNumberContactFlowRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associatePhoneNumberContactFlowRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a set of quick connects with a queue.
     * </p>
     * 
     * @param associateQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         AssociateQueueQuickConnects service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateQueueQuickConnectsAsync(
            final AssociateQueueQuickConnectsRequest associateQueueQuickConnectsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateQueueQuickConnects(associateQueueQuickConnectsRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a set of quick connects with a queue.
     * </p>
     * 
     * @param associateQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         AssociateQueueQuickConnects service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateQueueQuickConnectsAsync(
            final AssociateQueueQuickConnectsRequest associateQueueQuickConnectsRequest,
            final AsyncHandler<AssociateQueueQuickConnectsRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateQueueQuickConnects(associateQueueQuickConnectsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateQueueQuickConnectsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Associates a set of queues with a routing profile.
     * </p>
     * 
     * @param associateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         AssociateRoutingProfileQueues service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateRoutingProfileQueuesAsync(
            final AssociateRoutingProfileQueuesRequest associateRoutingProfileQueuesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                associateRoutingProfileQueues(associateRoutingProfileQueuesRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Associates a set of queues with a routing profile.
     * </p>
     * 
     * @param associateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         AssociateRoutingProfileQueues service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> associateRoutingProfileQueuesAsync(
            final AssociateRoutingProfileQueuesRequest associateRoutingProfileQueuesRequest,
            final AsyncHandler<AssociateRoutingProfileQueuesRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    associateRoutingProfileQueues(associateRoutingProfileQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateRoutingProfileQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a security key to the instance.
     * </p>
     * 
     * @param associateSecurityKeyRequest
     * @return A Java Future object containing the response from the
     *         AssociateSecurityKey service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateSecurityKeyResult> associateSecurityKeyAsync(
            final AssociateSecurityKeyRequest associateSecurityKeyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateSecurityKeyResult>() {
            public AssociateSecurityKeyResult call() throws Exception {
                return associateSecurityKey(associateSecurityKeyRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Associates a security key to the instance.
     * </p>
     * 
     * @param associateSecurityKeyRequest
     * @return A Java Future object containing the response from the
     *         AssociateSecurityKey service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws ResourceConflictException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<AssociateSecurityKeyResult> associateSecurityKeyAsync(
            final AssociateSecurityKeyRequest associateSecurityKeyRequest,
            final AsyncHandler<AssociateSecurityKeyRequest, AssociateSecurityKeyResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AssociateSecurityKeyResult>() {
            public AssociateSecurityKeyResult call() throws Exception {
                AssociateSecurityKeyResult result = null;
                try {
                    result = associateSecurityKey(associateSecurityKeyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(associateSecurityKeyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Claims an available phone number to your Amazon Connect instance.
     * </p>
     * 
     * @param claimPhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         ClaimPhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ClaimPhoneNumberResult> claimPhoneNumberAsync(
            final ClaimPhoneNumberRequest claimPhoneNumberRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ClaimPhoneNumberResult>() {
            public ClaimPhoneNumberResult call() throws Exception {
                return claimPhoneNumber(claimPhoneNumberRequest);
            }
        });
    }

    /**
     * <p>
     * Claims an available phone number to your Amazon Connect instance.
     * </p>
     * 
     * @param claimPhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         ClaimPhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ClaimPhoneNumberResult> claimPhoneNumberAsync(
            final ClaimPhoneNumberRequest claimPhoneNumberRequest,
            final AsyncHandler<ClaimPhoneNumberRequest, ClaimPhoneNumberResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ClaimPhoneNumberResult>() {
            public ClaimPhoneNumberResult call() throws Exception {
                ClaimPhoneNumberResult result = null;
                try {
                    result = claimPhoneNumber(claimPhoneNumberRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(claimPhoneNumberRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates an agent status for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         CreateAgentStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateAgentStatusResult> createAgentStatusAsync(
            final CreateAgentStatusRequest createAgentStatusRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<CreateAgentStatusResult>() {
            public CreateAgentStatusResult call() throws Exception {
                return createAgentStatus(createAgentStatusRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates an agent status for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         CreateAgentStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateAgentStatusResult> createAgentStatusAsync(
            final CreateAgentStatusRequest createAgentStatusRequest,
            final AsyncHandler<CreateAgentStatusRequest, CreateAgentStatusResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateAgentStatusResult>() {
            public CreateAgentStatusResult call() throws Exception {
                CreateAgentStatusResult result = null;
                try {
                    result = createAgentStatus(createAgentStatusRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createAgentStatusRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a flow for the specified Amazon Connect instance.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param createContactFlowRequest
     * @return A Java Future object containing the response from the
     *         CreateContactFlow service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidContactFlowException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateContactFlowResult> createContactFlowAsync(
            final CreateContactFlowRequest createContactFlowRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<CreateContactFlowResult>() {
            public CreateContactFlowResult call() throws Exception {
                return createContactFlow(createContactFlowRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a flow for the specified Amazon Connect instance.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param createContactFlowRequest
     * @return A Java Future object containing the response from the
     *         CreateContactFlow service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidContactFlowException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateContactFlowResult> createContactFlowAsync(
            final CreateContactFlowRequest createContactFlowRequest,
            final AsyncHandler<CreateContactFlowRequest, CreateContactFlowResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateContactFlowResult>() {
            public CreateContactFlowResult call() throws Exception {
                CreateContactFlowResult result = null;
                try {
                    result = createContactFlow(createContactFlowRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createContactFlowRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a flow module for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         CreateContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidContactFlowModuleException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws IdempotencyException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateContactFlowModuleResult> createContactFlowModuleAsync(
            final CreateContactFlowModuleRequest createContactFlowModuleRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateContactFlowModuleResult>() {
            public CreateContactFlowModuleResult call() throws Exception {
                return createContactFlowModule(createContactFlowModuleRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a flow module for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         CreateContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidContactFlowModuleException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws IdempotencyException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateContactFlowModuleResult> createContactFlowModuleAsync(
            final CreateContactFlowModuleRequest createContactFlowModuleRequest,
            final AsyncHandler<CreateContactFlowModuleRequest, CreateContactFlowModuleResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateContactFlowModuleResult>() {
            public CreateContactFlowModuleResult call() throws Exception {
                CreateContactFlowModuleResult result = null;
                try {
                    result = createContactFlowModule(createContactFlowModuleRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createContactFlowModuleRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates hours of operation.
     * </p>
     * 
     * @param createHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         CreateHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateHoursOfOperationResult> createHoursOfOperationAsync(
            final CreateHoursOfOperationRequest createHoursOfOperationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateHoursOfOperationResult>() {
            public CreateHoursOfOperationResult call() throws Exception {
                return createHoursOfOperation(createHoursOfOperationRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates hours of operation.
     * </p>
     * 
     * @param createHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         CreateHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateHoursOfOperationResult> createHoursOfOperationAsync(
            final CreateHoursOfOperationRequest createHoursOfOperationRequest,
            final AsyncHandler<CreateHoursOfOperationRequest, CreateHoursOfOperationResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateHoursOfOperationResult>() {
            public CreateHoursOfOperationResult call() throws Exception {
                CreateHoursOfOperationResult result = null;
                try {
                    result = createHoursOfOperation(createHoursOfOperationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createHoursOfOperationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Initiates an Amazon Connect instance with all the supported channels
     * enabled. It does not attach any storage, such as Amazon Simple Storage
     * Service (Amazon S3) or Amazon Kinesis. It also does not allow for any
     * configurations on features, such as Contact Lens for Amazon Connect.
     * </p>
     * <p>
     * Amazon Connect enforces a limit on the total number of instances that you
     * can create or delete in 30 days. If you exceed this limit, you will get
     * an error message indicating there has been an excessive number of
     * attempts at creating or deleting instances. You must wait 30 days before
     * you can restart creating and deleting instances in your account.
     * </p>
     * 
     * @param createInstanceRequest
     * @return A Java Future object containing the response from the
     *         CreateInstance service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateInstanceResult> createInstanceAsync(
            final CreateInstanceRequest createInstanceRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<CreateInstanceResult>() {
            public CreateInstanceResult call() throws Exception {
                return createInstance(createInstanceRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Initiates an Amazon Connect instance with all the supported channels
     * enabled. It does not attach any storage, such as Amazon Simple Storage
     * Service (Amazon S3) or Amazon Kinesis. It also does not allow for any
     * configurations on features, such as Contact Lens for Amazon Connect.
     * </p>
     * <p>
     * Amazon Connect enforces a limit on the total number of instances that you
     * can create or delete in 30 days. If you exceed this limit, you will get
     * an error message indicating there has been an excessive number of
     * attempts at creating or deleting instances. You must wait 30 days before
     * you can restart creating and deleting instances in your account.
     * </p>
     * 
     * @param createInstanceRequest
     * @return A Java Future object containing the response from the
     *         CreateInstance service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateInstanceResult> createInstanceAsync(
            final CreateInstanceRequest createInstanceRequest,
            final AsyncHandler<CreateInstanceRequest, CreateInstanceResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateInstanceResult>() {
            public CreateInstanceResult call() throws Exception {
                CreateInstanceResult result = null;
                try {
                    result = createInstance(createInstanceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createInstanceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates an Amazon Web Services resource association with an Amazon
     * Connect instance.
     * </p>
     * 
     * @param createIntegrationAssociationRequest
     * @return A Java Future object containing the response from the
     *         CreateIntegrationAssociation service method, as returned by
     *         Amazon Connect.
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateIntegrationAssociationResult> createIntegrationAssociationAsync(
            final CreateIntegrationAssociationRequest createIntegrationAssociationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateIntegrationAssociationResult>() {
            public CreateIntegrationAssociationResult call() throws Exception {
                return createIntegrationAssociation(createIntegrationAssociationRequest);
            }
        });
    }

    /**
     * <p>
     * Creates an Amazon Web Services resource association with an Amazon
     * Connect instance.
     * </p>
     * 
     * @param createIntegrationAssociationRequest
     * @return A Java Future object containing the response from the
     *         CreateIntegrationAssociation service method, as returned by
     *         Amazon Connect.
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateIntegrationAssociationResult> createIntegrationAssociationAsync(
            final CreateIntegrationAssociationRequest createIntegrationAssociationRequest,
            final AsyncHandler<CreateIntegrationAssociationRequest, CreateIntegrationAssociationResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateIntegrationAssociationResult>() {
            public CreateIntegrationAssociationResult call() throws Exception {
                CreateIntegrationAssociationResult result = null;
                try {
                    result = createIntegrationAssociation(createIntegrationAssociationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createIntegrationAssociationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates a new queue for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createQueueRequest
     * @return A Java Future object containing the response from the CreateQueue
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateQueueResult> createQueueAsync(final CreateQueueRequest createQueueRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateQueueResult>() {
            public CreateQueueResult call() throws Exception {
                return createQueue(createQueueRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates a new queue for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createQueueRequest
     * @return A Java Future object containing the response from the CreateQueue
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateQueueResult> createQueueAsync(final CreateQueueRequest createQueueRequest,
            final AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateQueueResult>() {
            public CreateQueueResult call() throws Exception {
                CreateQueueResult result = null;
                try {
                    result = createQueue(createQueueRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createQueueRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a quick connect for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         CreateQuickConnect service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateQuickConnectResult> createQuickConnectAsync(
            final CreateQuickConnectRequest createQuickConnectRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateQuickConnectResult>() {
            public CreateQuickConnectResult call() throws Exception {
                return createQuickConnect(createQuickConnectRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a quick connect for the specified Amazon Connect instance.
     * </p>
     * 
     * @param createQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         CreateQuickConnect service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateQuickConnectResult> createQuickConnectAsync(
            final CreateQuickConnectRequest createQuickConnectRequest,
            final AsyncHandler<CreateQuickConnectRequest, CreateQuickConnectResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateQuickConnectResult>() {
            public CreateQuickConnectResult call() throws Exception {
                CreateQuickConnectResult result = null;
                try {
                    result = createQuickConnect(createQuickConnectRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createQuickConnectRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a new routing profile.
     * </p>
     * 
     * @param createRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         CreateRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateRoutingProfileResult> createRoutingProfileAsync(
            final CreateRoutingProfileRequest createRoutingProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateRoutingProfileResult>() {
            public CreateRoutingProfileResult call() throws Exception {
                return createRoutingProfile(createRoutingProfileRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a new routing profile.
     * </p>
     * 
     * @param createRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         CreateRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateRoutingProfileResult> createRoutingProfileAsync(
            final CreateRoutingProfileRequest createRoutingProfileRequest,
            final AsyncHandler<CreateRoutingProfileRequest, CreateRoutingProfileResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateRoutingProfileResult>() {
            public CreateRoutingProfileResult call() throws Exception {
                CreateRoutingProfileResult result = null;
                try {
                    result = createRoutingProfile(createRoutingProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createRoutingProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates a security profile.
     * </p>
     * 
     * @param createSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         CreateSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws LimitExceededException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateSecurityProfileResult> createSecurityProfileAsync(
            final CreateSecurityProfileRequest createSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateSecurityProfileResult>() {
            public CreateSecurityProfileResult call() throws Exception {
                return createSecurityProfile(createSecurityProfileRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Creates a security profile.
     * </p>
     * 
     * @param createSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         CreateSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws LimitExceededException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateSecurityProfileResult> createSecurityProfileAsync(
            final CreateSecurityProfileRequest createSecurityProfileRequest,
            final AsyncHandler<CreateSecurityProfileRequest, CreateSecurityProfileResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateSecurityProfileResult>() {
            public CreateSecurityProfileResult call() throws Exception {
                CreateSecurityProfileResult result = null;
                try {
                    result = createSecurityProfile(createSecurityProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createSecurityProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a new task template in the specified Amazon Connect instance.
     * </p>
     * 
     * @param createTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         CreateTaskTemplate service method, as returned by Amazon Connect.
     * @throws PropertyValidationException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateTaskTemplateResult> createTaskTemplateAsync(
            final CreateTaskTemplateRequest createTaskTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateTaskTemplateResult>() {
            public CreateTaskTemplateResult call() throws Exception {
                return createTaskTemplate(createTaskTemplateRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a new task template in the specified Amazon Connect instance.
     * </p>
     * 
     * @param createTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         CreateTaskTemplate service method, as returned by Amazon Connect.
     * @throws PropertyValidationException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateTaskTemplateResult> createTaskTemplateAsync(
            final CreateTaskTemplateRequest createTaskTemplateRequest,
            final AsyncHandler<CreateTaskTemplateRequest, CreateTaskTemplateResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateTaskTemplateResult>() {
            public CreateTaskTemplateResult call() throws Exception {
                CreateTaskTemplateResult result = null;
                try {
                    result = createTaskTemplate(createTaskTemplateRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createTaskTemplateRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a use case for an integration association.
     * </p>
     * 
     * @param createUseCaseRequest
     * @return A Java Future object containing the response from the
     *         CreateUseCase service method, as returned by Amazon Connect.
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUseCaseResult> createUseCaseAsync(
            final CreateUseCaseRequest createUseCaseRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<CreateUseCaseResult>() {
            public CreateUseCaseResult call() throws Exception {
                return createUseCase(createUseCaseRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a use case for an integration association.
     * </p>
     * 
     * @param createUseCaseRequest
     * @return A Java Future object containing the response from the
     *         CreateUseCase service method, as returned by Amazon Connect.
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUseCaseResult> createUseCaseAsync(
            final CreateUseCaseRequest createUseCaseRequest,
            final AsyncHandler<CreateUseCaseRequest, CreateUseCaseResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUseCaseResult>() {
            public CreateUseCaseResult call() throws Exception {
                CreateUseCaseResult result = null;
                try {
                    result = createUseCase(createUseCaseRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createUseCaseRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a user account for the specified Amazon Connect instance.
     * </p>
     * <p>
     * For information about how to create user accounts using the Amazon
     * Connect console, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/user-management.html"
     * >Add Users</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param createUserRequest
     * @return A Java Future object containing the response from the CreateUser
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws LimitExceededException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUserResult> createUserAsync(final CreateUserRequest createUserRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserResult>() {
            public CreateUserResult call() throws Exception {
                return createUser(createUserRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a user account for the specified Amazon Connect instance.
     * </p>
     * <p>
     * For information about how to create user accounts using the Amazon
     * Connect console, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/user-management.html"
     * >Add Users</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param createUserRequest
     * @return A Java Future object containing the response from the CreateUser
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws LimitExceededException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUserResult> createUserAsync(final CreateUserRequest createUserRequest,
            final AsyncHandler<CreateUserRequest, CreateUserResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserResult>() {
            public CreateUserResult call() throws Exception {
                CreateUserResult result = null;
                try {
                    result = createUser(createUserRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createUserRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a new user hierarchy group.
     * </p>
     * 
     * @param createUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         CreateUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUserHierarchyGroupResult> createUserHierarchyGroupAsync(
            final CreateUserHierarchyGroupRequest createUserHierarchyGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserHierarchyGroupResult>() {
            public CreateUserHierarchyGroupResult call() throws Exception {
                return createUserHierarchyGroup(createUserHierarchyGroupRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a new user hierarchy group.
     * </p>
     * 
     * @param createUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         CreateUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateUserHierarchyGroupResult> createUserHierarchyGroupAsync(
            final CreateUserHierarchyGroupRequest createUserHierarchyGroupRequest,
            final AsyncHandler<CreateUserHierarchyGroupRequest, CreateUserHierarchyGroupResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateUserHierarchyGroupResult>() {
            public CreateUserHierarchyGroupResult call() throws Exception {
                CreateUserHierarchyGroupResult result = null;
                try {
                    result = createUserHierarchyGroup(createUserHierarchyGroupRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createUserHierarchyGroupRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates a custom vocabulary associated with your Amazon Connect instance.
     * You can set a custom vocabulary to be your default vocabulary for a given
     * language. Contact Lens for Amazon Connect uses the default vocabulary in
     * post-call and real-time contact analysis sessions for that language.
     * </p>
     * 
     * @param createVocabularyRequest
     * @return A Java Future object containing the response from the
     *         CreateVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws ResourceConflictException
     * @throws ServiceQuotaExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateVocabularyResult> createVocabularyAsync(
            final CreateVocabularyRequest createVocabularyRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<CreateVocabularyResult>() {
            public CreateVocabularyResult call() throws Exception {
                return createVocabulary(createVocabularyRequest);
            }
        });
    }

    /**
     * <p>
     * Creates a custom vocabulary associated with your Amazon Connect instance.
     * You can set a custom vocabulary to be your default vocabulary for a given
     * language. Contact Lens for Amazon Connect uses the default vocabulary in
     * post-call and real-time contact analysis sessions for that language.
     * </p>
     * 
     * @param createVocabularyRequest
     * @return A Java Future object containing the response from the
     *         CreateVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws ResourceConflictException
     * @throws ServiceQuotaExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<CreateVocabularyResult> createVocabularyAsync(
            final CreateVocabularyRequest createVocabularyRequest,
            final AsyncHandler<CreateVocabularyRequest, CreateVocabularyResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateVocabularyResult>() {
            public CreateVocabularyResult call() throws Exception {
                CreateVocabularyResult result = null;
                try {
                    result = createVocabulary(createVocabularyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(createVocabularyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes a flow for the specified Amazon Connect instance.
     * </p>
     * 
     * @param deleteContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DeleteContactFlow service method, as returned by Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteContactFlowAsync(
            final DeleteContactFlowRequest deleteContactFlowRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteContactFlow(deleteContactFlowRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes a flow for the specified Amazon Connect instance.
     * </p>
     * 
     * @param deleteContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DeleteContactFlow service method, as returned by Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteContactFlowAsync(
            final DeleteContactFlowRequest deleteContactFlowRequest,
            final AsyncHandler<DeleteContactFlowRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteContactFlow(deleteContactFlowRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteContactFlowRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes the specified flow module.
     * </p>
     * 
     * @param deleteContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         DeleteContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteContactFlowModuleResult> deleteContactFlowModuleAsync(
            final DeleteContactFlowModuleRequest deleteContactFlowModuleRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteContactFlowModuleResult>() {
            public DeleteContactFlowModuleResult call() throws Exception {
                return deleteContactFlowModule(deleteContactFlowModuleRequest);
            }
        });
    }

    /**
     * <p>
     * Deletes the specified flow module.
     * </p>
     * 
     * @param deleteContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         DeleteContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteContactFlowModuleResult> deleteContactFlowModuleAsync(
            final DeleteContactFlowModuleRequest deleteContactFlowModuleRequest,
            final AsyncHandler<DeleteContactFlowModuleRequest, DeleteContactFlowModuleResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteContactFlowModuleResult>() {
            public DeleteContactFlowModuleResult call() throws Exception {
                DeleteContactFlowModuleResult result = null;
                try {
                    result = deleteContactFlowModule(deleteContactFlowModuleRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteContactFlowModuleRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes an hours of operation.
     * </p>
     * 
     * @param deleteHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         DeleteHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteHoursOfOperationAsync(
            final DeleteHoursOfOperationRequest deleteHoursOfOperationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteHoursOfOperation(deleteHoursOfOperationRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes an hours of operation.
     * </p>
     * 
     * @param deleteHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         DeleteHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteHoursOfOperationAsync(
            final DeleteHoursOfOperationRequest deleteHoursOfOperationRequest,
            final AsyncHandler<DeleteHoursOfOperationRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteHoursOfOperation(deleteHoursOfOperationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteHoursOfOperationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes the Amazon Connect instance.
     * </p>
     * <p>
     * Amazon Connect enforces a limit on the total number of instances that you
     * can create or delete in 30 days. If you exceed this limit, you will get
     * an error message indicating there has been an excessive number of
     * attempts at creating or deleting instances. You must wait 30 days before
     * you can restart creating and deleting instances in your account.
     * </p>
     * 
     * @param deleteInstanceRequest
     * @return A Java Future object containing the response from the
     *         DeleteInstance service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteInstanceAsync(final DeleteInstanceRequest deleteInstanceRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteInstance(deleteInstanceRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes the Amazon Connect instance.
     * </p>
     * <p>
     * Amazon Connect enforces a limit on the total number of instances that you
     * can create or delete in 30 days. If you exceed this limit, you will get
     * an error message indicating there has been an excessive number of
     * attempts at creating or deleting instances. You must wait 30 days before
     * you can restart creating and deleting instances in your account.
     * </p>
     * 
     * @param deleteInstanceRequest
     * @return A Java Future object containing the response from the
     *         DeleteInstance service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteInstanceAsync(final DeleteInstanceRequest deleteInstanceRequest,
            final AsyncHandler<DeleteInstanceRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteInstance(deleteInstanceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteInstanceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes an Amazon Web Services resource association from an Amazon
     * Connect instance. The association must not have any use cases associated
     * with it.
     * </p>
     * 
     * @param deleteIntegrationAssociationRequest
     * @return A Java Future object containing the response from the
     *         DeleteIntegrationAssociation service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteIntegrationAssociationAsync(
            final DeleteIntegrationAssociationRequest deleteIntegrationAssociationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteIntegrationAssociation(deleteIntegrationAssociationRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes an Amazon Web Services resource association from an Amazon
     * Connect instance. The association must not have any use cases associated
     * with it.
     * </p>
     * 
     * @param deleteIntegrationAssociationRequest
     * @return A Java Future object containing the response from the
     *         DeleteIntegrationAssociation service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteIntegrationAssociationAsync(
            final DeleteIntegrationAssociationRequest deleteIntegrationAssociationRequest,
            final AsyncHandler<DeleteIntegrationAssociationRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteIntegrationAssociation(deleteIntegrationAssociationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteIntegrationAssociationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes a quick connect.
     * </p>
     * 
     * @param deleteQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         DeleteQuickConnect service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteQuickConnectAsync(
            final DeleteQuickConnectRequest deleteQuickConnectRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteQuickConnect(deleteQuickConnectRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes a quick connect.
     * </p>
     * 
     * @param deleteQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         DeleteQuickConnect service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteQuickConnectAsync(
            final DeleteQuickConnectRequest deleteQuickConnectRequest,
            final AsyncHandler<DeleteQuickConnectRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteQuickConnect(deleteQuickConnectRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteQuickConnectRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes a security profile.
     * </p>
     * 
     * @param deleteSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         DeleteSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws ResourceInUseException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteSecurityProfileAsync(
            final DeleteSecurityProfileRequest deleteSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteSecurityProfile(deleteSecurityProfileRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes a security profile.
     * </p>
     * 
     * @param deleteSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         DeleteSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws ResourceInUseException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteSecurityProfileAsync(
            final DeleteSecurityProfileRequest deleteSecurityProfileRequest,
            final AsyncHandler<DeleteSecurityProfileRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteSecurityProfile(deleteSecurityProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteSecurityProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes the task template.
     * </p>
     * 
     * @param deleteTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         DeleteTaskTemplate service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteTaskTemplateResult> deleteTaskTemplateAsync(
            final DeleteTaskTemplateRequest deleteTaskTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteTaskTemplateResult>() {
            public DeleteTaskTemplateResult call() throws Exception {
                return deleteTaskTemplate(deleteTaskTemplateRequest);
            }
        });
    }

    /**
     * <p>
     * Deletes the task template.
     * </p>
     * 
     * @param deleteTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         DeleteTaskTemplate service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteTaskTemplateResult> deleteTaskTemplateAsync(
            final DeleteTaskTemplateRequest deleteTaskTemplateRequest,
            final AsyncHandler<DeleteTaskTemplateRequest, DeleteTaskTemplateResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteTaskTemplateResult>() {
            public DeleteTaskTemplateResult call() throws Exception {
                DeleteTaskTemplateResult result = null;
                try {
                    result = deleteTaskTemplate(deleteTaskTemplateRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteTaskTemplateRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes a use case from an integration association.
     * </p>
     * 
     * @param deleteUseCaseRequest
     * @return A Java Future object containing the response from the
     *         DeleteUseCase service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUseCaseAsync(final DeleteUseCaseRequest deleteUseCaseRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteUseCase(deleteUseCaseRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes a use case from an integration association.
     * </p>
     * 
     * @param deleteUseCaseRequest
     * @return A Java Future object containing the response from the
     *         DeleteUseCase service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUseCaseAsync(final DeleteUseCaseRequest deleteUseCaseRequest,
            final AsyncHandler<DeleteUseCaseRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteUseCase(deleteUseCaseRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteUseCaseRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes a user account from the specified Amazon Connect instance.
     * </p>
     * <p>
     * For information about what happens to a user's data when their account is
     * deleted, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/delete-users.html"
     * >Delete Users from Your Amazon Connect Instance</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param deleteUserRequest
     * @return A Java Future object containing the response from the DeleteUser
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUserAsync(final DeleteUserRequest deleteUserRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteUser(deleteUserRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes a user account from the specified Amazon Connect instance.
     * </p>
     * <p>
     * For information about what happens to a user's data when their account is
     * deleted, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/delete-users.html"
     * >Delete Users from Your Amazon Connect Instance</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param deleteUserRequest
     * @return A Java Future object containing the response from the DeleteUser
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUserAsync(final DeleteUserRequest deleteUserRequest,
            final AsyncHandler<DeleteUserRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteUser(deleteUserRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteUserRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes an existing user hierarchy group. It must not be associated with
     * any agents or have any active child groups.
     * </p>
     * 
     * @param deleteUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         DeleteUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ResourceInUseException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUserHierarchyGroupAsync(
            final DeleteUserHierarchyGroupRequest deleteUserHierarchyGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteUserHierarchyGroup(deleteUserHierarchyGroupRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Deletes an existing user hierarchy group. It must not be associated with
     * any agents or have any active child groups.
     * </p>
     * 
     * @param deleteUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         DeleteUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ResourceInUseException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> deleteUserHierarchyGroupAsync(
            final DeleteUserHierarchyGroupRequest deleteUserHierarchyGroupRequest,
            final AsyncHandler<DeleteUserHierarchyGroupRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    deleteUserHierarchyGroup(deleteUserHierarchyGroupRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteUserHierarchyGroupRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Deletes the vocabulary that has the given identifier.
     * </p>
     * 
     * @param deleteVocabularyRequest
     * @return A Java Future object containing the response from the
     *         DeleteVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws ResourceInUseException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteVocabularyResult> deleteVocabularyAsync(
            final DeleteVocabularyRequest deleteVocabularyRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<DeleteVocabularyResult>() {
            public DeleteVocabularyResult call() throws Exception {
                return deleteVocabulary(deleteVocabularyRequest);
            }
        });
    }

    /**
     * <p>
     * Deletes the vocabulary that has the given identifier.
     * </p>
     * 
     * @param deleteVocabularyRequest
     * @return A Java Future object containing the response from the
     *         DeleteVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws ResourceInUseException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DeleteVocabularyResult> deleteVocabularyAsync(
            final DeleteVocabularyRequest deleteVocabularyRequest,
            final AsyncHandler<DeleteVocabularyRequest, DeleteVocabularyResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteVocabularyResult>() {
            public DeleteVocabularyResult call() throws Exception {
                DeleteVocabularyResult result = null;
                try {
                    result = deleteVocabulary(deleteVocabularyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(deleteVocabularyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes an agent status.
     * </p>
     * 
     * @param describeAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         DescribeAgentStatus service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeAgentStatusResult> describeAgentStatusAsync(
            final DescribeAgentStatusRequest describeAgentStatusRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAgentStatusResult>() {
            public DescribeAgentStatusResult call() throws Exception {
                return describeAgentStatus(describeAgentStatusRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes an agent status.
     * </p>
     * 
     * @param describeAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         DescribeAgentStatus service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeAgentStatusResult> describeAgentStatusAsync(
            final DescribeAgentStatusRequest describeAgentStatusRequest,
            final AsyncHandler<DescribeAgentStatusRequest, DescribeAgentStatusResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeAgentStatusResult>() {
            public DescribeAgentStatusResult call() throws Exception {
                DescribeAgentStatusResult result = null;
                try {
                    result = describeAgentStatus(describeAgentStatusRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeAgentStatusRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified contact.
     * </p>
     * <important>
     * <p>
     * Contact information remains available in Amazon Connect for 24 months,
     * and then it is deleted.
     * </p>
     * <p>
     * Only data from November 12, 2021, and later is returned by this API.
     * </p>
     * </important>
     * 
     * @param describeContactRequest
     * @return A Java Future object containing the response from the
     *         DescribeContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactResult> describeContactAsync(
            final DescribeContactRequest describeContactRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<DescribeContactResult>() {
            public DescribeContactResult call() throws Exception {
                return describeContact(describeContactRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified contact.
     * </p>
     * <important>
     * <p>
     * Contact information remains available in Amazon Connect for 24 months,
     * and then it is deleted.
     * </p>
     * <p>
     * Only data from November 12, 2021, and later is returned by this API.
     * </p>
     * </important>
     * 
     * @param describeContactRequest
     * @return A Java Future object containing the response from the
     *         DescribeContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactResult> describeContactAsync(
            final DescribeContactRequest describeContactRequest,
            final AsyncHandler<DescribeContactRequest, DescribeContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeContactResult>() {
            public DescribeContactResult call() throws Exception {
                DescribeContactResult result = null;
                try {
                    result = describeContact(describeContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param describeContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DescribeContactFlow service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ContactFlowNotPublishedException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactFlowResult> describeContactFlowAsync(
            final DescribeContactFlowRequest describeContactFlowRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeContactFlowResult>() {
            public DescribeContactFlowResult call() throws Exception {
                return describeContactFlow(describeContactFlowRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param describeContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DescribeContactFlow service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ContactFlowNotPublishedException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactFlowResult> describeContactFlowAsync(
            final DescribeContactFlowRequest describeContactFlowRequest,
            final AsyncHandler<DescribeContactFlowRequest, DescribeContactFlowResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeContactFlowResult>() {
            public DescribeContactFlowResult call() throws Exception {
                DescribeContactFlowResult result = null;
                try {
                    result = describeContactFlow(describeContactFlowRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeContactFlowRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified flow module.
     * </p>
     * 
     * @param describeContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         DescribeContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactFlowModuleResult> describeContactFlowModuleAsync(
            final DescribeContactFlowModuleRequest describeContactFlowModuleRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeContactFlowModuleResult>() {
            public DescribeContactFlowModuleResult call() throws Exception {
                return describeContactFlowModule(describeContactFlowModuleRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified flow module.
     * </p>
     * 
     * @param describeContactFlowModuleRequest
     * @return A Java Future object containing the response from the
     *         DescribeContactFlowModule service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeContactFlowModuleResult> describeContactFlowModuleAsync(
            final DescribeContactFlowModuleRequest describeContactFlowModuleRequest,
            final AsyncHandler<DescribeContactFlowModuleRequest, DescribeContactFlowModuleResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeContactFlowModuleResult>() {
            public DescribeContactFlowModuleResult call() throws Exception {
                DescribeContactFlowModuleResult result = null;
                try {
                    result = describeContactFlowModule(describeContactFlowModuleRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeContactFlowModuleRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the hours of operation.
     * </p>
     * 
     * @param describeHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         DescribeHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeHoursOfOperationResult> describeHoursOfOperationAsync(
            final DescribeHoursOfOperationRequest describeHoursOfOperationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeHoursOfOperationResult>() {
            public DescribeHoursOfOperationResult call() throws Exception {
                return describeHoursOfOperation(describeHoursOfOperationRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the hours of operation.
     * </p>
     * 
     * @param describeHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         DescribeHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeHoursOfOperationResult> describeHoursOfOperationAsync(
            final DescribeHoursOfOperationRequest describeHoursOfOperationRequest,
            final AsyncHandler<DescribeHoursOfOperationRequest, DescribeHoursOfOperationResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeHoursOfOperationResult>() {
            public DescribeHoursOfOperationResult call() throws Exception {
                DescribeHoursOfOperationResult result = null;
                try {
                    result = describeHoursOfOperation(describeHoursOfOperationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeHoursOfOperationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns the current state of the specified instance identifier. It tracks
     * the instance while it is being created and returns an error status, if
     * applicable.
     * </p>
     * <p>
     * If an instance is not created successfully, the instance status reason
     * field returns details relevant to the reason. The instance in a failed
     * state is returned only for 24 hours after the CreateInstance API was
     * invoked.
     * </p>
     * 
     * @param describeInstanceRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstance service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceResult> describeInstanceAsync(
            final DescribeInstanceRequest describeInstanceRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceResult>() {
            public DescribeInstanceResult call() throws Exception {
                return describeInstance(describeInstanceRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns the current state of the specified instance identifier. It tracks
     * the instance while it is being created and returns an error status, if
     * applicable.
     * </p>
     * <p>
     * If an instance is not created successfully, the instance status reason
     * field returns details relevant to the reason. The instance in a failed
     * state is returned only for 24 hours after the CreateInstance API was
     * invoked.
     * </p>
     * 
     * @param describeInstanceRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstance service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceResult> describeInstanceAsync(
            final DescribeInstanceRequest describeInstanceRequest,
            final AsyncHandler<DescribeInstanceRequest, DescribeInstanceResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceResult>() {
            public DescribeInstanceResult call() throws Exception {
                DescribeInstanceResult result = null;
                try {
                    result = describeInstance(describeInstanceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeInstanceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified instance attribute.
     * </p>
     * 
     * @param describeInstanceAttributeRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstanceAttribute service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(
            final DescribeInstanceAttributeRequest describeInstanceAttributeRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceAttributeResult>() {
            public DescribeInstanceAttributeResult call() throws Exception {
                return describeInstanceAttribute(describeInstanceAttributeRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified instance attribute.
     * </p>
     * 
     * @param describeInstanceAttributeRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstanceAttribute service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(
            final DescribeInstanceAttributeRequest describeInstanceAttributeRequest,
            final AsyncHandler<DescribeInstanceAttributeRequest, DescribeInstanceAttributeResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceAttributeResult>() {
            public DescribeInstanceAttributeResult call() throws Exception {
                DescribeInstanceAttributeResult result = null;
                try {
                    result = describeInstanceAttribute(describeInstanceAttributeRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeInstanceAttributeRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Retrieves the current storage configurations for the specified resource
     * type, association ID, and instance ID.
     * </p>
     * 
     * @param describeInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceStorageConfigResult> describeInstanceStorageConfigAsync(
            final DescribeInstanceStorageConfigRequest describeInstanceStorageConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceStorageConfigResult>() {
            public DescribeInstanceStorageConfigResult call() throws Exception {
                return describeInstanceStorageConfig(describeInstanceStorageConfigRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Retrieves the current storage configurations for the specified resource
     * type, association ID, and instance ID.
     * </p>
     * 
     * @param describeInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         DescribeInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeInstanceStorageConfigResult> describeInstanceStorageConfigAsync(
            final DescribeInstanceStorageConfigRequest describeInstanceStorageConfigRequest,
            final AsyncHandler<DescribeInstanceStorageConfigRequest, DescribeInstanceStorageConfigResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceStorageConfigResult>() {
            public DescribeInstanceStorageConfigResult call() throws Exception {
                DescribeInstanceStorageConfigResult result = null;
                try {
                    result = describeInstanceStorageConfig(describeInstanceStorageConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeInstanceStorageConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Gets details and status of a phone number that’s claimed to your Amazon
     * Connect instance
     * </p>
     * 
     * @param describePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         DescribePhoneNumber service method, as returned by Amazon
     *         Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribePhoneNumberResult> describePhoneNumberAsync(
            final DescribePhoneNumberRequest describePhoneNumberRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribePhoneNumberResult>() {
            public DescribePhoneNumberResult call() throws Exception {
                return describePhoneNumber(describePhoneNumberRequest);
            }
        });
    }

    /**
     * <p>
     * Gets details and status of a phone number that’s claimed to your Amazon
     * Connect instance
     * </p>
     * 
     * @param describePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         DescribePhoneNumber service method, as returned by Amazon
     *         Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribePhoneNumberResult> describePhoneNumberAsync(
            final DescribePhoneNumberRequest describePhoneNumberRequest,
            final AsyncHandler<DescribePhoneNumberRequest, DescribePhoneNumberResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribePhoneNumberResult>() {
            public DescribePhoneNumberResult call() throws Exception {
                DescribePhoneNumberResult result = null;
                try {
                    result = describePhoneNumber(describePhoneNumberRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describePhoneNumberRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified queue.
     * </p>
     * 
     * @param describeQueueRequest
     * @return A Java Future object containing the response from the
     *         DescribeQueue service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeQueueResult> describeQueueAsync(
            final DescribeQueueRequest describeQueueRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<DescribeQueueResult>() {
            public DescribeQueueResult call() throws Exception {
                return describeQueue(describeQueueRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Describes the specified queue.
     * </p>
     * 
     * @param describeQueueRequest
     * @return A Java Future object containing the response from the
     *         DescribeQueue service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeQueueResult> describeQueueAsync(
            final DescribeQueueRequest describeQueueRequest,
            final AsyncHandler<DescribeQueueRequest, DescribeQueueResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeQueueResult>() {
            public DescribeQueueResult call() throws Exception {
                DescribeQueueResult result = null;
                try {
                    result = describeQueue(describeQueueRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeQueueRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the quick connect.
     * </p>
     * 
     * @param describeQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         DescribeQuickConnect service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeQuickConnectResult> describeQuickConnectAsync(
            final DescribeQuickConnectRequest describeQuickConnectRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeQuickConnectResult>() {
            public DescribeQuickConnectResult call() throws Exception {
                return describeQuickConnect(describeQuickConnectRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the quick connect.
     * </p>
     * 
     * @param describeQuickConnectRequest
     * @return A Java Future object containing the response from the
     *         DescribeQuickConnect service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeQuickConnectResult> describeQuickConnectAsync(
            final DescribeQuickConnectRequest describeQuickConnectRequest,
            final AsyncHandler<DescribeQuickConnectRequest, DescribeQuickConnectResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeQuickConnectResult>() {
            public DescribeQuickConnectResult call() throws Exception {
                DescribeQuickConnectResult result = null;
                try {
                    result = describeQuickConnect(describeQuickConnectRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeQuickConnectRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified routing profile.
     * </p>
     * 
     * @param describeRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         DescribeRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeRoutingProfileResult> describeRoutingProfileAsync(
            final DescribeRoutingProfileRequest describeRoutingProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeRoutingProfileResult>() {
            public DescribeRoutingProfileResult call() throws Exception {
                return describeRoutingProfile(describeRoutingProfileRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified routing profile.
     * </p>
     * 
     * @param describeRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         DescribeRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeRoutingProfileResult> describeRoutingProfileAsync(
            final DescribeRoutingProfileRequest describeRoutingProfileRequest,
            final AsyncHandler<DescribeRoutingProfileRequest, DescribeRoutingProfileResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeRoutingProfileResult>() {
            public DescribeRoutingProfileResult call() throws Exception {
                DescribeRoutingProfileResult result = null;
                try {
                    result = describeRoutingProfile(describeRoutingProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeRoutingProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Gets basic information about the security profle.
     * </p>
     * 
     * @param describeSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         DescribeSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeSecurityProfileResult> describeSecurityProfileAsync(
            final DescribeSecurityProfileRequest describeSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeSecurityProfileResult>() {
            public DescribeSecurityProfileResult call() throws Exception {
                return describeSecurityProfile(describeSecurityProfileRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Gets basic information about the security profle.
     * </p>
     * 
     * @param describeSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         DescribeSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeSecurityProfileResult> describeSecurityProfileAsync(
            final DescribeSecurityProfileRequest describeSecurityProfileRequest,
            final AsyncHandler<DescribeSecurityProfileRequest, DescribeSecurityProfileResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeSecurityProfileResult>() {
            public DescribeSecurityProfileResult call() throws Exception {
                DescribeSecurityProfileResult result = null;
                try {
                    result = describeSecurityProfile(describeSecurityProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeSecurityProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified user account. You can find the instance ID in the
     * console (it’s the final part of the ARN). The console does not display
     * the user IDs. Instead, list the users and note the IDs provided in the
     * output.
     * </p>
     * 
     * @param describeUserRequest
     * @return A Java Future object containing the response from the
     *         DescribeUser service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserResult> describeUserAsync(
            final DescribeUserRequest describeUserRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<DescribeUserResult>() {
            public DescribeUserResult call() throws Exception {
                return describeUser(describeUserRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified user account. You can find the instance ID in the
     * console (it’s the final part of the ARN). The console does not display
     * the user IDs. Instead, list the users and note the IDs provided in the
     * output.
     * </p>
     * 
     * @param describeUserRequest
     * @return A Java Future object containing the response from the
     *         DescribeUser service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserResult> describeUserAsync(
            final DescribeUserRequest describeUserRequest,
            final AsyncHandler<DescribeUserRequest, DescribeUserResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeUserResult>() {
            public DescribeUserResult call() throws Exception {
                DescribeUserResult result = null;
                try {
                    result = describeUser(describeUserRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeUserRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified hierarchy group.
     * </p>
     * 
     * @param describeUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         DescribeUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserHierarchyGroupResult> describeUserHierarchyGroupAsync(
            final DescribeUserHierarchyGroupRequest describeUserHierarchyGroupRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeUserHierarchyGroupResult>() {
            public DescribeUserHierarchyGroupResult call() throws Exception {
                return describeUserHierarchyGroup(describeUserHierarchyGroupRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified hierarchy group.
     * </p>
     * 
     * @param describeUserHierarchyGroupRequest
     * @return A Java Future object containing the response from the
     *         DescribeUserHierarchyGroup service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserHierarchyGroupResult> describeUserHierarchyGroupAsync(
            final DescribeUserHierarchyGroupRequest describeUserHierarchyGroupRequest,
            final AsyncHandler<DescribeUserHierarchyGroupRequest, DescribeUserHierarchyGroupResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeUserHierarchyGroupResult>() {
            public DescribeUserHierarchyGroupResult call() throws Exception {
                DescribeUserHierarchyGroupResult result = null;
                try {
                    result = describeUserHierarchyGroup(describeUserHierarchyGroupRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeUserHierarchyGroupRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the hierarchy structure of the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param describeUserHierarchyStructureRequest
     * @return A Java Future object containing the response from the
     *         DescribeUserHierarchyStructure service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserHierarchyStructureResult> describeUserHierarchyStructureAsync(
            final DescribeUserHierarchyStructureRequest describeUserHierarchyStructureRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeUserHierarchyStructureResult>() {
            public DescribeUserHierarchyStructureResult call() throws Exception {
                return describeUserHierarchyStructure(describeUserHierarchyStructureRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the hierarchy structure of the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param describeUserHierarchyStructureRequest
     * @return A Java Future object containing the response from the
     *         DescribeUserHierarchyStructure service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeUserHierarchyStructureResult> describeUserHierarchyStructureAsync(
            final DescribeUserHierarchyStructureRequest describeUserHierarchyStructureRequest,
            final AsyncHandler<DescribeUserHierarchyStructureRequest, DescribeUserHierarchyStructureResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeUserHierarchyStructureResult>() {
            public DescribeUserHierarchyStructureResult call() throws Exception {
                DescribeUserHierarchyStructureResult result = null;
                try {
                    result = describeUserHierarchyStructure(describeUserHierarchyStructureRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeUserHierarchyStructureRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Describes the specified vocabulary.
     * </p>
     * 
     * @param describeVocabularyRequest
     * @return A Java Future object containing the response from the
     *         DescribeVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeVocabularyResult> describeVocabularyAsync(
            final DescribeVocabularyRequest describeVocabularyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeVocabularyResult>() {
            public DescribeVocabularyResult call() throws Exception {
                return describeVocabulary(describeVocabularyRequest);
            }
        });
    }

    /**
     * <p>
     * Describes the specified vocabulary.
     * </p>
     * 
     * @param describeVocabularyRequest
     * @return A Java Future object containing the response from the
     *         DescribeVocabulary service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<DescribeVocabularyResult> describeVocabularyAsync(
            final DescribeVocabularyRequest describeVocabularyRequest,
            final AsyncHandler<DescribeVocabularyRequest, DescribeVocabularyResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeVocabularyResult>() {
            public DescribeVocabularyResult call() throws Exception {
                DescribeVocabularyResult result = null;
                try {
                    result = describeVocabulary(describeVocabularyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(describeVocabularyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes access to integrated applications from Amazon Connect.
     * </p>
     * 
     * @param disassociateApprovedOriginRequest
     * @return A Java Future object containing the response from the
     *         DisassociateApprovedOrigin service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateApprovedOriginAsync(
            final DisassociateApprovedOriginRequest disassociateApprovedOriginRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateApprovedOrigin(disassociateApprovedOriginRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes access to integrated applications from Amazon Connect.
     * </p>
     * 
     * @param disassociateApprovedOriginRequest
     * @return A Java Future object containing the response from the
     *         DisassociateApprovedOrigin service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateApprovedOriginAsync(
            final DisassociateApprovedOriginRequest disassociateApprovedOriginRequest,
            final AsyncHandler<DisassociateApprovedOriginRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateApprovedOrigin(disassociateApprovedOriginRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateApprovedOriginRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes authorization from the specified instance to access the specified
     * Amazon Lex or Amazon Lex V2 bot.
     * </p>
     * 
     * @param disassociateBotRequest
     * @return A Java Future object containing the response from the
     *         DisassociateBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateBotAsync(final DisassociateBotRequest disassociateBotRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateBot(disassociateBotRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes authorization from the specified instance to access the specified
     * Amazon Lex or Amazon Lex V2 bot.
     * </p>
     * 
     * @param disassociateBotRequest
     * @return A Java Future object containing the response from the
     *         DisassociateBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateBotAsync(final DisassociateBotRequest disassociateBotRequest,
            final AsyncHandler<DisassociateBotRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateBot(disassociateBotRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateBotRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Removes the storage type configurations for the specified resource type
     * and association ID.
     * </p>
     * 
     * @param disassociateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         DisassociateInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateInstanceStorageConfigAsync(
            final DisassociateInstanceStorageConfigRequest disassociateInstanceStorageConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateInstanceStorageConfig(disassociateInstanceStorageConfigRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Removes the storage type configurations for the specified resource type
     * and association ID.
     * </p>
     * 
     * @param disassociateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         DisassociateInstanceStorageConfig service method, as returned by
     *         Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateInstanceStorageConfigAsync(
            final DisassociateInstanceStorageConfigRequest disassociateInstanceStorageConfigRequest,
            final AsyncHandler<DisassociateInstanceStorageConfigRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateInstanceStorageConfig(disassociateInstanceStorageConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateInstanceStorageConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Remove the Lambda function from the dropdown options available in the
     * relevant flow blocks.
     * </p>
     * 
     * @param disassociateLambdaFunctionRequest
     * @return A Java Future object containing the response from the
     *         DisassociateLambdaFunction service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateLambdaFunctionAsync(
            final DisassociateLambdaFunctionRequest disassociateLambdaFunctionRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateLambdaFunction(disassociateLambdaFunctionRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Remove the Lambda function from the dropdown options available in the
     * relevant flow blocks.
     * </p>
     * 
     * @param disassociateLambdaFunctionRequest
     * @return A Java Future object containing the response from the
     *         DisassociateLambdaFunction service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateLambdaFunctionAsync(
            final DisassociateLambdaFunctionRequest disassociateLambdaFunctionRequest,
            final AsyncHandler<DisassociateLambdaFunctionRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateLambdaFunction(disassociateLambdaFunctionRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateLambdaFunctionRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes authorization from the specified instance to access the specified
     * Amazon Lex bot.
     * </p>
     * 
     * @param disassociateLexBotRequest
     * @return A Java Future object containing the response from the
     *         DisassociateLexBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateLexBotAsync(
            final DisassociateLexBotRequest disassociateLexBotRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateLexBot(disassociateLexBotRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Revokes authorization from the specified instance to access the specified
     * Amazon Lex bot.
     * </p>
     * 
     * @param disassociateLexBotRequest
     * @return A Java Future object containing the response from the
     *         DisassociateLexBot service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateLexBotAsync(
            final DisassociateLexBotRequest disassociateLexBotRequest,
            final AsyncHandler<DisassociateLexBotRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateLexBot(disassociateLexBotRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateLexBotRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Removes the flow association from a phone number claimed to your Amazon
     * Connect instance, if a flow association exists.
     * </p>
     * 
     * @param disassociatePhoneNumberContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DisassociatePhoneNumberContactFlow service method, as returned by
     *         Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociatePhoneNumberContactFlowAsync(
            final DisassociatePhoneNumberContactFlowRequest disassociatePhoneNumberContactFlowRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociatePhoneNumberContactFlow(disassociatePhoneNumberContactFlowRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Removes the flow association from a phone number claimed to your Amazon
     * Connect instance, if a flow association exists.
     * </p>
     * 
     * @param disassociatePhoneNumberContactFlowRequest
     * @return A Java Future object containing the response from the
     *         DisassociatePhoneNumberContactFlow service method, as returned by
     *         Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociatePhoneNumberContactFlowAsync(
            final DisassociatePhoneNumberContactFlowRequest disassociatePhoneNumberContactFlowRequest,
            final AsyncHandler<DisassociatePhoneNumberContactFlowRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociatePhoneNumberContactFlow(disassociatePhoneNumberContactFlowRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociatePhoneNumberContactFlowRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Disassociates a set of quick connects from a queue.
     * </p>
     * 
     * @param disassociateQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         DisassociateQueueQuickConnects service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateQueueQuickConnectsAsync(
            final DisassociateQueueQuickConnectsRequest disassociateQueueQuickConnectsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateQueueQuickConnects(disassociateQueueQuickConnectsRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Disassociates a set of quick connects from a queue.
     * </p>
     * 
     * @param disassociateQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         DisassociateQueueQuickConnects service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateQueueQuickConnectsAsync(
            final DisassociateQueueQuickConnectsRequest disassociateQueueQuickConnectsRequest,
            final AsyncHandler<DisassociateQueueQuickConnectsRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateQueueQuickConnects(disassociateQueueQuickConnectsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateQueueQuickConnectsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Disassociates a set of queues from a routing profile.
     * </p>
     * 
     * @param disassociateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         DisassociateRoutingProfileQueues service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateRoutingProfileQueuesAsync(
            final DisassociateRoutingProfileQueuesRequest disassociateRoutingProfileQueuesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateRoutingProfileQueues(disassociateRoutingProfileQueuesRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Disassociates a set of queues from a routing profile.
     * </p>
     * 
     * @param disassociateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         DisassociateRoutingProfileQueues service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateRoutingProfileQueuesAsync(
            final DisassociateRoutingProfileQueuesRequest disassociateRoutingProfileQueuesRequest,
            final AsyncHandler<DisassociateRoutingProfileQueuesRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateRoutingProfileQueues(disassociateRoutingProfileQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateRoutingProfileQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes the specified security key.
     * </p>
     * 
     * @param disassociateSecurityKeyRequest
     * @return A Java Future object containing the response from the
     *         DisassociateSecurityKey service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateSecurityKeyAsync(
            final DisassociateSecurityKeyRequest disassociateSecurityKeyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                disassociateSecurityKey(disassociateSecurityKeyRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Deletes the specified security key.
     * </p>
     * 
     * @param disassociateSecurityKeyRequest
     * @return A Java Future object containing the response from the
     *         DisassociateSecurityKey service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> disassociateSecurityKeyAsync(
            final DisassociateSecurityKeyRequest disassociateSecurityKeyRequest,
            final AsyncHandler<DisassociateSecurityKeyRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    disassociateSecurityKey(disassociateSecurityKeyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(disassociateSecurityKeyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Retrieves the contact attributes for the specified contact.
     * </p>
     * 
     * @param getContactAttributesRequest
     * @return A Java Future object containing the response from the
     *         GetContactAttributes service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetContactAttributesResult> getContactAttributesAsync(
            final GetContactAttributesRequest getContactAttributesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContactAttributesResult>() {
            public GetContactAttributesResult call() throws Exception {
                return getContactAttributes(getContactAttributesRequest);
            }
        });
    }

    /**
     * <p>
     * Retrieves the contact attributes for the specified contact.
     * </p>
     * 
     * @param getContactAttributesRequest
     * @return A Java Future object containing the response from the
     *         GetContactAttributes service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetContactAttributesResult> getContactAttributesAsync(
            final GetContactAttributesRequest getContactAttributesRequest,
            final AsyncHandler<GetContactAttributesRequest, GetContactAttributesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetContactAttributesResult>() {
            public GetContactAttributesResult call() throws Exception {
                GetContactAttributesResult result = null;
                try {
                    result = getContactAttributes(getContactAttributesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getContactAttributesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Gets the real-time metric data from the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * For a description of each metric, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/real-time-metrics-definitions.html"
     * >Real-time Metrics Definitions</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param getCurrentMetricDataRequest
     * @return A Java Future object containing the response from the
     *         GetCurrentMetricData service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetCurrentMetricDataResult> getCurrentMetricDataAsync(
            final GetCurrentMetricDataRequest getCurrentMetricDataRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCurrentMetricDataResult>() {
            public GetCurrentMetricDataResult call() throws Exception {
                return getCurrentMetricData(getCurrentMetricDataRequest);
            }
        });
    }

    /**
     * <p>
     * Gets the real-time metric data from the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * For a description of each metric, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/real-time-metrics-definitions.html"
     * >Real-time Metrics Definitions</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param getCurrentMetricDataRequest
     * @return A Java Future object containing the response from the
     *         GetCurrentMetricData service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetCurrentMetricDataResult> getCurrentMetricDataAsync(
            final GetCurrentMetricDataRequest getCurrentMetricDataRequest,
            final AsyncHandler<GetCurrentMetricDataRequest, GetCurrentMetricDataResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCurrentMetricDataResult>() {
            public GetCurrentMetricDataResult call() throws Exception {
                GetCurrentMetricDataResult result = null;
                try {
                    result = getCurrentMetricData(getCurrentMetricDataRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getCurrentMetricDataRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Gets the real-time active user data from the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param getCurrentUserDataRequest
     * @return A Java Future object containing the response from the
     *         GetCurrentUserData service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetCurrentUserDataResult> getCurrentUserDataAsync(
            final GetCurrentUserDataRequest getCurrentUserDataRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCurrentUserDataResult>() {
            public GetCurrentUserDataResult call() throws Exception {
                return getCurrentUserData(getCurrentUserDataRequest);
            }
        });
    }

    /**
     * <p>
     * Gets the real-time active user data from the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param getCurrentUserDataRequest
     * @return A Java Future object containing the response from the
     *         GetCurrentUserData service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetCurrentUserDataResult> getCurrentUserDataAsync(
            final GetCurrentUserDataRequest getCurrentUserDataRequest,
            final AsyncHandler<GetCurrentUserDataRequest, GetCurrentUserDataResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetCurrentUserDataResult>() {
            public GetCurrentUserDataResult call() throws Exception {
                GetCurrentUserDataResult result = null;
                try {
                    result = getCurrentUserData(getCurrentUserDataRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getCurrentUserDataRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Retrieves a token for federation.
     * </p>
     * <note>
     * <p>
     * This API doesn't support root users. If you try to invoke
     * GetFederationToken with root credentials, an error message similar to the
     * following one appears:
     * </p>
     * <p>
     * <code>Provided identity: Principal: .... User: .... cannot be used for federation with Amazon Connect</code>
     * </p>
     * </note>
     * 
     * @param getFederationTokenRequest
     * @return A Java Future object containing the response from the
     *         GetFederationToken service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws UserNotFoundException
     * @throws InternalServiceException
     * @throws DuplicateResourceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetFederationTokenResult> getFederationTokenAsync(
            final GetFederationTokenRequest getFederationTokenRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetFederationTokenResult>() {
            public GetFederationTokenResult call() throws Exception {
                return getFederationToken(getFederationTokenRequest);
            }
        });
    }

    /**
     * <p>
     * Retrieves a token for federation.
     * </p>
     * <note>
     * <p>
     * This API doesn't support root users. If you try to invoke
     * GetFederationToken with root credentials, an error message similar to the
     * following one appears:
     * </p>
     * <p>
     * <code>Provided identity: Principal: .... User: .... cannot be used for federation with Amazon Connect</code>
     * </p>
     * </note>
     * 
     * @param getFederationTokenRequest
     * @return A Java Future object containing the response from the
     *         GetFederationToken service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws UserNotFoundException
     * @throws InternalServiceException
     * @throws DuplicateResourceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetFederationTokenResult> getFederationTokenAsync(
            final GetFederationTokenRequest getFederationTokenRequest,
            final AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetFederationTokenResult>() {
            public GetFederationTokenResult call() throws Exception {
                GetFederationTokenResult result = null;
                try {
                    result = getFederationToken(getFederationTokenRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getFederationTokenRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Gets historical metric data from the specified Amazon Connect instance.
     * </p>
     * <p>
     * For a description of each historical metric, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/historical-metrics-definitions.html"
     * >Historical Metrics Definitions</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param getMetricDataRequest
     * @return A Java Future object containing the response from the
     *         GetMetricData service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetMetricDataResult> getMetricDataAsync(
            final GetMetricDataRequest getMetricDataRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<GetMetricDataResult>() {
            public GetMetricDataResult call() throws Exception {
                return getMetricData(getMetricDataRequest);
            }
        });
    }

    /**
     * <p>
     * Gets historical metric data from the specified Amazon Connect instance.
     * </p>
     * <p>
     * For a description of each historical metric, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/historical-metrics-definitions.html"
     * >Historical Metrics Definitions</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param getMetricDataRequest
     * @return A Java Future object containing the response from the
     *         GetMetricData service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws ResourceNotFoundException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetMetricDataResult> getMetricDataAsync(
            final GetMetricDataRequest getMetricDataRequest,
            final AsyncHandler<GetMetricDataRequest, GetMetricDataResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetMetricDataResult>() {
            public GetMetricDataResult call() throws Exception {
                GetMetricDataResult result = null;
                try {
                    result = getMetricData(getMetricDataRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getMetricDataRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Gets details about a specific task template in the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param getTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         GetTaskTemplate service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetTaskTemplateResult> getTaskTemplateAsync(
            final GetTaskTemplateRequest getTaskTemplateRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<GetTaskTemplateResult>() {
            public GetTaskTemplateResult call() throws Exception {
                return getTaskTemplate(getTaskTemplateRequest);
            }
        });
    }

    /**
     * <p>
     * Gets details about a specific task template in the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param getTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         GetTaskTemplate service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<GetTaskTemplateResult> getTaskTemplateAsync(
            final GetTaskTemplateRequest getTaskTemplateRequest,
            final AsyncHandler<GetTaskTemplateRequest, GetTaskTemplateResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<GetTaskTemplateResult>() {
            public GetTaskTemplateResult call() throws Exception {
                GetTaskTemplateResult result = null;
                try {
                    result = getTaskTemplate(getTaskTemplateRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(getTaskTemplateRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists agent statuses.
     * </p>
     * 
     * @param listAgentStatusesRequest
     * @return A Java Future object containing the response from the
     *         ListAgentStatuses service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListAgentStatusesResult> listAgentStatusesAsync(
            final ListAgentStatusesRequest listAgentStatusesRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListAgentStatusesResult>() {
            public ListAgentStatusesResult call() throws Exception {
                return listAgentStatuses(listAgentStatusesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists agent statuses.
     * </p>
     * 
     * @param listAgentStatusesRequest
     * @return A Java Future object containing the response from the
     *         ListAgentStatuses service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListAgentStatusesResult> listAgentStatusesAsync(
            final ListAgentStatusesRequest listAgentStatusesRequest,
            final AsyncHandler<ListAgentStatusesRequest, ListAgentStatusesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListAgentStatusesResult>() {
            public ListAgentStatusesResult call() throws Exception {
                ListAgentStatusesResult result = null;
                try {
                    result = listAgentStatuses(listAgentStatusesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listAgentStatusesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all approved origins associated with the
     * instance.
     * </p>
     * 
     * @param listApprovedOriginsRequest
     * @return A Java Future object containing the response from the
     *         ListApprovedOrigins service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListApprovedOriginsResult> listApprovedOriginsAsync(
            final ListApprovedOriginsRequest listApprovedOriginsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListApprovedOriginsResult>() {
            public ListApprovedOriginsResult call() throws Exception {
                return listApprovedOrigins(listApprovedOriginsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all approved origins associated with the
     * instance.
     * </p>
     * 
     * @param listApprovedOriginsRequest
     * @return A Java Future object containing the response from the
     *         ListApprovedOrigins service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListApprovedOriginsResult> listApprovedOriginsAsync(
            final ListApprovedOriginsRequest listApprovedOriginsRequest,
            final AsyncHandler<ListApprovedOriginsRequest, ListApprovedOriginsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListApprovedOriginsResult>() {
            public ListApprovedOriginsResult call() throws Exception {
                ListApprovedOriginsResult result = null;
                try {
                    result = listApprovedOrigins(listApprovedOriginsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listApprovedOriginsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * For the specified version of Amazon Lex, returns a paginated list of all
     * the Amazon Lex bots currently associated with the instance. Use this API
     * to returns both Amazon Lex V1 and V2 bots.
     * </p>
     * 
     * @param listBotsRequest
     * @return A Java Future object containing the response from the ListBots
     *         service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListBotsResult> listBotsAsync(final ListBotsRequest listBotsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListBotsResult>() {
            public ListBotsResult call() throws Exception {
                return listBots(listBotsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * For the specified version of Amazon Lex, returns a paginated list of all
     * the Amazon Lex bots currently associated with the instance. Use this API
     * to returns both Amazon Lex V1 and V2 bots.
     * </p>
     * 
     * @param listBotsRequest
     * @return A Java Future object containing the response from the ListBots
     *         service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListBotsResult> listBotsAsync(final ListBotsRequest listBotsRequest,
            final AsyncHandler<ListBotsRequest, ListBotsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListBotsResult>() {
            public ListBotsResult call() throws Exception {
                ListBotsResult result = null;
                try {
                    result = listBots(listBotsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listBotsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the flow modules for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listContactFlowModulesRequest
     * @return A Java Future object containing the response from the
     *         ListContactFlowModules service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactFlowModulesResult> listContactFlowModulesAsync(
            final ListContactFlowModulesRequest listContactFlowModulesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListContactFlowModulesResult>() {
            public ListContactFlowModulesResult call() throws Exception {
                return listContactFlowModules(listContactFlowModulesRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the flow modules for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listContactFlowModulesRequest
     * @return A Java Future object containing the response from the
     *         ListContactFlowModules service method, as returned by Amazon
     *         Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactFlowModulesResult> listContactFlowModulesAsync(
            final ListContactFlowModulesRequest listContactFlowModulesRequest,
            final AsyncHandler<ListContactFlowModulesRequest, ListContactFlowModulesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListContactFlowModulesResult>() {
            public ListContactFlowModulesResult call() throws Exception {
                ListContactFlowModulesResult result = null;
                try {
                    result = listContactFlowModules(listContactFlowModulesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listContactFlowModulesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the flows for the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * <p>
     * For more information about flows, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-contact-flows.html"
     * >Flows</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listContactFlowsRequest
     * @return A Java Future object containing the response from the
     *         ListContactFlows service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactFlowsResult> listContactFlowsAsync(
            final ListContactFlowsRequest listContactFlowsRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListContactFlowsResult>() {
            public ListContactFlowsResult call() throws Exception {
                return listContactFlows(listContactFlowsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the flows for the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * <p>
     * For more information about flows, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-contact-flows.html"
     * >Flows</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listContactFlowsRequest
     * @return A Java Future object containing the response from the
     *         ListContactFlows service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactFlowsResult> listContactFlowsAsync(
            final ListContactFlowsRequest listContactFlowsRequest,
            final AsyncHandler<ListContactFlowsRequest, ListContactFlowsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListContactFlowsResult>() {
            public ListContactFlowsResult call() throws Exception {
                ListContactFlowsResult result = null;
                try {
                    result = listContactFlows(listContactFlowsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listContactFlowsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * For the specified <code>referenceTypes</code>, returns a list of
     * references associated with the contact.
     * </p>
     * 
     * @param listContactReferencesRequest
     * @return A Java Future object containing the response from the
     *         ListContactReferences service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactReferencesResult> listContactReferencesAsync(
            final ListContactReferencesRequest listContactReferencesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListContactReferencesResult>() {
            public ListContactReferencesResult call() throws Exception {
                return listContactReferences(listContactReferencesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * For the specified <code>referenceTypes</code>, returns a list of
     * references associated with the contact.
     * </p>
     * 
     * @param listContactReferencesRequest
     * @return A Java Future object containing the response from the
     *         ListContactReferences service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListContactReferencesResult> listContactReferencesAsync(
            final ListContactReferencesRequest listContactReferencesRequest,
            final AsyncHandler<ListContactReferencesRequest, ListContactReferencesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListContactReferencesResult>() {
            public ListContactReferencesResult call() throws Exception {
                ListContactReferencesResult result = null;
                try {
                    result = listContactReferences(listContactReferencesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listContactReferencesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists the default vocabularies for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listDefaultVocabulariesRequest
     * @return A Java Future object containing the response from the
     *         ListDefaultVocabularies service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListDefaultVocabulariesResult> listDefaultVocabulariesAsync(
            final ListDefaultVocabulariesRequest listDefaultVocabulariesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListDefaultVocabulariesResult>() {
            public ListDefaultVocabulariesResult call() throws Exception {
                return listDefaultVocabularies(listDefaultVocabulariesRequest);
            }
        });
    }

    /**
     * <p>
     * Lists the default vocabularies for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listDefaultVocabulariesRequest
     * @return A Java Future object containing the response from the
     *         ListDefaultVocabularies service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListDefaultVocabulariesResult> listDefaultVocabulariesAsync(
            final ListDefaultVocabulariesRequest listDefaultVocabulariesRequest,
            final AsyncHandler<ListDefaultVocabulariesRequest, ListDefaultVocabulariesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListDefaultVocabulariesResult>() {
            public ListDefaultVocabulariesResult call() throws Exception {
                ListDefaultVocabulariesResult result = null;
                try {
                    result = listDefaultVocabularies(listDefaultVocabulariesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listDefaultVocabulariesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the hours of operation for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about hours of operation, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-hours-operation.html"
     * >Set the Hours of Operation for a Queue</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param listHoursOfOperationsRequest
     * @return A Java Future object containing the response from the
     *         ListHoursOfOperations service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListHoursOfOperationsResult> listHoursOfOperationsAsync(
            final ListHoursOfOperationsRequest listHoursOfOperationsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListHoursOfOperationsResult>() {
            public ListHoursOfOperationsResult call() throws Exception {
                return listHoursOfOperations(listHoursOfOperationsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the hours of operation for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about hours of operation, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-hours-operation.html"
     * >Set the Hours of Operation for a Queue</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param listHoursOfOperationsRequest
     * @return A Java Future object containing the response from the
     *         ListHoursOfOperations service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListHoursOfOperationsResult> listHoursOfOperationsAsync(
            final ListHoursOfOperationsRequest listHoursOfOperationsRequest,
            final AsyncHandler<ListHoursOfOperationsRequest, ListHoursOfOperationsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListHoursOfOperationsResult>() {
            public ListHoursOfOperationsResult call() throws Exception {
                ListHoursOfOperationsResult result = null;
                try {
                    result = listHoursOfOperations(listHoursOfOperationsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listHoursOfOperationsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all attribute types for the given instance.
     * </p>
     * 
     * @param listInstanceAttributesRequest
     * @return A Java Future object containing the response from the
     *         ListInstanceAttributes service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstanceAttributesResult> listInstanceAttributesAsync(
            final ListInstanceAttributesRequest listInstanceAttributesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceAttributesResult>() {
            public ListInstanceAttributesResult call() throws Exception {
                return listInstanceAttributes(listInstanceAttributesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all attribute types for the given instance.
     * </p>
     * 
     * @param listInstanceAttributesRequest
     * @return A Java Future object containing the response from the
     *         ListInstanceAttributes service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstanceAttributesResult> listInstanceAttributesAsync(
            final ListInstanceAttributesRequest listInstanceAttributesRequest,
            final AsyncHandler<ListInstanceAttributesRequest, ListInstanceAttributesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceAttributesResult>() {
            public ListInstanceAttributesResult call() throws Exception {
                ListInstanceAttributesResult result = null;
                try {
                    result = listInstanceAttributes(listInstanceAttributesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listInstanceAttributesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of storage configs for the identified instance
     * and resource type.
     * </p>
     * 
     * @param listInstanceStorageConfigsRequest
     * @return A Java Future object containing the response from the
     *         ListInstanceStorageConfigs service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstanceStorageConfigsResult> listInstanceStorageConfigsAsync(
            final ListInstanceStorageConfigsRequest listInstanceStorageConfigsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceStorageConfigsResult>() {
            public ListInstanceStorageConfigsResult call() throws Exception {
                return listInstanceStorageConfigs(listInstanceStorageConfigsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of storage configs for the identified instance
     * and resource type.
     * </p>
     * 
     * @param listInstanceStorageConfigsRequest
     * @return A Java Future object containing the response from the
     *         ListInstanceStorageConfigs service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstanceStorageConfigsResult> listInstanceStorageConfigsAsync(
            final ListInstanceStorageConfigsRequest listInstanceStorageConfigsRequest,
            final AsyncHandler<ListInstanceStorageConfigsRequest, ListInstanceStorageConfigsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstanceStorageConfigsResult>() {
            public ListInstanceStorageConfigsResult call() throws Exception {
                ListInstanceStorageConfigsResult result = null;
                try {
                    result = listInstanceStorageConfigs(listInstanceStorageConfigsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listInstanceStorageConfigsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Return a list of instances which are in active state,
     * creation-in-progress state, and failed state. Instances that aren't
     * successfully created (they are in a failed state) are returned only for
     * 24 hours after the CreateInstance API was invoked.
     * </p>
     * 
     * @param listInstancesRequest
     * @return A Java Future object containing the response from the
     *         ListInstances service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstancesResult> listInstancesAsync(
            final ListInstancesRequest listInstancesRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListInstancesResult>() {
            public ListInstancesResult call() throws Exception {
                return listInstances(listInstancesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Return a list of instances which are in active state,
     * creation-in-progress state, and failed state. Instances that aren't
     * successfully created (they are in a failed state) are returned only for
     * 24 hours after the CreateInstance API was invoked.
     * </p>
     * 
     * @param listInstancesRequest
     * @return A Java Future object containing the response from the
     *         ListInstances service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListInstancesResult> listInstancesAsync(
            final ListInstancesRequest listInstancesRequest,
            final AsyncHandler<ListInstancesRequest, ListInstancesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListInstancesResult>() {
            public ListInstancesResult call() throws Exception {
                ListInstancesResult result = null;
                try {
                    result = listInstances(listInstancesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listInstancesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the Amazon Web Services resource
     * associations for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listIntegrationAssociationsRequest
     * @return A Java Future object containing the response from the
     *         ListIntegrationAssociations service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListIntegrationAssociationsResult> listIntegrationAssociationsAsync(
            final ListIntegrationAssociationsRequest listIntegrationAssociationsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListIntegrationAssociationsResult>() {
            public ListIntegrationAssociationsResult call() throws Exception {
                return listIntegrationAssociations(listIntegrationAssociationsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the Amazon Web Services resource
     * associations for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listIntegrationAssociationsRequest
     * @return A Java Future object containing the response from the
     *         ListIntegrationAssociations service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListIntegrationAssociationsResult> listIntegrationAssociationsAsync(
            final ListIntegrationAssociationsRequest listIntegrationAssociationsRequest,
            final AsyncHandler<ListIntegrationAssociationsRequest, ListIntegrationAssociationsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListIntegrationAssociationsResult>() {
            public ListIntegrationAssociationsResult call() throws Exception {
                ListIntegrationAssociationsResult result = null;
                try {
                    result = listIntegrationAssociations(listIntegrationAssociationsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listIntegrationAssociationsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all Lambda functions that display in the
     * dropdown options in the relevant flow blocks.
     * </p>
     * 
     * @param listLambdaFunctionsRequest
     * @return A Java Future object containing the response from the
     *         ListLambdaFunctions service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListLambdaFunctionsResult> listLambdaFunctionsAsync(
            final ListLambdaFunctionsRequest listLambdaFunctionsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListLambdaFunctionsResult>() {
            public ListLambdaFunctionsResult call() throws Exception {
                return listLambdaFunctions(listLambdaFunctionsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all Lambda functions that display in the
     * dropdown options in the relevant flow blocks.
     * </p>
     * 
     * @param listLambdaFunctionsRequest
     * @return A Java Future object containing the response from the
     *         ListLambdaFunctions service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListLambdaFunctionsResult> listLambdaFunctionsAsync(
            final ListLambdaFunctionsRequest listLambdaFunctionsRequest,
            final AsyncHandler<ListLambdaFunctionsRequest, ListLambdaFunctionsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListLambdaFunctionsResult>() {
            public ListLambdaFunctionsResult call() throws Exception {
                ListLambdaFunctionsResult result = null;
                try {
                    result = listLambdaFunctions(listLambdaFunctionsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listLambdaFunctionsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all the Amazon Lex V1 bots currently
     * associated with the instance. To return both Amazon Lex V1 and V2 bots,
     * use the <a href=
     * "https://docs.aws.amazon.com/connect/latest/APIReference/API_ListBots.html"
     * >ListBots</a> API.
     * </p>
     * 
     * @param listLexBotsRequest
     * @return A Java Future object containing the response from the ListLexBots
     *         service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListLexBotsResult> listLexBotsAsync(final ListLexBotsRequest listLexBotsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListLexBotsResult>() {
            public ListLexBotsResult call() throws Exception {
                return listLexBots(listLexBotsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all the Amazon Lex V1 bots currently
     * associated with the instance. To return both Amazon Lex V1 and V2 bots,
     * use the <a href=
     * "https://docs.aws.amazon.com/connect/latest/APIReference/API_ListBots.html"
     * >ListBots</a> API.
     * </p>
     * 
     * @param listLexBotsRequest
     * @return A Java Future object containing the response from the ListLexBots
     *         service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListLexBotsResult> listLexBotsAsync(final ListLexBotsRequest listLexBotsRequest,
            final AsyncHandler<ListLexBotsRequest, ListLexBotsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListLexBotsResult>() {
            public ListLexBotsResult call() throws Exception {
                ListLexBotsResult result = null;
                try {
                    result = listLexBots(listLexBotsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listLexBotsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the phone numbers for the specified Amazon
     * Connect instance.
     * </p>
     * <p>
     * For more information about phone numbers, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/contact-center-phone-number.html"
     * >Set Up Phone Numbers for Your Contact Center</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listPhoneNumbersRequest
     * @return A Java Future object containing the response from the
     *         ListPhoneNumbers service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPhoneNumbersResult> listPhoneNumbersAsync(
            final ListPhoneNumbersRequest listPhoneNumbersRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListPhoneNumbersResult>() {
            public ListPhoneNumbersResult call() throws Exception {
                return listPhoneNumbers(listPhoneNumbersRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the phone numbers for the specified Amazon
     * Connect instance.
     * </p>
     * <p>
     * For more information about phone numbers, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/contact-center-phone-number.html"
     * >Set Up Phone Numbers for Your Contact Center</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listPhoneNumbersRequest
     * @return A Java Future object containing the response from the
     *         ListPhoneNumbers service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPhoneNumbersResult> listPhoneNumbersAsync(
            final ListPhoneNumbersRequest listPhoneNumbersRequest,
            final AsyncHandler<ListPhoneNumbersRequest, ListPhoneNumbersResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPhoneNumbersResult>() {
            public ListPhoneNumbersResult call() throws Exception {
                ListPhoneNumbersResult result = null;
                try {
                    result = listPhoneNumbers(listPhoneNumbersRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listPhoneNumbersRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists phone numbers claimed to your Amazon Connect instance.
     * </p>
     * <p>
     * For more information about phone numbers, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/contact-center-phone-number.html"
     * >Set Up Phone Numbers for Your Contact Center</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listPhoneNumbersV2Request
     * @return A Java Future object containing the response from the
     *         ListPhoneNumbersV2 service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPhoneNumbersV2Result> listPhoneNumbersV2Async(
            final ListPhoneNumbersV2Request listPhoneNumbersV2Request)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPhoneNumbersV2Result>() {
            public ListPhoneNumbersV2Result call() throws Exception {
                return listPhoneNumbersV2(listPhoneNumbersV2Request);
            }
        });
    }

    /**
     * <p>
     * Lists phone numbers claimed to your Amazon Connect instance.
     * </p>
     * <p>
     * For more information about phone numbers, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/contact-center-phone-number.html"
     * >Set Up Phone Numbers for Your Contact Center</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listPhoneNumbersV2Request
     * @return A Java Future object containing the response from the
     *         ListPhoneNumbersV2 service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPhoneNumbersV2Result> listPhoneNumbersV2Async(
            final ListPhoneNumbersV2Request listPhoneNumbersV2Request,
            final AsyncHandler<ListPhoneNumbersV2Request, ListPhoneNumbersV2Result> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPhoneNumbersV2Result>() {
            public ListPhoneNumbersV2Result call() throws Exception {
                ListPhoneNumbersV2Result result = null;
                try {
                    result = listPhoneNumbersV2(listPhoneNumbersV2Request);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listPhoneNumbersV2Request, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the prompts for the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param listPromptsRequest
     * @return A Java Future object containing the response from the ListPrompts
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPromptsResult> listPromptsAsync(final ListPromptsRequest listPromptsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPromptsResult>() {
            public ListPromptsResult call() throws Exception {
                return listPrompts(listPromptsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the prompts for the specified Amazon Connect
     * instance.
     * </p>
     * 
     * @param listPromptsRequest
     * @return A Java Future object containing the response from the ListPrompts
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListPromptsResult> listPromptsAsync(final ListPromptsRequest listPromptsRequest,
            final AsyncHandler<ListPromptsRequest, ListPromptsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListPromptsResult>() {
            public ListPromptsResult call() throws Exception {
                ListPromptsResult result = null;
                try {
                    result = listPrompts(listPromptsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listPromptsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists the quick connects associated with a queue.
     * </p>
     * 
     * @param listQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         ListQueueQuickConnects service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQueueQuickConnectsResult> listQueueQuickConnectsAsync(
            final ListQueueQuickConnectsRequest listQueueQuickConnectsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListQueueQuickConnectsResult>() {
            public ListQueueQuickConnectsResult call() throws Exception {
                return listQueueQuickConnects(listQueueQuickConnectsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists the quick connects associated with a queue.
     * </p>
     * 
     * @param listQueueQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         ListQueueQuickConnects service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQueueQuickConnectsResult> listQueueQuickConnectsAsync(
            final ListQueueQuickConnectsRequest listQueueQuickConnectsRequest,
            final AsyncHandler<ListQueueQuickConnectsRequest, ListQueueQuickConnectsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListQueueQuickConnectsResult>() {
            public ListQueueQuickConnectsResult call() throws Exception {
                ListQueueQuickConnectsResult result = null;
                try {
                    result = listQueueQuickConnects(listQueueQuickConnectsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listQueueQuickConnectsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the queues for the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * If you do not specify a <code>QueueTypes</code> parameter, both standard
     * and agent queues are returned. This might cause an unexpected truncation
     * of results if you have more than 1000 agents and you limit the number of
     * results of the API call in code.
     * </p>
     * <p>
     * For more information about queues, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-queues-standard-and-agent.html"
     * >Queues: Standard and Agent</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listQueuesRequest
     * @return A Java Future object containing the response from the ListQueues
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQueuesResult> listQueuesAsync(final ListQueuesRequest listQueuesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListQueuesResult>() {
            public ListQueuesResult call() throws Exception {
                return listQueues(listQueuesRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the queues for the specified Amazon Connect
     * instance.
     * </p>
     * <p>
     * If you do not specify a <code>QueueTypes</code> parameter, both standard
     * and agent queues are returned. This might cause an unexpected truncation
     * of results if you have more than 1000 agents and you limit the number of
     * results of the API call in code.
     * </p>
     * <p>
     * For more information about queues, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-queues-standard-and-agent.html"
     * >Queues: Standard and Agent</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listQueuesRequest
     * @return A Java Future object containing the response from the ListQueues
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQueuesResult> listQueuesAsync(final ListQueuesRequest listQueuesRequest,
            final AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListQueuesResult>() {
            public ListQueuesResult call() throws Exception {
                ListQueuesResult result = null;
                try {
                    result = listQueues(listQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides information about the quick connects for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         ListQuickConnects service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQuickConnectsResult> listQuickConnectsAsync(
            final ListQuickConnectsRequest listQuickConnectsRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListQuickConnectsResult>() {
            public ListQuickConnectsResult call() throws Exception {
                return listQuickConnects(listQuickConnectsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides information about the quick connects for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listQuickConnectsRequest
     * @return A Java Future object containing the response from the
     *         ListQuickConnects service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListQuickConnectsResult> listQuickConnectsAsync(
            final ListQuickConnectsRequest listQuickConnectsRequest,
            final AsyncHandler<ListQuickConnectsRequest, ListQuickConnectsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListQuickConnectsResult>() {
            public ListQuickConnectsResult call() throws Exception {
                ListQuickConnectsResult result = null;
                try {
                    result = listQuickConnects(listQuickConnectsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listQuickConnectsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists the queues associated with a routing profile.
     * </p>
     * 
     * @param listRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         ListRoutingProfileQueues service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListRoutingProfileQueuesResult> listRoutingProfileQueuesAsync(
            final ListRoutingProfileQueuesRequest listRoutingProfileQueuesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRoutingProfileQueuesResult>() {
            public ListRoutingProfileQueuesResult call() throws Exception {
                return listRoutingProfileQueues(listRoutingProfileQueuesRequest);
            }
        });
    }

    /**
     * <p>
     * Lists the queues associated with a routing profile.
     * </p>
     * 
     * @param listRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         ListRoutingProfileQueues service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListRoutingProfileQueuesResult> listRoutingProfileQueuesAsync(
            final ListRoutingProfileQueuesRequest listRoutingProfileQueuesRequest,
            final AsyncHandler<ListRoutingProfileQueuesRequest, ListRoutingProfileQueuesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRoutingProfileQueuesResult>() {
            public ListRoutingProfileQueuesResult call() throws Exception {
                ListRoutingProfileQueuesResult result = null;
                try {
                    result = listRoutingProfileQueues(listRoutingProfileQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listRoutingProfileQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the routing profiles for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about routing profiles, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-routing.html"
     * >Routing Profiles</a> and <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/routing-profiles.html"
     * >Create a Routing Profile</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listRoutingProfilesRequest
     * @return A Java Future object containing the response from the
     *         ListRoutingProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListRoutingProfilesResult> listRoutingProfilesAsync(
            final ListRoutingProfilesRequest listRoutingProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRoutingProfilesResult>() {
            public ListRoutingProfilesResult call() throws Exception {
                return listRoutingProfiles(listRoutingProfilesRequest);
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the routing profiles for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about routing profiles, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/concepts-routing.html"
     * >Routing Profiles</a> and <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/routing-profiles.html"
     * >Create a Routing Profile</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listRoutingProfilesRequest
     * @return A Java Future object containing the response from the
     *         ListRoutingProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListRoutingProfilesResult> listRoutingProfilesAsync(
            final ListRoutingProfilesRequest listRoutingProfilesRequest,
            final AsyncHandler<ListRoutingProfilesRequest, ListRoutingProfilesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListRoutingProfilesResult>() {
            public ListRoutingProfilesResult call() throws Exception {
                ListRoutingProfilesResult result = null;
                try {
                    result = listRoutingProfiles(listRoutingProfilesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listRoutingProfilesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all security keys associated with the
     * instance.
     * </p>
     * 
     * @param listSecurityKeysRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityKeys service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityKeysResult> listSecurityKeysAsync(
            final ListSecurityKeysRequest listSecurityKeysRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListSecurityKeysResult>() {
            public ListSecurityKeysResult call() throws Exception {
                return listSecurityKeys(listSecurityKeysRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Returns a paginated list of all security keys associated with the
     * instance.
     * </p>
     * 
     * @param listSecurityKeysRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityKeys service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityKeysResult> listSecurityKeysAsync(
            final ListSecurityKeysRequest listSecurityKeysRequest,
            final AsyncHandler<ListSecurityKeysRequest, ListSecurityKeysResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSecurityKeysResult>() {
            public ListSecurityKeysResult call() throws Exception {
                ListSecurityKeysResult result = null;
                try {
                    result = listSecurityKeys(listSecurityKeysRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listSecurityKeysRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists the permissions granted to a security profile.
     * </p>
     * 
     * @param listSecurityProfilePermissionsRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityProfilePermissions service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityProfilePermissionsResult> listSecurityProfilePermissionsAsync(
            final ListSecurityProfilePermissionsRequest listSecurityProfilePermissionsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSecurityProfilePermissionsResult>() {
            public ListSecurityProfilePermissionsResult call() throws Exception {
                return listSecurityProfilePermissions(listSecurityProfilePermissionsRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Lists the permissions granted to a security profile.
     * </p>
     * 
     * @param listSecurityProfilePermissionsRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityProfilePermissions service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityProfilePermissionsResult> listSecurityProfilePermissionsAsync(
            final ListSecurityProfilePermissionsRequest listSecurityProfilePermissionsRequest,
            final AsyncHandler<ListSecurityProfilePermissionsRequest, ListSecurityProfilePermissionsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSecurityProfilePermissionsResult>() {
            public ListSecurityProfilePermissionsResult call() throws Exception {
                ListSecurityProfilePermissionsResult result = null;
                try {
                    result = listSecurityProfilePermissions(listSecurityProfilePermissionsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listSecurityProfilePermissionsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the security profiles for the
     * specified Amazon Connect instance.
     * </p>
     * <p>
     * For more information about security profiles, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/connect-security-profiles.html"
     * >Security Profiles</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityProfilesResult> listSecurityProfilesAsync(
            final ListSecurityProfilesRequest listSecurityProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSecurityProfilesResult>() {
            public ListSecurityProfilesResult call() throws Exception {
                return listSecurityProfiles(listSecurityProfilesRequest);
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the security profiles for the
     * specified Amazon Connect instance.
     * </p>
     * <p>
     * For more information about security profiles, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/connect-security-profiles.html"
     * >Security Profiles</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         ListSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListSecurityProfilesResult> listSecurityProfilesAsync(
            final ListSecurityProfilesRequest listSecurityProfilesRequest,
            final AsyncHandler<ListSecurityProfilesRequest, ListSecurityProfilesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListSecurityProfilesResult>() {
            public ListSecurityProfilesResult call() throws Exception {
                ListSecurityProfilesResult result = null;
                try {
                    result = listSecurityProfiles(listSecurityProfilesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listSecurityProfilesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists the tags for the specified resource.
     * </p>
     * <p>
     * For sample policies that use tags, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security_iam_id-based-policy-examples.html"
     * >Amazon Connect Identity-Based Policy Examples</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listTagsForResourceRequest
     * @return A Java Future object containing the response from the
     *         ListTagsForResource service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListTagsForResourceResult> listTagsForResourceAsync(
            final ListTagsForResourceRequest listTagsForResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListTagsForResourceResult>() {
            public ListTagsForResourceResult call() throws Exception {
                return listTagsForResource(listTagsForResourceRequest);
            }
        });
    }

    /**
     * <p>
     * Lists the tags for the specified resource.
     * </p>
     * <p>
     * For sample policies that use tags, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security_iam_id-based-policy-examples.html"
     * >Amazon Connect Identity-Based Policy Examples</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param listTagsForResourceRequest
     * @return A Java Future object containing the response from the
     *         ListTagsForResource service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListTagsForResourceResult> listTagsForResourceAsync(
            final ListTagsForResourceRequest listTagsForResourceRequest,
            final AsyncHandler<ListTagsForResourceRequest, ListTagsForResourceResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListTagsForResourceResult>() {
            public ListTagsForResourceResult call() throws Exception {
                ListTagsForResourceResult result = null;
                try {
                    result = listTagsForResource(listTagsForResourceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listTagsForResourceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists task templates for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listTaskTemplatesRequest
     * @return A Java Future object containing the response from the
     *         ListTaskTemplates service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListTaskTemplatesResult> listTaskTemplatesAsync(
            final ListTaskTemplatesRequest listTaskTemplatesRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListTaskTemplatesResult>() {
            public ListTaskTemplatesResult call() throws Exception {
                return listTaskTemplates(listTaskTemplatesRequest);
            }
        });
    }

    /**
     * <p>
     * Lists task templates for the specified Amazon Connect instance.
     * </p>
     * 
     * @param listTaskTemplatesRequest
     * @return A Java Future object containing the response from the
     *         ListTaskTemplates service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListTaskTemplatesResult> listTaskTemplatesAsync(
            final ListTaskTemplatesRequest listTaskTemplatesRequest,
            final AsyncHandler<ListTaskTemplatesRequest, ListTaskTemplatesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListTaskTemplatesResult>() {
            public ListTaskTemplatesResult call() throws Exception {
                ListTaskTemplatesResult result = null;
                try {
                    result = listTaskTemplates(listTaskTemplatesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listTaskTemplatesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Lists the use cases for the integration association.
     * </p>
     * 
     * @param listUseCasesRequest <p>
     *            Provides summary information about the use cases for the
     *            specified integration association.
     *            </p>
     * @return A Java Future object containing the response from the
     *         ListUseCases service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUseCasesResult> listUseCasesAsync(
            final ListUseCasesRequest listUseCasesRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<ListUseCasesResult>() {
            public ListUseCasesResult call() throws Exception {
                return listUseCases(listUseCasesRequest);
            }
        });
    }

    /**
     * <p>
     * Lists the use cases for the integration association.
     * </p>
     * 
     * @param listUseCasesRequest <p>
     *            Provides summary information about the use cases for the
     *            specified integration association.
     *            </p>
     * @return A Java Future object containing the response from the
     *         ListUseCases service method, as returned by Amazon Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUseCasesResult> listUseCasesAsync(
            final ListUseCasesRequest listUseCasesRequest,
            final AsyncHandler<ListUseCasesRequest, ListUseCasesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUseCasesResult>() {
            public ListUseCasesResult call() throws Exception {
                ListUseCasesResult result = null;
                try {
                    result = listUseCases(listUseCasesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listUseCasesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the hierarchy groups for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about agent hierarchies, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/agent-hierarchy.html"
     * >Set Up Agent Hierarchies</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listUserHierarchyGroupsRequest
     * @return A Java Future object containing the response from the
     *         ListUserHierarchyGroups service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUserHierarchyGroupsResult> listUserHierarchyGroupsAsync(
            final ListUserHierarchyGroupsRequest listUserHierarchyGroupsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUserHierarchyGroupsResult>() {
            public ListUserHierarchyGroupsResult call() throws Exception {
                return listUserHierarchyGroups(listUserHierarchyGroupsRequest);
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the hierarchy groups for the specified
     * Amazon Connect instance.
     * </p>
     * <p>
     * For more information about agent hierarchies, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/agent-hierarchy.html"
     * >Set Up Agent Hierarchies</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param listUserHierarchyGroupsRequest
     * @return A Java Future object containing the response from the
     *         ListUserHierarchyGroups service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUserHierarchyGroupsResult> listUserHierarchyGroupsAsync(
            final ListUserHierarchyGroupsRequest listUserHierarchyGroupsRequest,
            final AsyncHandler<ListUserHierarchyGroupsRequest, ListUserHierarchyGroupsResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUserHierarchyGroupsResult>() {
            public ListUserHierarchyGroupsResult call() throws Exception {
                ListUserHierarchyGroupsResult result = null;
                try {
                    result = listUserHierarchyGroups(listUserHierarchyGroupsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listUserHierarchyGroupsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the users for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listUsersRequest
     * @return A Java Future object containing the response from the ListUsers
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUsersResult> listUsersAsync(final ListUsersRequest listUsersRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUsersResult>() {
            public ListUsersResult call() throws Exception {
                return listUsers(listUsersRequest);
            }
        });
    }

    /**
     * <p>
     * Provides summary information about the users for the specified Amazon
     * Connect instance.
     * </p>
     * 
     * @param listUsersRequest
     * @return A Java Future object containing the response from the ListUsers
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ListUsersResult> listUsersAsync(final ListUsersRequest listUsersRequest,
            final AsyncHandler<ListUsersRequest, ListUsersResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ListUsersResult>() {
            public ListUsersResult call() throws Exception {
                ListUsersResult result = null;
                try {
                    result = listUsers(listUsersRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(listUsersRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Changes the current status of a user or agent in Amazon Connect. If the
     * agent is currently handling a contact, this sets the agent's next status.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/metrics-agent-status.html"
     * >Agent status</a> and <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-next-status.html"
     * >Set your next status</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param putUserStatusRequest
     * @return A Java Future object containing the response from the
     *         PutUserStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<PutUserStatusResult> putUserStatusAsync(
            final PutUserStatusRequest putUserStatusRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<PutUserStatusResult>() {
            public PutUserStatusResult call() throws Exception {
                return putUserStatus(putUserStatusRequest);
            }
        });
    }

    /**
     * <p>
     * Changes the current status of a user or agent in Amazon Connect. If the
     * agent is currently handling a contact, this sets the agent's next status.
     * </p>
     * <p>
     * For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/metrics-agent-status.html"
     * >Agent status</a> and <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-next-status.html"
     * >Set your next status</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param putUserStatusRequest
     * @return A Java Future object containing the response from the
     *         PutUserStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<PutUserStatusResult> putUserStatusAsync(
            final PutUserStatusRequest putUserStatusRequest,
            final AsyncHandler<PutUserStatusRequest, PutUserStatusResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<PutUserStatusResult>() {
            public PutUserStatusResult call() throws Exception {
                PutUserStatusResult result = null;
                try {
                    result = putUserStatus(putUserStatusRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(putUserStatusRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Releases a phone number previously claimed to an Amazon Connect instance.
     * </p>
     * 
     * @param releasePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         ReleasePhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws ResourceInUseException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> releasePhoneNumberAsync(
            final ReleasePhoneNumberRequest releasePhoneNumberRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                releasePhoneNumber(releasePhoneNumberRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Releases a phone number previously claimed to an Amazon Connect instance.
     * </p>
     * 
     * @param releasePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         ReleasePhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws ResourceInUseException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> releasePhoneNumberAsync(
            final ReleasePhoneNumberRequest releasePhoneNumberRequest,
            final AsyncHandler<ReleasePhoneNumberRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    releasePhoneNumber(releasePhoneNumberRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(releasePhoneNumberRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * When a contact is being recorded, and the recording has been suspended
     * using SuspendContactRecording, this API resumes recording the call.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param resumeContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         ResumeContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ResumeContactRecordingResult> resumeContactRecordingAsync(
            final ResumeContactRecordingRequest resumeContactRecordingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ResumeContactRecordingResult>() {
            public ResumeContactRecordingResult call() throws Exception {
                return resumeContactRecording(resumeContactRecordingRequest);
            }
        });
    }

    /**
     * <p>
     * When a contact is being recorded, and the recording has been suspended
     * using SuspendContactRecording, this API resumes recording the call.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param resumeContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         ResumeContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<ResumeContactRecordingResult> resumeContactRecordingAsync(
            final ResumeContactRecordingRequest resumeContactRecordingRequest,
            final AsyncHandler<ResumeContactRecordingRequest, ResumeContactRecordingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ResumeContactRecordingResult>() {
            public ResumeContactRecordingResult call() throws Exception {
                ResumeContactRecordingResult result = null;
                try {
                    result = resumeContactRecording(resumeContactRecordingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(resumeContactRecordingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Searches for available phone numbers that you can claim to your Amazon
     * Connect instance.
     * </p>
     * 
     * @param searchAvailablePhoneNumbersRequest
     * @return A Java Future object containing the response from the
     *         SearchAvailablePhoneNumbers service method, as returned by Amazon
     *         Connect.
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchAvailablePhoneNumbersResult> searchAvailablePhoneNumbersAsync(
            final SearchAvailablePhoneNumbersRequest searchAvailablePhoneNumbersRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchAvailablePhoneNumbersResult>() {
            public SearchAvailablePhoneNumbersResult call() throws Exception {
                return searchAvailablePhoneNumbers(searchAvailablePhoneNumbersRequest);
            }
        });
    }

    /**
     * <p>
     * Searches for available phone numbers that you can claim to your Amazon
     * Connect instance.
     * </p>
     * 
     * @param searchAvailablePhoneNumbersRequest
     * @return A Java Future object containing the response from the
     *         SearchAvailablePhoneNumbers service method, as returned by Amazon
     *         Connect.
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchAvailablePhoneNumbersResult> searchAvailablePhoneNumbersAsync(
            final SearchAvailablePhoneNumbersRequest searchAvailablePhoneNumbersRequest,
            final AsyncHandler<SearchAvailablePhoneNumbersRequest, SearchAvailablePhoneNumbersResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchAvailablePhoneNumbersResult>() {
            public SearchAvailablePhoneNumbersResult call() throws Exception {
                SearchAvailablePhoneNumbersResult result = null;
                try {
                    result = searchAvailablePhoneNumbers(searchAvailablePhoneNumbersRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchAvailablePhoneNumbersRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches queues in an Amazon Connect instance, with optional filtering.
     * </p>
     * 
     * @param searchQueuesRequest
     * @return A Java Future object containing the response from the
     *         SearchQueues service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchQueuesResult> searchQueuesAsync(
            final SearchQueuesRequest searchQueuesRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<SearchQueuesResult>() {
            public SearchQueuesResult call() throws Exception {
                return searchQueues(searchQueuesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches queues in an Amazon Connect instance, with optional filtering.
     * </p>
     * 
     * @param searchQueuesRequest
     * @return A Java Future object containing the response from the
     *         SearchQueues service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchQueuesResult> searchQueuesAsync(
            final SearchQueuesRequest searchQueuesRequest,
            final AsyncHandler<SearchQueuesRequest, SearchQueuesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchQueuesResult>() {
            public SearchQueuesResult call() throws Exception {
                SearchQueuesResult result = null;
                try {
                    result = searchQueues(searchQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches routing profiles in an Amazon Connect instance, with optional
     * filtering.
     * </p>
     * 
     * @param searchRoutingProfilesRequest
     * @return A Java Future object containing the response from the
     *         SearchRoutingProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchRoutingProfilesResult> searchRoutingProfilesAsync(
            final SearchRoutingProfilesRequest searchRoutingProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchRoutingProfilesResult>() {
            public SearchRoutingProfilesResult call() throws Exception {
                return searchRoutingProfiles(searchRoutingProfilesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches routing profiles in an Amazon Connect instance, with optional
     * filtering.
     * </p>
     * 
     * @param searchRoutingProfilesRequest
     * @return A Java Future object containing the response from the
     *         SearchRoutingProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchRoutingProfilesResult> searchRoutingProfilesAsync(
            final SearchRoutingProfilesRequest searchRoutingProfilesRequest,
            final AsyncHandler<SearchRoutingProfilesRequest, SearchRoutingProfilesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchRoutingProfilesResult>() {
            public SearchRoutingProfilesResult call() throws Exception {
                SearchRoutingProfilesResult result = null;
                try {
                    result = searchRoutingProfiles(searchRoutingProfilesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchRoutingProfilesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches security profiles in an Amazon Connect instance, with optional
     * filtering.
     * </p>
     * 
     * @param searchSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         SearchSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchSecurityProfilesResult> searchSecurityProfilesAsync(
            final SearchSecurityProfilesRequest searchSecurityProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchSecurityProfilesResult>() {
            public SearchSecurityProfilesResult call() throws Exception {
                return searchSecurityProfiles(searchSecurityProfilesRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Searches security profiles in an Amazon Connect instance, with optional
     * filtering.
     * </p>
     * 
     * @param searchSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         SearchSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchSecurityProfilesResult> searchSecurityProfilesAsync(
            final SearchSecurityProfilesRequest searchSecurityProfilesRequest,
            final AsyncHandler<SearchSecurityProfilesRequest, SearchSecurityProfilesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchSecurityProfilesResult>() {
            public SearchSecurityProfilesResult call() throws Exception {
                SearchSecurityProfilesResult result = null;
                try {
                    result = searchSecurityProfiles(searchSecurityProfilesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchSecurityProfilesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Searches users in an Amazon Connect instance, with optional filtering.
     * </p>
     * 
     * @param searchUsersRequest
     * @return A Java Future object containing the response from the SearchUsers
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchUsersResult> searchUsersAsync(final SearchUsersRequest searchUsersRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchUsersResult>() {
            public SearchUsersResult call() throws Exception {
                return searchUsers(searchUsersRequest);
            }
        });
    }

    /**
     * <p>
     * Searches users in an Amazon Connect instance, with optional filtering.
     * </p>
     * 
     * @param searchUsersRequest
     * @return A Java Future object containing the response from the SearchUsers
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchUsersResult> searchUsersAsync(final SearchUsersRequest searchUsersRequest,
            final AsyncHandler<SearchUsersRequest, SearchUsersResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchUsersResult>() {
            public SearchUsersResult call() throws Exception {
                SearchUsersResult result = null;
                try {
                    result = searchUsers(searchUsersRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchUsersRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Searches for vocabularies within a specific Amazon Connect instance using
     * <code>State</code>, <code>NameStartsWith</code>, and
     * <code>LanguageCode</code>.
     * </p>
     * 
     * @param searchVocabulariesRequest
     * @return A Java Future object containing the response from the
     *         SearchVocabularies service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchVocabulariesResult> searchVocabulariesAsync(
            final SearchVocabulariesRequest searchVocabulariesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchVocabulariesResult>() {
            public SearchVocabulariesResult call() throws Exception {
                return searchVocabularies(searchVocabulariesRequest);
            }
        });
    }

    /**
     * <p>
     * Searches for vocabularies within a specific Amazon Connect instance using
     * <code>State</code>, <code>NameStartsWith</code>, and
     * <code>LanguageCode</code>.
     * </p>
     * 
     * @param searchVocabulariesRequest
     * @return A Java Future object containing the response from the
     *         SearchVocabularies service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SearchVocabulariesResult> searchVocabulariesAsync(
            final SearchVocabulariesRequest searchVocabulariesRequest,
            final AsyncHandler<SearchVocabulariesRequest, SearchVocabulariesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SearchVocabulariesResult>() {
            public SearchVocabulariesResult call() throws Exception {
                SearchVocabulariesResult result = null;
                try {
                    result = searchVocabularies(searchVocabulariesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(searchVocabulariesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Initiates a flow to start a new chat for the customer. Response of this
     * API provides a token required to obtain credentials from the <a href=
     * "https://docs.aws.amazon.com/connect-participant/latest/APIReference/API_CreateParticipantConnection.html"
     * >CreateParticipantConnection</a> API in the Amazon Connect Participant
     * Service.
     * </p>
     * <p>
     * When a new chat contact is successfully created, clients must subscribe
     * to the participant’s connection for the created chat within 5 minutes.
     * This is achieved by invoking <a href=
     * "https://docs.aws.amazon.com/connect-participant/latest/APIReference/API_CreateParticipantConnection.html"
     * >CreateParticipantConnection</a> with WEBSOCKET and
     * CONNECTION_CREDENTIALS.
     * </p>
     * <p>
     * A 429 error occurs in the following situations:
     * </p>
     * <ul>
     * <li>
     * <p>
     * API rate limit is exceeded. API TPS throttling returns a
     * <code>TooManyRequests</code> exception.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html"
     * >quota for concurrent active chats</a> is exceeded. Active chat
     * throttling returns a <code>LimitExceededException</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If you use the <code>ChatDurationInMinutes</code> parameter and receive a
     * 400 error, your account may not support the ability to configure custom
     * chat durations. For more information, contact Amazon Web Services
     * Support.
     * </p>
     * <p>
     * For more information about chat, see <a
     * href="https://docs.aws.amazon.com/connect/latest/adminguide/chat.html"
     * >Chat</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param startChatContactRequest
     * @return A Java Future object containing the response from the
     *         StartChatContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartChatContactResult> startChatContactAsync(
            final StartChatContactRequest startChatContactRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<StartChatContactResult>() {
            public StartChatContactResult call() throws Exception {
                return startChatContact(startChatContactRequest);
            }
        });
    }

    /**
     * <p>
     * Initiates a flow to start a new chat for the customer. Response of this
     * API provides a token required to obtain credentials from the <a href=
     * "https://docs.aws.amazon.com/connect-participant/latest/APIReference/API_CreateParticipantConnection.html"
     * >CreateParticipantConnection</a> API in the Amazon Connect Participant
     * Service.
     * </p>
     * <p>
     * When a new chat contact is successfully created, clients must subscribe
     * to the participant’s connection for the created chat within 5 minutes.
     * This is achieved by invoking <a href=
     * "https://docs.aws.amazon.com/connect-participant/latest/APIReference/API_CreateParticipantConnection.html"
     * >CreateParticipantConnection</a> with WEBSOCKET and
     * CONNECTION_CREDENTIALS.
     * </p>
     * <p>
     * A 429 error occurs in the following situations:
     * </p>
     * <ul>
     * <li>
     * <p>
     * API rate limit is exceeded. API TPS throttling returns a
     * <code>TooManyRequests</code> exception.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html"
     * >quota for concurrent active chats</a> is exceeded. Active chat
     * throttling returns a <code>LimitExceededException</code>.
     * </p>
     * </li>
     * </ul>
     * <p>
     * If you use the <code>ChatDurationInMinutes</code> parameter and receive a
     * 400 error, your account may not support the ability to configure custom
     * chat durations. For more information, contact Amazon Web Services
     * Support.
     * </p>
     * <p>
     * For more information about chat, see <a
     * href="https://docs.aws.amazon.com/connect/latest/adminguide/chat.html"
     * >Chat</a> in the <i>Amazon Connect Administrator Guide</i>.
     * </p>
     * 
     * @param startChatContactRequest
     * @return A Java Future object containing the response from the
     *         StartChatContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartChatContactResult> startChatContactAsync(
            final StartChatContactRequest startChatContactRequest,
            final AsyncHandler<StartChatContactRequest, StartChatContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartChatContactResult>() {
            public StartChatContactResult call() throws Exception {
                StartChatContactResult result = null;
                try {
                    result = startChatContact(startChatContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(startChatContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Starts recording the contact:
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the API is called <i>before</i> the agent joins the call, recording
     * starts when the agent joins the call.
     * </p>
     * </li>
     * <li>
     * <p>
     * If the API is called <i>after</i> the agent joins the call, recording
     * starts at the time of the API call.
     * </p>
     * </li>
     * </ul>
     * <p>
     * StartContactRecording is a one-time action. For example, if you use
     * StopContactRecording to stop recording an ongoing call, you can't use
     * StartContactRecording to restart it. For scenarios where the recording
     * has started and you want to suspend and resume it, such as when
     * collecting sensitive information (for example, a credit card number), use
     * SuspendContactRecording and ResumeContactRecording.
     * </p>
     * <p>
     * You can use this API to override the recording behavior configured in the
     * <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-recording-behavior.html"
     * >Set recording behavior</a> block.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param startContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         StartContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartContactRecordingResult> startContactRecordingAsync(
            final StartContactRecordingRequest startContactRecordingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartContactRecordingResult>() {
            public StartContactRecordingResult call() throws Exception {
                return startContactRecording(startContactRecordingRequest);
            }
        });
    }

    /**
     * <p>
     * Starts recording the contact:
     * </p>
     * <ul>
     * <li>
     * <p>
     * If the API is called <i>before</i> the agent joins the call, recording
     * starts when the agent joins the call.
     * </p>
     * </li>
     * <li>
     * <p>
     * If the API is called <i>after</i> the agent joins the call, recording
     * starts at the time of the API call.
     * </p>
     * </li>
     * </ul>
     * <p>
     * StartContactRecording is a one-time action. For example, if you use
     * StopContactRecording to stop recording an ongoing call, you can't use
     * StartContactRecording to restart it. For scenarios where the recording
     * has started and you want to suspend and resume it, such as when
     * collecting sensitive information (for example, a credit card number), use
     * SuspendContactRecording and ResumeContactRecording.
     * </p>
     * <p>
     * You can use this API to override the recording behavior configured in the
     * <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/set-recording-behavior.html"
     * >Set recording behavior</a> block.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param startContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         StartContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartContactRecordingResult> startContactRecordingAsync(
            final StartContactRecordingRequest startContactRecordingRequest,
            final AsyncHandler<StartContactRecordingRequest, StartContactRecordingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartContactRecordingResult>() {
            public StartContactRecordingResult call() throws Exception {
                StartContactRecordingResult result = null;
                try {
                    result = startContactRecording(startContactRecordingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(startContactRecordingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Initiates real-time message streaming for a new chat contact.
     * </p>
     * <p>
     * For more information about message streaming, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/chat-message-streaming.html"
     * >Enable real-time chat message streaming</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param startContactStreamingRequest
     * @return A Java Future object containing the response from the
     *         StartContactStreaming service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartContactStreamingResult> startContactStreamingAsync(
            final StartContactStreamingRequest startContactStreamingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartContactStreamingResult>() {
            public StartContactStreamingResult call() throws Exception {
                return startContactStreaming(startContactStreamingRequest);
            }
        });
    }

    /**
     * <p>
     * Initiates real-time message streaming for a new chat contact.
     * </p>
     * <p>
     * For more information about message streaming, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/chat-message-streaming.html"
     * >Enable real-time chat message streaming</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * 
     * @param startContactStreamingRequest
     * @return A Java Future object containing the response from the
     *         StartContactStreaming service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartContactStreamingResult> startContactStreamingAsync(
            final StartContactStreamingRequest startContactStreamingRequest,
            final AsyncHandler<StartContactStreamingRequest, StartContactStreamingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartContactStreamingResult>() {
            public StartContactStreamingResult call() throws Exception {
                StartContactStreamingResult result = null;
                try {
                    result = startContactStreaming(startContactStreamingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(startContactStreamingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Places an outbound call to a contact, and then initiates the flow. It
     * performs the actions in the flow that's specified (in
     * <code>ContactFlowId</code>).
     * </p>
     * <p>
     * Agents do not initiate the outbound API, which means that they do not
     * dial the contact. If the flow places an outbound call to a contact, and
     * then puts the contact in queue, the call is then routed to the agent,
     * like any other inbound case.
     * </p>
     * <p>
     * There is a 60-second dialing timeout for this operation. If the call is
     * not connected after 60 seconds, it fails.
     * </p>
     * <note>
     * <p>
     * UK numbers with a 447 prefix are not allowed by default. Before you can
     * dial these UK mobile numbers, you must submit a service quota increase
     * request. For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html"
     * >Amazon Connect Service Quotas</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * </note> <note>
     * <p>
     * Campaign calls are not allowed by default. Before you can make a call
     * with <code>TrafficType</code> = <code>CAMPAIGN</code>, you must submit a
     * service quota increase request to the quota <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html#outbound-communications-quotas"
     * >Amazon Connect campaigns</a>.
     * </p>
     * </note>
     * 
     * @param startOutboundVoiceContactRequest
     * @return A Java Future object containing the response from the
     *         StartOutboundVoiceContact service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws DestinationNotAllowedException
     * @throws OutboundContactNotPermittedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartOutboundVoiceContactResult> startOutboundVoiceContactAsync(
            final StartOutboundVoiceContactRequest startOutboundVoiceContactRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartOutboundVoiceContactResult>() {
            public StartOutboundVoiceContactResult call() throws Exception {
                return startOutboundVoiceContact(startOutboundVoiceContactRequest);
            }
        });
    }

    /**
     * <p>
     * Places an outbound call to a contact, and then initiates the flow. It
     * performs the actions in the flow that's specified (in
     * <code>ContactFlowId</code>).
     * </p>
     * <p>
     * Agents do not initiate the outbound API, which means that they do not
     * dial the contact. If the flow places an outbound call to a contact, and
     * then puts the contact in queue, the call is then routed to the agent,
     * like any other inbound case.
     * </p>
     * <p>
     * There is a 60-second dialing timeout for this operation. If the call is
     * not connected after 60 seconds, it fails.
     * </p>
     * <note>
     * <p>
     * UK numbers with a 447 prefix are not allowed by default. Before you can
     * dial these UK mobile numbers, you must submit a service quota increase
     * request. For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html"
     * >Amazon Connect Service Quotas</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * </note> <note>
     * <p>
     * Campaign calls are not allowed by default. Before you can make a call
     * with <code>TrafficType</code> = <code>CAMPAIGN</code>, you must submit a
     * service quota increase request to the quota <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html#outbound-communications-quotas"
     * >Amazon Connect campaigns</a>.
     * </p>
     * </note>
     * 
     * @param startOutboundVoiceContactRequest
     * @return A Java Future object containing the response from the
     *         StartOutboundVoiceContact service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws LimitExceededException
     * @throws DestinationNotAllowedException
     * @throws OutboundContactNotPermittedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartOutboundVoiceContactResult> startOutboundVoiceContactAsync(
            final StartOutboundVoiceContactRequest startOutboundVoiceContactRequest,
            final AsyncHandler<StartOutboundVoiceContactRequest, StartOutboundVoiceContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartOutboundVoiceContactResult>() {
            public StartOutboundVoiceContactResult call() throws Exception {
                StartOutboundVoiceContactResult result = null;
                try {
                    result = startOutboundVoiceContact(startOutboundVoiceContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(startOutboundVoiceContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Initiates a flow to start a new task.
     * </p>
     * 
     * @param startTaskContactRequest
     * @return A Java Future object containing the response from the
     *         StartTaskContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartTaskContactResult> startTaskContactAsync(
            final StartTaskContactRequest startTaskContactRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<StartTaskContactResult>() {
            public StartTaskContactResult call() throws Exception {
                return startTaskContact(startTaskContactRequest);
            }
        });
    }

    /**
     * <p>
     * Initiates a flow to start a new task.
     * </p>
     * 
     * @param startTaskContactRequest
     * @return A Java Future object containing the response from the
     *         StartTaskContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StartTaskContactResult> startTaskContactAsync(
            final StartTaskContactRequest startTaskContactRequest,
            final AsyncHandler<StartTaskContactRequest, StartTaskContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StartTaskContactResult>() {
            public StartTaskContactResult call() throws Exception {
                StartTaskContactResult result = null;
                try {
                    result = startTaskContact(startTaskContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(startTaskContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Ends the specified contact. This call does not work for the following
     * initiation methods:
     * </p>
     * <ul>
     * <li>
     * <p>
     * DISCONNECT
     * </p>
     * </li>
     * <li>
     * <p>
     * TRANSFER
     * </p>
     * </li>
     * <li>
     * <p>
     * QUEUE_TRANSFER
     * </p>
     * </li>
     * </ul>
     * 
     * @param stopContactRequest
     * @return A Java Future object containing the response from the StopContact
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ContactNotFoundException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactResult> stopContactAsync(final StopContactRequest stopContactRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactResult>() {
            public StopContactResult call() throws Exception {
                return stopContact(stopContactRequest);
            }
        });
    }

    /**
     * <p>
     * Ends the specified contact. This call does not work for the following
     * initiation methods:
     * </p>
     * <ul>
     * <li>
     * <p>
     * DISCONNECT
     * </p>
     * </li>
     * <li>
     * <p>
     * TRANSFER
     * </p>
     * </li>
     * <li>
     * <p>
     * QUEUE_TRANSFER
     * </p>
     * </li>
     * </ul>
     * 
     * @param stopContactRequest
     * @return A Java Future object containing the response from the StopContact
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws ContactNotFoundException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactResult> stopContactAsync(final StopContactRequest stopContactRequest,
            final AsyncHandler<StopContactRequest, StopContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactResult>() {
            public StopContactResult call() throws Exception {
                StopContactResult result = null;
                try {
                    result = stopContact(stopContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(stopContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Stops recording a call when a contact is being recorded.
     * StopContactRecording is a one-time action. If you use
     * StopContactRecording to stop recording an ongoing call, you can't use
     * StartContactRecording to restart it. For scenarios where the recording
     * has started and you want to suspend it for sensitive information (for
     * example, to collect a credit card number), and then restart it, use
     * SuspendContactRecording and ResumeContactRecording.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param stopContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         StopContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactRecordingResult> stopContactRecordingAsync(
            final StopContactRecordingRequest stopContactRecordingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactRecordingResult>() {
            public StopContactRecordingResult call() throws Exception {
                return stopContactRecording(stopContactRecordingRequest);
            }
        });
    }

    /**
     * <p>
     * Stops recording a call when a contact is being recorded.
     * StopContactRecording is a one-time action. If you use
     * StopContactRecording to stop recording an ongoing call, you can't use
     * StartContactRecording to restart it. For scenarios where the recording
     * has started and you want to suspend it for sensitive information (for
     * example, to collect a credit card number), and then restart it, use
     * SuspendContactRecording and ResumeContactRecording.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param stopContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         StopContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactRecordingResult> stopContactRecordingAsync(
            final StopContactRecordingRequest stopContactRecordingRequest,
            final AsyncHandler<StopContactRecordingRequest, StopContactRecordingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactRecordingResult>() {
            public StopContactRecordingResult call() throws Exception {
                StopContactRecordingResult result = null;
                try {
                    result = stopContactRecording(stopContactRecordingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(stopContactRecordingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Ends message streaming on a specified contact. To restart message
     * streaming on that contact, call the <a href=
     * "https://docs.aws.amazon.com/connect/latest/APIReference/API_StartContactStreaming.html"
     * >StartContactStreaming</a> API.
     * </p>
     * 
     * @param stopContactStreamingRequest
     * @return A Java Future object containing the response from the
     *         StopContactStreaming service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactStreamingResult> stopContactStreamingAsync(
            final StopContactStreamingRequest stopContactStreamingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactStreamingResult>() {
            public StopContactStreamingResult call() throws Exception {
                return stopContactStreaming(stopContactStreamingRequest);
            }
        });
    }

    /**
     * <p>
     * Ends message streaming on a specified contact. To restart message
     * streaming on that contact, call the <a href=
     * "https://docs.aws.amazon.com/connect/latest/APIReference/API_StartContactStreaming.html"
     * >StartContactStreaming</a> API.
     * </p>
     * 
     * @param stopContactStreamingRequest
     * @return A Java Future object containing the response from the
     *         StopContactStreaming service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<StopContactStreamingResult> stopContactStreamingAsync(
            final StopContactStreamingRequest stopContactStreamingRequest,
            final AsyncHandler<StopContactStreamingRequest, StopContactStreamingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<StopContactStreamingResult>() {
            public StopContactStreamingResult call() throws Exception {
                StopContactStreamingResult result = null;
                try {
                    result = stopContactStreaming(stopContactStreamingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(stopContactStreamingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * When a contact is being recorded, this API suspends recording the call.
     * For example, you might suspend the call recording while collecting
     * sensitive information, such as a credit card number. Then use
     * ResumeContactRecording to restart recording.
     * </p>
     * <p>
     * The period of time that the recording is suspended is filled with silence
     * in the final recording.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param suspendContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         SuspendContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SuspendContactRecordingResult> suspendContactRecordingAsync(
            final SuspendContactRecordingRequest suspendContactRecordingRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SuspendContactRecordingResult>() {
            public SuspendContactRecordingResult call() throws Exception {
                return suspendContactRecording(suspendContactRecordingRequest);
            }
        });
    }

    /**
     * <p>
     * When a contact is being recorded, this API suspends recording the call.
     * For example, you might suspend the call recording while collecting
     * sensitive information, such as a credit card number. Then use
     * ResumeContactRecording to restart recording.
     * </p>
     * <p>
     * The period of time that the recording is suspended is filled with silence
     * in the final recording.
     * </p>
     * <p>
     * Only voice recordings are supported at this time.
     * </p>
     * 
     * @param suspendContactRecordingRequest
     * @return A Java Future object containing the response from the
     *         SuspendContactRecording service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<SuspendContactRecordingResult> suspendContactRecordingAsync(
            final SuspendContactRecordingRequest suspendContactRecordingRequest,
            final AsyncHandler<SuspendContactRecordingRequest, SuspendContactRecordingResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SuspendContactRecordingResult>() {
            public SuspendContactRecordingResult call() throws Exception {
                SuspendContactRecordingResult result = null;
                try {
                    result = suspendContactRecording(suspendContactRecordingRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(suspendContactRecordingRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Adds the specified tags to the specified resource.
     * </p>
     * <p>
     * Some of the supported resource types are agents, routing profiles,
     * queues, quick connects, contact flows, agent statuses, hours of
     * operation, phone numbers, security profiles, and task templates. For a
     * complete list, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/tagging.html"
     * >Tagging resources in Amazon Connect</a>.
     * </p>
     * <p>
     * For sample policies that use tags, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security_iam_id-based-policy-examples.html"
     * >Amazon Connect Identity-Based Policy Examples</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param tagResourceRequest
     * @return A Java Future object containing the response from the TagResource
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> tagResourceAsync(final TagResourceRequest tagResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                tagResource(tagResourceRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Adds the specified tags to the specified resource.
     * </p>
     * <p>
     * Some of the supported resource types are agents, routing profiles,
     * queues, quick connects, contact flows, agent statuses, hours of
     * operation, phone numbers, security profiles, and task templates. For a
     * complete list, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/tagging.html"
     * >Tagging resources in Amazon Connect</a>.
     * </p>
     * <p>
     * For sample policies that use tags, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security_iam_id-based-policy-examples.html"
     * >Amazon Connect Identity-Based Policy Examples</a> in the <i>Amazon
     * Connect Administrator Guide</i>.
     * </p>
     * 
     * @param tagResourceRequest
     * @return A Java Future object containing the response from the TagResource
     *         service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> tagResourceAsync(final TagResourceRequest tagResourceRequest,
            final AsyncHandler<TagResourceRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    tagResource(tagResourceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(tagResourceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Transfers contacts from one agent or queue to another agent or queue at
     * any point after a contact is created. You can transfer a contact to
     * another queue by providing the flow which orchestrates the contact to the
     * destination queue. This gives you more control over contact handling and
     * helps you adhere to the service level agreement (SLA) guaranteed to your
     * customers.
     * </p>
     * <p>
     * Note the following requirements:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Transfer is supported for only <code>TASK</code> contacts.
     * </p>
     * </li>
     * <li>
     * <p>
     * Do not use both <code>QueueId</code> and <code>UserId</code> in the same
     * call.
     * </p>
     * </li>
     * <li>
     * <p>
     * The following flow types are supported: Inbound flow, Transfer to agent
     * flow, and Transfer to queue flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <code>TransferContact</code> API can be called only on active
     * contacts.
     * </p>
     * </li>
     * <li>
     * <p>
     * A contact cannot be transferred more than 11 times.
     * </p>
     * </li>
     * </ul>
     * 
     * @param transferContactRequest
     * @return A Java Future object containing the response from the
     *         TransferContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws ResourceNotFoundException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<TransferContactResult> transferContactAsync(
            final TransferContactRequest transferContactRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<TransferContactResult>() {
            public TransferContactResult call() throws Exception {
                return transferContact(transferContactRequest);
            }
        });
    }

    /**
     * <p>
     * Transfers contacts from one agent or queue to another agent or queue at
     * any point after a contact is created. You can transfer a contact to
     * another queue by providing the flow which orchestrates the contact to the
     * destination queue. This gives you more control over contact handling and
     * helps you adhere to the service level agreement (SLA) guaranteed to your
     * customers.
     * </p>
     * <p>
     * Note the following requirements:
     * </p>
     * <ul>
     * <li>
     * <p>
     * Transfer is supported for only <code>TASK</code> contacts.
     * </p>
     * </li>
     * <li>
     * <p>
     * Do not use both <code>QueueId</code> and <code>UserId</code> in the same
     * call.
     * </p>
     * </li>
     * <li>
     * <p>
     * The following flow types are supported: Inbound flow, Transfer to agent
     * flow, and Transfer to queue flow.
     * </p>
     * </li>
     * <li>
     * <p>
     * The <code>TransferContact</code> API can be called only on active
     * contacts.
     * </p>
     * </li>
     * <li>
     * <p>
     * A contact cannot be transferred more than 11 times.
     * </p>
     * </li>
     * </ul>
     * 
     * @param transferContactRequest
     * @return A Java Future object containing the response from the
     *         TransferContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws ResourceNotFoundException
     * @throws ServiceQuotaExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<TransferContactResult> transferContactAsync(
            final TransferContactRequest transferContactRequest,
            final AsyncHandler<TransferContactRequest, TransferContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<TransferContactResult>() {
            public TransferContactResult call() throws Exception {
                TransferContactResult result = null;
                try {
                    result = transferContact(transferContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(transferContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Removes the specified tags from the specified resource.
     * </p>
     * 
     * @param untagResourceRequest
     * @return A Java Future object containing the response from the
     *         UntagResource service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> untagResourceAsync(final UntagResourceRequest untagResourceRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                untagResource(untagResourceRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Removes the specified tags from the specified resource.
     * </p>
     * 
     * @param untagResourceRequest
     * @return A Java Future object containing the response from the
     *         UntagResource service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws InternalServiceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> untagResourceAsync(final UntagResourceRequest untagResourceRequest,
            final AsyncHandler<UntagResourceRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    untagResource(untagResourceRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(untagResourceRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates agent status.
     * </p>
     * 
     * @param updateAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         UpdateAgentStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateAgentStatusAsync(
            final UpdateAgentStatusRequest updateAgentStatusRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateAgentStatus(updateAgentStatusRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates agent status.
     * </p>
     * 
     * @param updateAgentStatusRequest
     * @return A Java Future object containing the response from the
     *         UpdateAgentStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws LimitExceededException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateAgentStatusAsync(
            final UpdateAgentStatusRequest updateAgentStatusRequest,
            final AsyncHandler<UpdateAgentStatusRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateAgentStatus(updateAgentStatusRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateAgentStatusRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Adds or updates user-defined contact information associated with the
     * specified contact. At least one field to be updated must be present in
     * the request.
     * </p>
     * <important>
     * <p>
     * You can add or update user-defined contact information for both ongoing
     * and completed contacts.
     * </p>
     * </important>
     * 
     * @param updateContactRequest
     * @return A Java Future object containing the response from the
     *         UpdateContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactResult> updateContactAsync(
            final UpdateContactRequest updateContactRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<UpdateContactResult>() {
            public UpdateContactResult call() throws Exception {
                return updateContact(updateContactRequest);
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Adds or updates user-defined contact information associated with the
     * specified contact. At least one field to be updated must be present in
     * the request.
     * </p>
     * <important>
     * <p>
     * You can add or update user-defined contact information for both ongoing
     * and completed contacts.
     * </p>
     * </important>
     * 
     * @param updateContactRequest
     * @return A Java Future object containing the response from the
     *         UpdateContact service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactResult> updateContactAsync(
            final UpdateContactRequest updateContactRequest,
            final AsyncHandler<UpdateContactRequest, UpdateContactResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactResult>() {
            public UpdateContactResult call() throws Exception {
                UpdateContactResult result = null;
                try {
                    result = updateContact(updateContactRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Creates or updates user-defined contact attributes associated with the
     * specified contact.
     * </p>
     * <p>
     * You can create or update user-defined attributes for both ongoing and
     * completed contacts. For example, while the call is active, you can update
     * the customer's name or the reason the customer called. You can add notes
     * about steps that the agent took during the call that display to the next
     * agent that takes the call. You can also update attributes for a contact
     * using data from your CRM application and save the data with the contact
     * in Amazon Connect. You could also flag calls for additional analysis,
     * such as legal review or to identify abusive callers.
     * </p>
     * <p>
     * Contact attributes are available in Amazon Connect for 24 months, and are
     * then deleted. For information about contact record retention and the
     * maximum size of the contact record attributes section, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html#feature-limits"
     * >Feature specifications</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param updateContactAttributesRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactAttributes service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactAttributesResult> updateContactAttributesAsync(
            final UpdateContactAttributesRequest updateContactAttributesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactAttributesResult>() {
            public UpdateContactAttributesResult call() throws Exception {
                return updateContactAttributes(updateContactAttributesRequest);
            }
        });
    }

    /**
     * <p>
     * Creates or updates user-defined contact attributes associated with the
     * specified contact.
     * </p>
     * <p>
     * You can create or update user-defined attributes for both ongoing and
     * completed contacts. For example, while the call is active, you can update
     * the customer's name or the reason the customer called. You can add notes
     * about steps that the agent took during the call that display to the next
     * agent that takes the call. You can also update attributes for a contact
     * using data from your CRM application and save the data with the contact
     * in Amazon Connect. You could also flag calls for additional analysis,
     * such as legal review or to identify abusive callers.
     * </p>
     * <p>
     * Contact attributes are available in Amazon Connect for 24 months, and are
     * then deleted. For information about contact record retention and the
     * maximum size of the contact record attributes section, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/amazon-connect-service-limits.html#feature-limits"
     * >Feature specifications</a> in the <i>Amazon Connect Administrator
     * Guide</i>.
     * </p>
     * 
     * @param updateContactAttributesRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactAttributes service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactAttributesResult> updateContactAttributesAsync(
            final UpdateContactAttributesRequest updateContactAttributesRequest,
            final AsyncHandler<UpdateContactAttributesRequest, UpdateContactAttributesResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactAttributesResult>() {
            public UpdateContactAttributesResult call() throws Exception {
                UpdateContactAttributesResult result = null;
                try {
                    result = updateContactAttributes(updateContactAttributesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactAttributesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the specified flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param updateContactFlowContentRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowContent service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidContactFlowException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowContentAsync(
            final UpdateContactFlowContentRequest updateContactFlowContentRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateContactFlowContent(updateContactFlowContentRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the specified flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param updateContactFlowContentRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowContent service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidContactFlowException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowContentAsync(
            final UpdateContactFlowContentRequest updateContactFlowContentRequest,
            final AsyncHandler<UpdateContactFlowContentRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateContactFlowContent(updateContactFlowContentRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactFlowContentRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates metadata about specified flow.
     * </p>
     * 
     * @param updateContactFlowMetadataRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowMetadata service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowMetadataAsync(
            final UpdateContactFlowMetadataRequest updateContactFlowMetadataRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateContactFlowMetadata(updateContactFlowMetadataRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates metadata about specified flow.
     * </p>
     * 
     * @param updateContactFlowMetadataRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowMetadata service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowMetadataAsync(
            final UpdateContactFlowMetadataRequest updateContactFlowMetadataRequest,
            final AsyncHandler<UpdateContactFlowMetadataRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateContactFlowMetadata(updateContactFlowMetadataRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactFlowMetadataRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates specified flow module for the specified Amazon Connect instance.
     * </p>
     * 
     * @param updateContactFlowModuleContentRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowModuleContent service method, as returned by
     *         Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidContactFlowModuleException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactFlowModuleContentResult> updateContactFlowModuleContentAsync(
            final UpdateContactFlowModuleContentRequest updateContactFlowModuleContentRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactFlowModuleContentResult>() {
            public UpdateContactFlowModuleContentResult call() throws Exception {
                return updateContactFlowModuleContent(updateContactFlowModuleContentRequest);
            }
        });
    }

    /**
     * <p>
     * Updates specified flow module for the specified Amazon Connect instance.
     * </p>
     * 
     * @param updateContactFlowModuleContentRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowModuleContent service method, as returned by
     *         Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidContactFlowModuleException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactFlowModuleContentResult> updateContactFlowModuleContentAsync(
            final UpdateContactFlowModuleContentRequest updateContactFlowModuleContentRequest,
            final AsyncHandler<UpdateContactFlowModuleContentRequest, UpdateContactFlowModuleContentResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactFlowModuleContentResult>() {
            public UpdateContactFlowModuleContentResult call() throws Exception {
                UpdateContactFlowModuleContentResult result = null;
                try {
                    result = updateContactFlowModuleContent(updateContactFlowModuleContentRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactFlowModuleContentRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates metadata about specified flow module.
     * </p>
     * 
     * @param updateContactFlowModuleMetadataRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowModuleMetadata service method, as returned by
     *         Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactFlowModuleMetadataResult> updateContactFlowModuleMetadataAsync(
            final UpdateContactFlowModuleMetadataRequest updateContactFlowModuleMetadataRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactFlowModuleMetadataResult>() {
            public UpdateContactFlowModuleMetadataResult call() throws Exception {
                return updateContactFlowModuleMetadata(updateContactFlowModuleMetadataRequest);
            }
        });
    }

    /**
     * <p>
     * Updates metadata about specified flow module.
     * </p>
     * 
     * @param updateContactFlowModuleMetadataRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowModuleMetadata service method, as returned by
     *         Amazon Connect.
     * @throws AccessDeniedException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactFlowModuleMetadataResult> updateContactFlowModuleMetadataAsync(
            final UpdateContactFlowModuleMetadataRequest updateContactFlowModuleMetadataRequest,
            final AsyncHandler<UpdateContactFlowModuleMetadataRequest, UpdateContactFlowModuleMetadataResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactFlowModuleMetadataResult>() {
            public UpdateContactFlowModuleMetadataResult call() throws Exception {
                UpdateContactFlowModuleMetadataResult result = null;
                try {
                    result = updateContactFlowModuleMetadata(updateContactFlowModuleMetadataRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactFlowModuleMetadataRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * The name of the flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param updateContactFlowNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowName service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowNameAsync(
            final UpdateContactFlowNameRequest updateContactFlowNameRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateContactFlowName(updateContactFlowNameRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * The name of the flow.
     * </p>
     * <p>
     * You can also create and update flows using the <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/flow-language.html"
     * >Amazon Connect Flow language</a>.
     * </p>
     * 
     * @param updateContactFlowNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactFlowName service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateContactFlowNameAsync(
            final UpdateContactFlowNameRequest updateContactFlowNameRequest,
            final AsyncHandler<UpdateContactFlowNameRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateContactFlowName(updateContactFlowNameRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactFlowNameRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the scheduled time of a task contact that is already scheduled.
     * </p>
     * 
     * @param updateContactScheduleRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactSchedule service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws LimitExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactScheduleResult> updateContactScheduleAsync(
            final UpdateContactScheduleRequest updateContactScheduleRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactScheduleResult>() {
            public UpdateContactScheduleResult call() throws Exception {
                return updateContactSchedule(updateContactScheduleRequest);
            }
        });
    }

    /**
     * <p>
     * Updates the scheduled time of a task contact that is already scheduled.
     * </p>
     * 
     * @param updateContactScheduleRequest
     * @return A Java Future object containing the response from the
     *         UpdateContactSchedule service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws LimitExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateContactScheduleResult> updateContactScheduleAsync(
            final UpdateContactScheduleRequest updateContactScheduleRequest,
            final AsyncHandler<UpdateContactScheduleRequest, UpdateContactScheduleResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateContactScheduleResult>() {
            public UpdateContactScheduleResult call() throws Exception {
                UpdateContactScheduleResult result = null;
                try {
                    result = updateContactSchedule(updateContactScheduleRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateContactScheduleRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the hours of operation.
     * </p>
     * 
     * @param updateHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         UpdateHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateHoursOfOperationAsync(
            final UpdateHoursOfOperationRequest updateHoursOfOperationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateHoursOfOperation(updateHoursOfOperationRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the hours of operation.
     * </p>
     * 
     * @param updateHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         UpdateHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateHoursOfOperationAsync(
            final UpdateHoursOfOperationRequest updateHoursOfOperationRequest,
            final AsyncHandler<UpdateHoursOfOperationRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateHoursOfOperation(updateHoursOfOperationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateHoursOfOperationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the value for the specified attribute type.
     * </p>
     * 
     * @param updateInstanceAttributeRequest
     * @return A Java Future object containing the response from the
     *         UpdateInstanceAttribute service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateInstanceAttributeAsync(
            final UpdateInstanceAttributeRequest updateInstanceAttributeRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateInstanceAttribute(updateInstanceAttributeRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the value for the specified attribute type.
     * </p>
     * 
     * @param updateInstanceAttributeRequest
     * @return A Java Future object containing the response from the
     *         UpdateInstanceAttribute service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateInstanceAttributeAsync(
            final UpdateInstanceAttributeRequest updateInstanceAttributeRequest,
            final AsyncHandler<UpdateInstanceAttributeRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateInstanceAttribute(updateInstanceAttributeRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateInstanceAttributeRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates an existing configuration for a resource type. This API is
     * idempotent.
     * </p>
     * 
     * @param updateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateInstanceStorageConfig service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateInstanceStorageConfigAsync(
            final UpdateInstanceStorageConfigRequest updateInstanceStorageConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateInstanceStorageConfig(updateInstanceStorageConfigRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates an existing configuration for a resource type. This API is
     * idempotent.
     * </p>
     * 
     * @param updateInstanceStorageConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateInstanceStorageConfig service method, as returned by Amazon
     *         Connect.
     * @throws ResourceNotFoundException
     * @throws InternalServiceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ThrottlingException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateInstanceStorageConfigAsync(
            final UpdateInstanceStorageConfigRequest updateInstanceStorageConfigRequest,
            final AsyncHandler<UpdateInstanceStorageConfigRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateInstanceStorageConfig(updateInstanceStorageConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateInstanceStorageConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates your claimed phone number from its current Amazon Connect
     * instance to another Amazon Connect instance in the same Region.
     * </p>
     * 
     * @param updatePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         UpdatePhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws ResourceInUseException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdatePhoneNumberResult> updatePhoneNumberAsync(
            final UpdatePhoneNumberRequest updatePhoneNumberRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<UpdatePhoneNumberResult>() {
            public UpdatePhoneNumberResult call() throws Exception {
                return updatePhoneNumber(updatePhoneNumberRequest);
            }
        });
    }

    /**
     * <p>
     * Updates your claimed phone number from its current Amazon Connect
     * instance to another Amazon Connect instance in the same Region.
     * </p>
     * 
     * @param updatePhoneNumberRequest
     * @return A Java Future object containing the response from the
     *         UpdatePhoneNumber service method, as returned by Amazon Connect.
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws ResourceInUseException
     * @throws IdempotencyException
     * @throws AccessDeniedException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdatePhoneNumberResult> updatePhoneNumberAsync(
            final UpdatePhoneNumberRequest updatePhoneNumberRequest,
            final AsyncHandler<UpdatePhoneNumberRequest, UpdatePhoneNumberResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdatePhoneNumberResult>() {
            public UpdatePhoneNumberResult call() throws Exception {
                UpdatePhoneNumberResult result = null;
                try {
                    result = updatePhoneNumber(updatePhoneNumberRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updatePhoneNumberRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the hours of operation for the specified queue.
     * </p>
     * 
     * @param updateQueueHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueHoursOfOperationAsync(
            final UpdateQueueHoursOfOperationRequest updateQueueHoursOfOperationRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQueueHoursOfOperation(updateQueueHoursOfOperationRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the hours of operation for the specified queue.
     * </p>
     * 
     * @param updateQueueHoursOfOperationRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueHoursOfOperation service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueHoursOfOperationAsync(
            final UpdateQueueHoursOfOperationRequest updateQueueHoursOfOperationRequest,
            final AsyncHandler<UpdateQueueHoursOfOperationRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQueueHoursOfOperation(updateQueueHoursOfOperationRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQueueHoursOfOperationRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the maximum number of contacts allowed in a queue before it is
     * considered full.
     * </p>
     * 
     * @param updateQueueMaxContactsRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueMaxContacts service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueMaxContactsAsync(
            final UpdateQueueMaxContactsRequest updateQueueMaxContactsRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQueueMaxContacts(updateQueueMaxContactsRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the maximum number of contacts allowed in a queue before it is
     * considered full.
     * </p>
     * 
     * @param updateQueueMaxContactsRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueMaxContacts service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueMaxContactsAsync(
            final UpdateQueueMaxContactsRequest updateQueueMaxContactsRequest,
            final AsyncHandler<UpdateQueueMaxContactsRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQueueMaxContacts(updateQueueMaxContactsRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQueueMaxContactsRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the name and description of a queue. At least <code>Name</code>
     * or <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateQueueNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueName service method, as returned by Amazon Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueNameAsync(final UpdateQueueNameRequest updateQueueNameRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQueueName(updateQueueNameRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the name and description of a queue. At least <code>Name</code>
     * or <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateQueueNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueName service method, as returned by Amazon Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueNameAsync(final UpdateQueueNameRequest updateQueueNameRequest,
            final AsyncHandler<UpdateQueueNameRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQueueName(updateQueueNameRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQueueNameRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the outbound caller ID name, number, and outbound whisper flow
     * for a specified queue.
     * </p>
     * 
     * @param updateQueueOutboundCallerConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueOutboundCallerConfig service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueOutboundCallerConfigAsync(
            final UpdateQueueOutboundCallerConfigRequest updateQueueOutboundCallerConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQueueOutboundCallerConfig(updateQueueOutboundCallerConfigRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the outbound caller ID name, number, and outbound whisper flow
     * for a specified queue.
     * </p>
     * 
     * @param updateQueueOutboundCallerConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueOutboundCallerConfig service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueOutboundCallerConfigAsync(
            final UpdateQueueOutboundCallerConfigRequest updateQueueOutboundCallerConfigRequest,
            final AsyncHandler<UpdateQueueOutboundCallerConfigRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQueueOutboundCallerConfig(updateQueueOutboundCallerConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQueueOutboundCallerConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the status of the queue.
     * </p>
     * 
     * @param updateQueueStatusRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueStatusAsync(
            final UpdateQueueStatusRequest updateQueueStatusRequest) throws AmazonServiceException,
            AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQueueStatus(updateQueueStatusRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates the status of the queue.
     * </p>
     * 
     * @param updateQueueStatusRequest
     * @return A Java Future object containing the response from the
     *         UpdateQueueStatus service method, as returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQueueStatusAsync(
            final UpdateQueueStatusRequest updateQueueStatusRequest,
            final AsyncHandler<UpdateQueueStatusRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQueueStatus(updateQueueStatusRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQueueStatusRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the configuration settings for the specified quick connect.
     * </p>
     * 
     * @param updateQuickConnectConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateQuickConnectConfig service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQuickConnectConfigAsync(
            final UpdateQuickConnectConfigRequest updateQuickConnectConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQuickConnectConfig(updateQuickConnectConfigRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the configuration settings for the specified quick connect.
     * </p>
     * 
     * @param updateQuickConnectConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateQuickConnectConfig service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQuickConnectConfigAsync(
            final UpdateQuickConnectConfigRequest updateQuickConnectConfigRequest,
            final AsyncHandler<UpdateQuickConnectConfigRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQuickConnectConfig(updateQuickConnectConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQuickConnectConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the name and description of a quick connect. The request accepts
     * the following data in JSON format. At least <code>Name</code> or
     * <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateQuickConnectNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateQuickConnectName service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQuickConnectNameAsync(
            final UpdateQuickConnectNameRequest updateQuickConnectNameRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateQuickConnectName(updateQuickConnectNameRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the name and description of a quick connect. The request accepts
     * the following data in JSON format. At least <code>Name</code> or
     * <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateQuickConnectNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateQuickConnectName service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateQuickConnectNameAsync(
            final UpdateQuickConnectNameRequest updateQuickConnectNameRequest,
            final AsyncHandler<UpdateQuickConnectNameRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateQuickConnectName(updateQuickConnectNameRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateQuickConnectNameRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the channels that agents can handle in the Contact Control Panel
     * (CCP) for a routing profile.
     * </p>
     * 
     * @param updateRoutingProfileConcurrencyRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileConcurrency service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileConcurrencyAsync(
            final UpdateRoutingProfileConcurrencyRequest updateRoutingProfileConcurrencyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateRoutingProfileConcurrency(updateRoutingProfileConcurrencyRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the channels that agents can handle in the Contact Control Panel
     * (CCP) for a routing profile.
     * </p>
     * 
     * @param updateRoutingProfileConcurrencyRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileConcurrency service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileConcurrencyAsync(
            final UpdateRoutingProfileConcurrencyRequest updateRoutingProfileConcurrencyRequest,
            final AsyncHandler<UpdateRoutingProfileConcurrencyRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateRoutingProfileConcurrency(updateRoutingProfileConcurrencyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateRoutingProfileConcurrencyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the default outbound queue of a routing profile.
     * </p>
     * 
     * @param updateRoutingProfileDefaultOutboundQueueRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileDefaultOutboundQueue service method, as
     *         returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileDefaultOutboundQueueAsync(
            final UpdateRoutingProfileDefaultOutboundQueueRequest updateRoutingProfileDefaultOutboundQueueRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateRoutingProfileDefaultOutboundQueue(updateRoutingProfileDefaultOutboundQueueRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the default outbound queue of a routing profile.
     * </p>
     * 
     * @param updateRoutingProfileDefaultOutboundQueueRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileDefaultOutboundQueue service method, as
     *         returned by Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileDefaultOutboundQueueAsync(
            final UpdateRoutingProfileDefaultOutboundQueueRequest updateRoutingProfileDefaultOutboundQueueRequest,
            final AsyncHandler<UpdateRoutingProfileDefaultOutboundQueueRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateRoutingProfileDefaultOutboundQueue(updateRoutingProfileDefaultOutboundQueueRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateRoutingProfileDefaultOutboundQueueRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the name and description of a routing profile. The request
     * accepts the following data in JSON format. At least <code>Name</code> or
     * <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateRoutingProfileNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileName service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileNameAsync(
            final UpdateRoutingProfileNameRequest updateRoutingProfileNameRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateRoutingProfileName(updateRoutingProfileNameRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the name and description of a routing profile. The request
     * accepts the following data in JSON format. At least <code>Name</code> or
     * <code>Description</code> must be provided.
     * </p>
     * 
     * @param updateRoutingProfileNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileName service method, as returned by Amazon
     *         Connect.
     * @throws DuplicateResourceException
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileNameAsync(
            final UpdateRoutingProfileNameRequest updateRoutingProfileNameRequest,
            final AsyncHandler<UpdateRoutingProfileNameRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateRoutingProfileName(updateRoutingProfileNameRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateRoutingProfileNameRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the properties associated with a set of queues for a routing
     * profile.
     * </p>
     * 
     * @param updateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileQueues service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileQueuesAsync(
            final UpdateRoutingProfileQueuesRequest updateRoutingProfileQueuesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateRoutingProfileQueues(updateRoutingProfileQueuesRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the properties associated with a set of queues for a routing
     * profile.
     * </p>
     * 
     * @param updateRoutingProfileQueuesRequest
     * @return A Java Future object containing the response from the
     *         UpdateRoutingProfileQueues service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateRoutingProfileQueuesAsync(
            final UpdateRoutingProfileQueuesRequest updateRoutingProfileQueuesRequest,
            final AsyncHandler<UpdateRoutingProfileQueuesRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateRoutingProfileQueues(updateRoutingProfileQueuesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateRoutingProfileQueuesRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates a security profile.
     * </p>
     * 
     * @param updateSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         UpdateSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateSecurityProfileAsync(
            final UpdateSecurityProfileRequest updateSecurityProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateSecurityProfile(updateSecurityProfileRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * This API is in preview release for Amazon Connect and is subject to
     * change.
     * </p>
     * <p>
     * Updates a security profile.
     * </p>
     * 
     * @param updateSecurityProfileRequest
     * @return A Java Future object containing the response from the
     *         UpdateSecurityProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateSecurityProfileAsync(
            final UpdateSecurityProfileRequest updateSecurityProfileRequest,
            final AsyncHandler<UpdateSecurityProfileRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateSecurityProfile(updateSecurityProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateSecurityProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates details about a specific task template in the specified Amazon
     * Connect instance. This operation does not support partial updates.
     * Instead it does a full update of template content.
     * </p>
     * 
     * @param updateTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         UpdateTaskTemplate service method, as returned by Amazon Connect.
     * @throws PropertyValidationException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateTaskTemplateResult> updateTaskTemplateAsync(
            final UpdateTaskTemplateRequest updateTaskTemplateRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateTaskTemplateResult>() {
            public UpdateTaskTemplateResult call() throws Exception {
                return updateTaskTemplate(updateTaskTemplateRequest);
            }
        });
    }

    /**
     * <p>
     * Updates details about a specific task template in the specified Amazon
     * Connect instance. This operation does not support partial updates.
     * Instead it does a full update of template content.
     * </p>
     * 
     * @param updateTaskTemplateRequest
     * @return A Java Future object containing the response from the
     *         UpdateTaskTemplate service method, as returned by Amazon Connect.
     * @throws PropertyValidationException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws ServiceQuotaExceededException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<UpdateTaskTemplateResult> updateTaskTemplateAsync(
            final UpdateTaskTemplateRequest updateTaskTemplateRequest,
            final AsyncHandler<UpdateTaskTemplateRequest, UpdateTaskTemplateResult> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<UpdateTaskTemplateResult>() {
            public UpdateTaskTemplateResult call() throws Exception {
                UpdateTaskTemplateResult result = null;
                try {
                    result = updateTaskTemplate(updateTaskTemplateRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateTaskTemplateRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified hierarchy group to the specified user.
     * </p>
     * 
     * @param updateUserHierarchyRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchy service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyAsync(
            final UpdateUserHierarchyRequest updateUserHierarchyRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserHierarchy(updateUserHierarchyRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified hierarchy group to the specified user.
     * </p>
     * 
     * @param updateUserHierarchyRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchy service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyAsync(
            final UpdateUserHierarchyRequest updateUserHierarchyRequest,
            final AsyncHandler<UpdateUserHierarchyRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserHierarchy(updateUserHierarchyRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserHierarchyRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the name of the user hierarchy group.
     * </p>
     * 
     * @param updateUserHierarchyGroupNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchyGroupName service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyGroupNameAsync(
            final UpdateUserHierarchyGroupNameRequest updateUserHierarchyGroupNameRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserHierarchyGroupName(updateUserHierarchyGroupNameRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the name of the user hierarchy group.
     * </p>
     * 
     * @param updateUserHierarchyGroupNameRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchyGroupName service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws DuplicateResourceException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyGroupNameAsync(
            final UpdateUserHierarchyGroupNameRequest updateUserHierarchyGroupNameRequest,
            final AsyncHandler<UpdateUserHierarchyGroupNameRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserHierarchyGroupName(updateUserHierarchyGroupNameRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserHierarchyGroupNameRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the user hierarchy structure: add, remove, and rename user
     * hierarchy levels.
     * </p>
     * 
     * @param updateUserHierarchyStructureRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchyStructure service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ResourceInUseException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyStructureAsync(
            final UpdateUserHierarchyStructureRequest updateUserHierarchyStructureRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserHierarchyStructure(updateUserHierarchyStructureRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the user hierarchy structure: add, remove, and rename user
     * hierarchy levels.
     * </p>
     * 
     * @param updateUserHierarchyStructureRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserHierarchyStructure service method, as returned by
     *         Amazon Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ResourceInUseException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserHierarchyStructureAsync(
            final UpdateUserHierarchyStructureRequest updateUserHierarchyStructureRequest,
            final AsyncHandler<UpdateUserHierarchyStructureRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserHierarchyStructure(updateUserHierarchyStructureRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserHierarchyStructureRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the identity information for the specified user.
     * </p>
     * <important>
     * <p>
     * We strongly recommend limiting who has the ability to invoke
     * <code>UpdateUserIdentityInfo</code>. Someone with that ability can change
     * the login credentials of other users by changing their email address.
     * This poses a security risk to your organization. They can change the
     * email address of a user to the attacker's email address, and then reset
     * the password through email. For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security-profile-best-practices.html"
     * >Best Practices for Security Profiles</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * </important>
     * 
     * @param updateUserIdentityInfoRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserIdentityInfo service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserIdentityInfoAsync(
            final UpdateUserIdentityInfoRequest updateUserIdentityInfoRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserIdentityInfo(updateUserIdentityInfoRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the identity information for the specified user.
     * </p>
     * <important>
     * <p>
     * We strongly recommend limiting who has the ability to invoke
     * <code>UpdateUserIdentityInfo</code>. Someone with that ability can change
     * the login credentials of other users by changing their email address.
     * This poses a security risk to your organization. They can change the
     * email address of a user to the attacker's email address, and then reset
     * the password through email. For more information, see <a href=
     * "https://docs.aws.amazon.com/connect/latest/adminguide/security-profile-best-practices.html"
     * >Best Practices for Security Profiles</a> in the <i>Amazon Connect
     * Administrator Guide</i>.
     * </p>
     * </important>
     * 
     * @param updateUserIdentityInfoRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserIdentityInfo service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserIdentityInfoAsync(
            final UpdateUserIdentityInfoRequest updateUserIdentityInfoRequest,
            final AsyncHandler<UpdateUserIdentityInfoRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserIdentityInfo(updateUserIdentityInfoRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserIdentityInfoRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Updates the phone configuration settings for the specified user.
     * </p>
     * 
     * @param updateUserPhoneConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserPhoneConfig service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserPhoneConfigAsync(
            final UpdateUserPhoneConfigRequest updateUserPhoneConfigRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserPhoneConfig(updateUserPhoneConfigRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Updates the phone configuration settings for the specified user.
     * </p>
     * 
     * @param updateUserPhoneConfigRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserPhoneConfig service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserPhoneConfigAsync(
            final UpdateUserPhoneConfigRequest updateUserPhoneConfigRequest,
            final AsyncHandler<UpdateUserPhoneConfigRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserPhoneConfig(updateUserPhoneConfigRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserPhoneConfigRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified routing profile to the specified user.
     * </p>
     * 
     * @param updateUserRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserRoutingProfileAsync(
            final UpdateUserRoutingProfileRequest updateUserRoutingProfileRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserRoutingProfile(updateUserRoutingProfileRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified routing profile to the specified user.
     * </p>
     * 
     * @param updateUserRoutingProfileRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserRoutingProfile service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserRoutingProfileAsync(
            final UpdateUserRoutingProfileRequest updateUserRoutingProfileRequest,
            final AsyncHandler<UpdateUserRoutingProfileRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserRoutingProfile(updateUserRoutingProfileRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserRoutingProfileRequest, result);
                return result;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified security profiles to the specified user.
     * </p>
     * 
     * @param updateUserSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserSecurityProfilesAsync(
            final UpdateUserSecurityProfilesRequest updateUserSecurityProfilesRequest)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                updateUserSecurityProfiles(updateUserSecurityProfilesRequest);
                return null;
            }
        });
    }

    /**
     * <p>
     * Assigns the specified security profiles to the specified user.
     * </p>
     * 
     * @param updateUserSecurityProfilesRequest
     * @return A Java Future object containing the response from the
     *         UpdateUserSecurityProfiles service method, as returned by Amazon
     *         Connect.
     * @throws InvalidRequestException
     * @throws InvalidParameterException
     * @throws ResourceNotFoundException
     * @throws ThrottlingException
     * @throws InternalServiceException
     * @throws AmazonClientException If any internal errors are encountered
     *             inside the client while attempting to make the request or
     *             handle the response. For example if a network connection is
     *             not available.
     * @throws AmazonServiceException If an error response is returned by Amazon
     *             Connect indicating either a problem with the data in the
     *             request, or a server side issue.
     */
    public Future<Void> updateUserSecurityProfilesAsync(
            final UpdateUserSecurityProfilesRequest updateUserSecurityProfilesRequest,
            final AsyncHandler<UpdateUserSecurityProfilesRequest, Void> asyncHandler)
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                Void result = null;
                try {
                    updateUserSecurityProfiles(updateUserSecurityProfilesRequest);
                } catch (Exception ex) {
                    asyncHandler.onError(ex);
                    throw ex;
                }
                asyncHandler.onSuccess(updateUserSecurityProfilesRequest, result);
                return result;
            }
        });
    }

}
