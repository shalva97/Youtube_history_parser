# What is it?
This app shows your YouTube history, grouped by months and sorted by watch count

# Instructions

1. Go to [google takeout page](https://takeout.google.com/settings/takeout), deselect everything except *YouTube and
   YouTube Music*.
2. Under *YouTube and YouTube Music* click on *Multiple formats* and change history type from html to json
3. Under *YouTube and YouTube Music* click on *All YouTube data included* and deselect everything except history
4. click next step, choose your method and download files
5. Install Java 11 and make sure JAVA_HOME is set
6. Download .jar file from the Releases page and run it with `java -jar youtube-history-all.jar watch-history.json`
7. The output from the program is MD formatted, you can copy&paste it in your repo on Github or in Notion.

# Recover removed videos

- Search deleted video url with Google. You will find many other similar videos.
- these websites maybe helpful: [quiteaplaylist](https://quiteaplaylist.com)
  and [this post on archivarix](https://archivarix.com/en/blog/download-deleted-youtube-videos/)

# Build from source

clone the repository and in the project directory run `./gradlew shadowjar`
then inside `build/libs` folder should be a jar file which you can run
with `java -jar filename-all.jar "otpauth-..."`

# this is what it looks like

![image](https://user-images.githubusercontent.com/22417494/124386451-89aa5980-dceb-11eb-8cd3-1d8fec57ad9a.png)

