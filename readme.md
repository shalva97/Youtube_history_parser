# What is it?
This app shows your youtube history, grouped by months and sorted by watch count

# Instructions

1. git clone or download and extract project
2. Go to [google takeout page](https://takeout.google.com/settings/takeout), deselect everything except *YouTube and YouTube Music*.
3. Under *YouTube and YouTube Music* click on *Multiple formats* and change history type from html to json
4. Under *YouTube and YouTube Music* click on *All YouTube data included* and deselect everything except history
5. click next step, choose your method and download files
6. extract `watch-history.json` file into projects directory  `/src/main/resources/watch-history.json`
7. If you are on linux open console in projects root directory and execute `./gradlew run`
8. If you are on windows open cmd in projects root directory and execute `gradlew.bat run`