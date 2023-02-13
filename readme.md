# What is it?
This app shows your YouTube history, grouped by months and sorted by watch count

# Instructions

1. Go to [google takeout page](https://takeout.google.com/settings/takeout), deselect everything except *YouTube and
   YouTube Music*.
2. Under *YouTube and YouTube Music* click on *Multiple formats* and change history type from html to json
3. Under *YouTube and YouTube Music* click on *All YouTube data included* and deselect everything except history
4. click next step, choose your method and download files
5. Open https://shalva97.github.io/Youtube_history_parser/ website and upload your file

### or

5. Install Java 11 and make sure JAVA_HOME is set
6. Download .jar file from the Releases page (currently we have .jar file for previous release) and run it with `java -jar youtube-history-all.jar watch-history.json`

The output from the program is MD formatted, you can copy&paste it in your repo on Github or in Notion.

# Recover removed videos

- Search deleted video url with Google. You will find many other similar videos.
- these websites maybe helpful: [quiteaplaylist](https://quiteaplaylist.com)
  and [this post on archivarix](https://archivarix.com/en/blog/download-deleted-youtube-videos/)

# Build from source

clone the repository and in the project directory run `./gradlew shadowjar`
then inside `build/libs` folder should be a jar file which you can run
with `java -jar filename-all.jar history.json`

# this is what it looks like
## Youtube Video History

## 2018

### MARCH

- [UNDERTALE - MEGALOVANIA 【Intense Symphonic Metal Cover】 - 66](https://www.youtube.com/watch?v=WJgt6m6njVw)
- [Undertale[AU] | Bloodlust | A Yuri Megalovania - 62](https://www.youtube.com/watch?v=WQ7KACXQjxc)
- [Indila - Dernière Danse (Clip Officiel) - 60](https://www.youtube.com/watch?v=K5KAc5CoCuk)
- [Lordi - Hard Rock Hallelujah - 56](https://www.youtube.com/watch?v=-6Xl9tBWt54)
- [BAD APPLE!! || METAL COVER by RichaadEB ft. Cristina Vee - 39](https://www.youtube.com/watch?v=9Xz4NV0zsbY)
- [Lindsey Stirling - Stars Align (Official Music Video) - 37](https://www.youtube.com/watch?v=55_bV4ORRFM)
- [THIS IS HALLOWEEN (Metal Cover) - 35](https://www.youtube.com/watch?v=w7gadauy4sk)
- [World's Greatest Battle Music: Seven Sisters by Titan Slayer - 34](https://www.youtube.com/watch?v=TSShvQiRblw)
- [Mob Psycho 100 - You Don't F**K With A God「ＡＭＶ」ORIGINAL REMIX - 32](https://www.youtube.com/watch?v=vTAutb-scn0)
- [Nightwish - Élan (OFFICIAL VIDEO) - 27](https://www.youtube.com/watch?v=zPonioDYnoY)
- [World's Greatest Battle Music Ever: Stars And Warriors - 26](https://www.youtube.com/watch?v=SwOcZ3_MLd0)
- Deleted Video _rfxqRRN2hM
  - [quiteaplaylist](https://quiteaplaylist.com/search?url=https://www.youtube.com/watch?v=_rfxqRRN2hM)
  - [Google](https://www.google.com/search?q=https://www.youtube.com/watch?v=_rfxqRRN2hM)
- [Anti-Nightcore - Seven Nation Army - 13](https://www.youtube.com/watch?v=PM7iibrcLEQ)
- [MARILYN MANSON :: This Is Halloween - 12](https://www.youtube.com/watch?v=jU6iP0WLsU8)
- [Nightwish - Endless Forms Most Beautiful (LYRIC VIDEO) - 11](https://www.youtube.com/watch?v=VUb1p8fm7Ag)

### APRIL

- [This Will Be The Day (feat. Casey Lee Williams) by Jeff Williams with Lyrics - 92](https://www.youtube.com/watch?v=Wwohhs3LvRQ)
- [Red Like Roses Part 1+2 Complete - 56](https://www.youtube.com/watch?v=1iSTJYIXYao)
- [I am a champion - the greatest speech ever [ENG SUB] - 45](https://www.youtube.com/watch?v=yX39J_YyKbs)
- [Powerwolf – In the Name of God - 45](https://www.youtube.com/watch?v=mobtxEJHhY4)
- [Two Steps From Hell - Victory - 42](https://www.youtube.com/watch?v=hKRUPYrAQoE)

and so on...