# Bootroid
Libraries for Android. It'll be useful if you plan to create an app using JSON API.

# Run Example Project
## In your Android SDK Manager
Please install the followings:

- Android SDK Build-tools 21.1.1
- Android 5.0 SDK Platform
- Android Support Repository
- Android Support Library 21.0.2
- Google Play services 21
- Google Repository

## In your Console
```
git clone https://github.com/honkimi/Bootroid.git
```

## In your AndroidStudio
`Open an existing Android Studio project` -> select `build.gradle`.

Run the app!

# Features
## Image Load
- HTTP Image Load

You can simply load the image via http. The image will be cached into the disk or memory.  

- Fontawesome Load

You can load [Fontawesome](http://fortawesome.github.io/Font-Awesome/) icons in your app.

## Api Request
- Simple Http Access

Simple `GET`, `POST`, `PATCH`, `DELETE` access.

- REST Api Access

You create entity class and automatically set the field magically using GSON.

## Object Cache
You may want to save objects as cache. Bootroid enables you to save and get cache one line!

## EditText Validate
EditText validate code sometimes becomes complicated. Bootroid provides common validate framework.

## Other utilities
Hide keyboard, launch browser, share, local notifications and so on.

# How to import to your project
Bootroid is Android library project.

```
cd /path/to/your/project
mkdir library
cp -r /path/to/bootroid library/
```

in your settings.gradle, add `, ':library:bootroid'`  
in your app's build.gradle `dependencies`, add `compile project(':library:bootroid')`

## Make your Application
Please make your Application class which extends `ApplicationController`.

Then in the `AndroidManifest`, add `android:name='YourApplication'` to `<application>` tag.

## Application setup
In your application class, add the blow if necessary.

```
Conf.DEV_MODE = true;
Conf.BUG_SENSE_API_KEY = "your bugsense api key";
Conf.TRACKER_ID = "your google analytics trackerid";
Conf.GCM_SENDERID = "your gcm sender id";
```

[Splunk(Bugsense)](https://mint.splunk.com/) is android bug report tool.

[Google Analytics](http://www.google.com/analytics/) is tracking tool of the App.

[Google Cloud Messaging(GCM)](https://developer.android.com/google/gcm/index.html) is push notification service.

# More Information
Please look at the source code in `SampleProject`. There are many samples there. 

Bootroid source code is also simple.

