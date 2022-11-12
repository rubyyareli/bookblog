package com.fcfm.menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable

class AlbumRecyclerAdapter(private val bookList:ArrayList<Books>):RecyclerView.Adapter<AlbumRecyclerAdapter.MyViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position:Int)
    }

    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return MyViewHolder(itemView/*,mListener*/)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=bookList[position]
        holder.titulo.text=currentItem.titulo
        holder.description.text=currentItem.description
    }

    override fun getItemCount():Int{
        return bookList.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val description:TextView=itemView.findViewById(R.id.tvDescription)
        val titulo:TextView=itemView.findViewById(R.id.tvTitulo)

        /*init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }*/
    }



}


