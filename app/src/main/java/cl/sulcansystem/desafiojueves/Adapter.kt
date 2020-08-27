package cl.sulcansystem.desafiojueves

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: String
    var foto1: String
    var foto2: String

    init {
        title = itemView.findViewById(R.id.txt_titulo)
        foto1 = itemView.findViewById(R.id.image_grande)
        foto2 = itemView.findViewById(R.id.image_chica)
    }
}

class PhotoAdapter(var photosList: MutableList<Photos>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_detail,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title = photosList[position].title

/*       Picasso.get()
            .load(photosList[position].url)
            .resize(300, 300)
            .placeholder(R.drawable.ic_no_image)
            .centerCrop()
            .into(foto1)*/
    }

    override fun getItemCount(): Int {
        return photosList.size
    }
}