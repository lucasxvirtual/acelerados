package com.acelerados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private fun setupScreen(view: View){
        val adapterCategory =
            GenericRecyclerAdapter(listOf("", "", "", "", "", "", "", "", "", "", "", ""),
                { parent, _ ->
                    GenericViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_category, parent, false))
                },
                { _, _, _ -> })

        view.categories.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,
            false)
        view.categories.adapter = adapterCategory

        val adapterProducts =
            GenericRecyclerAdapter(listOf("", "", "", "", "", "", "", "", "", "", "", ""),
                { parent, _ ->
                    GenericViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_product, parent, false))
                },
                { _, _, _ -> })
        view.items.layoutManager = LinearLayoutManager(context)
        view.items.adapter = adapterProducts
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setupScreen(view)

        return view
    }

}