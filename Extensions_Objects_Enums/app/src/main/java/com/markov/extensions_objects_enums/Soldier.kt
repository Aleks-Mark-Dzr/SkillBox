package com.markov.extensions_objects_enums

class Soldier (
    override val isKilled: Boolean
): AbstractWarrior (150, 50, 65, AbstractWeapon.Weapons.createFifle()){
}