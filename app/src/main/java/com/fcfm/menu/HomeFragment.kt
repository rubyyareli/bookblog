package com.fcfm.menu

import android.app.AlarmManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class HomeFragment : Fragment() {

    private lateinit var adapter:AlbumRecyclerAdapter
    private lateinit var recyclerview:RecyclerView
    private lateinit var bookArrayList:ArrayList<Books>
    private lateinit var fragmentCont:FragmentContainerView

    lateinit var titulo:Array<String>
    lateinit var description:Array<String>
    lateinit var book:Array<String>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //fragmentCont = view?.findViewById<View>(R.id.fragmentContainerView) as FragmentContainerView

        //val bundle = arguments

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

    override fun onResume() {
        super.onResume()
        recyclerview.adapter?.notifyDataSetChanged()
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

        //val bundle = arguments
        //val message = bundle?.getSerializable("bookList")
        //val message = bundle?.getString("bookList")

        //bookArrayList.add(Books(message.toString(), "a"))

        val queue = Volley.newRequestQueue(context)
        val url = "http://192.168.100.6/webServiceBookBlog/books.php"


        val stringRequest = StringRequest(
            Request.Method.GET, url, { response ->
                val jsonArray = JSONArray(response)

                for (i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))
                    //textView.text = text.toString()

                    var title = jsonObject.get("name").toString()
                    var description = jsonObject.get("synopsis").toString()

                    var books = Books(title, description)
                    bookArrayList.add(books)

                    recyclerview.adapter?.notifyDataSetChanged()

                    //Toast.makeText(context, jsonArray.length().toString(), Toast.LENGTH_LONG).show()
                }

            }, { error ->  })

        queue.add(stringRequest)




        //Toast.makeText(context, resp.toString(), Toast.LENGTH_LONG).show()



        /*var adapter=AlbumRecyclerAdapter(bookArrayList)
        recyclerview.adapter=adapter
        adapter.setOnItemClickListener(object :AlbumRecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomeFragment, "Item1",Toast.LENGTH_LONG).show()

            }

        })*/



    }

}