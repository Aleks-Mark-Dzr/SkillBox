package com.markov.extensions_objects_enums

class Captain (
    override val isKilled: Boolean

): AbstractWarrior (200, 65, 75, AbstractWeapon.Weapons.createSniperRifle()){
}