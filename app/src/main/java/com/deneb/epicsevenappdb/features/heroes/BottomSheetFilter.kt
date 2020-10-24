package com.deneb.epicsevenappdb.features.heroes

import android.view.View
import androidx.fragment.app.FragmentActivity
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.extensions.onClick
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.filter_bottom_sheet.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class BottomSheetFilter(private val activity: FragmentActivity) {

    private lateinit var dialog: BottomSheetDialog
    private lateinit var view: View
    private var checkedTypeList: MutableList<String> = mutableListOf()
    private var checkedClassesList: MutableList<String> = mutableListOf()
    private var checkedStarsList: MutableList<Int> = mutableListOf()
    private val vm = activity.getViewModel<FilterViewModel>()

    fun create(
        title: String,
        aceptAction: (
            listTypes: MutableList<String>,
            listClasses: MutableList<String>,
            listRare: MutableList<Int>) -> Unit
    ) {
        dialog = BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme)
        view = activity.layoutInflater.inflate(R.layout.filter_bottom_sheet, null)

        initListeners()
        setChecks()

        with(view.tvTitle) {
            this.text = title
        }

        view.btConfirm.setOnClickListener {
            dialog.dismiss()
            getCheckedsTypes()
            getCheckedsClasses()
            getCheckedStars()
            aceptAction(checkedTypeList, checkedClassesList, checkedStarsList)
        }

        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
    }

    private fun setChecks() {
        view.checkRanger.isChecked = vm._checkRanger.value?:false
        view.checkWarrior.isChecked = vm._checkWarrior.value?:false
        view.checkKnight.isChecked = vm._checkKnight.value?:false
        view.checkMage.isChecked = vm._checkMage.value?:false
        view.checkAssassin.isChecked = vm._checkThief.value?:false
        view.checkManauser.isChecked = vm._checkSoulWeaver.value?:false
        view.checkFire.isChecked = vm._checkFire.value?:false
        view.checkIce.isChecked = vm._checkIce.value?:false
        view.checkWind.isChecked = vm._checkWind.value?:false
        view.checkLight.isChecked = vm._checkLight.value?:false
        view.checkDark.isChecked = vm._checkDark.value?:false
        view.checkFiveStar.isChecked = vm._checkFiveStars.value?:false
        view.checkFourStar.isChecked = vm._checkFourStars.value?:false
        view.checkThreeStar.isChecked = vm._checkRanger.value?:false
    }

    private fun initListeners() {
        view.checkRanger.onClick { vm._checkRanger.value = view.checkRanger.isChecked }
        view.checkWarrior.onClick { vm._checkWarrior.value = view.checkWarrior.isChecked }
        view.checkKnight.onClick { vm._checkKnight.value = view.checkKnight.isChecked }
        view.checkMage.onClick { vm._checkMage.value = view.checkMage.isChecked }
        view.checkAssassin.onClick { vm._checkThief.value = view.checkAssassin.isChecked }
        view.checkManauser.onClick { vm._checkSoulWeaver.value = view.checkManauser.isChecked }
        view.checkFire.onClick { vm._checkFire.value = view.checkFire.isChecked }
        view.checkIce.onClick { vm._checkIce.value = view.checkIce.isChecked }
        view.checkWind.onClick { vm._checkWind.value = view.checkWind.isChecked }
        view.checkLight.onClick { vm._checkLight.value = view.checkLight.isChecked }
        view.checkDark.onClick { vm._checkDark.value = view.checkDark.isChecked }
        view.checkFiveStar.onClick { vm._checkFiveStars.value = view.checkFiveStar.isChecked }
        view.checkFourStar.onClick { vm._checkFourStars.value = view.checkFourStar.isChecked }
        view.checkThreeStar.onClick { vm._checkRanger.value = view.checkThreeStar.isChecked }
    }

    private fun getCheckedsClasses() {
        if (view.checkRanger.isChecked) checkedClassesList.add("ranger")
        if (view.checkWarrior.isChecked) checkedClassesList.add("warrior")
        if (view.checkKnight.isChecked) checkedClassesList.add("knight")
        if (view.checkMage.isChecked) checkedClassesList.add("mage")
        if (view.checkAssassin.isChecked) checkedClassesList.add("assassin")
        if (view.checkManauser.isChecked) checkedClassesList.add("manauser")
    }

    private fun getCheckedsTypes() {
        if (view.checkFire.isChecked) checkedTypeList.add("fire")
        if (view.checkIce.isChecked) checkedTypeList.add("ice")
        if (view.checkWind.isChecked) checkedTypeList.add("wind")
        if (view.checkLight.isChecked) checkedTypeList.add("light")
        if (view.checkDark.isChecked) checkedTypeList.add("dark")
    }

    private fun getCheckedStars() {
        if (view.checkFiveStar.isChecked) checkedStarsList.add(5)
        if (view.checkFourStar.isChecked) checkedStarsList.add(4)
        if (view.checkThreeStar.isChecked) checkedStarsList.add(3)
    }
}