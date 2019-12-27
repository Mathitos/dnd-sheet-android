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

class SheetFragment : Fragment(), SheetContract.View {

    private var presenter: SheetContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.presenter = SheetPresenter()
        this.presenter?.bindView(this)

        return inflater.inflate(R.layout.fragment_sheet, container, false)
    }
}