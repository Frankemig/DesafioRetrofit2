package cl.sulcansystem.desafiojueves

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  var photolist = ArrayList<Photos>()
    private lateinit var adapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        adapter = PhotoAdapter(photolist)
        recycler_photos.adapter = adapter
        val model : ViewModelPhoto by viewModels()

        model.photo.observe(this, Oserver{
            adapter.updateItem(it)*/
        }

        private fun loadApiData(){
        val service = RetrofitClient.retrofitInstance()
        val call = service.getPhotos()

        call.enqueue(object : retrofit2.Callback<List<Photos>> {
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                response.body()?.map {

                    Log.d("MAIN", "${it.id} - ${it.title}")

                }
            }
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Log.d("MAIN", "Error: " + t)
                Toast.makeText(
                        applicationContext,
                        "Error: no pudimos recuperar los users desde el api",
                        Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}