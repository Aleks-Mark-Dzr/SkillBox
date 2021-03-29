package com.markov.skillboxkotlin.oop

import com.markov.skillboxkotlin.User

class Car(
    val wheelCount: Int,
    val doorCount: Int,
    maxSpeed: Int
) : Vehicle(maxSpeed) {

    var isDoorOpen: Boolean = false
        private set

    private lateinit var driver: User

    private val engine by lazy {
        Engine()
    }

    operator fun component1(): Int = wheelCount
    operator fun component2(): Int = doorCount

    fun openDoor(openCallback: () -> Unit = { println("open door") }) {
        if (!isDoorOpen) {
            openCallback()
        }
        isDoorOpen = true
    }

    fun closeDoor(closeCallback: () -> Unit = { println("door is closed") }) {
        if (isDoorOpen) {
            closeCallback()
            if (::driver.isInitialized) {
                println("driver = ${driver}")
            }
        }
        isDoorOpen = false
    }

    override fun getTitle(): String = "Car"

    override fun accelerate(speed: Int) {
        engine.use()
        if (isDoorOpen) {
            println("you can't accselerate with opened door")
        } else {
            super.accelerate(speed)
        }

    }

    fun setDriver(driver: User) {
        this.driver = driver
    }

    fun accelerate(speed: Int, force: Boolean) {
        if (force) {
            if (isDoorOpen) println("warning, accelerate with opened door")
            super.accelerate(speed)
        } else {
            accelerate(speed)
        }
    }

    override fun useFuel(fuelCount: Int) {
        super.useFuel(fuelCount)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (wheelCount != other.wheelCount) return false
        if (doorCount != other.doorCount) return false
        if (isDoorOpen != other.isDoorOpen) return false

        return true
    }

    override fun hashCode(): Int {
        var result = wheelCount
        result = 31 * result + doorCount
        result = 31 * result + isDoorOpen.hashCode()
        return result
    }

    companion object {
        val default = Car(4, 4, 200)

        fun createWithDefaultWheelCount(doorCount: Int, maxSpeed: Int): Car {
            return Car(4, doorCount = doorCount, maxSpeed = maxSpeed)
        }
    }
}

