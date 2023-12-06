package com.example.rollthedice

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var playerScore = 0
    private var computerScore = 0
    private var playerHold = false


    @SuppressLint("SuspiciousIndentation", "SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerScoreText = findViewById<TextView>(R.id.playerScore)
        val computerScoreText = findViewById<TextView>(R.id.computerScore)


        val holdButton = findViewById<Button>(R.id.buttonHold)
        holdButton.setOnClickListener {
            playerHold = true
        }


        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener {
            var playerRoll = 0

            val computerHold = Random.nextBoolean()
            val computerRoll = if (computerHold) {
                Toast.makeText(this, "Computer Holds!", Toast.LENGTH_SHORT).show()
                0
            } else {
                Random.nextInt(6) + 1
            }


            computerScore += computerRoll
            computerScoreText.text = "Computer Score: $computerScore"

            if (!playerHold) {
                playerRoll = Random.nextInt(6) + 1
                playerScore += playerRoll
                playerScoreText.text = "Your Score: $playerScore"
            }
            if (playerScore > 20) {
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
                rollButton.isEnabled = false
                holdButton.isEnabled = false
                return@setOnClickListener
            } else if (computerScore > 20) {
                Toast.makeText(this, "Computer Loses, You Win!", Toast.LENGTH_SHORT).show()
                rollButton.isEnabled = false
                holdButton.isEnabled = false
                return@setOnClickListener
            } else if (playerScore == 20 || computerScore == 20) {
                if (playerScore == 20) {
                    Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Computer Wins!", Toast.LENGTH_SHORT).show()
                }
                rollButton.isEnabled = false
                holdButton.isEnabled = false
                return@setOnClickListener
            }





            val imageView = findViewById<ImageView>(R.id.imageView)
            val imageResource = when (playerRoll) {
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            imageView.setImageResource(imageResource)

        }
                val restartButton = findViewById<Button>(R.id.restartButton)
                restartButton.setOnClickListener {
                    playerScore = 0
                    computerScore = 0
                    playerHold = false

                    playerScoreText.text = "Your Score: $playerScore"
                    computerScoreText.text = "Computer Score: $computerScore"

                    rollButton.isEnabled = true
                    holdButton.isEnabled = true
                }


            }

        }




