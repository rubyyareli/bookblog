package com.fcfm.menu

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    //private lateinit var bookArrayList:ArrayList<Books>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //replaceFragment(HomeFragment())

        /*val recycler : RecyclerView = findViewById(R.id.rcBook)
        val adapter : AlbumRecyclerAdapter=AlbumRecyclerAdapter()

        //recycler view adapter
        adapter.AlbumRecyclerA(libros(),this)

        //recycler view configuracion
        recycler.hasFixedSize()
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=adapter*/

        //bookArrayList = arrayListOf<Books>()

        //val queue = Volley.newRequestQueue(this)
        //val url = "http://192.168.100.6/webServiceBookBlog/books.php"

        /*val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val jsonArray = JSONArray(response)

                for (i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))
                    //textView.text = text.toString()

                    var title = jsonObject.get("name").toString()
                    var description = jsonObject.get("synopsis").toString()

                    var book = Books(title, description)
                    bookArrayList.add(book)

                    Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
                }

            }, { error ->  })*/

        //queue.add(stringRequest)

        //val mFragmentManager = supportFragmentManager
        //val mFragmentTransaction = mFragmentManager.beginTransaction()
        //val mFragment = HomeFragment()

        //val bundle = Bundle()
        //bundle.putSerializable("bookList",  bookArrayList)
        //bundle.putStringArrayList("bookList",  bookArrayList)
        //val titulo = bookArrayList[1].titulo
        //bundle.putString("bookList",  "asd")

        //mFragment.arguments = bundle
        //mFragmentTransaction.add(R.id.fragmentContainerView, mFragment).commit()



        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer=findViewById(R.id.drawer_layout)
        toggle=ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView= findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_item_inicio->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }
                R.id.nav_item_crear->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, CrearFragment())
                        commit()
                    }
                }
                R.id.nav_item_ajustes->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, AjustesFragment())
                        commit()
                    }
                }


            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }

    }

    private fun replaceFragment(homeFragment: HomeFragment) {
        val fragmentManager=supportFragmentManager
        val fragmenttrans=fragmentManager.beginTransaction()
        fragmenttrans.replace(R.id.frame_layout,homeFragment)
        fragmenttrans.commit()
    }

    /*private fun libros(): MutableList<Books> {
        var librosModels:MutableList<Books> =ArrayList()
        librosModels.add(Books("pppppp","asdfghjkloiuytresdfg"))

        return librosModels
    }*/

    override fun onNavigationItemSelected(item:MenuItem):Boolean{
        when(item.itemId)
        {
            R.id.nav_item_inicio->Toast.makeText(this,"Item1",Toast.LENGTH_LONG).show()
            R.id.nav_item_crear->Toast.makeText(this,"Item2",Toast.LENGTH_LONG).show()
            R.id.nav_item_ajustes->Toast.makeText(this,"Item3",Toast.LENGTH_LONG).show()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}