package com.example.ics26011_mp4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class UsersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_users, container, false)
        val nav_view : NavigationView = requireActivity().findViewById(R.id.nav_view)

        var currentUser = activity?.intent?.getStringExtra("User").toString()

        var tbUsers : TableLayout = rootView.findViewById(R.id.tableUsers)
        var btnBackHome : Button = rootView.findViewById(R.id.btnBackHome)

        for(i in 0 until userArray.size) {
            var row = TableRow(rootView.getContext())
            if(i%2==0)
                row = LayoutInflater.from(rootView.getContext()).inflate(R.layout.table_row_whitebg, null) as TableRow
            else
                row = LayoutInflater.from(rootView.getContext()).inflate(R.layout.table_row_lightgreybg, null) as TableRow

            val username: String = userArray.get(i).username
            val firstname: String = userArray.get(i).firstname
            val lastname: String = userArray.get(i).lastname

            row.findViewById<TextView>(R.id.txtUsername).setText(username)
            row.findViewById<TextView>(R.id.txtName).setText(getString(R.string.name, firstname,lastname))

            //val txtUsername = TextView(rootView.getContext())
            //txtUsername.text = username
            //row.addView(txtUsername)

            tbUsers.addView(row)

            var btnView : ImageButton = row.findViewById(R.id.btnView)
            var btnEdit : ImageButton = row.findViewById(R.id.btnEdit)
            var btnDelete : ImageButton = row.findViewById(R.id.btnDelete)
            btnView.setOnClickListener {
                var fragmentObject = UsersView()
                fragmentObject.setCancelable(false)
                var bundle = Bundle()
                bundle.putString("user", username)
                fragmentObject.arguments = bundle
                fragmentObject.show(requireActivity().supportFragmentManager, "View User Details Dialog")
            }
            btnEdit.setOnClickListener {
                var fragmentObject = UsersEdit()
                fragmentObject.setCancelable(false)
                var bundle = Bundle()
                bundle.putString("user", username)
                fragmentObject.arguments = bundle
                fragmentObject.show(requireActivity().supportFragmentManager, "Edit User Details Dialog")
            }
            btnDelete.setOnClickListener {
                var fragmentObject = UsersDelete()
                fragmentObject.setCancelable(false)
                var bundle = Bundle()
                bundle.putString("user", username)
                bundle.putString("currentUser", currentUser)
                fragmentObject.arguments = bundle
                fragmentObject.show(requireActivity().supportFragmentManager, "Delete Confirm Dialog")
            }
        }

        btnBackHome.setOnClickListener {
            nav_view.setCheckedItem(R.id.nav_home)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
        }

        return rootView
    }
}