package com.deneb.epicsevenappdb.features.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilterViewModel: ViewModel() {

    val _checkFire: MutableLiveData<Boolean> = MutableLiveData()
    val checkFire: LiveData<Boolean> = _checkFire
    val _checkIce: MutableLiveData<Boolean> = MutableLiveData()
    val checkIce: LiveData<Boolean> = _checkIce
    val _checkWind: MutableLiveData<Boolean> = MutableLiveData()
    val checkWind: LiveData<Boolean> = _checkWind
    val _checkLight: MutableLiveData<Boolean> = MutableLiveData()
    val checkLight: LiveData<Boolean> = _checkLight
    val _checkDark: MutableLiveData<Boolean> = MutableLiveData()
    val checkDark: LiveData<Boolean> = _checkDark
    val _checkRanger: MutableLiveData<Boolean> = MutableLiveData()
    val checkRanger: LiveData<Boolean> = _checkRanger
    val _checkWarrior: MutableLiveData<Boolean> = MutableLiveData()
    val checkWarrior: LiveData<Boolean> = _checkWarrior
    val _checkKnight: MutableLiveData<Boolean> = MutableLiveData()
    val checkKnight: LiveData<Boolean> = _checkKnight
    val _checkMage: MutableLiveData<Boolean> = MutableLiveData()
    val checkMage: LiveData<Boolean> = _checkMage
    val _checkThief: MutableLiveData<Boolean> = MutableLiveData()
    val checkThief: LiveData<Boolean> = _checkThief
    val _checkSoulWeaver: MutableLiveData<Boolean> = MutableLiveData()
    val checkSoulWeaver: LiveData<Boolean> = _checkSoulWeaver
    val _checkFiveStars: MutableLiveData<Boolean> = MutableLiveData()
    val checkFiveStars: LiveData<Boolean> = _checkFiveStars
    val _checkFourStars: MutableLiveData<Boolean> = MutableLiveData()
    val checkFourStars: LiveData<Boolean> = _checkFourStars
    val _checkThreeStars: MutableLiveData<Boolean> = MutableLiveData()
    val checkThreeStars: LiveData<Boolean> = _checkThreeStars

}