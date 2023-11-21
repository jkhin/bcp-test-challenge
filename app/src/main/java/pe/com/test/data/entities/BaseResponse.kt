package pe.com.test.data.entities

import com.google.gson.annotations.SerializedName

data class BaseResponse (
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val results: List<MovieResponse>
)