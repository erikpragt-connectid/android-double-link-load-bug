# Android Double Loading Bug

These projects are created to demonstrate a possible Android bug, as described here: 
https://connectid2.atlassian.net/wiki/spaces/CONNECTID/pages/752091150/Android+App+Launch+-+Double+Link+Load+POC

In summary, it seems that while iOS doesn't fetch a link when there's an apple-app-site-association, for Android phones 
the browser does do a request. This is a problem when links are one time use links, which happens to be the case in our situation.

This project attempts to mimic this situation by showing that Android browsers do an actual request, even when there
is an assetlink registered. This project does this by counting the number of requests made to the backend, and record the user 
agent of this application. While we expect that only the Android app makes the request, we can see that also the browser 
makes a request to the backend.

## Overview

The project consists of several components:

* static - a simple html UI
* server - a Spring Boot component to capture requests
* android - a minimal Android app to react to assetlinks

## Deployment

Currently, it's deployed outside of ConnectID to make deployment a bit easier since it requires a bit of setup on the server side, 
which is easier to do using a few Nginx servers.

## Demo

For a live demo, install the APK, either by building it or by downloading it here.

Then:
- using the Android phone, browse to https://connectid.jworks.com.au
- create a new URL
- click on Open Test page

The test page will be opened in the native Android application, but 2 requests will be done to /echo, where each
call to /echo adds an item to a cache. After the first click from the Android phone, go to https://android.jworks.com.au/dump,
and you'll see that there are 2 requests done, not 1, as what is expected.

Alternatively, you can look at this video:

https://github.com/connectid-tools/android-double-link-load-bug/assets/119275045/eb923b20-b724-4664-937d-c96230b97c71


