package pe.com.test.utils

import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import pe.com.test.R

fun ImageView.setImage(url: String, isBordered: Boolean = false) {
    val glide = Glide.with(this.context)
        .load(url)
        .centerCrop()
    if (isBordered) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(24))
        glide.apply(requestOptions)
    }
    glide.diskCacheStrategy(DiskCacheStrategy.DATA)
    glide.into(this)
}


fun RecyclerView.setup(listAdapter: ListAdapter<*, *>) = apply {
    addItemDecoration(HorizontalItemDecorator(resources.getDimension(R.dimen.dp_8).toInt()))
    layoutManager =
        LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    adapter = listAdapter
}