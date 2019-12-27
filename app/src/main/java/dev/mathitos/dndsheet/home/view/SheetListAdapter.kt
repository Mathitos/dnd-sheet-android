package dev.mathitos.dndsheet.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import dev.mathitos.dndsheet.R
import dev.mathitos.dndsheet.entities.Sheet


class SheetListAdapter(context: Context, var sheets: MutableList<Sheet>) : ArrayAdapter<Sheet>(context, 0, sheets) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.sheet_list_item, parent, false)
        }

        val sheet = sheets[position]

        view!!.findViewById<TextView>(R.id.name).text = sheet.name
        view.findViewById<TextView>(R.id.race).text = sheet.race.name
        view.findViewById<TextView>(R.id.level).text = sheet.level.toString()

        return view
    }
}