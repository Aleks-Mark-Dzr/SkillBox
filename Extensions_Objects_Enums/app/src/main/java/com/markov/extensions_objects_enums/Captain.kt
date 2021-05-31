package com.markov.extensions_objects_enums

class Captain() : AbstractWarrior(200, 65, 75, AbstractWeapon.Weapons.createSniperRifle()) {
    override var isKilled: Boolean = false
}