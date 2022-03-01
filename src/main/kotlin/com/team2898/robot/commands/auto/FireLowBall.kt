package com.team2898.robot.commands.auto

import com.team2898.robot.subsystems.Feeder
import com.team2898.robot.subsystems.Shooter
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.CommandBase

class FireLowBall(private val ballCount: Int) : CommandBase() {
    private val timer = Timer()

    override fun initialize() {
        Shooter.spinUp()
        timer.reset()
    }

    override fun execute() {
        Feeder.forceShoot()
    }

    override fun isFinished(): Boolean {
        return if (ballCount == 2) timer.hasElapsed(3.0) else timer.hasElapsed(2.0)
    }
}