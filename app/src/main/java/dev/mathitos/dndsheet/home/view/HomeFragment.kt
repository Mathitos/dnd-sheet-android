package dev.mathitos.dndsheet.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import dev.mathitos.dndsheet.R
import dev.mathitos.dndsheet.entities.RPGClass
import dev.mathitos.dndsheet.entities.Race
import dev.mathitos.dndsheet.entities.Sheet
import dev.mathitos.dndsheet.home.HomeContract
import dev.mathitos.dndsheet.home.HomePresenter
import dev.mathitos.dndsheet.main.MainActivity


class HomeFragment : Fragment(),
    HomeContract.View {

    private var presenter: HomeContract.Presenter? = null

    private var sheetListAdapter: SheetListAdapter? = null

    private var sheet: Sheet = Sheet(
        "Guilherme o Vegano",
        Race.Human,
        mutableMapOf(RPGClass.Warrior to 1),
        10,
        10,
        10,
        10,
        10,
        10
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = HomePresenter()
        presenter?.bindView(this)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSheetListAdapter()
        initializeButtonClickHandlers()

        presenter?.onViewCreated()
    }

    private fun initSheetListAdapter() {
        activity?.let {
            sheetListAdapter = SheetListAdapter(it, mutableListOf(sheet))
            val sheetList = it.findViewById<ListView>(R.id.sheets_listview)
            sheetList?.adapter = sheetListAdapter
            sheetList?.setOnItemClickListener { _, _, position, _ ->
                presenter?.handleOnSheetClicked(position)
            }
            sheetListAdapter?.notifyDataSetChanged()
        }
    }

    private fun initializeButtonClickHandlers() {
        val createButton = activity?.findViewById<Button>(R.id.create_new)
        createButton?.setOnClickListener {
            presenter?.handleOnCreateNewSheetClick()
        }
    }

    override fun updateSheetsList(newList: MutableList<Sheet>) {
        sheetListAdapter?.let {
            it.clear()
            it.sheets = newList
            it.notifyDataSetChanged()
        }
    }

    override fun showText(text: String) {
        (activity as? MainActivity)?.showText(text)
    }

    override fun showSheetPage() {
        (activity as? MainActivity)?.changePage(R.id.nav_sheet)
    }
}