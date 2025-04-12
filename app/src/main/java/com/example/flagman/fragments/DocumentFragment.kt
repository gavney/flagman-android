package com.example.flagman.fragments

import android.os.Bundle
import android.provider.DocumentsContract.Document
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.flagman.Data.Company
import com.example.flagman.R

class DocumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val test = com.example.flagman.Data.Document(
            id = 1,
            title = "Приказ 94",
            company = Company(id = 1, name = "ttk"),
            createdAt = "11 22 33",
            documentUrl = "3213",
            recipientsCount = 134,
            signingStatus = "0"
        )

        val view = inflater.inflate(R.layout.fragment_document, container, false)
        val layout: LinearLayout = view.findViewById(R.id.linealLayout)

        val buttonNewDocument: Button = view.findViewById(R.id.buttonNewDocument)

        buttonNewDocument.setOnClickListener{
            layout.addView(makeLayout(document = test, layout = layout))
        }
        return view
    }


    private fun makeLayout(document: com.example.flagman.Data.Document, layout: LinearLayout): View{
        val row = layoutInflater.inflate(R.layout.document_layout, layout, false)
        row.findViewById<TextView>(R.id.textViewDocumentName).text = document.title
        row.findViewById<TextView>(R.id.textViewAuthor).text = document.company.name
        row.findViewById<TextView>(R.id.textViewDate).text = document.createdAt
        row.findViewById<TextView>(R.id.textViewRecipients).text = document.recipientsCount.toString()

//        row.findViewById<ImageButton>(R.id.imageButtonDone).setImageResource(imageArray[done])
//
//        with(row.findViewById<TextView>(R.id.textViewLectureHomework)){
//            if (task.isNotEmpty()){
//                this.text = task
//            } else this.isVisible = false
//        }
//        with(row.findViewById<TextView>(R.id.textViewSerialNumber)){
//            this.text = lecture.serialNumber.toString()
//            this.isVisible = true
//        }
        return row
    }
}