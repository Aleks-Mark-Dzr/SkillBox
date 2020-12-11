package com.markov.extensions_objects_enums

class General (
    override val isKilled: Boolean

): AbstractWarrior(300,75,85, AbstractWeapon.Weapons.createMachineGun()){
}