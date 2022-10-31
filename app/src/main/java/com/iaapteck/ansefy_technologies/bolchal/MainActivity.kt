package com.iaapteck.ansefy_technologies.bolchal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var bolchal: Bolchal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bolchal = Bolchal(this)

        //bolchal.setLanguage(Locale("hn"))
        bolchal.setLanguage(Locale("Hindi", "IN"))

        bolchal.setQueueMode(TextToSpeech.QUEUE_ADD)
        bolchal.setQueueMode(TextToSpeech.QUEUE_FLUSH)

        bolchal.setSpeed(1.0f) // Setting up actual speed volume level
        bolchal.isPlaying()

        Toast.makeText(this, "Successfully, We have implemented Bolchal Library for Android Studio Project. Bolchal Android Library is Android TextToSpeech Helper Library. This is easiest way to use TextToSpeech on android where you can handle all events of TextToSpeech on U.I.\n", Toast.LENGTH_LONG).show()
        bolchal.talkAndOnDone("namaste, kaise ho aap...!\n", suspend {
            // do something
        })

        bolchal.talk("There she goes",
            onStart = suspend { /* Do some UI change */ },
            onDone = suspend { /* Do Some UI Change */ },
            onError = suspend { /* Do Some UI Change */ }
        )

        bolchal.talk("Successfully, We have implemented Bolchal Library for Android Studio Project. Bolchal Android Library is Android TextToSpeech Helper Library. This is easiest way to use TextToSpeech on android where you can handle all events of TextToSpeech on UI.\n") // नमस्ते, कैसे हो आप
        //bolchal.talk("नमस्ते, कैसे हो आप")
    }
}