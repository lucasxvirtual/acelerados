package com.acelerados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_suppliers.view.*

class SuppliersFragment: Fragment() {

    private fun setupScreen(view: View){
        val adapterCategory =
            GenericRecyclerAdapter(listOf("", "", "", "", "", "", "", "", "", "", "", ""),
                { parent, _ ->
                    GenericViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_supplier, parent, false))
                },
                { _, _, _ -> })

        view.suppliers.layoutManager = GridLayoutManager(context, 2)
        view.suppliers.adapter = adapterCategory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_suppliers, container, false)
        setupScreen(view)
        return view
    }

}