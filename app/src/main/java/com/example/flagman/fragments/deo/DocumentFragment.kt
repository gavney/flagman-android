package com.example.flagman.fragments

import CreateOrganizationDialogFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.flagman.Data.Company
import com.example.flagman.R

class DocumentFragment : Fragment(), CreateOrganizationDialogFragment.OnDataPassListener{
    lateinit var layout: LinearLayout
    val test = com.example.flagman.Data.Document(
        id = 1,
        title = "Приказ 94",
        company = Company(id = 1, name = "ttk"),
        createdAt = "11 22 33",
        documentUrl = "3213",
        recipientsCount = 134,
        signingStatus = "0"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_document, container, false)
        layout = view.findViewById(R.id.linealLayout)

        val buttonNewDocument: Button = view.findViewById(R.id.buttonNewDocument)

        buttonNewDocument.setOnClickListener{
            val dialog = CreateOrganizationDialogFragment()
            dialog.setListener(this)
            dialog.show(childFragmentManager, "CreateOrganizationDialogFragment")
        }
        return view
    }

    override fun onDataPass(data: String) {
        layout.addView(makeLayout(document = test, layout = layout))
    }


    private fun makeLayout(document: com.example.flagman.Data.Document, layout: LinearLayout): View{
        val row = layoutInflater.inflate(R.layout.custom_document_layout, layout, false)
        row.findViewById<TextView>(R.id.textViewOrgName).text = document.title
        row.findViewById<TextView>(R.id.textViewAuthor).text = document.company.name
        row.findViewById<TextView>(R.id.textViewDate).text = document.createdAt
        row.findViewById<TextView>(R.id.textViewRecipients).text = document.recipientsCount.toString()

        return row
    }
}