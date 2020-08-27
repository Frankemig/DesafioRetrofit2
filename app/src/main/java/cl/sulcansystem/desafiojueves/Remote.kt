package cl.sulcansystem.desafiojueves

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/*"
"id": 1,
"title": "accusamus beatae ad facilis cum similique qui sunt",
"url": "https://via.placeholder.com/600/92c952",
"thumbnailUrl": "https://via.placeholder.com/150/92c952*/

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

data class Photos(val id: Int, val title: String, val url: String, val thumbnailUrl: String)

interface Api{
    @GET("/photos")
    fun getPhotos(): Call<List<Photos>>

    @GET("/photos/{id}")
    fun getPhoto(@Path("id")photoId:Int): Call<Photos>
}

class RetrofitClient{
    companion object{
        fun retrofitInstance():Api{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}