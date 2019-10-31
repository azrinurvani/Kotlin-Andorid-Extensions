package com.mobile.azrinurvani.kotlinandroidextensions

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

//Tambahkan plugin LayoutContainer dan Item list
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*


class RecyclerViewAdapter(private val context:Context,private val list:List<Item>,private val listener:(Item)->Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.bindItem(list[i],listener)
    }


//    tambahkam(import) interface LayoutContainer
    class ViewHolder(override val containerView:View):RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItem(list:Item,listener: (Item) -> Unit){
            nameClub.text = list.name
            list.image?.let { Picasso.get().load(it).into(imgClub) }
            containerView.setOnClickListener{
                listener(list)
            }
        }
    }

}