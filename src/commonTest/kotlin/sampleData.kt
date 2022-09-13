// TODO reformat
const val sampleData = """
[
  {
    "header": "YouTube",
    "title": "Watched Cepheid - Gaia (feat. Nonon \u0026 Sithu Aye)",
    "titleUrl": "https://www.youtube.com/watch?v\u003dSZvrKO763Mc",
    "subtitles": [
      {
        "name": "Cepheid",
        "url": "https://www.youtube.com/channel/UCUs2Csm28An8pzmcGP2UO2Q"
      }
    ],
    "time": "2020-05-14T15:48:29.760Z",
    "products": [
      "YouTube"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched How to See Time Watched on YouTube",
    "titleUrl": "https://www.youtube.com/watch?v\u003de1ru-22K1JQ",
    "subtitles": [
      {
        "name": "Howfinity",
        "url": "https://www.youtube.com/channel/UCrSvDunJEc1CME4-KvhW_3Q"
      }
    ],
    "time": "2021-05-14T15:42:59.790Z",
    "products": [
      "YouTube"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched How to See Time Watched on YouTube",
    "titleUrl": "https://www.youtube.com/watch?v\u003de1ru-22K1JQ",
    "subtitles": [
      {
        "name": "Howfinity",
        "url": "https://www.youtube.com/channel/UCrSvDunJEc1CME4-KvhW_3Q"
      }
    ],
    "time": "2021-05-14T15:42:59.790Z",
    "products": [
      "YouTube"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Sabaton - To Hell And Back",
    "titleUrl": "https://www.youtube.com/watch?v\u003d-2ksLxpPhc8",
    "subtitles": [
      {
        "name": "W. Hugo",
        "url": "https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA"
      }
    ],
    "time": "2020-01-28T14:10:04.913Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Sabaton - To Hell And Back",
    "titleUrl": "https://www.youtube.com/watch?v\u003d-2ksLxpPhc8",
    "subtitles": [
      {
        "name": "W. Hugo",
        "url": "https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA"
      }
    ],
    "time": "2019-12-21T10:21:32.995Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Sabaton - To Hell And Back",
    "titleUrl": "https://www.youtube.com/watch?v\u003d-2ksLxpPhc8",
    "subtitles": [
      {
        "name": "W. Hugo",
        "url": "https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA"
      }
    ],
    "time": "2019-11-14T20:45:36.151Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Sabaton - To Hell And Back",
    "titleUrl": "https://www.youtube.com/watch?v\u003d-2ksLxpPhc8",
    "subtitles": [
      {
        "name": "W. Hugo",
        "url": "https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA"
      }
    ],
    "time": "2019-10-13T17:41:15.967Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records",
    "titleUrl": "https://www.youtube.com/watch?v\u003d34CZjsEI1yU",
    "subtitles": [
      {
        "name": "Napalm Records",
        "url": "https://www.youtube.com/channel/UCG7AaCh_CiG6pq_rRDNw72A"
      }
    ],
    "time": "2019-10-12T20:09:58.412Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records",
    "titleUrl": "https://www.youtube.com/watch?v\u003d34CZjsEI1yU",
    "subtitles": [
      {
        "name": "Napalm Records",
        "url": "https://www.youtube.com/channel/UCG7AaCh_CiG6pq_rRDNw72A"
      }
    ],
    "time": "2019-10-07T20:37:38.199Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records",
    "titleUrl": "https://www.youtube.com/watch?v\u003d34CZjsEI1yU",
    "subtitles": [
      {
        "name": "Napalm Records",
        "url": "https://www.youtube.com/channel/UCG7AaCh_CiG6pq_rRDNw72A"
      }
    ],
    "time": "2019-10-15T19:07:03.564Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched WIND ROSE - Diggy Diggy Hole (Official Video) | Napalm Records",
    "titleUrl": "https://www.youtube.com/watch?v\u003d34CZjsEI1yU",
    "subtitles": [
      {
        "name": "Napalm Records",
        "url": "https://www.youtube.com/channel/UCG7AaCh_CiG6pq_rRDNw72A"
      }
    ],
    "time": "2019-10-14T12:48:08.919Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】",
    "titleUrl": "https://www.youtube.com/watch?v\u003dz3lCroFnILs",
    "subtitles": [
      {
        "name": "FalKKonE",
        "url": "https://www.youtube.com/channel/UChAHYPBvyaQIpjyTSdQhOMQ"
      }
    ],
    "time": "2019-10-13T18:53:19.151Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】",
    "titleUrl": "https://www.youtube.com/watch?v\u003dz3lCroFnILs",
    "subtitles": [
      {
        "name": "FalKKonE",
        "url": "https://www.youtube.com/channel/UChAHYPBvyaQIpjyTSdQhOMQ"
      }
    ],
    "time": "2019-10-12T11:31:38.820Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Happy Halloween (feat. Megumi) 【Intense Symphonic Metal Cover】",
    "titleUrl": "https://www.youtube.com/watch?v\u003dz3lCroFnILs",
    "subtitles": [
      {
        "name": "FalKKonE",
        "url": "https://www.youtube.com/channel/UChAHYPBvyaQIpjyTSdQhOMQ"
      }
    ],
    "time": "2019-10-09T21:57:34.052Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched 一首超好聽的日語歌 -【Spirits】《 中日歌詞》",
    "titleUrl": "https://www.youtube.com/watch?v\u003d5QhwXoy8CT8",
    "subtitles": [
      {
        "name": "Kundi",
        "url": "https://www.youtube.com/channel/UCwhpoqym25kcis9efwlvAng"
      }
    ],
    "time": "2022-04-23T14:22:43.394Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched 一首超好聽的日語歌 -【Spirits】《 中日歌詞》",
    "titleUrl": "https://www.youtube.com/watch?v\u003d5QhwXoy8CT8",
    "subtitles": [
      {
        "name": "Kundi",
        "url": "https://www.youtube.com/channel/UCwhpoqym25kcis9efwlvAng"
      }
    ],
    "time": "2022-01-27T21:37:26.917Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched 一首超好聽的日語歌 -【Spirits】《 中日歌詞》",
    "titleUrl": "https://www.youtube.com/watch?v\u003d5QhwXoy8CT8",
    "subtitles": [
      {
        "name": "Kundi",
        "url": "https://www.youtube.com/channel/UCwhpoqym25kcis9efwlvAng"
      }
    ],
    "time": "2022-01-27T14:58:27.683Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Owl vision - zyborg | Music Visualization",
    "titleUrl": "https://www.youtube.com/watch?v\u003dHkNU0FTBYEI",
    "subtitles": [
      {
        "name": "Miss Hentai Music",
        "url": "https://www.youtube.com/channel/UCxeZ8I2gwi8cnxzRMDexiIg"
      }
    ],
    "time": "2021-05-14T15:22:37.655Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Owl vision - zyborg | Music Visualization",
    "titleUrl": "https://www.youtube.com/watch?v\u003dHkNU0FTBYEI",
    "subtitles": [
      {
        "name": "Miss Hentai Music",
        "url": "https://www.youtube.com/channel/UCxeZ8I2gwi8cnxzRMDexiIg"
      }
    ],
    "time": "2021-05-08T20:46:24.841Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Owl vision - zyborg | Music Visualization",
    "titleUrl": "https://www.youtube.com/watch?v\u003dHkNU0FTBYEI",
    "subtitles": [
      {
        "name": "Miss Hentai Music",
        "url": "https://www.youtube.com/channel/UCxeZ8I2gwi8cnxzRMDexiIg"
      }
    ],
    "time": "2021-02-13T19:52:45.459Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  },
  {
    "header": "YouTube",
    "title": "Watched Sabaton - To Hell And Back",
    "titleUrl": "https://www.youtube.com/watch?v\u003d-2ksLxpPhc8",
    "subtitles": [
      {
        "name": "W. Hugo",
        "url": "https://www.youtube.com/channel/UCM4GP41J2L6tl3TBlTkOdrA"
      }
    ],
    "time": "2019-09-01T13:01:18.138Z",
    "products": [
      "YouTube"
    ],
    "activityControls": [
      "YouTube watch history"
    ]
  }
]
"""