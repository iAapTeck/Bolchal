
Bolchal Android Library
======
**Bolchal Library** is a simple application speech toast library for continuous text speaking toast without google dialog. Bolchal Android Library is Android TextToSpeech Helper that to talk any text you want and handle events.

## Play 👇Video👇 on YouTube
<div align="left">
      <a href="https://www.youtube.com/watch?v=XdhmkILtzjA">
         <img src="https://github.com/iAapTeck/Bolchal/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png" style="width:20%;">
      </a>
</div>

## Repository Tested on [![](https://jitpack.io/v/iAapTeck/Bolchal.svg)](https://jitpack.io/#iAapTeck/Bolchal)

## Installation
Add the following line in your app level `build.gradle` file and you can bolchal.

    implementation 'com.github.iAapTeck:Bolchal:1.0.2'
    implementation 'com.github.iAapTeck:Bolchal:v1.0.2'

Or you can just use the `Bolchal.kt` file in your project (dependencies: Kotlin Coroutines)

## Usage
1. Initialise the `Bolchal` as

        class MainActivity : AppCompatActivity() {
            lateinit var bolchal: Bolchal

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                bolchal = Bolchal(this)
            }
        }

2. Basic Bolchaling

       bolchal.talk("She is beautiful")

The above code will initialise and start a `TextToSpeech` of Android and will speak the string passed.

3. Perform UI operations on `TextToSpeech` speak events
There are three methods, you can use three to handle `onStart` `onDone` & `onError` states of `TextToSpeech`

    - **talkAndOnStart**

          bolchal.talkAndOnStart("She should change her dressing", suspend {
                // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.red_dress
            })
        The suspend lambda will be invoked at the time when TextToSpeech will start the talking of passed string.

    - **talkAndOnDone**

          bolchal.talkAndOnDone("She should put a lipstik as final touch", suspend {
                // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.lipstik
            })
        The suspend lambda will be invoked at the time when TextToSpeech will end the talking of passed string.

    - **talkAndOnError**

          bolchal.talkAndOnStart("She messed up her makeup", suspend {
               // Any UI/ MainThread changes
                girl_image_view.setBackgroundResource = R.drawable.messed_up_girl
            })
        The suspend lambda will be invoked at the time when there is an error in speaking the given string.

    If you want to define all three events at once, you can use the following method

         bolchal.talk("There she goes",
            onStart = suspend { /*Do some UI change */ },
            onDone = suspend { /*Do some UI change */ },
            onError = suspend { /*Do some UI change */ }
         )

3. Stop Gossiping
Stop the TTS with `stop()` method

        bolchal.stop()

4. Take care of all AfterParty mess
Stop the TTS engine to avoid memory leaks.

        override fun onDestroy() {
            super.onDestroy()
            bolchal.shutdown()
        }


### Methods
**Change Language Locale**
You can set the language with `setLanguage()`. Default is English

      bolchal.setLanguage(Locale("hn")) // For Hindi, You can also use your own locale language i.e. en, fr, ca, many more

**Change Speed of Reader**
You can change speed with `setSpeed()`.

      bolchal.setSpeed(1.0f) // Volume Level inbetween 0.5f, 1.0f, 2.0f, 3.0f or So On

**Change the mode of Reader**
You can change the mode `Queue` and `Flush` with `setQueueMode`.
`Queue` mode will play the text in queue. If you keep playing text/strings.
`Flush` mode will flush the whole string at once and reader will play it at once.

    bolchal.setQueueMode(TextToSpeech.QUEUE_ADD)
    bolchal.setQueueMode(TextToSpeech.QUEUE_FLUSH)

**Check status**

    bolchal.isPlaying()


----------------------------

## [License](https://github.com/iAapTeck/Bolchal/blob/master/LICENSE)

       Copyright 2022 @ iAapTeck Software Labs

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
