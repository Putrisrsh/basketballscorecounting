package android.thortechasia.thortechkotlin

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.score_board.*

class ScoreBoardActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score_board)

        //mendapatkan data yang dikirim dari MainActivity
        val edtTeamA = intent.getStringExtra(MainActivity.TEAM_A)
        val edtTeamB = intent.getStringExtra(MainActivity.TEAM_B)

        //inisiasi view ke object
//        val txtTeamA = findViewById<TextView>(R.id.txt_team_a)
//        val txtTeamB = findViewById<TextView>(R.id.txt_team_b)

        //setText textview dengan data yang dikirim oleh MainActivity
        txt_team_a.text = edtTeamA
        txt_team_b.text = edtTeamB

        teamAListener()
        teamBListener()

        btnReset.setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            txt_scoreA.text = "$scoreTeamA"
            txt_scoreB.text = "$scoreTeamB"
        }

        btnSave.setOnClickListener {
            val scoreTeamA = txt_scoreA.text.toString()
            val scoreTeamB = txt_scoreB.text.toString()
//            val edtTeamA   = txt_team_a.text.toString()
//            val edtTeamB   = txt_team_b.text.toString()
            val intent = Intent()
            intent.putExtra(MainActivity.SCORE_TEAM_A, scoreTeamA)
            intent.putExtra(MainActivity.SCORE_TEAM_B, scoreTeamB)
            intent.putExtra(MainActivity.TEAM_A, edtTeamA)
            intent.putExtra(MainActivity.TEAM_B, txt_team_b.text.toString())
            //
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun teamAListener(){
        btn3pointsA.setOnClickListener {
            scoreTeamA += 3 //scoreTeamA = scoreTeam + 3
            txt_scoreA.text = "$scoreTeamA"
        }
        btn2pointsA.setOnClickListener {
            scoreTeamA += 2
            txt_scoreA.text = "$scoreTeamA"
        }
        btnFreeThrowA.setOnClickListener {
            scoreTeamA += 1
            txt_scoreA.text = "$scoreTeamA"
        }
    }
    private fun teamBListener(){
        btn3pointsB.setOnClickListener {
            scoreTeamB += 3 // bisa juga dengan scoreTeamB = scoreTeam + 3
            txt_scoreB.text = "$scoreTeamB"
        }
        btn2pointsB.setOnClickListener {
            scoreTeamB += 2
            txt_scoreB.text = "$scoreTeamB"
        }
        btnFreeThrowB.setOnClickListener {
            scoreTeamB += 1
            txt_scoreB.text = "$scoreTeamB"
        }
    }
}
