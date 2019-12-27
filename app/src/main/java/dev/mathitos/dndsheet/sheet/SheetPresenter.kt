package dev.mathitos.dndsheet.sheet

class SheetPresenter: SheetContract.Presenter {
    private var view: SheetContract.View? = null

    override fun bindView(view: SheetContract.View) {
        this.view = view
    }
}