# ImageBrowser

It's a sample project of image browsing app based on:
https://picsum.photos/

The main goal is to show how I build the architecture for Android app. 

# Tech stack:
- Kotlin 
- Android Architecture Components
- Retrofit & Moshi
- Dagger 2
- RxJava 2

# What has been done?
- prepared architure
- fetching image list
- displaying them in 2 column grid
- image's width depends on screen width
- handling errors (no internet/unknown error)
- added structure of unit tests

# What should have been done in production environment
- add crashlytics
- add code style settings
- configure proguard (R8)

# What features are missing:
- better states handling  - hiding loader & better error view (no toasts)
- details view implementation & share button
- full tests implementation
