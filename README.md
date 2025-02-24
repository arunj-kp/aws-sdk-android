# AWS SDK for Android 
[Arun notes] 
- Use the following command for building
```
./gradlew build -x test -x lint
```
- Update the version number in gradle.properties (to a unique one)
```
-VERSION_NAME=2.54.0
+VERSION_NAME=2.99.2

```
- Install to local repo
```
./gradlew install
```

[![DiscordChat](https://img.shields.io/discord/308323056592486420?logo=discord)](https://discord.gg/amplify)
[![GitHub release](https://img.shields.io/github/release/aws-amplify/aws-sdk-android.svg)](https://github.com/aws-amplify/aws-sdk-android/releases)
[![Maven Central](https://img.shields.io/maven-central/v/com.amazonaws/aws-android-sdk-core.svg)](https://search.maven.org/search?q=a:aws-android-sdk-core)
[![CircleCI](https://circleci.com/gh/aws-amplify/aws-sdk-android.svg?style=svg)](https://circleci.com/gh/aws-amplify/aws-sdk-android)

For new projects, we recommend interacting with AWS using the [Amplify Framework](https://docs.amplify.aws/start/q/integration/android).

The AWS SDK for Android is a collection of low-level libraries for direct interaction with AWS backend services. For use cases not covered by the Amplify Framework, you may directly integrate these clients into your Android app.

## Installation

The AWS SDK for Android can be directly embedded via `.aar` files, or you can download it from the Maven Central repository, by integrating it into your Android project's Gradle files.

### From Maven
We recommend obtaining the dependency from Maven. To do so, add a dependency to your app's (module-level) `build.gradle`, in the `dependencies` section:

```groovy
dependencies {
    implementation 'com.amazonaws:aws-android-sdk-SERVICE:2.x.y'
}
```

Above, SERVICE might be `s3`, `ddb`, `pinpoint`, etc. A full list is provided below.

## Available Modules
 
 * apigateway-core
 * auth-core
 * auth-facebook
 * auth-google
 * auth-ui
 * auth-userpools
 * chimesdkidentity
 * chimesdkmessaging
 * cloudwatch
 * cognitoauth
 * cognitoidentityprovider
 * cognitoidentityprovider-asf
 * comprehend
 * connect
 * connectparticipant
 * core
 * ddb
 * ddb-document
 * ddb-mapper
 * ec2
 * iot
 * kinesis
 * kinesisvideo
 * kinesisvideo-archivedmedia
 * kinesisvideo-signaling
 * kms
 * lambda
 * lex
 * location
 * logs
 * machinelearning
 * mobile-client
 * pinpoint
 * polly
 * rekognition
 * s3
 * sagemaker-runtime
 * sdb
 * ses
 * sns
 * sqs
 * testutils
 * textract
 * transcribe
 * translate

## SDK Fundamentals
There are a few fundamentals that are helpful to know when developing against the AWS SDK for Android.

* Never embed credentials in an Android application.  It is trivially easy to decompile applications and steal embedded credentials.  Always use temporarily vended credentials from services such as Amazon Cognito Identity.
* Unless explicitly stated, calls are synchronous and must be taken off of the main thread.
* Unless explicitly stated, calls can always throw an AmazonServiceException or an AmazonClientException (depending on if the exception is generated by the service or the client respectively).
* The SDK will handle re-trying requests automatically, but unless explicitly stated will throw an exception if it cannot contact AWS.
* We are always looking to help, please feel free to open an [issue](https://github.com/aws-amplify/aws-sdk-android/issues).

## Versioning

The Android SDK is versioned like `2.x.y`. `2` is a product identifier that never changes. `x` is bumped when there are breaking changes. `y` is bumped for not-breaking bugfixes, or for the introduction of new features/capabilities.

## Building the SDK
### Pre-requisites
The AWS Core Runtime (`aws-android-sdk-core`) module builds against Android API Level 23. Please download and install Android API Level 23 through SDK Manager in Android Studio, before building the SDK.

Set the `ANDROID_HOME` environment variable, to the root directory of your Android SDK installation.

_For example_, on a Mac OS X where Android Studio has been installed, the SDK comes bundled with it.
```shell
export ANDROID_HOME="$HOME/Library/Android/sdk"
```

### Build
```shell
./gradlew build
```

### Consuming Development Versions

Once you've built the SDK, you can manually install the SDK
by publishing its artifacts to your local Maven repository.

The local Maven repository is usually found in your home directory at
`~/.m2/repository`.

To publish the outputs of the build, execute the following command from
the root of the `amplify-android` project:

```shell
./gradlew publishToMavenLocal
```

After this, you can use the published development artifacts from an app.
To do so, specify `mavenLocal()` inside the app's top-level
`build.gradle(Project)` file:

```gradle
buildscript {
    repositories {
        mavenLocal() // this should ideally appear before other repositories
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:4.0.1'
    }
}

allprojects {
    repositories {
        mavenLocal() // this should ideally appear before other repositories
    }
}
```
Then, find the `VERSION_NAME` of the *library* inside `gradle.properties` file.

Use the above version to specify dependencies in your *app*'s `build.gradle (:app)` file:
```
dependencies {
    implementation 'com.amazonaws:aws-android-sdk-SERVICE:VERSION_NAME'
}
```

## Talk to Us

[Come chat with us on our Discord Channel](https://discord.gg/amplify).

Report bugs to our [GitHub Issues](https://github.com/aws-amplify/aws-sdk-android/issues) page.

## Author

Amazon Web Services

## License

See the [`LICENSE.txt`](https://github.com/aws-amplify/aws-sdk-android/blob/main/LICENSE.txt) for more info.
