package dev.mathitos.dndsheet.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import dev.mathitos.dndsheet.R

class HomeFragment : Fragment(), HomeContract.View {

    private var homePresenter: HomeContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homePresenter = HomePresenter()
        homePresenter?.bindView(this)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDestroy() {
        homePresenter?.onDestroy()
        homePresenter = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homePresenter?.onViewCreated()
        initializeButtonClickHandlers()
    }

    private fun initializeButtonClickHandlers() {
        val createButton = activity?.findViewById<Button>(R.id.create_new)
        createButton?.setOnClickListener {
            homePresenter?.handleOnCreateNewSheetClick()
        }

        val loadButton = activity?.findViewById<Button>(R.id.load_sheet)
        loadButton?.setOnClickListener {
            homePresenter?.handleOnLoadSheetClick()
        }
    }
}