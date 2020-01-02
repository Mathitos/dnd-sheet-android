package dev.mathitos.dndsheet.sheet

import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.mathitos.dndsheet.R
import dev.mathitos.dndsheet.databinding.FragmentSheetBinding
import dev.mathitos.dndsheet.entities.Sheet


class SheetFragment : Fragment(), SheetContract.View {

    private var presenter: SheetContract.Presenter? = null
    private lateinit var binding: FragmentSheetBinding
    private lateinit var sheet: Sheet

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.presenter = SheetPresenter()
        this.presenter?.bindView(this)

        this.sheet = arguments?.getSerializable("sheet") as Sheet

        this.binding = FragmentSheetBinding.inflate(inflater)

        this.binding.sheet = this.sheet
        return binding.root
    }
}