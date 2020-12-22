package com.markov.extensions_objects_enums

class General() : AbstractWarrior(300,75,85, AbstractWeapon.Weapons.createMachineGun()){
    override var isKilled: Boolean = false
}