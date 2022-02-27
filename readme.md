# What is it?
This app shows your youtube history, grouped by months and sorted by watch count

# Instructions

1. git clone or download and extract project
2. Go to [google takeout page](https://takeout.google.com/settings/takeout), deselect everything except *YouTube and YouTube Music*.
3. Under *YouTube and YouTube Music* click on *Multiple formats* and change history type from html to json
4. Under *YouTube and YouTube Music* click on *All YouTube data included* and deselect everything except history
5. click next step, choose your method and download files
6. Install Java 11 and make sure JAVA_HOME is set
7. extract `watch-history.json` file into projects directory  `/src/main/resources/watch-history.json`
8. If you are on linux open console in projects root directory and execute `./gradlew run`
9. If you are on windows open cmd in projects root directory and execute `gradlew.bat run`
10. The output from the program is MD formatted, you can copy&paste it in your repo on Github or in Notion.

# Recover removed videos
- you can use google to find video name by url. Then search the name and you will find many similar videos
- these websites maybe helpful: [quiteaplaylist](https://quiteaplaylist.com) and [this post on archivarix](https://archivarix.com/en/blog/download-deleted-youtube-videos/)

# this is what it looks like
![image](https://user-images.githubusercontent.com/22417494/124386451-89aa5980-dceb-11eb-8cd3-1d8fec57ad9a.png)

