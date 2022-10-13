package com.adesoftware.dicerolling

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adesoftware.dicerolling.databinding.ActivityDiceRollingBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlin.random.Random

class DiceRollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiceRollingBinding
    private lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val diceImages: ArrayList<Int> = arrayListOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )

        media = MediaPlayer.create(this, R.raw.dice_sound)

        binding.buttonRoll.setOnClickListener {
            rollDice(diceImages)
        }
    }

    private fun rollDice(diceImages: ArrayList<Int>) {
        val randomDice: Random = Random
        var myRandomNumber: Int = randomDice.nextInt(6)

        binding.ivDice1.setImageResource(diceImages[myRandomNumber])

        myRandomNumber = randomDice.nextInt(6)
        binding.ivDice2.setImageResource(diceImages[myRandomNumber])

        animateDice()

        media.start()
    }

    private fun animateDice() {
        YoYo.with(Techniques.Shake)
            .duration(500) // 1000 2000
            .repeat(0)
            .playOn(binding.ivDice1);
        YoYo.with(Techniques.Shake)
            .duration(500)
            .repeat(0)
            .playOn(binding.ivDice2);
    }
}