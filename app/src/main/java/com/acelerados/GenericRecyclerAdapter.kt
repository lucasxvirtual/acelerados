package com.acelerados

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerAdapter<L, V : RecyclerView.ViewHolder>(
    private var list: List<L>,
    val mOnCreateViewHolder: (parent: ViewGroup, viewType: Int) -> V,
    val mOnBindViewHolder: (holder: V, position: Int, list: List<L>) -> Unit
) : RecyclerView.Adapter<V>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V {
        return mOnCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        mOnBindViewHolder(holder, position, list)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
