package com.fcfm.menu

import android.app.AlarmManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var adapter:AlbumRecyclerAdapter
    private lateinit var recyclerview:RecyclerView
    private lateinit var bookArrayList:ArrayList<Books>

    lateinit var titulo:Array<String>
    lateinit var description:Array<String>
    lateinit var book:Array<String>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager=LinearLayoutManager(context)
        recyclerview=view.findViewById(R.id.rcBook)
        recyclerview.layoutManager=layoutManager
        recyclerview.setHasFixedSize(true)
        adapter=AlbumRecyclerAdapter(bookArrayList)
        recyclerview.adapter=adapter
    }

    private fun dataInitialize(){
        bookArrayList = arrayListOf<Books>()

        titulo= arrayOf(
            getString(R.string.app_name),
            getString(R.string.action_settings),
            getString(R.string.nav_header_desc),
            getString(R.string.nav_header_subtitle),
            getString(R.string.nav_header_title),
        )

        description= arrayOf(
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.app_name),
        )

        description= arrayOf(
            getString(R.string.nav_header_title),
            getString(R.string.nav_header_title),
            getString(R.string.nav_header_title),
            getString(R.string.nav_header_title),
            getString(R.string.nav_header_title),
        )

        for(i in titulo.indices){
            val books =Books(titulo[i], description[i])
            bookArrayList.add(books)
        }

        /*var adapter=AlbumRecyclerAdapter(bookArrayList)
        recyclerview.adapter=adapter
        adapter.setOnItemClickListener(object :AlbumRecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomeFragment, "Item1",Toast.LENGTH_LONG).show()

            }

        })*/



    }

}