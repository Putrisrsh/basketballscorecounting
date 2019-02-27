package android.thortechasia.thortechkotlin

import android.support.annotation.StringDef

data class Match(
    val team_A : String?, //diberi tanda ? untuk memperbolehkan null
    val team_B : String?,
    val scoreTeamA : String?,
    val scoreTeamB : String?
)