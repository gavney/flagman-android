package com.example.flagman.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.flagman.R

class AuthFragment : Fragment() {
    interface OnDataListener {
        fun onDataReceived(data: String)
    }

    private var dataListener: OnDataListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)
        val buttonDone = view.findViewById<Button>(R.id.buttonDone)

        buttonDone.setOnClickListener{
            dataListener?.onDataReceived("123")
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataListener = context as? OnDataListener ?: throw IllegalStateException(
            "Activity must implement OnDataListener!"
        )
    }

    override fun onDetach() {
        super.onDetach()
        dataListener = null
    }
}