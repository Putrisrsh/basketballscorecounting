package android.thortechasia.thortechkotlin


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import kotlinx.android.synthetic.main.item_match.view.*
import org.intellij.lang.annotations.JdkConstants

// adpter  untuk mengelola/mengatur dataset untuk ditampilkan pada recyclerview
class matchAdapter(val matchs: List<Match>) : RecyclerView.Adapter<matchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): matchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_match, parent, false)
        return  matchViewHolder(view)
    }

    // mendapatkan jumlah data yang ada pada list
    override fun getItemCount(): Int = matchs.size

    // bind data to viewholder untuk ditampilkan
    override fun onBindViewHolder(holder: matchViewHolder, position: Int) {
        holder.bindItem(matchs[position])
        //To change body of created functions use File | Settings | File Templates.
    }

}

//class viewHolder untuk menampilkan data per item di recyclerview
class matchViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    fun bindItem(match: Match) = with(itemView){
        text_team_a.text = match.team_A
        text_team_b.text = match.team_B
        text_scoreteamA.text = match.scoreTeamA
        text_scoreteamB.text = match.scoreTeamB
    }
}