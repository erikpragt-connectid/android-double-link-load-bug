# Android Double Loading Bug

These projects are created to demonstrate a possible Android bug, as described here: https://connectid2.atlassian.net/wiki/spaces/CONNECTID/pages/752091150/Android+App+Launch+-+Double+Link+Load+POC

The project consists of several components:

* static - a simple html UI
* server - a Spring Boot component to capture requests
* android - a minimal Android app to react to assetlinks

## Deployment

Currently, it's deployed outside of ConnectID to make deployment a bit easier since it requires a bit of setup on the server side, which is easier to do using a few Nginx servers.
