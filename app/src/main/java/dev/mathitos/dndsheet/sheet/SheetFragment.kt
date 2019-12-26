package dev.mathitos.dndsheet.sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.mathitos.dndsheet.R

class SheetFragment : Fragment() {

    private lateinit var sheetViewModel: SheetViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sheetViewModel =
            ViewModelProviders.of(this).get(SheetViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sheet, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        sheetViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}