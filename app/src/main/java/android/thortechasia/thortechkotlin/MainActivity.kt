package android.thortechasia.thortechkotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.score_board.*


class MainActivity : AppCompatActivity() {

    private val matchs : MutableList<Match> = mutableListOf()
    private lateinit var adapter : matchAdapter

    companion object {
        const val TEAM_A = "team_a"
        const val TEAM_B = "team_b"

        const val SCORE_TEAM_A = "score_team_a"
        const val SCORE_TEAM_B = "score_team_b"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRv()

        btn_match_begin.setOnClickListener {
            val intent = Intent(this@MainActivity, ScoreBoardActivity::class.java)
            intent.putExtra(MainActivity.TEAM_A, edt_team_a.text.toString())
            intent.putExtra(MainActivity.TEAM_B, edt_team_b.text.toString())
            //startActivity(Intent)
            startActivityForResult(intent, 9) //
            }
        }

    private fun initRv(){
        rv_match.layoutManager = LinearLayoutManager(this)
        adapter = matchAdapter(matchs)
        rv_match.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 9 && resultCode == Activity.RESULT_OK){
            val scoreTeamA = data?.getStringExtra(SCORE_TEAM_A)
            val teamA = data?.getStringExtra(TEAM_A)
            val scoreTeamB = data?.getStringExtra(SCORE_TEAM_B)
            val teamB = data?.getStringExtra(TEAM_B)

            val match = Match(teamA, teamB, scoreTeamA, scoreTeamB)

            matchs.add(match)
            adapter.notifyDataSetChanged()
//            matchs.size untuk mengambil s
//            matchs.get() untuk mengambil
//            text_team_a.text = teamA //bisa langsung dipanggil dengan kode data?.getStringExtra(TEAM_A)
//            text_scoreteamA.text = scoreTeamA
//            text_team_b.text = data?.getStringExtra(TEAM_B)
//            text_scoreteamB.text = scoreTeamB ;tidak dipakai lagi

//            textVS.text = "VS"
//            textVS.visibility = View.VISIBLE
            edt_team_a.setText("")
            edt_team_b.setText("")
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
    }
