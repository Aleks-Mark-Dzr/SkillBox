package com.markov.extensions_objects_enums

class Soldier() : AbstractWarrior (150, 50, 65, AbstractWeapon.Weapons.createFifle()){
    override var isKilled: Boolean = false
}