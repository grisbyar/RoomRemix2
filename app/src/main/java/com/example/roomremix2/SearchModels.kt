package com.example.roomremix2

class SearchModels {
    import com.squareup.moshi.Json

    data class SearchResult(
        @Json(name = "title") val title: String,
        @Json(name = "link") val link: String
    )

    data class SearchResponse(
        @Json(name = "items") val items: List<SearchResult>
    )
}