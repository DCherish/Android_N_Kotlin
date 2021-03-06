package org.techtown.recyclerviewpet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_list_item.*
import kotlinx.android.synthetic.main.data_list_item.view.*

// findViewById 방식
//class DataAdapter(private val items: ArrayList<String>,
//                  private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(context).inflate(
//            R.layout.data_list_item, parent, false) // 아이템 레이아웃
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.tvDataType.text = items[position]
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//}

// 캐시 이용방식
class DataAdapter(private val items: ArrayList<Pet>,
                  private val context: Context,
                  private val itemSelect: (Pet) -> Unit) : RecyclerView.Adapter<ExtensionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.data_list_item, parent, false) // 아이템 레이아웃
        return ExtensionViewHolder(view, itemSelect)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
        holder.bind(items[position], context)
    }
}

// findViewById 방식
//class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    val tvDataType = view.tv_data_type!!
//}

// 캐시 이용방식
class ExtensionViewHolder(
    override val containerView: View,
    itemSelect: (Pet) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun bind(pet: Pet, context: Context) {
        if (pet.photo != ""){
            val resourceId = context.resources.getIdentifier(pet.photo, "drawable", context.packageName)
            img_pet.setImageResource(resourceId)
        }
        else
        {
            img_pet.setImageResource(R.mipmap.ic_launcher)
        }
        tv_breed.text = pet.breed
        tv_age.text = pet.age
        tv_gender.text = pet.gender
    }
}