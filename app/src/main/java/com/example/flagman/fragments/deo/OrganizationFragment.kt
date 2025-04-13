package com.example.flagman.fragments

import CreateOrganizationDialogFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.flagman.Data.Organization
import com.example.flagman.R


class OrganizationFragment : Fragment(), CreateOrganizationDialogFragment.OnDataPassListener {
    lateinit var layout: LinearLayout;
    val test = Organization(1, "ТТТТТК", 9, 4)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_organization, container, false)
        val buttonNewOrganization = view.findViewById<Button>(R.id.buttonNewOrganization)
        layout = view.findViewById(R.id.organizationLayout)

        buttonNewOrganization.setOnClickListener{
            val dialog = CreateOrganizationDialogFragment()
            dialog.setListener(this)
            dialog.show(childFragmentManager, "CreateOrganizationDialogFragment")
        }
        return view
    }

    override fun onDataPass(data: String) {
        test.name = data
        layout.addView(makeLayout(test, layout))
    }


    private fun makeLayout(organization: Organization, layout: LinearLayout): View{
        val row = layoutInflater.inflate(R.layout.custom_organization_layout, layout, false)
        row.findViewById<TextView>(R.id.textViewOrgName).text = organization.name
        row.findViewById<TextView>(R.id.textViewCount).text = organization.employeesCount.toString()
        return row
    }
}