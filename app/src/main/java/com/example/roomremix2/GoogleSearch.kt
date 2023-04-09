import android.content.Context
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder

suspend fun searchFurniture(context: Context, furniture: String): List<SearchResult> {
    val apiKey = context.getString(R.string.google_search_api_key)
    val customSearchEngineId = context.getString(R.string.custom_search_engine_id)
    val httpClient = OkHttpClient()
    //val query = "couch OR sofa"
    val query = furniture
    val encodedQuery = URLEncoder.encode(query, "UTF-8")
    val url = "https://www.googleapis.com/customsearch/v1?key=$apiKey&cx=$customSearchEngineId&q=$encodedQuery"

    val request = Request.Builder()
        .url(url)
        .build()

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(SearchResponse::class.java)

    val response = httpClient.newCall(request).execute()

    if (response.isSuccessful) {
        val responseBody = response.body?.string()
        if (responseBody != null) {
            val searchResponse = adapter.fromJson(responseBody)
            if (searchResponse != null) {
                return searchResponse.items
            }
        }
    }

    return emptyList()
}

/*to do

how to add the google search like in the tutorial
find the api key

 */
