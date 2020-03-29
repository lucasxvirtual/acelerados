package com.acelerados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cart.view.*

class CartFragment: Fragment() {

    private fun setupScreen(view: View){
        val adapterCategory =
            GenericRecyclerAdapter(listOf("", "", "", "", "", "", "", "", "", "", "", ""),
                { parent, _ ->
                    GenericViewHolder(LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_cart, parent, false))
                },
                { _, _, _ -> })

        view.cart.layoutManager = LinearLayoutManager(context)
        view.cart.adapter = adapterCategory

        view.finalize.setOnClickListener {
            view.switcher.showNext()
        }

        view.initial_page.setOnClickListener {
            view.switcher.showNext()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        setupScreen(view)

        return view
    }

}